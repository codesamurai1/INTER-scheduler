import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;

public class Login extends JFrame implements ActionListener {
	
	String[] quotes = {
			"\"Uno de los mayores errores que comete la gente es intentar forzarse a tener interés por algo. Tú no eliges tus pasiones; tus pasiones te eligen a ti\"",
			"\"El genio se hace con un 1% de talento, y un 99% de trabajo.\"",
			"\"Los ganadores nunca abandonan y los que abandonan nunca ganan\"",
			"\"En realidad competimos con nosotros mismos, nosotros no tenemos control sobre el rendimiento de otros\"",
			"\"Elige un trabajo que te guste, y nunca tendrás que volver a trabajar en tu vida\"",
			"\"El pesimista se queja del viento, el optimista espera que cambie, pero el realista acomoda las velas\"",
			"\"La cosa más valiosa que puedes hacer es cometer un error, nada puedes aprender de ser perfecto\""};
	
	Random rand = new Random();
	JPanel contentPane = new JPanel();
	JPanel panel = new JPanel();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel title = new JLabel("FRASE DEL DIA");
    JLabel description = new JLabel("<html><p align=\"center\">"+quotes[rand.nextInt(quotes.length)]+"</p></html>");
    JTextField textField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    Button loginButton = new Button("LOGIN");
    JLabel close = new JLabel("X");
    JLabel tiger = new JLabel();
    JLabel interLogo = new JLabel();
    JButton btnClose = new JButton();
    

	public Login() {
		setLayoutManager();
		setLocationAndSize();
		setText();
		setColorsAndImage();
		invisibleButton();
		addComponentsToContainer();
		addActionEvent();
	}
	
	public void setLayoutManager() {
		contentPane.setLayout(null);
		panel.setLayout(null);
		setContentPane(contentPane);
    }
	
	public void setLocationAndSize() {
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 346, 592);
		tiger.setBounds(-38, 0, 420, 275);
		title.setBounds(109, 316, 133, 27);
		description.setBounds(40, 356, 270, 74);
        userLabel.setBounds(398, 193, 114, 14);
        passwordLabel.setBounds(398, 269, 96, 14);
        close.setBounds(691, 13, 37, 27);
        textField.setBounds(398, 220, 283, 36);
        passwordField.setBounds(398, 296, 283, 36);
        loginButton.setBounds(398, 377, 283, 41);
        interLogo.setBounds(410, 13, 289, 167);
        btnClose.setBounds(691, 0, 43, 41);
    }
	
	public void setText() {
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		description.setFont(new Font("Tahoma", Font.PLAIN, 13));
		close.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
	
	public void setColorsAndImage() {
		tiger.setIcon(new ImageIcon(Login.class.getResource("/images/tiger.jpg")));
		interLogo.setIcon(new ImageIcon(Login.class.getResource("/images/inter_logo.jpg")));
		panel.setBackground(new Color(0, 125, 0));
		contentPane.setBackground(Color.WHITE);
		title.setForeground(new Color(240, 248, 255));
		description.setForeground(new Color(240, 248, 255));
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(0, 125, 0));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setForeground(new Color(0, 125, 0));
	}
	
	public void addComponentsToContainer() {
		panel.add(title);
		panel.add(tiger);
		panel.add(description);
		contentPane.add(panel);
        contentPane.add(userLabel);
        contentPane.add(passwordLabel);
        contentPane.add(textField);
        contentPane.add(passwordField);
        contentPane.add(loginButton);
        contentPane.add(close);
        contentPane.add(interLogo);
        contentPane.add(btnClose);
    }
	
	public void invisibleButton() {
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
	}
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        btnClose.addActionListener(this);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == loginButton) {
    		 String userText = textField.getText();
             String pwdText = passwordField.getText();
//             JOptionPane.showMessageDialog(this, "Login Successful");
//             if (userText.equalsIgnoreCase("kevin") && pwdText.equalsIgnoreCase("123")) {
//                 JOptionPane.showMessageDialog(this, "Login Successful");
//             } else {
//                 JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//             }
 		
    	}
    	if(e.getSource() == btnClose) {
    		System.exit(0);
    	}
	}
}