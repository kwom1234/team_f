package team_f;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Monster_10 extends Monster_State {
	MoveMonster move;

	public Monster_10() {
		move = new MoveMonster();
		index_x = 0;
		index_y = 0;
		start_x = 0;// 그림상의 좌표
		start_y = 0;
		frame_size = 6;
		Power = 0;
		HP=100;
		stop = false;
		move.Copydata();
		try {
			mob = ImageIO.read(new File("team_f/src/Resource/monster-10.png"));
			mob = TransformColorToTransparency(mob, new Color(45, 86, 56));

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

	public void drawMonster(Graphics g, Screen screen, int[] Point) {
		g.drawImage(mob, Point[0], Point[1], // 위치
				Point[0] + width + 20, Point[1] + height + 20, // 크기
				width * index_x + start_x, height * index_y + start_y, width * index_x + +start_x + width,
				height * index_y + start_y + height, screen);
		if (screen.getCount() % 100 == 0) {
			if (index_x < frame_size - 1) {
				index_x++;
			} else {
				if (!stop)
					index_x = 0;
				else
					index_x = frame_size - 1;
			}
		}
	}
}