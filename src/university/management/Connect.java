
package university.management;
import java.sql.*;


public class Connect {
    
    Connection c;
    Statement s;
    
    Connect(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagement","root","Tnselva@24680");
            s = c.createStatement();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
