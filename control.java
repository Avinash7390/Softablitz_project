
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.*;


public class control {

    private Double currentDigit, finalResult;
    private String currentOperation;
    Boolean resultOperation = false;
    @FXML

    private TextField txtDisplay;//=new TextField();
    //you can not write in textfield
    //txtDisplay.setEditable(false);


    //@Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }

    @FXML
    private void handleDigitAction(ActionEvent event) {
        if (resultOperation) {
            txtDisplay.clear();
            resultOperation = false;
        }
        String digit = ((Button) event.getSource()).getText();
        String oldText = txtDisplay.getText();
        String newText = oldText + digit;
        //String digit=((Button)event.getSource()).getText();
        txtDisplay.setText(newText);
        //currentDigit = Double.parseDouble(newText);

    }

    @FXML
    private void handleOperationAction(ActionEvent event) {
        String newText = txtDisplay.getText();
        Double newDigit = Double.parseDouble(newText);
        currentDigit = newDigit;
        currentOperation = ((Button) event.getSource()).getText();
        txtDisplay.setText(currentDigit + currentOperation);

    }
    //function for seting up textfield for trigo functions
   public void handle_trigo_operations(ActionEvent actionEvent) {
        txtDisplay.clear();
        String text= ((Button) actionEvent.getSource()).getText();
        txtDisplay.setText(text);
        resultOperation=false;
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
        Double num1, num2, result;
        String newText = txtDisplay.getText();
        System.out.println(newText);
//        Double newDigit = Double.parseDouble(newText);
        if (newText.contains("+")) {
            String[] parts = newText.split("\\+");
            String part1 = parts[0];
            String part2 = parts[1];
            num1 = Double.parseDouble(part1);
            num2 = Double.parseDouble(part2);
            result = num1 + num2;
            txtDisplay.setText(result.toString());
        } else if (newText.contains("-")) {
            String[] parts = newText.split("-");
            String part1 = parts[0];
            String part2 = parts[1];
            num1 = Double.parseDouble(part1);
            num2 = Double.parseDouble(part2);
            result = num1 - num2;
            txtDisplay.setText(result.toString());
        } else if (newText.contains("/")) {
            String[] parts = newText.split("/");
            String part1 = parts[0];
            String part2 = parts[1];
            num1 = Double.parseDouble(part1);
            num2 = Double.parseDouble(part2);
            result = num1 / num2;
            txtDisplay.setText(result.toString());
        } else if (newText.contains("X")) {
            String[] parts = newText.split("X");
            String part1 = parts[0];
            String part2 = parts[1];
            num1 = Double.parseDouble(part1);
            num2 = Double.parseDouble(part2);
            result = num1 * num2;
            txtDisplay.setText(result.toString());
// Date- 6/11/2022   8:34pm 
// Trigononometric functions            
        } else if(newText.contains("SIN")){
            String[] parts=newText.split("N");
            String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "PI")){
                part2="0";
            }else if(Objects.equals(part2, "180")){
                part2="0";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            result=Math.sin(radiuns);
            txtDisplay.setText(result.toString());

        } else if (newText.contains("cosec")) {
            String[] parts=newText.split("ec");
            String part2=parts[1];
//            String newstr = null;
//            if(part2=="π"){
//                newstr="180";
//            }
            if(Objects.equals(part2, "PI")){
                part2="0";
            }else if(Objects.equals(part2, "180")){
                part2="0";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            double rev =Math.sin(radiuns);
//            result=1/rev;
//            txtDisplay.setText(result.toString());
            String newstr=null;
            Double ans;
            if(rev==0.0) {
                newstr="Undefined";
                txtDisplay.setText(newstr.toString());
            }else{
                ans=1/rev;
                txtDisplay.setText(ans.toString());
            }
        }else if(newText.contains("COS")){
            String[] parts=newText.split("S");
            String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "PI")){
                part2="180";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            result=Math.cos(radiuns);
            txtDisplay.setText(result.toString());
        } else if (newText.contains("TAN")) {
            String[] parts=newText.split("N");
            String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "PI")){
                part2="0";
            }else if(Objects.equals(part2, "180")){
                part2="0";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            result=Math.tan(radiuns);
            txtDisplay.setText(result.toString());
        }else if(newText.contains("cot")){
            String[] parts=newText.split("t");
           String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "PI")){
                part2="0";
            }else if(Objects.equals(part2, "180")){
                part2="0";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            double rev=Math.tan(radiuns);
            String newstr=null;
            Double ans;
            if(rev==0.0) {
                newstr="Undefined";
                txtDisplay.setText(newstr.toString());
            }else{
                ans=1/rev;
                txtDisplay.setText(ans.toString());
            }
            //txtDisplay.setText(result.toString());
        }else if(newText.contains("sec")){
            String[] parts=newText.split("c");
            String part2=parts[1];
            if(Objects.equals(part2, "PI")){
                part2="180";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            double rev=Math.cos(radiuns);
            result=1/rev;
            txtDisplay.setText(result.toString());
        }
     
        resultOperation = true;

    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        txtDisplay.clear();
    }
    @FXML
    private void handleBackspaceAction(ActionEvent event) {
        StringBuffer sb = new StringBuffer(txtDisplay.getText());
        sb = sb.deleteCharAt(txtDisplay.getText().length() - 1);
        txtDisplay.setText(sb.toString());

    }
}


