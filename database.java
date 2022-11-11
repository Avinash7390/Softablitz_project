package model;
import javafx.stage.Stage;

import java.sql.*;
public class database {
    Connection connection;
    public Statement statement;
    public  database(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/softablitz_cal_pro_history","root","avi@7390");
            statement=connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
