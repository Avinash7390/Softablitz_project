package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.database;

import java.beans.Introspector;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;
import java.util.ResourceBundle;

public class Base_conversion_controller implements Initializable {
    public ComboBox<String> FromComboBoxID;
    public TextField PromptTextFieldID;
    public Button ButtonFieldID;
    public TextField ResultTextFieldID;
    public Hyperlink HyperLinkID;

    public void onActionButton(ActionEvent actionEvent) {
        String promptText=PromptTextFieldID.getText();
        Integer Number=Integer.parseInt(promptText);
        String ComboBoxTxt=FromComboBoxID.getValue();
        Integer res=0;
        String ans=null;
        if(Objects.equals(ComboBoxTxt, "Decimal")){
            res=Number;
            ans=res.toString();
            ResultTextFieldID.setText(ans);
        }else if(Objects.equals(ComboBoxTxt, "Binary")){
            int []arr=new int[100];
            int c=0;
            int  x=Number;
            while(x>0){
                arr[c++]=x%2;
                x=x/2;
            }
            int a=0;
            int []arr2=new int[c];
            for(int i=c-1;i>=0;i--){
                arr2[a++]=arr[i];
            }
             ans= Arrays.toString(arr2).replaceAll("\\[|\\]|,|\\s", "");
            ResultTextFieldID.setText(ans);
        }else if(Objects.equals(ComboBoxTxt, "Octal")){
            int []arr=new int[100];
            int c=0;
            int  x=Number;
            while(x>0){
                arr[c++]=x%8;
                x=x/8;
            }
            int a=0;
            int []arr2=new int[c];
            for(int i=c-1;i>=0;i--){
                arr2[a++]=arr[i];
            }
            ans= Arrays.toString(arr2).replaceAll("\\[|\\]|,|\\s", "");
            ResultTextFieldID.setText(ans);

        }else if(Objects.equals(ComboBoxTxt, "HDecimal")){
            char []arr=new char[100];
            int c=0;
            int  x=Number;
            while(x>0){
                if(x%16<10){
                    arr[c++]=(char)(48+(x%16));
                }else{
                    arr[c++]=(char)(55+(x%16));
                }
                x=x/16;
            }
//            int a=0;
//            int []arr2=new int[c];
//            for(int i=c-1;i>=0;i--){
//                arr2[a++]=arr[i];
//            }
//            String ans= Arrays.toString(arr2).replaceAll("\\[|\\]|,|\\s", "");
//            ResultTextFieldID.setText(ans);
            StringBuilder str=new StringBuilder();
            for(int i=c-1;i>=0;i--){
                str.append(arr[i]);
            }
             ans= String.valueOf(str);
            ResultTextFieldID.setText(ans);

        }
        try{
            int Fromval= Number;
            String rse=ans;

            database d1=new database();
            String query="insert into history4 (DecimalNo,convertedtype) values('"+ Fromval +"','"+ rse +"')";
            d1.statement.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FromComboBoxID.setItems(FXCollections.observableArrayList("Decimal","Binary","Octal","HDecimal"));
    }

    public void SwitchToHomePage(ActionEvent actionEvent) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../view/view1.fxml"));
        Stage stage= (Stage) HyperLinkID.getScene().getWindow();
        Scene scene=null;
        try{
            scene=new Scene(loader.load());

        }catch (Exception e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Calculator");

    }
}
