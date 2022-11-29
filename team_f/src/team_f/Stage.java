package team_f;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import static team_f.MainFrame.Setting;
public class Stage {
	Image back;
	Image Load;
	Image mob;
	int setting = Setting;//기본세팅
	public static int[][] mapdata = new int[16][24]; // 흙 위치- 게임 재시작하거나 맵 변경시 다시 0으로 초기화할것
	Screen screen;


	public Stage() {
		back = new ImageIcon(getClass().getClassLoader().getResource("Resource/jandy-2.png")).getImage();
		Load = new ImageIcon(getClass().getClassLoader().getResource("Resource/load.png")).getImage();
		if (setting == 0) {// 기본맵
			for (int i = 18; i < 24; i++) {// 리스트에 1들어갈시 길
				mapdata[7][i] = 1;
			}
			mapdata[6][18] = 1;
			mapdata[5][18] = 1;
			mapdata[4][18] = 1;
			mapdata[4][17] = 1;
			mapdata[4][16] = 1;
			mapdata[4][15] = 1;
			mapdata[4][14] = 1;
			mapdata[5][14] = 1;
			mapdata[6][14] = 1;
			mapdata[7][14] = 1;

			for (int i = 0; i < 14; i++) {
				mapdata[7][i] = 1;
			}
		}
		if (setting == 1) {
			// 맵 /2
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
		}
	


	// 배경화면 ( 잔디)
	public void background(Graphics g) {
		g.drawImage(this.back, 0, 0, screen);
	}

	// 길 그리기(흙) 클래스
	public void map(Graphics g) {
		
		// 길 그리는 부분

		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 16; j++) {
				if (mapdata[j][i] == 1) {
					int x = i * 30, y = j * 30;
					g.drawImage(this.Load, x, y, screen); // 30은 load이미지의 크기
				}
			}
		}
	}

}
