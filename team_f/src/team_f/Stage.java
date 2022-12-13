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
import static team_f.Screen.mousePoint;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static team_f.MainFrame.Setting;
public class Stage {
	Image back;
	Image Load;
	BufferedImage Potal;
	Image mob;
	int setting = Setting;//아아 한글테스트~한글테스트~
	public static int[][] mapdata = new int[16][24]; // �쓾 �쐞移�- 寃뚯엫 �옱�떆�옉�븯嫄곕굹 留� 蹂�寃쎌떆 �떎�떆 0�쑝濡� 珥덇린�솕�븷寃�
	Screen screen;


	public Stage() {
		back = new ImageIcon(getClass().getClassLoader().getResource("Resource/jandy-2.png")).getImage();
		Load = new ImageIcon(getClass().getClassLoader().getResource("Resource/load.png")).getImage();
		try {
			Potal = ImageIO.read(new File("team_f/src/Resource/potal.png"));
			Potal=TransformColorToTransparency(Potal, new Color(45, 86, 56));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (setting == 0) {
			//이지모드
			MoveMonster.StartX=0;
			MoveMonster.StartY=14;
			MoveMonster.EndX=23;
			MoveMonster.EndY=14;
			mapdata[14][0] = 1;
			mapdata[14][1] = 1;
			mapdata[14][2] = 1;
			mapdata[14][3] = 1;
			mapdata[14][4] = 1;
			mapdata[13][4] = 1;
			mapdata[12][4] = 1;
			mapdata[12][3] = 1;
			mapdata[12][2] = 1;
			mapdata[12][1] = 1;
			mapdata[11][1] = 1;
			mapdata[10][1] = 1;
			mapdata[10][2] = 1;
			mapdata[10][3] = 1;
			mapdata[10][4] = 1;
			mapdata[9][4] = 1;
			mapdata[8][4] = 1;
			mapdata[8][3] = 1;
			mapdata[8][2] = 1;
			mapdata[8][1] = 1;
			mapdata[7][1] = 1;
			mapdata[6][1] = 1;
			mapdata[6][2] = 1;
			mapdata[6][3] = 1;
			mapdata[6][4] = 1;
			mapdata[5][4] = 1;
			mapdata[4][4] = 1;
			mapdata[3][4] = 1;
	

			
			for(int i=4;i<20;i++) {
				mapdata[2][i]=1;
			}
			mapdata[3][19] = 1;
			mapdata[4][19] = 1;
			mapdata[5][19] = 1;
			mapdata[5][20] = 1;
			mapdata[5][21] = 1;
			mapdata[5][22] = 1;
			mapdata[6][22] = 1;
			mapdata[7][22] = 1;
			mapdata[7][21] = 1;
			mapdata[7][20] = 1;
			mapdata[7][19] = 1;
			mapdata[8][19] = 1;
			mapdata[9][19] = 1;
			mapdata[9][20] = 1;
			mapdata[9][21] = 1;
			mapdata[9][22] = 1;
			mapdata[10][22] = 1;
			mapdata[11][22] = 1;
			mapdata[11][21] = 1;
			mapdata[11][20] = 1;
			mapdata[11][19] = 1;
			mapdata[12][19] = 1;
			mapdata[13][19] = 1;
			mapdata[14][19] = 1;
			mapdata[14][20] = 1;
			mapdata[14][21] = 1;
			mapdata[14][22] = 1;
			mapdata[14][22] = 1;
			mapdata[14][23] = 1;

		}
		if (setting == 1) {
			// 노말모드

			MoveMonster.StartX=0;
			MoveMonster.StartY=14;
			MoveMonster.EndX=23;
			MoveMonster.EndY=14;
			mapdata[14][0]=1;
			for(int i=14;i>2;i--) {
				mapdata[i][1]=1;
			}
			for(int i=1;i<23;i++) {
				mapdata[2][i]=1;
			}
			for(int i=14;i>2;i--) {
				mapdata[i][22]=1;
			}
			mapdata[14][23]=1;
			
			
					
			}
		if(setting == 2) {
			//하드모드
			MoveMonster.StartX=0;
			MoveMonster.StartY=14;
			MoveMonster.EndX=12;
			MoveMonster.EndY=0;
			mapdata[14][0]=1;
			mapdata[14][1]=1;
			mapdata[13][1]=1;
			mapdata[12][1]=1;
			mapdata[11][1]=1;
			mapdata[10][1]=1;
			mapdata[9][1]=1;
			mapdata[8][1]=1;
			mapdata[7][1]=1;
			mapdata[6][1]=1;
			mapdata[5][1]=1;
			mapdata[4][1]=1;
			mapdata[3][1]=1;
			mapdata[2][1]=1;
			mapdata[2][2]=1;
			mapdata[2][3]=1;
			mapdata[2][4]=1;
			mapdata[2][5]=1;
			mapdata[2][6]=1;
			mapdata[2][7]=1;
			mapdata[2][8]=1;
			mapdata[2][9]=1;
			mapdata[2][10]=1;
			mapdata[2][11]=1;
			mapdata[2][12]=1;
			mapdata[1][12]=1;
			mapdata[0][12]=1;
			
		}
		mousePoint[0]= MoveMonster.StartX;
		mousePoint[1]= MoveMonster.StartY;
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
	public void background(Graphics g) {
		g.drawImage(this.back, 0, 0, screen);
	}

	// 湲� 洹몃━湲�(�쓾) �겢�옒�뒪
	public void map(Graphics g) {
		
		// 湲� 洹몃━�뒗 遺�遺�

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 16; j++) {
				if (mapdata[j][i] == 1) {
					int x = i * 30, y = j * 30;
					g.drawImage(this.Load, x, y, screen); // 30�� load�씠誘몄��쓽 �겕湲�
				}
			}
		}
		g.drawImage(this.Potal,MoveMonster.StartX*30,MoveMonster.StartY*30, screen);
		g.drawImage(this.Potal,MoveMonster.EndX*30,MoveMonster.EndY*30, screen);
	}

}
