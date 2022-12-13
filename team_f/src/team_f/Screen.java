package team_f;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;

public class Screen extends Canvas implements Runnable, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = -7314136332860432911L;
	public static Dimension dim;
	public static Image offscreen;
	public static Graphics bufferGraphics;
	Stage map = new Stage();
	int nextMobT = 50;
	int NextC = 0;
	int count = 0;
	private Point Bpoint = new Point();
	public static int[] mousePoint = new int[2];
	public static ArrayList<Tower_Circle> Tcircle = new ArrayList<Tower_Circle>();
	public static ArrayList<Tower_Canon> Tcanon = new ArrayList<Tower_Canon>();
	public static ArrayList<Tower_Spark> Tspark= new ArrayList<Tower_Spark>();
	public static ArrayList<Tower_Spider> Tspider = new ArrayList<Tower_Spider>();
	

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
	public void addTowerCilcle() {

		Tcircle.add(new Tower_Circle());
		System.out.println("추가?");
	}
	public void addTowerCanon() {

		Tcanon.add(new Tower_Canon());
		System.out.println("추가?");
	}
	public void addTowerSpark() {

		Tspark.add(new Tower_Spark());
		System.out.println("추가?");
	}
	public void addTowerSpider() {

		Tspider.add(new Tower_Spider());
		System.out.println("추가?");
	}

	public Screen() {

		addMouseListener(this);
		addMouseMotionListener(this);
		mob1.add(new Monster_1());
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (Tower_Circle t : Tcircle) {
					for (Bullet_circle c : t.bullet) {
						c.move.movepoint();
						 if(c.move.x<0||c.move.y<0 || c.move.x>720 || c.move.y>480) { //총알 맵 범위 벗어났는가 확인하기
					t.bullet.remove(c);
					break;
					 }
					}
					
				}
				for (Tower_Canon t : Tcanon) {
					for (Bullet_canon c : t.bullet) {
						c.move.movepoint();
						 if(c.move.x<0||c.move.y<0 || c.move.x>720 || c.move.y>480) { //총알 맵 범위 벗어났는가 확인하기
					t.bullet.remove(c);
					break;
					 }
					}
					
				}
				for (Tower_Spark t : Tspark) {
					for (Bullet_spark c : t.bullet) {
						c.move.movepoint();
						 if(c.move.x<0||c.move.y<0 || c.move.x>720 || c.move.y>480) { //총알 맵 범위 벗어났는가 확인하기
					t.bullet.remove(c);
					break;
					 }
					}
					
				}
				for (Tower_Spider t : Tspider) {
					for (Bullet_web c : t.bullet) {
						c.move.movepoint();
						 if(c.move.x<0||c.move.y<0 || c.move.x>720 || c.move.y>480) { //총알 맵 범위 벗어났는가 확인하기
					t.bullet.remove(c);
					break;
					 }
					}
					
				}
				repaint();
				counting();
			}
		}, 0, 1);
		Timer Bullet_timer = new Timer();
		Bullet_timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (Tower_Circle t : Tcircle) {
					t.addBullet();
				}
				for (Tower_Canon t : Tcanon) {
					t.addBullet();
				}
				for (Tower_Spark t : Tspark) {
					t.addBullet();
				}
				for (Tower_Spider t : Tspider) {
					t.addBullet();
				}
			}

		}, 0, 1000);

		Timer MoveTimer = new Timer();
		MoveTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				for (Monster_1 i : mob1) {// 각 몬스터마다 이동시키기
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					i.move.MovePoint();
					if (i.HP <= 0) {
						mob1.remove(i);
						break;
					}
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) { // 만약에
						// 삭제
						mob1.remove(i);
						break;// 포문이 지속될시 오류
					}
				}
				for (Monster_2 i : mob2) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					i.move.MovePoint();
					if (i.HP <= 0) {
						mob1.remove(i);
						break;
					}
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob2.remove(i);
						break;
					}
				}
				for (Monster_3 i : mob3) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob3.remove(i);
						break;
					}
				}
				for (Monster_4 i : mob4) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob4.remove(i);
						break;
					}
				}
				for (Monster_5 i : mob5) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob5.remove(i);
						break;
					}
				}
				for (Monster_6 i : mob6) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob6.remove(i);
						break;
					}
				}
				for (Monster_7 i : mob7) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob7.remove(i);
						break;
					}
				}
				for (Monster_8 i : mob8) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob8.remove(i);
						break;
					}
				}
				for (Monster_9 i : mob9) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob9.remove(i);
						break;
					}
				}
				for (Monster_10 i : mob10) {
					for (Tower_Circle t : Tcircle) {
						for (Bullet_circle c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Canon t : Tcanon) {
						for (Bullet_canon c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spark t : Tspark) {
						for (Bullet_spark c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					for (Tower_Spider t : Tspider) {
						for (Bullet_web c : t.bullet) {
							if (((int) c.move.x - i.move.Point[0]) <= 30 && ((int) c.move.y - i.move.Point[1]) <= 30
									&&((int) c.move.x - i.move.Point[0]) >= 0 && ((int) c.move.y - i.move.Point[1]) >= 0) {
								t.bullet.remove(c);
								i.HP -= t.Power;
								break;
							}
						}
					}
					if(i.HP<=0) {
						mob1.remove(i);
						break;
					}
					i.move.MovePoint();
					if (i.move.Point[0] == MoveMonster.EndX * 30 && i.move.Point[1] == MoveMonster.EndY * 30 - 20) {
						mob10.remove(i);
						break;
					}
				}
				NextC++;
				if (NextC == nextMobT) {
					count++;
					if (count < 50) {
						mob1.add(new Monster_1());
					} else if (count < 100) { // 카운터 갯수 조절시 변경 몹 사이 간격 조절 가능 Ex) 100 <count < 103
						mob2.add(new Monster_2());
					} else if (count < 150) {
						mob3.add(new Monster_3());
					} else if (count < 200) {
						mob4.add(new Monster_4());
					} else if (count < 250) {
						mob5.add(new Monster_5());
					} else if (count < 300) {
						mob6.add(new Monster_6());
					} else if (count < 350) {
						mob7.add(new Monster_7());
					} else if (count < 400) {
						mob8.add(new Monster_8());
					} else if (count < 450) {
						mob9.add(new Monster_9());
					} else if (count < 500) {
						mob10.add(new Monster_10());
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
	public void initBufferd(Graphics g) {
		dim = getSize();
		// 화면의 크기를 가져온다.
		offscreen = createImage(dim.width, dim.height);
		// 화면 크기와 똑같은 가상 버퍼(이미지)를 생성한다.
		bufferGraphics = offscreen.getGraphics();
		// 가상버퍼(이미지)로 부터 그래픽스 객체를 얻어옴
		update(g);
	}

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
		for (Tower_Circle i : Tcircle) {
			i.drawTower(g, this);
			for (Bullet_circle b : i.bullet) {
				b.drawBcircle(g, this);
			}
		}
		for (Tower_Canon i : Tcanon) {
			i.drawTower(g, this);
			for (Bullet_canon b : i.bullet) {
				b.drawBcircle(g, this);
			}
		}
		for (Tower_Spark i : Tspark) {
			i.drawTower(g, this);
			for (Bullet_spark b : i.bullet) {
				b.drawBcircle(g, this);
			}
		}
		for (Tower_Spider i : Tspider) {
			i.drawTower(g, this);
			for (Bullet_web b : i.bullet) {
				b.drawBcircle(g, this);
			}
		}
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

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		Graphics g = getGraphics();
		// Point point = e.getPoint();
		Bpoint = e.getPoint();
		mousePoint[0] = Bpoint.x;
		mousePoint[1] = Bpoint.y;

		// System.out.println(Bpoint.x);
		// System.out.println(Bpoint.y);

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
