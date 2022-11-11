package controller;
//import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.database;

//import java.util.*;
//import java.io.*;
//import javafx.event.ActionEvent;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Button;

import java.util.Objects;
//import javafx.scene.control.TextField;

public class currency_controller implements Initializable{


//    public TextField FromTextField;
//    public TextField ToTextField;

    public TextField ResultTextField;
    public TextField AmountTextField;
    public Button ConverButton;
    public ComboBox<String> FromComboBox;
    public Hyperlink HyprlinkId;
    public ComboBox<String > ToComboBox;

    public void buttonaction  (ActionEvent actionEvent) {
            Double res=0.0;
            String amounttxtfield=AmountTextField.getText();
            Double amount=Double.parseDouble(amounttxtfield);
            String fromDropBox=FromComboBox.getValue();
            String toDropBox=ToComboBox.getValue();
            if(Objects.equals(fromDropBox, "USD") && Objects.equals(toDropBox, "INR")){
               res=amount*81.32;
               ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "USD") && Objects.equals(toDropBox, "EURO")){
                res=amount*0.99;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "USD") && Objects.equals(toDropBox, "YEN")){
                res=amount*145.52;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "USD") && Objects.equals(toDropBox, "USD")){
                res=amount;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "EURO") && Objects.equals(toDropBox, "EURO")){
                res=amount;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "EURO") && Objects.equals(toDropBox, "YEN")){
                res=amount*146.70;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "EURO") && Objects.equals(toDropBox, "INR")){
                res=amount*82.07;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "EURO") && Objects.equals(toDropBox, "USD")){
                res=amount/0.99;
                ResultTextField.setText(res.toString());
            }
            else if(Objects.equals(fromDropBox, "YEN") && Objects.equals(toDropBox, "YEN")){
                res=amount;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "YEN") && Objects.equals(toDropBox, "USD")){
                res=amount/145.52;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "YEN") && Objects.equals(toDropBox, "EURO")){
                res=amount/146.70;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "YEN") && Objects.equals(toDropBox, "INR")){
                res=amount/1.79;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "INR") && Objects.equals(toDropBox, "INR")){
                res=amount;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "INR") && Objects.equals(toDropBox, "USD")){
                res=amount/81.32;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "INR") && Objects.equals(toDropBox, "EURO")){
                res=amount/82.07;
                ResultTextField.setText(res.toString());
            }else if(Objects.equals(fromDropBox, "INR") && Objects.equals(toDropBox, "YEN")){
                res=amount*1.79;
                ResultTextField.setText(res.toString());
            }else{
                ResultTextField.setText("Invalid Conversion");
            }
        try{
            double Fromval=amount;
            double rse=res;
            database d1=new database();
            String query="insert into history5 (amountFrom,result) values('"+ Fromval +"','"+ rse +"')";
            d1.statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void switchToHomePage(ActionEvent actionEvent) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../view/view1.fxml"));
        Stage stage= (Stage) HyprlinkId.getScene().getWindow();
        Scene scene=null;
        try{
            scene=new Scene(loader.load());

        }catch (Exception e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Calculator");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       FromComboBox .setItems(FXCollections.observableArrayList("USD","EURO","YEN","INR"));
        ToComboBox.setItems(FXCollections.observableArrayList("USD","EURO","YEN","INR"));

    }
}
