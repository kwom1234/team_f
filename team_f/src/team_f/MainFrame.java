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
		startImage();
		
		
		
		
		
	//	initialize();
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
		
		gameStart = new JButton("보통(Normal) / 1");
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
		
		JButton gameStart_1 = new JButton("쉬움(Easy) / 0");
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
		
		JButton gameStart_2 = new JButton("어려움(Hard) / 2");
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
					.addGap(32)
					.addComponent(gameStart_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(gameStart, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(gameStart_2, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(gameStart_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(gameStart_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(gameStart, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		Start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	private void initialize() {
		this.screen = new Screen();
		frame = new JFrame();
		frame.getContentPane().add(screen,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("스킬 사용");
		
		JButton btnNewButton_2 = new JButton("포탑 강화");
		
		JButton btnNewButton = new JButton("포탑 설치");
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_2)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		
		ImageIcon iconClose = new ImageIcon(getClass().getClassLoader().getResource("Resource/tower.png"));
		iconClose = new ImageIcon(
		iconClose.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));
		
		JButton btnNewButton_3 = new JButton("New button");
		
		JButton btnNewButton_4 = new JButton("New button");
		
		JButton btnNewButton_5 = new JButton("New button");
		
		JButton btnNewButton_6 = new JButton("New button");
		
		JButton btnNewButton_7 = new JButton("New button");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_5)
					.addGap(18)
					.addComponent(btnNewButton_6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_7)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		frame.setTitle("타워디펜스");
		frame.setBounds(100, 100, 730, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnNewButton_3.addActionListener(new ActionListener() {// 게임시작 버튼 누르면 게임화면으로 넘어감
			public void actionPerformed(ActionEvent e) {
			
				screen.addTowerCilcle();
				count++;

		}
	});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}