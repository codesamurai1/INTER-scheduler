import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableCreator extends JTable {
	
	TableColumnModel columnModel = getColumnModel();
	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	JTableHeader tHeader = getTableHeader();
	Database_connect connect = new Database_connect();
	

	public TableCreator(String term) {
		setTable(term);
		init();
	}
	
	
	private void init() {
		setIntercellSpacing(new Dimension(0, 0));
		setShowGrid(false);
		setFocusable(false);
		setSelectionBackground(new Color(254,209,66));
		setGridColor(new Color(0, 100, 0));
		setAutoCreateColumnsFromModel(false);
		setFocusTraversalKeysEnabled(false);
		setShowVerticalLines(false);
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Segoe UI", Font.PLAIN, 22));
		getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 24));
		setRowHeight(86);
		tHeader.setBackground(new Color(34, 139, 34));
		tHeader.setForeground(new Color(255, 255, 255));
	}
	
	private void setTable(String term) {
		int termType = 0;
		if(term=="courses") termType = 1; 
		if(term=="instructors") termType = 2;
		if(term=="planning") termType = 3;
		
		switch (termType) {
		// Courses
		case 1:
			// Header
			setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		            	"Subject", "Course","Title","Crdts"
		            }
		        ));
			
			// Spacing
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			columnModel.getColumn(0).setPreferredWidth(50);
			columnModel.getColumn(1).setPreferredWidth(50);
			columnModel.getColumn(2).setPreferredWidth(500);
			columnModel.getColumn(3).setPreferredWidth(50);
			getDepartment("courses");
			break;
		// Instructors
		case 2:
			// Header
			setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		            	"Name", "Phone", "Email", "Office"
		            }
		        ));
			// Spacing
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			columnModel.getColumn(0).setPreferredWidth(200);
			columnModel.getColumn(1).setPreferredWidth(100);
			columnModel.getColumn(2).setPreferredWidth(300);
			columnModel.getColumn(3).setPreferredWidth(20);
			getDepartment("instructors");
			break;
		// Shift Planning
		case 3:
			// Header
			setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            new String [] {
		            	"Course", "Name", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
		            }
		        ));
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(6).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(7).setCellRenderer( centerRenderer );
			getColumnModel().getColumn(8).setCellRenderer( centerRenderer );
			columnModel.getColumn(0).setPreferredWidth(20);
			columnModel.getColumn(1).setPreferredWidth(200);
			columnModel.getColumn(2).setPreferredWidth(20);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(20);
			columnModel.getColumn(5).setPreferredWidth(20);
			columnModel.getColumn(6).setPreferredWidth(20);
			columnModel.getColumn(7).setPreferredWidth(20);
			columnModel.getColumn(8).setPreferredWidth(20);
			getDepartment("planning");
			break;
		}
	}
	
	
	private void getDepartment(String term){
		ArrayList<Database_data> list = connect.getData(term);
        DefaultTableModel dtm = (DefaultTableModel) getModel();
        if(term == "planning") {
        	Object[] obj = new Object[9];
            for(int i = 0; i< list.size(); i++) {
                obj[0] = list.get(i).getColumn_1();
                obj[1] = list.get(i).getColumn_2();
                obj[2] = list.get(i).getColumn_3();
                obj[3] = list.get(i).getColumn_4();
                obj[4] = list.get(i).getColumn_5();
                obj[5] = list.get(i).getColumn_6();
                obj[6] = list.get(i).getColumn_7();
                obj[7] = list.get(i).getColumn_8();
                obj[8] = list.get(i).getColumn_9();
                dtm.addRow(obj);
            }
        } else {
        	Object[] obj = new Object[4];
            for(int i = 0; i< list.size(); i++) {
                obj[0] = list.get(i).getColumn_1();
                obj[1] = list.get(i).getColumn_2();
                obj[2] = list.get(i).getColumn_3();
                obj[3] = list.get(i).getColumn_4();
                dtm.addRow(obj);
            }
        }
    }
	
	// Table disable editing
//	DefaultTableModel model = new DefaultTableModel(rowData, columnNames) {
//		@Override
//		public Class<?> getColumnClass(int column) {
//			// TODO Auto-generated method stub
//			switch(column) {
//            case 0: return ImageIcon.class;
//            default: return Object.class;
//			}
//		}
//		@Override
//		public boolean isCellEditable(int row, int column) {
//			return false;
//		};
//	};
}
