
package team_f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import static team_f.Player_State.HP;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Life {
	BufferedImage life;
	Screen screen;


	public Life() {
	
		try {
			life = ImageIO.read(new File("team_f/src/Resource/heart.png"));
			life=TransformColorToTransparency(life, new Color(45, 86, 56));

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

	// 諛곌꼍�솕硫� ( �옍�뵒)

	// 湲� 洹몃━湲�(�쓾) �겢�옒�뒪
	public void drawlife(Graphics g) {
		
		// 湲� 洹몃━�뒗 遺�遺�

		for(int i=0;i<HP;i++) {
		g.drawImage(this.life,30*i,0, screen);
		}
		}

}
