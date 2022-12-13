package team_f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static team_f.Stage.mapdata;
import javax.imageio.ImageIO;

public class Tower_Spark extends Tower_State {
	
	public static int x; // 랜덤 x좌표
	public static int y; // 랜덤 y좌표
	int xx; //
	int yy;
	int w; //
	int h;
	public ArrayList<Bullet_spark> bullet = new ArrayList<Bullet_spark>();
	public Tower_Spark() {
		// this.x= (int) (Math.random() *23);
		// this.y=(int) (Math.random() *15);
		index_x = 0;
		index_y = 0;
		start_x = 0;// 그림상의 좌표
		start_y = 0;
		frame_size = 0;
		Power = 0;
		Speed = 0;
		stop = false;
		PointInv();
		// System.out.println("d");

		// System.out.println(count);
		//System.out.println(x);
		//System.out.println(y);
		// count=0;
		try {
			tower = ImageIO.read(new File("team_f/src/Resource/Tower-spark.png"));
			tower = TransformColorToTransparency(tower, new Color(255, 255, 255));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SettingStartPoint(Bullet_spark b) {
		
			b.move.StartSetting(xx, yy);
			b.move.lunch();
	}
	public void addBullet() {
		Bullet_spark b = new Bullet_spark();
		SettingStartPoint(b);
		bullet.add(b);
		
	}
	public void PointInv() {
		x = (int) (Math.random() * (16 - 6 + 1) + 6); // 랜덤 x좌표
		y = (int) (Math.random() * (14 - 4 + 1) + 4); // 랜덤 y좌표
		if ((x % 2) == 1) {
			x = x - 1;
		}
		if ((y % 2) == 1) {
			y = y - 1;
		}
		xx = x * 30; //
		yy = y * 30;
		w = x / 30; //
		h = y / 30;
		if (mapdata[y][x] == 0) {
			mapdata[y][x] = 5;
		}else {
			PointInv();
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

	public void drawTower(Graphics g, Screen screen) {

		if (MainFrame.count >= 1) {

			
				g.drawImage(tower, xx, yy, // 위치
						xx + width + 30, yy + height + 30, // 크기
						width * index_x + start_x, height * index_y + start_y, width * index_x + +start_x + width,
						height * index_y + start_y + height, screen);
			
		}

	}

	public static void drawTower(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}