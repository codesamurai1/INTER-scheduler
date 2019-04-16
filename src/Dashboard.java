import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Dashboard extends JPanel {
	
	JPanel topPanel = new JPanel();
	JPanel logOutPanel = new JPanel();
	JLabel logOutLabel = new JLabel("Log Out");
	JPanel profilePanel = new JPanel();
	JPanel profilePicPanel = new JPanel();
	JLabel profilePic = new JLabel();
	JPanel profileInfoPanel = new JPanel();
	JLabel lblProfileName = new JLabel("<html>Kevin E. Hernandez Vazquez</html>");
	JLabel lblCampus = new JLabel("Bayamon Campus");
	JLabel lblPosition = new JLabel("Administrator");
	JPanel coursesTotalPane = new JPanel();
	JPanel coursesTopPanel = new JPanel();
	JLabel lblCourses = new JLabel("Courses");
	JLabel coursesCount = new JLabel("0");
	JPanel instructorsTotalPane = new JPanel();
	JPanel instructorsTopPane = new JPanel();
	JLabel lblInstructors = new JLabel("Instructors");
	JLabel instructCount = new JLabel("0");
	JPanel datePanel = new JPanel();
	JLabel lblDate = new JLabel("<html>APRIL 12, 2019</html>");
	
	public Dashboard() {
		init();
	}
	
	private void init() {
		setLocationAndSize();
		setColorsAndImages();
		setText();
		setLayoutManager();
		addComponents();
	}
	
	private void setLocationAndSize() {
		setBounds(0, 0, 1178, 907);
		logOutPanel.setBounds(931, 13, 190, 53);
		logOutLabel.setBounds(0, 0, 190, 53);
		profilePanel.setBounds(59, 135, 744, 239);
		topPanel.setBounds(0, 0, 1178, 79);
		profilePicPanel.setBounds(12, 13, 213, 213);
		profilePic.setBounds(0, 0, 213, 213);
		profileInfoPanel.setBounds(249, 13, 483, 213);
		coursesTotalPane.setBounds(59, 387, 366, 365);
		coursesTopPanel.setBounds(0, 0, 1178, 81);
		lblCourses.setBounds(0, 0, 366, 78);
		coursesCount.setBounds(0, 78, 366, 287);
		instructorsTotalPane.setBounds(437, 387, 366, 365);
		instructorsTopPane.setBounds(0, 0, 366, 78);
		lblInstructors.setBounds(0, 0, 366, 78);
		instructCount.setBounds(0, 78, 366, 287);
		datePanel.setBounds(815, 135, 307, 617);
		lblDate.setBounds(12, 225, 283, 379);
	}
	
	private void setColorsAndImages() {
		// Setting colors to objects
		setBackground(Color.WHITE);
		logOutPanel.setBackground(new Color(34, 139, 34));
		logOutLabel.setForeground(Color.WHITE);
		profilePicPanel.setBackground(Color.BLACK);
		profilePanel.setBackground(new Color(34, 139, 34));
		profilePanel.setBorder(new LineBorder(new Color(34, 139, 34)));
		profileInfoPanel.setBackground(new Color(34, 139, 34));
		lblCampus.setForeground(new Color(102, 204, 0));
		lblProfileName.setForeground(Color.WHITE);
		coursesTotalPane.setBackground(new Color(102, 204, 0));
		coursesTopPanel.setBackground(new Color(34, 139, 34));
		lblCourses.setForeground(Color.WHITE);
		coursesCount.setForeground(Color.WHITE);
		instructorsTotalPane.setBackground(new Color(102, 204, 0));
		instructorsTopPane.setBackground(new Color(34, 139, 34));
		lblInstructors.setForeground(Color.WHITE);
		instructCount.setForeground(Color.WHITE);
		datePanel.setBackground(new Color(34, 139, 34));
		lblDate.setForeground(Color.WHITE);
		
		// Setting images
		profilePic.setIcon(new ImageIcon(Home.class.getResource("/images/profilePic.jpg")));
	}
	
	private void addComponents() {
		add(topPanel);
		add(datePanel);
		add(instructorsTotalPane);
		add(coursesTotalPane);
		add(profilePanel);
		logOutPanel.add(logOutLabel);
		topPanel.add(logOutPanel);
		profilePanel.add(profilePicPanel);
		profilePicPanel.add(profilePic);
		profilePanel.add(profileInfoPanel);
		profileInfoPanel.add(lblProfileName);
		profileInfoPanel.add(lblCampus);
		profileInfoPanel.add(lblPosition);
		coursesTotalPane.add(coursesTopPanel);
		coursesTopPanel.add(lblCourses);
		coursesTotalPane.add(coursesCount);
		instructorsTotalPane.add(instructorsTopPane);
		instructorsTopPane.add(lblInstructors);
		instructorsTotalPane.add(instructCount);
		datePanel.add(lblDate);
	}
	
	private void setText() {
		logOutLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		logOutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfileName.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblProfileName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCampus.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblPosition.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		lblCourses.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourses.setFont(new Font("Segoe UI", Font.BOLD, 50));
		coursesCount.setFont(new Font("Segoe UI", Font.BOLD, 90));
		coursesCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructors.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructors.setFont(new Font("Segoe UI", Font.BOLD, 50));
		instructCount.setHorizontalAlignment(SwingConstants.CENTER);
		instructCount.setFont(new Font("Segoe UI", Font.BOLD, 90));
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 90));
		profilePic.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void setLayoutManager() {
		setLayout(null);
		logOutPanel.setLayout(null);
		topPanel.setLayout(null);
		profilePanel.setLayout(null);
		profilePicPanel.setLayout(null);
		profileInfoPanel.setLayout(new BoxLayout(profileInfoPanel, BoxLayout.Y_AXIS));
		coursesTotalPane.setLayout(null);
		coursesTopPanel.setLayout(null);
		instructorsTotalPane.setLayout(null);
		instructorsTopPane.setLayout(null);
		datePanel.setLayout(null);
	}
}
