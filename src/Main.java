import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setBackground(Color.WHITE);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setBounds(100, 100, 729, 476);
        login.setUndecorated(true);
        login.setLocationRelativeTo(null);
        login.setResizable(false);
        login.setVisible(true);
	}
}