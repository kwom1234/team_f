package team_f;
import static team_f.Stage.next;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Taskbar.State;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Monster_basic {


		private BufferedImage sprite;
		private Monster_State[]states;
		private int state = 0;
		private int x = 50;
		private int y = 450;
		private File punchSound;
		private boolean flip = false;
		public void setPosition(int x, int y, boolean flip) {
			this.x = x;
			this.y = y;
			this.flip = flip;
		}
		public Monster_basic() {
			loadImage();
			states = new Monster_State[5];
			Monster_State state = new Monster_State();
			states[0] = state;
				
			state.width = 32;
			state.height = 24;
			state.index_x = 0;
			state.index_y = 0;
			state.start_x = 0;
			state.start_y = 40;
			state.frame_size = 6;
			}
		
		private void loadImage() {
			try {
				this.sprite = ImageIO.read(new File("Resource/monster1.png"));
				this.sprite = TransformColorToTransparency(this.sprite, new Color(9, 12, 17));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		protected BufferedImage TransformColorToTransparency(BufferedImage image, Color c1) {
		  final int r1 = c1.getRed();
		  final int g1 = c1.getGreen();
		  final int b1 = c1.getBlue();
		 
		  ImageFilter filter = new RGBImageFilter() {
				public int filterRGB(int x, int y, int rgb) {
					int r = ( rgb & 0xFF0000 ) >> 16;
					int g = ( rgb & 0xFF00 ) >> 8;
					int b = ( rgb & 0xFF );
					if( r == r1 && g == g1 && b == b1) {
						return rgb & 0xFFFFFF;
					}
					return rgb;
				}
			};
		 
			ImageProducer ip = new FilteredImageSource( image.getSource(), filter );
			Image img = Toolkit.getDefaultToolkit().createImage(ip);
			BufferedImage dest = new BufferedImage(img.getWidth(null), 
					img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = dest.createGraphics();
			g.drawImage(img, 0, 0, null);
			g.dispose();
			return dest;
		}
		private Monster_State getState() {
			return states[state];
		}
		public void draw(Graphics g, Screen screen) {
			//g.drawImage(sprite, 0, 0, screen);
			drawMonster(getState(), g, screen);
		}
		
		private void drawMonster(Monster_State state, Graphics g, Screen screen) {
			BufferedImage bufferedImage = new BufferedImage(state.width, state.height, BufferedImage.TYPE_INT_ARGB);

		    Graphics gb = bufferedImage.getGraphics();
		    gb.drawImage(sprite, 
					0, 0,  //위치 
					0 + state.width, 0 + state.height, //크기 
					state.width*state.index_x + state.start_x, 
					state.height*state.index_y + state.start_y, 
					state.width*state.index_x + state.width + state.start_x, 
					state.height*state.index_y + state.start_y + state.height, 
					null);
		    
		    gb.dispose();
		    
		    if(this.flip) {
			    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			    tx.translate(-state.width, 0);
			    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			    bufferedImage = op.filter(bufferedImage, null);
		    }
		    g.drawImage(bufferedImage, x, y, null);
		    
			
			
			if(screen.getCount() % 100 == 0)
			{	
				if((state.index_x < state.frame_size-1) && (state.fristCheck == false))
				{
					state.index_x++;
				}
				else
				{
					state.index_x = 0;
					if(state.stop) {
						state.fristCheck = true;
					}
				}
			}
		}
	
	
	
	
	
	}

