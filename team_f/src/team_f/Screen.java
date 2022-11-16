package team_f;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;




public class Screen extends Canvas implements Runnable{
	private static final long serialVersionUID = -7314136332860432911L;
	public static Dimension dim;
	public static Image offscreen;
	public static Graphics bufferGraphics;
	Stage map = new Stage();
	//ImageIcon background = new ImageIcon(getClass().getClassLoader().getResource("Resource/eraser.png"));
	public Screen() {

	}

	//더블 버퍼링
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		offscreen = createImage(1050, 650);
		bufferGraphics = offscreen.getGraphics();
		update(g);
	}
	//더블 버퍼링
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		render(bufferGraphics);
		g.drawImage(offscreen, 0, 0, this);
	}
	public void render(Graphics g) {
		g.clearRect(0, 0, 1050, 650);
		//배경
		map.background(g);
			}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				
				repaint();
				Thread.sleep(10);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
