import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;

public class Content extends JPanel implements DocumentListener, FocusListener, ActionListener {
	
	JTextField search = new JTextField("Search Term");
	JPanel topPanel = new JPanel();
	JPanel addPane = new JPanel();
	JLabel addIcon = new JLabel();
	JPanel searchPane = new JPanel();
	JLabel searchIcon = new JLabel();
	JPanel tablePanel = new JPanel();
	JPanel editPane = new JPanel();
	JLabel editIcon = new JLabel();
	JPanel remove = new JPanel();
	JLabel removeIcon = new JLabel();
	JButton addButton = new JButton();
	JButton editButton = new JButton();
	JButton removeButton = new JButton();
	
	TableCreator table;
	TableRowSorter<TableModel> rowSorter;
	JScrollPane scrollPane;
	
	
	public Content(String term) {
		table = new TableCreator(term);
		rowSorter = new TableRowSorter<>(table.getModel());
		scrollPane = new JScrollPane(table);
		init();
	}
	
	private void init() {
		setText();
		setLayoutManagement();
		setLocationAndSize();
		setColorsAndImages();
		addComponents();
		invisibleButtons();
		addActionEvent();
		
		table.setRowSorter(rowSorter);
	}
	
	private void setText() {
		addIcon.setFont(new Font("Segoe UI", Font.BOLD, 24));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		editIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		search.setHorizontalAlignment(SwingConstants.LEFT);
		search.setFont(new Font("Segoe UI", Font.BOLD, 24));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		removeIcon.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private void addComponents() {
		add(topPanel);
		add(tablePanel);
		topPanel.add(addPane);
		addPane.add(addButton);
		addPane.add(addIcon);
		searchPane.add(searchIcon);
		topPanel.add(searchPane);
		topPanel.add(search);
		topPanel.add(editPane);
		editPane.add(editButton);
		editPane.add(editIcon);
		topPanel.add(remove);
		tablePanel.add(scrollPane);
		remove.add(removeButton);
		remove.add(removeIcon);
	}
	
	private void setLayoutManagement() {
		setLayout(null);
		topPanel.setLayout(null);
		addPane.setLayout(null);
		searchPane.setLayout(null);
		editPane.setLayout(null);
		tablePanel.setLayout(new GridLayout(0, 1, 0, 0));
		remove.setLayout(null);
	}
	
	private void setLocationAndSize() {
		setBounds(0, 0, 1178, 907);
		topPanel.setBounds(0, 0, 1178, 81);
		addPane.setBounds(1015, 13, 63, 53);
		editButton.setBounds(0, 0, 63, 53);
		addIcon.setBounds(0, 0, 63, 53);
		search.setMargin(new Insets(2, 14, 2, 2));
		search.setBounds(155, 13, 293, 54);
		searchPane.setBounds(95, 13, 60, 53);
		removeButton.setBounds(0, 0, 63, 53);
		searchIcon.setBounds(0, 0, 60, 53);
		editPane.setBounds(952, 13, 63, 53);
		editIcon.setBounds(0, 0, 63, 53);
		tablePanel.setBounds(0, 80, 1178, 729);
		remove.setBounds(1078, 13, 63, 53);
		removeIcon.setBounds(0, 0, 63, 53);
		addButton.setBounds(0, 0, 63, 53);
	}
	
	private void setColorsAndImages() {
		// Setting colors
		setBackground(new Color(255, 255, 255));
		addPane.setBackground(new Color(102, 204, 0));
		addIcon.setForeground(Color.WHITE);
		search.setForeground(new Color(190, 190, 190));
		searchPane.setBackground(new Color(34, 139, 34));
		searchIcon.setForeground(SystemColor.controlHighlight);
		searchPane.setForeground(SystemColor.controlHighlight);
		editPane.setBackground(new Color(34, 139, 34));
		remove.setBackground(new Color(102, 204, 0));
		
		// Setting images
		searchIcon.setIcon(new ImageIcon(Home.class.getResource("/icons/iconSearch.png")));
		addIcon.setIcon(new ImageIcon(Home.class.getResource("/icons/iconAdd.png")));
		editIcon.setIcon(new ImageIcon(Home.class.getResource("/icons/iconEdit.png")));
		removeIcon.setIcon(new ImageIcon(Home.class.getResource("/icons/iconRemove.png")));
	}
	
	private void invisibleButtons() {
		addButton.setOpaque(false);
		addButton.setContentAreaFilled(false);
		addButton.setBorderPainted(false);
		editButton.setOpaque(false);
		editButton.setContentAreaFilled(false);
		editButton.setBorderPainted(false);
		removeButton.setOpaque(false);
		removeButton.setContentAreaFilled(false);
		removeButton.setBorderPainted(false);
	}
	
	private void addActionEvent() {
		search.getDocument().addDocumentListener(this);
		search.addFocusListener(this);
		addButton.addActionListener(this);
		removeButton.addActionListener(this);
		editButton.addActionListener(this);
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		throw new UnsupportedOperationException("Not supported yet.");
	}


	@Override
	public void insertUpdate(DocumentEvent arg0) {
		String text = search.getText();

        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
	}


	@Override
	public void removeUpdate(DocumentEvent arg0) {
		String text = search.getText();

        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
	}


	@Override
	public void focusGained(FocusEvent arg0) {
		search.setText("");
    	search.setForeground(new Color(34, 139, 34));
	}


	@Override
	public void focusLost(FocusEvent arg0) {
		// Nothing
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			System.out.println("Adding");
		}
		if(e.getSource() == removeButton) {
			System.out.println("Removing");
		}
		if(e.getSource() == editButton) {
			System.out.println("Editing");
		}
	}
}
