package team_f;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import team_f.Screen;
import java.awt.BorderLayout;
import javax.swing.JToolBar;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = -7314136332860432911L;
	private Screen screen;
	public static JFrame frame;




	/**
	 * Create the application.
	 */
	public MainFrame() {
		this.screen = new Screen();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().add(screen,BorderLayout.CENTER);
		frame.setTitle("타워디펜스");
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}