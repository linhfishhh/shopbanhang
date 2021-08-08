package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSql {
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/case_study";
        String user="root";
        String pwd="123@123a";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, pwd);
        }catch(Exception e){
            return null;
        }
    }
}
