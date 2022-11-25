package team_f;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LoadScreen extends Canvas{
	private static final long serialVersionUID = -7314136332860432911L;
	public static Dimension dim;
	public static Image offscreen;
	Image Load = new ImageIcon(getClass().getClassLoader().getResource("Resource/start-1.png")).getImage();
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Load,0,0,this );
	}
}
