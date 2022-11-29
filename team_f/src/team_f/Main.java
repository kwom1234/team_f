package team_f;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("189142조유송");
		System.out.println("213627최태양");
		System.out.println("213621장성균");
		System.out.println("213621장성균");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.Start.setVisible(true);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
