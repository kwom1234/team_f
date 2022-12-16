package team_f;

import static team_f.Stage.mapdata;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Bullet_canon extends Bullet_Canon_State {

		Canon_Bullet_Move move;
	public Bullet_canon() {
		move= new Canon_Bullet_Move();
		index_x = 0;
		index_y = 0;
		start_x = 0;// 그림상의 좌표
		start_y = 0;
		
		frame_size = 1;
	
		//HP=100;
		stop = false;
		//move.Copydata();
		try {
			Bul = ImageIO.read(new File("team_f/src/Resource/Bullet-canon.png"));
			Bul = TransformColorToTransparency(Bul, new Color(45, 86, 56));

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
				int r = (rgb & 0xFF0000) >> 16;
				int g = (rgb & 0xFF00) >> 8;
				int b = (rgb & 0xFF);
				if (r == r1 && g == g1 && b == b1) {
					return rgb & 0xFFFFFF;
				}
				return rgb;
			}
		};

		ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
		Image img = Toolkit.getDefaultToolkit().createImage(ip);
		BufferedImage dest = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = dest.createGraphics();
		g.drawImage(img, 0, 0, null);
		g.dispose();
		return dest;
	}

	public  void drawBcircle(Graphics g, Screen screen) throws IOException {
		if(Player_State.TowerCannon ==2) {
			index_x = 1;
		}
		if (MainFrame.count >= 1) {
				g.drawImage(Bul, (int)move.x,(int)move.y, // 위치
						(int)move.x + width + 30, (int)move.y + height + 30, // 크기
						width * index_x + start_x, height * index_y + start_y, width * index_x + +start_x + width,
						height * index_y + start_y + height, screen);
			
		}

	}

}
