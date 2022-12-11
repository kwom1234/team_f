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

public class Bullet_circle extends Bullet_State {
		int x;
		int y; 
		int px;
		int py;
		int pw;
		int ph;
		Circle_Bullet_Move move;
	public Bullet_circle() {
		move= new Circle_Bullet_Move();
		index_x = 0;
		index_y = 0;
		start_x = 0;// 그림상의 좌표
		start_y = 0;
		
		frame_size = 1;
		Power = 0;
		//HP=100;
		stop = false;
		//move.Copydata();
		try {
			Bul = ImageIO.read(new File("team_f/src/Resource/Bullet-circlet.png"));
			Bul = TransformColorToTransparency(Bul, new Color(45, 86, 56));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PointInv() {
		x = (int) (Math.random() * (16 - 6 + 1) + 6); // 랜덤 x좌표
		y = (int) (Math.random() * (14 - 4 + 1) + 4);
		System.out.println(x);
		System.out.println(y);

		if ((x % 2) == 1) {
			x = x - 1;
		}
		if ((y % 2) == 1) {
			y = y - 1;
		}
		px = x * 30; //
		py = y * 30;
		pw = x / 30; //
		ph = y / 30;
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

	public  void drawBcircle(Graphics g, Screen screen,int[][] Point) {

		if (MainFrame.count >= 1) {
				g.drawImage(Bul, px, py, // 위치
						px + width + 30, py + height + 30, // 크기
						width * index_x + start_x, height * index_y + start_y, width * index_x + +start_x + width,
						height * index_y + start_y + height, screen);
			
		}

	}

}
