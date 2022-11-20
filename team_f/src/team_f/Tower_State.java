package team_f;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Tower_State {
	public BufferedImage tower;
	public int width = 24;
	public int height = 24;
	public int index_x = 0; //애니매이션 n번째 동작
	public int index_y = 0;
	public int start_x = 0;//소스상의 사진 위치
	public int start_y = 0;
	public int frame_size = 0;
	public int Power=0;
	public int Speed= 0;
	public boolean stop = false;
	
	Screen screen;
}
