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

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7314136332860432911L;
	private Screen screen;
	public static JFrame frame;
	public static JFrame Start;
	private LoadScreen loadscreen;
	private JButton gameStart;
	public static int Setting;
	public static int count;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		
	this.loadscreen=new LoadScreen();
	//	startImage();
		
		
		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void startImage() {
		Start = new JFrame();
		Start.setTitle("타워디펜스");
		Start.setBounds(100, 100, 730, 640);
		Start.getContentPane().add(loadscreen,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		Start.getContentPane().add(panel, BorderLayout.SOUTH);
		
		gameStart = new JButton("보통(Normal Mode)");
		gameStart.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gameStart.addActionListener(new ActionListener() {// 게임시작 버튼 누르면 게임화면으로 넘어감
			public void actionPerformed(ActionEvent e) {				
				EventQueue.invokeLater(new Runnable() {					
					public void run() {
						try {
							
							//Setting = Integer.parseInt(difficulty.getText());
							Setting = 1;
							System.out.println(Setting);
							if(Setting>=0&&Setting<=6) {
								initialize();
								screen.Setting(Setting);
							Start.dispose();
							
							MainFrame window = new MainFrame();
							window.frame.setVisible(true);}
							else {
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
		
		JButton gameStart_1 = new JButton("쉬움(Easy Mode)");
		gameStart_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gameStart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					
					public void run() {
						try {
							
							Setting = 0;
							//Setting = Integer.parseInt(difficulty.getText());
							System.out.println(Setting);
							if(Setting>=0&&Setting<=6) {
								
								
								initialize();
								screen.Setting(Setting);
							Start.dispose();
							
							MainFrame window = new MainFrame();
							window.frame.setVisible(true);}
							else {
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
		
		gameStart_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton gameStart_2 = new JButton("어려움(Hard Mode)");
		gameStart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {	
					public void run() {
						try {		
							//Setting = Integer.parseInt(difficulty.getText());
							Setting = 2;
							System.out.println(Setting);
							if(Setting>=0&&Setting<=6) {
								initialize();
								screen.Setting(Setting);
								Start.dispose();
											
								MainFrame window = new MainFrame();
								window.frame.setVisible(true);
								}
								else {
									JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
								}
						}
						catch (Exception e) {
							JOptionPane.showMessageDialog(null, "지정된 범위의 값을 입력하세요");
							e.printStackTrace();
						}
					}
				});
			}
		});
		gameStart_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(gameStart_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(gameStart, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(gameStart_2, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(gameStart_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(gameStart, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(gameStart_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		panel.setLayout(gl_panel);
		Start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private void initialize() {
		this.screen = new Screen();
		frame = new JFrame();
		frame.getContentPane().add(screen,BorderLayout.CENTER);
		
		JPanel TowerPanel = new JPanel();
		TowerPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(TowerPanel, BorderLayout.SOUTH);
		
		JButton TowerCreatButton_1 = new JButton("Circle Creat");
		TowerCreatButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.addTowerCilcle();
				count++;
			}
		});
		
		JButton TowerCreatButton_2 = new JButton("Canon Creat");
		TowerCreatButton_2.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-cannon.png")));
		TowerCreatButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton TowerCreatButton_3 = new JButton("Spider Creat");
		TowerCreatButton_3.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spider.png")));
		
		JButton TowerCreatButton_4 = new JButton("Spark Creat");
		TowerCreatButton_4.setIcon(new ImageIcon(MainFrame.class.getResource("/Resource/Tower-spark.png")));
		
		JButton TowerUpgradeButton_1 = new JButton("Circle Upgrade");
		
		JButton TowerUpgradeButton_2 = new JButton("Canon Upgrade");
		
		JButton TowerUpgradeButton_3 = new JButton("Spider Upgrade");
		
		JButton TowerUpgradeButton_4 = new JButton("Spark Upgrade");
		
		JButton TowerSellButton_4 = new JButton("Spark Sell");
		TowerSellButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton TowerSellButton_3 = new JButton("Spider Sell");
		TowerSellButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton TowerSellButton_2 = new JButton("Canon Sell");
		
		JButton TowerSellButton_1 = new JButton("Circle Sell");
		TowerSellButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_TowerPanel = new GroupLayout(TowerPanel);
		gl_TowerPanel.setHorizontalGroup(
			gl_TowerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TowerPanel.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TowerPanel.createSequentialGroup()
							.addComponent(TowerUpgradeButton_1, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TowerUpgradeButton_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TowerUpgradeButton_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TowerUpgradeButton_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_TowerPanel.createSequentialGroup()
							.addComponent(TowerSellButton_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(TowerSellButton_2, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TowerSellButton_3, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(TowerSellButton_4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_TowerPanel.createSequentialGroup()
							.addComponent(TowerCreatButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TowerCreatButton_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(TowerCreatButton_3)
							.addGap(18)
							.addComponent(TowerCreatButton_4)))
					.addGap(102))
		);
		gl_TowerPanel.setVerticalGroup(
			gl_TowerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TowerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_TowerPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(TowerCreatButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(TowerCreatButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(TowerCreatButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(TowerCreatButton_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TowerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(TowerUpgradeButton_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(TowerUpgradeButton_2)
						.addComponent(TowerUpgradeButton_1)
						.addComponent(TowerUpgradeButton_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_TowerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TowerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_TowerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(TowerSellButton_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(TowerSellButton_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(TowerSellButton_2))
							.addContainerGap())
						.addGroup(gl_TowerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TowerSellButton_1)
							.addContainerGap())))
		);
		TowerPanel.setLayout(gl_TowerPanel);
		
		ImageIcon iconClose = new ImageIcon(getClass().getClassLoader().getResource("Resource/tower.png"));
		iconClose = new ImageIcon(
		iconClose.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
		frame.setTitle("타워디펜스");
		frame.setBounds(100, 100, 730, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}