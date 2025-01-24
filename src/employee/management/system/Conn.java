package employee.management.system;
import java.sql.*;


public class Conn {
    
    Connection con;
    PreparedStatement pstmt;
    
    public Conn() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "Chaithanya@4");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
