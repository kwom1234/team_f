package team_f;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import team_f.Screen;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import team_f.LoadScreen;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Font;
import static team_f.Player_State.Gold;
import static team_f.Stage.mapdata;
import static team_f.Main.window;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7314136332860432911L;
	public static Screen screen;
	public static JFrame frame;
	public static JFrame Start;
	private LoadScreen loadscreen;
	private JButton gameStart_Normal;
	public static int Setting;
	public static int count;
	public static JTextField GoldState_TextField;

	/**
	 * Create the application.
	 */
	public MainFrame() {

		this.loadscreen = new LoadScreen();
		startImage();

		// initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void restart() {// 게임 재시작 
		startImage();
		frame.dispose();
		window = new MainFrame();
		window.Start.setVisible(true);
	}

	public void startImage() {
		Start = new JFrame(); //게임 시작 프레임 
		Start.setTitle("타워디펜스");
		Start.setBounds(100, 100, 730, 640);
		Start.getContentPane().add(loadscreen, BorderLayout.CENTER);

		JPanel GameStartPanel = new JPanel();
		Start.getContentPane().add(GameStartPanel, BorderLayout.SOUTH);

		gameStart_Normal = new JButton("보통(Normal Mode)");
		gameStart_Normal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gameStart_Normal.addActionListener(new ActionListener() {// 게임시작 버튼 누르면 게임화면으로 넘어감
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {

							// Setting = Integer.parseInt(difficulty.getText());
							Setting = 1;
							System.out.println(Setting);
							if (Setting >= 0 && Setting <= 6) {
								initialize();
								screen.Setting(Setting);
								Start.dispose();

								MainFrame window = new MainFrame();
								window.frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");

							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
							e.printStackTrace();
						}
					}
				});

			}
		});

		JButton gameStart_Easy = new JButton("쉬움(Easy Mode)");
		gameStart_Easy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gameStart_Easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {

					public void run() {
						try {

							Setting = 0;
							// Setting = Integer.parseInt(difficulty.getText());
							System.out.println(Setting);
							if (Setting >= 0 && Setting <= 6) {

								initialize();
								screen.Setting(Setting);
								Start.dispose();

								window = new MainFrame();
								window.frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");

							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
							e.printStackTrace();
						}
					}
				});

			}
		});

		gameStart_Easy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JButton gameStart_Hard = new JButton("어려움(Hard Mode)");
		gameStart_Hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							// Setting = Integer.parseInt(difficulty.getText());
							Setting = 2;
							System.out.println(Setting);
							if (Setting >= 0 && Setting <= 6) {
								initialize();
								screen.Setting(Setting);
								Start.dispose();

								MainFrame window = new MainFrame();
								window.frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
							e.printStackTrace();
						}
					}
				});
			}
		});
		gameStart_Hard.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_GameStartPanel = new GroupLayout(GameStartPanel);
		gl_GameStartPanel.setHorizontalGroup(gl_GameStartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GameStartPanel.createSequentialGroup().addGap(31)
						.addComponent(gameStart_Easy, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
						.addGap(50)
						.addComponent(gameStart_Normal, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
						.addComponent(gameStart_Hard, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addGap(26)));
		gl_GameStartPanel.setVerticalGroup(gl_GameStartPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_GameStartPanel.createSequentialGroup().addContainerGap(73, Short.MAX_VALUE)
						.addGroup(gl_GameStartPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(gameStart_Easy, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(gameStart_Normal, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(gameStart_Hard, GroupLayout.PREFERRED_SIZE, 48,
										GroupLayout.PREFERRED_SIZE))
						.addGap(40)));
		GameStartPanel.setLayout(gl_GameStartPanel);
		Start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void initialize() { //실제 게임 화면
		this.screen = new Screen();
		frame = new JFrame();
		frame.getContentPane().add(screen, BorderLayout.CENTER);

		JPanel TowerPanel = new JPanel();
		TowerPanel.setForeground(Color.ORANGE);
		TowerPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(TowerPanel, BorderLayout.SOUTH);

		JButton TowerCreatButton_1 = new JButton("Circle Creat");
		TowerCreatButton_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-magic2.png")));
		TowerCreatButton_1.addActionListener(new ActionListener() { //타워 설치눌렀을때 
			public void actionPerformed(ActionEvent e) {
				if(Gold >=50) {
					screen.addTowerCilcle();
					count++;
					Gold -= 50;
					GoldState_TextField.setText(Integer.toString(Gold)); //골드가 바뀔떄마다 넣어줌

				}
					}
		});

		JButton TowerCreatButton_2 = new JButton("Canon Creat");
		TowerCreatButton_2.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-cannon.png")));
		TowerCreatButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=50) {
				screen.addTowerCanon();
				count++;
				Gold -= 50;
				GoldState_TextField.setText(Integer.toString(Gold));

				}
			}
		});

		JButton TowerCreatButton_3 = new JButton("Spider Creat");
		TowerCreatButton_3.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spider.png")));
		TowerCreatButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=50) {
				screen.addTowerSpider();
				count++;
				Gold -= 50;
				GoldState_TextField.setText(Integer.toString(Gold));

				}
			}
		});

		JButton TowerCreatButton_4 = new JButton("Spark Creat");
		TowerCreatButton_4.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spark.png")));
		TowerCreatButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=50) {
				screen.addTowerSpark();
				count++;
				Gold -= 50;
				GoldState_TextField.setText(Integer.toString(Gold));
				}
			}
		});

		JButton TowerUpgradeButton_1 = new JButton("Circle Upgrade");
		TowerUpgradeButton_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-magic3.png")));
		TowerUpgradeButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=150 && Player_State.TowerCircle<3) {
				Gold -= 150;
				GoldState_TextField.setText(Integer.toString(Gold));
				Player_State.TowerCircle +=1;
				}
			}
		});
		//업그레이드 버튼 구현

		JButton TowerUpgradeButton_2 = new JButton("Canon Upgrade");
		TowerUpgradeButton_2.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-cannon2.png")));
		TowerUpgradeButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=200 && Player_State.TowerCannon<3) {
				Gold -= 200;
				GoldState_TextField.setText(Integer.toString(Gold));
				Player_State.TowerCannon +=1;
				}
			}
		});
		JButton TowerUpgradeButton_3 = new JButton("Spider Upgrade");
		TowerUpgradeButton_3.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spider2.png")));
		TowerUpgradeButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=180 && Player_State.TowerSpyder<3) {
				Gold -= 180;
				GoldState_TextField.setText(Integer.toString(Gold));
				Player_State.TowerSpyder +=1;
				}
			}
		});

		JButton TowerUpgradeButton_4 = new JButton("Spark Upgrade");
		TowerUpgradeButton_4.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spark2.png")));
		TowerUpgradeButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gold >=130 && Player_State.TowerSpark<3) {
				Gold -= 130;
				GoldState_TextField.setText(Integer.toString(Gold));
				Player_State.TowerSpark +=1;
				}
			}
		});
		
		JButton TowerSellButton_4 = new JButton("Spark Sell");
		TowerSellButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(screen.Tspark.size() >0) {
					Gold += 30;
					mapdata[screen.Tspark.get(0).y][screen.Tspark.get(0).x] = 0;
					screen.Tspark.remove(0);
					GoldState_TextField.setText(Integer.toString(Gold));
				}
			}//판매 버튼구현
		});

		JButton TowerSellButton_3 = new JButton("Spider Sell");
		TowerSellButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(screen.Tspider.size() >0) {
					Gold += 30;
					mapdata[screen.Tspider.get(0).y][screen.Tspider.get(0).x] = 0;
					screen.Tspider.remove(0);
					GoldState_TextField.setText(Integer.toString(Gold));	
				}
			}
		});

		JButton TowerSellButton_2 = new JButton("Canon Sell");
		TowerSellButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(screen.Tcanon.size() >0) {
					Gold += 30;
					mapdata[screen.Tcanon.get(0).y][screen.Tcanon.get(0).x] = 0;
					screen.Tcanon.remove(0);
					GoldState_TextField.setText(Integer.toString(Gold));
					
				}
			}
		});
		
		JButton TowerSellButton_1 = new JButton("Circle Sell");
		TowerSellButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(screen.Tcircle.size() >0) {
					Gold += 30;
					mapdata[screen.Tcircle.get(0).y][screen.Tcircle.get(0).x] = 0;
					screen.Tcircle.remove(0);
					GoldState_TextField.setText(Integer.toString(Gold));
					
				}
			}
		});

		GoldState_TextField = new JTextField(); //골드 택스트바
		GoldState_TextField.setEditable(false);
		GoldState_TextField.setText(Integer.toString(Gold));
		GoldState_TextField.setHorizontalAlignment(SwingConstants.CENTER);
		GoldState_TextField.setFont(new Font("Nanum Gothic", Font.BOLD, 16));
		GoldState_TextField.setForeground(Color.ORANGE);
		GoldState_TextField.setBackground(Color.GRAY);
		GoldState_TextField.setColumns(10);
		GroupLayout gl_TowerPanel = new GroupLayout(TowerPanel);
		gl_TowerPanel.setHorizontalGroup(gl_TowerPanel.createParallelGroup(Alignment.TRAILING).addGroup(gl_TowerPanel
				.createSequentialGroup().addGap(10)
				.addComponent(GoldState_TextField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_TowerPanel
						.createSequentialGroup().addComponent(TowerUpgradeButton_1, 0, 0, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(TowerUpgradeButton_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(TowerUpgradeButton_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(TowerUpgradeButton_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addGap(12))
						.addGroup(
								gl_TowerPanel.createSequentialGroup()
										.addComponent(TowerSellButton_1, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(TowerSellButton_2, GroupLayout.PREFERRED_SIZE, 121,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(TowerSellButton_3, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(TowerSellButton_4, GroupLayout.PREFERRED_SIZE, 116,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_TowerPanel.createSequentialGroup().addComponent(TowerCreatButton_1)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(TowerCreatButton_2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(TowerCreatButton_3)
								.addGap(18).addComponent(TowerCreatButton_4)))
				.addGap(102)));
		gl_TowerPanel.setVerticalGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TowerPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(TowerCreatButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(TowerCreatButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(TowerCreatButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(gl_TowerPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(TowerCreatButton_1, GroupLayout.PREFERRED_SIZE, 62,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(GoldState_TextField, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_TowerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(TowerUpgradeButton_3, GroupLayout.PREFERRED_SIZE, 32,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(TowerUpgradeButton_2).addComponent(TowerUpgradeButton_1)
								.addComponent(
										TowerUpgradeButton_4, GroupLayout.PREFERRED_SIZE, 31,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_TowerPanel
								.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_TowerPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(TowerSellButton_4, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(TowerSellButton_3, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(TowerSellButton_2))
								.addContainerGap())
								.addGroup(gl_TowerPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(TowerSellButton_1)
										.addContainerGap()))));
		TowerPanel.setLayout(gl_TowerPanel);

		ImageIcon iconClose = new ImageIcon(getClass().getClassLoader().getResource("Resource/tower.png"));
		iconClose = new ImageIcon(iconClose.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
		frame.setTitle("타워디펜스"); 
		frame.setBounds(100, 100, 730, 690);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
