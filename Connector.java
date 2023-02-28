// Creating a class for connect our database with our program.....

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {

    // Declaring variables Globally
    Connection con;
    Statement stmt;

    // Constructor Method
    Connector(){
        // Here we use try & catch because the operation is happening outside the java. That is creating connection with the database.
        try{
            // Create connection with database

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hotel?characterEncoding=latin1";
            String user = "root";
            String pwd = "root9771";

            con = DriverManager.getConnection(url,user,pwd);
            stmt = con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
