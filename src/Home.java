import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.BoxLayout;

public class Home extends JFrame implements ActionListener {
	
	Content courses = new Content("courses");
	Content instructors = new Content("instructors");
	Content planning = new Content("planning");
	Dashboard dashboard = new Dashboard();
	
	JPanel sideBar = new JPanel();
	JPanel dashboardPanel = new JPanel();
	JPanel shiftPanel = new JPanel();
	JPanel profilePanel = new JPanel();
	JLabel iconInstructor = new JLabel();
	JLabel iconDashboard = new JLabel();
	JLabel iconShift = new JLabel();
	JLabel lblDashboard = new JLabel("Dashborad");
	JLabel lblShift = new JLabel("Shift Planning");
	JLabel lblProfile = new JLabel("Instructors");
	JLabel lblCourses = new JLabel("Courses");
	JLabel logoINTER = new JLabel();
	JPanel contentPane = new JPanel();
	JLabel close = new JLabel();
	JPanel dashboardPane = new JPanel();
	JPanel topPanel = new JPanel();
	JButton btnShift = new JButton();
	JButton btnInstructor = new JButton();
	JButton btnCourses = new JButton();
	JButton btnDashboard = new JButton();
	JButton btnClose = new JButton();
	JButton btnHide = new JButton();
	JLabel iconHide = new JLabel();
	JLabel iconCourses = new JLabel();
	JPanel coursesPane = new JPanel();
	
	boolean hideSideBar = true;
	JPanel hidePane = new JPanel();
	


	public static void main(String[] args) {
		Home home = new Home();
	}


	public Home() {
		init();	
	}

	
	private void init() {
		setUndecorated(true);
		setLocationRelativeTo(null);
        setResizable(false);
        setColorsAndImage();
		setLayoutManager();
		setLocationAndSize();
		setText();
		setInvisibleButtons();
		addComponentsToPanel();
		addActionEvent();
		setVisible(true);
	}
	
	private void setLayoutManager() {
		getContentPane().setLayout(null);
		sideBar.setLayout(null);
		dashboardPanel.setLayout(null);
		dashboardPane.setLayout(null);
		shiftPanel.setLayout(null);
		profilePanel.setLayout(null);
		contentPane.setLayout(null);
		hidePane.setLayout(null);
		coursesPane.setLayout(null);
		topPanel.setLayout(null);
    }
	
	private void setLocationAndSize() {
		setBounds(100, 100, 1600, 900);
		sideBar.setBounds(0, 96, 422, 804);
		dashboardPanel.setBounds(0, 0, 422, 79);
		shiftPanel.setBounds(0, 79, 422, 79);
		iconDashboard.setBounds(0, 0, 96, 79);
		iconShift.setBounds(0, 0, 96, 79);
		lblShift.setBounds(108, 23, 230, 32);
		iconInstructor.setBounds(0, 0, 96, 79);
		lblProfile.setBounds(108, 23, 230, 32);
		profilePanel.setBounds(0, 158, 422, 79);
		logoINTER.setBounds(0, 0, 423, 97);
		contentPane.setBounds(422, 96, 1178, 824);
		lblDashboard.setBounds(108, 23, 230, 32);
		topPanel.setBounds(0, 0, 1600, 96);
		btnDashboard.setBounds(0, 0, 423, 79);
		btnInstructor.setBounds(0, 0, 423, 79);
		btnShift.setBounds(0, 0, 423, 79);
		btnClose.setBounds(1512, 0, 88, 97);
		iconHide.setBounds(0, 0, 53, 53);
		btnHide.setBounds(0, 0, 53, 53);
		hidePane.setBounds(422, 110, 53, 53);
		coursesPane.setBounds(0, 237, 422, 79);
		iconCourses.setBounds(0, 0, 96, 79);
		lblCourses.setBounds(108, 23, 230, 32);
		btnCourses.setBounds(0, 0, 423, 79);
		close.setBounds(1512, 0, 88, 97);
    }
	
	private void setText() {
		lblShift.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblProfile.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblDashboard.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCourses.setFont(new Font("Segoe UI", Font.BOLD, 24));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		iconHide.setHorizontalAlignment(SwingConstants.CENTER);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		iconDashboard.setHorizontalAlignment(SwingConstants.CENTER);
		iconShift.setHorizontalAlignment(SwingConstants.CENTER);
		iconInstructor.setHorizontalAlignment(SwingConstants.CENTER);
		iconCourses.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setColorsAndImage() {
		// Images
		logoINTER.setIcon(new ImageIcon(Login.class.getResource("/images/logo.jpg")));
		iconDashboard.setIcon(new ImageIcon(Home.class.getResource("/icons/iconDashboard.png")));
		iconShift.setIcon(new ImageIcon(Home.class.getResource("/icons/shiftPlanning.png")));
		iconInstructor.setIcon(new ImageIcon(Home.class.getResource("/icons/iconInstructor.png")));
		iconHide.setIcon(new ImageIcon(Home.class.getResource("/icons/iconHideLeft.png")));
		iconCourses.setIcon(new ImageIcon(Home.class.getResource("/icons/iconCourses.png")));
		close.setIcon(new ImageIcon(Home.class.getResource("/icons/iconClose.png")));
		
		// Colors
		lblDashboard.setForeground(new Color(255, 255, 255));
		sideBar.setBackground(new Color(0, 128, 0));
		dashboardPanel.setBackground(new Color(102, 204, 0));
		shiftPanel.setBackground(new Color(34, 139, 34));
		profilePanel.setBackground(new Color(34, 139, 34));
		hidePane.setBackground(new Color(254,209,66));
		coursesPane.setBackground(new Color(34, 139, 34));
		contentPane.setBackground(new Color(255, 255, 255));
		close.setForeground(new Color(0, 125, 0));
		lblShift.setForeground(Color.WHITE);
		lblProfile.setForeground(Color.WHITE);
		lblCourses.setForeground(Color.WHITE);
		topPanel.setBackground(Color.WHITE);
	}
	
	public void addComponentsToPanel() {
		getContentPane().add(hidePane);
		getContentPane().add(sideBar);
		getContentPane().add(topPanel);
		getContentPane().add(contentPane);
		sideBar.add(dashboardPanel);
		sideBar.add(shiftPanel);
		sideBar.add(profilePanel);
		dashboardPanel.add(lblDashboard);
		dashboardPanel.add(iconDashboard);
		dashboardPanel.add(btnDashboard);
		shiftPanel.add(iconShift);
		shiftPanel.add(lblShift);
		shiftPanel.add(btnShift);
		profilePanel.add(iconInstructor);
		profilePanel.add(lblProfile);
		profilePanel.add(btnInstructor);
		hidePane.add(iconHide);
		hidePane.add(btnHide);
		sideBar.add(coursesPane);
		coursesPane.add(iconCourses);
		coursesPane.add(lblCourses);
		coursesPane.add(btnCourses);
		topPanel.add(logoINTER);
		topPanel.add(close);
		contentPane.add(dashboard); 
		topPanel.add(btnClose);
    }
	
	public void setInvisibleButtons() {
		btnDashboard.setOpaque(false);
		btnDashboard.setContentAreaFilled(false);
		btnDashboard.setBorderPainted(false);
		btnShift.setOpaque(false);
		btnShift.setContentAreaFilled(false);
		btnShift.setBorderPainted(false);
		btnCourses.setOpaque(false);
		btnCourses.setContentAreaFilled(false);
		btnCourses.setBorderPainted(false);
		btnInstructor.setOpaque(false);
		btnInstructor.setContentAreaFilled(false);
		btnInstructor.setBorderPainted(false);
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnHide.setOpaque(false);
		btnHide.setContentAreaFilled(false);
		btnHide.setBorderPainted(false);
	}
	
 
    public void addActionEvent() {
		btnDashboard.addActionListener(this);
		btnShift.addActionListener(this);
		btnInstructor.addActionListener(this);
		btnCourses.addActionListener(this);
		btnClose.addActionListener(this);
		btnHide.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnDashboard) {
			dashboardPanel.setBackground(new Color(102, 204, 0));
			shiftPanel.setBackground(new Color(34, 139, 34));
			profilePanel.setBackground(new Color(34, 139, 34));
			coursesPane.setBackground(new Color(34, 139, 34));
			
			contentPane.removeAll();
			contentPane.repaint();
			contentPane.revalidate();
			contentPane.add(dashboard);
			
		}
		if (e.getSource() == btnShift) {
			dashboardPanel.setBackground(new Color(34, 139, 34));
			shiftPanel.setBackground(new Color(102, 204, 0));
			profilePanel.setBackground(new Color(34, 139, 34));
			coursesPane.setBackground(new Color(34, 139, 34));
			
			contentPane.removeAll();
			contentPane.repaint();
			contentPane.revalidate();
			contentPane.add(planning);
		}
		if (e.getSource() == btnInstructor) {
			dashboardPanel.setBackground(new Color(34, 139, 34));
			shiftPanel.setBackground(new Color(34, 139, 34));
			profilePanel.setBackground(new Color(102, 204, 0));
			coursesPane.setBackground(new Color(34, 139, 34));
			
			contentPane.removeAll();
			contentPane.repaint();
			contentPane.revalidate();
			contentPane.add(instructors);
		}
		if (e.getSource() == btnCourses) {
			dashboardPanel.setBackground(new Color(34, 139, 34));
			shiftPanel.setBackground(new Color(34, 139, 34));
			profilePanel.setBackground(new Color(34, 139, 34));
			coursesPane.setBackground(new Color(102, 204, 0));
			
			contentPane.removeAll();
			contentPane.repaint();
			contentPane.revalidate();
			contentPane.add(courses);
		}
		if (e.getSource() == btnHide) {
			if(hideSideBar) {
				contentPane.setBounds(0, 96, 1600, 824);
				hidePane.setBounds(0, 110, 53, 53);
				iconHide.setIcon(null);
				iconHide.setIcon(new ImageIcon(Home.class.getResource("/icons/iconHideRight.png")));
				sideBar.setVisible(false);
				
				// Shift Planning Resize
//				panel.setBounds(0, 0, 1600, 907);
//				panel_4.setBounds(0, 0, 1600, 79);
//				professorPanel.setBounds(952+422, 13, 63, 53);
//				possitionPanel.setBounds(1015+422, 13, 63, 53);
//				listviewPanel.setBounds(1078+422, 13, 63, 53);
//				tablePanel.setBounds(0, 81, 1600, 723);
				
				// Instructor Resize
//				instructorsPane.setBounds(0, 0, 1600, 907);
//				instrsTopPane.setBounds(0, 0, 1600, 81);
//				instrTablePanel.setBounds(0, 81, 1600, 729);
//				editInstructorPane.setBounds(935+422, 13, 206, 53);
				

				hideSideBar = false;
			} else {
				contentPane.setBounds(422, 96, 1178, 824);
				hidePane.setBounds(422, 110, 53, 53);
				iconHide.setIcon(null);
				iconHide.setIcon(new ImageIcon(Home.class.getResource("/icons/iconHideLeft.png")));
				sideBar.setVisible(true);
				
				// Shift Planning Resize
//				panel.setBounds(0, 0, 1178, 907);
//				panel_4.setBounds(0, 0, 1178, 79);
//				professorPanel.setBounds(952, 13, 63, 53);
//				possitionPanel.setBounds(1015, 13, 63, 53);
//				listviewPanel.setBounds(1078, 13, 63, 53);
//				tablePanel.setBounds(0, 81, 1178, 723);
				
				// Instructor Resize
//				instructorsPane.setBounds(0, 0, 1178, 907);
//				instrsTopPane.setBounds(0, 0, 1178, 81);
//				instrTablePanel.setBounds(0, 81, 1178, 729);
//				editInstructorPane.setBounds(935, 13, 206, 53);
				

				hideSideBar = true;
			}
		}
		if (e.getSource() == btnClose) {
			System.exit(0);
		}
		iconHide.repaint();
	}
}
