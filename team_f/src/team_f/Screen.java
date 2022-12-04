package team_f;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Screen extends Canvas implements Runnable {
	private static final long serialVersionUID = -7314136332860432911L;
	public static Dimension dim;
	public static Image offscreen;
	public static Graphics bufferGraphics;
	Stage map = new Stage();
	int Cmob1 = 40;
	int count = 0;

	Tower_Circle Tcircle = new Tower_Circle();
	ArrayList<Monster_1> mob1 = new ArrayList<Monster_1>();

	// ImageIcon background = new
	// ImageIcon(getClass().getClassLoader().getResource("Resource/eraser.png"));
	public Screen() {
		mob1.add(new Monster_1());
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				repaint();
				counting();
			}
		}, 0, 1);
		Timer MoveTimer = new Timer();
		MoveTimer.schedule(new TimerTask() {
		

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(Monster_1 i : mob1) {
					i.move.MovePoint();	
				}
				
				count++;
				if (count == Cmob1) {
					mob1.add(new Monster_1());
					count = 0;
				}
//				mob.move.MovePoint();

			}
		}, 0, 10);

	}

	private int countNumber = 0;

	public void counting() {
		this.countNumber++;
	}

	public int getCount() {
		return this.countNumber;
	}

	// 더블 버퍼링
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		offscreen = createImage(1050, 650);
		bufferGraphics = offscreen.getGraphics();
		update(g);
	}

	// 더블 버퍼링
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		render(bufferGraphics);
		g.drawImage(offscreen, 0, 0, this);
	}

	public void render(Graphics g) {
		g.clearRect(0, 0, 720, 480);
		// 배경

		map.background(g);
		map.map(g);
		for (Monster_1 i : mob1) {
			i.drawMonster(g, this, i.move.Point);
		}
//		mob.drawMonster(g,this,mob.move.Point);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
//				mob.move.MovePoint();
				repaint();
				Thread.sleep(10);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 세팅값 지정
	public void Setting(int a) {
		map.setting = a;
	}

}
