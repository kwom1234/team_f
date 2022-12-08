package team_f;

import java.awt.image.BufferedImage;

public class Monster_State {
	public BufferedImage mob;
	public int width = 32;
	public int height = 24;
	public int index_x = 0; //애니매이션 n번째 동작
	public int index_y = 0;
	public int start_x = 0;//소스상의 사진 위치
	public int start_y = 0;
	public int frame_size = 0;
	public int Power=0;
	public int drop =10;
	public int HP = 100;
	public boolean stop = false;
	
}
