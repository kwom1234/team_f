package team_f;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Stage {
	Image back;
	Image Load;
	int setting;
	Screen screen;
	public Stage(){
	back	= new ImageIcon(getClass().getClassLoader().getResource("Resource/jandy.png")).getImage();
	Load = new ImageIcon(getClass().getClassLoader().getResource("Resource/load.png")).getImage();
	
	}
	public void Setting(int a) {
		setting = a;
	}
	public void background(Graphics g) {
		g.drawImage(this.back,0,0,screen);
	}

}
