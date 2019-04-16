import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database_connect {

    public ArrayList<Database_data> getData(String term) {
    ArrayList<Database_data> data = new  ArrayList<Database_data>();
    Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/inter_schedule", "root", "");
            if (conn !=null) {
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery("Select * from " + term);
            
            while(rst.next()) {
            	Database_data djt = null;
            	if(term == "courses") {
            		djt = new Database_data(
            				rst.getString("subject"), 
            				rst.getString("course"), 
            				rst.getString("title"), 
            				rst.getString("crdts")
            			);
            	}
            	if(term == "instructors") {
            		djt = new Database_data(
            				rst.getString("name"), 
            				rst.getString("phone"), 
            				rst.getString("email"), 
            				rst.getString("office")
            			);
            	}
            	if(term == "planning") {
            		djt = new Database_data(
            				rst.getString("course"),
            				rst.getString("name"), 
            				rst.getString("mon"), 
            				rst.getString("tue"), 
            				rst.getString("wed"),
            				rst.getString("thu"),
            				rst.getString("fri"),
            				rst.getString("sat"),
            				rst.getString("sun")
            			);
            	}
                data.add(djt);
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(DepartmentUI.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data;
    }                
}