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
	int nextMobT = 40;
	int NextC = 0;
	int count=0;
	Tower_Circle Tcircle = new Tower_Circle();
	ArrayList<Monster_1> mob1 = new ArrayList<Monster_1>();
	ArrayList<Monster_2> mob2 = new ArrayList<Monster_2>();
	ArrayList<Monster_3> mob3 = new ArrayList<Monster_3>();
	ArrayList<Monster_4> mob4 = new ArrayList<Monster_4>();
	ArrayList<Monster_5> mob5 = new ArrayList<Monster_5>();
	ArrayList<Monster_6> mob6 = new ArrayList<Monster_6>();
	ArrayList<Monster_7> mob7 = new ArrayList<Monster_7>();
	ArrayList<Monster_8> mob8 = new ArrayList<Monster_8>();
	ArrayList<Monster_9> mob9 = new ArrayList<Monster_9>();
	ArrayList<Monster_10> mob10 = new ArrayList<Monster_10>();

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
				for (Monster_1 i : mob1) {
					i.move.MovePoint();
				}
				for (Monster_2 i : mob2) {
					i.move.MovePoint();
				}
				for (Monster_3 i : mob3) {
					i.move.MovePoint();
				}
				for (Monster_4 i : mob4) {
					i.move.MovePoint();
				}
				for (Monster_5 i : mob5) {
					i.move.MovePoint();
				}
				for (Monster_6 i : mob6) {
					i.move.MovePoint();
				}
				for (Monster_7 i : mob7) {
					i.move.MovePoint();
				}
				for (Monster_8 i : mob8) {
					i.move.MovePoint();
				}
				for (Monster_9 i : mob9) {
					i.move.MovePoint();
				}
				for (Monster_10 i : mob10) {
					i.move.MovePoint();
				}
				NextC++;
				if (NextC == nextMobT) {
					count++;
					if(count<10) {
						mob1.add(new Monster_1());	
					}else if(count<20) {
						mob2.add(new Monster_2());
					}else if(count<30) {
						mob3.add(new Monster_3());
					}
					NextC = 0;
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
		for (Monster_2 i : mob2) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_3 i : mob3) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_4 i : mob4) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_5 i : mob5) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_6 i : mob6) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_7 i : mob7) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_8 i : mob8) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_9 i : mob9) {
			i.drawMonster(g, this, i.move.Point);
		}
		for (Monster_10 i : mob10) {
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
