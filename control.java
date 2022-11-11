
package controller;

import java.io.IOException;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.database;
import java.sql.*;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.Stack;
// A class which will perform simple calculation and arithmetic expression evaluation
// Basically the algo inside the class is based on the Edgar Dijkstra algo which convert the infix expression into prefix and postfix
 class EvaluateString
{
    public  double evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Double> values = new
                Stack<Double>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new
                Stack<Character>();

    for (int i = 0; i < tokens.length; i++) {

        // Current token is a
        // whitespace, skip it
        if (tokens[i] == ' ')
            continue;

        // Current token is a number,
        // push it to stack for numbers
        if (tokens[i] >= '0' &&
                tokens[i] <= '9') {
            StringBuffer sbuf = new
                    StringBuffer();

            // There may be more than one
            // digits in number
            while (i < tokens.length &&
                    tokens[i] >= '0' &&
                    tokens[i] <= '9')
                sbuf.append(tokens[i++]);
            values.push(Double.parseDouble(sbuf.
                    toString()));

            // right now the i points to
            // the character next to the digit,
            // since the for loop also increases
            // the i, we would skip one
            //  token position; we need to
            // decrease the value of i by 1 to
            // correct the offset.
            i--;
        }

        // Current token is an opening brace,
        // push it to 'ops'
        else if (tokens[i] == '(')
            ops.push(tokens[i]);

            // Closing brace encountered,
            // solve entire brace
        else if (tokens[i] == ')') {
            while (ops.peek() != '(')
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            ops.pop();
        }

        // Current token is an operator.
        else if (tokens[i] == '+' ||
                tokens[i] == '-' ||
                tokens[i] == 'X' ||
                tokens[i] == '/') {
            // While top of 'ops' has same
            // or greater precedence to current
            // token, which is an operator.
            // Apply operator on top of 'ops'
            // to top two elements in values stack
            while (!ops.empty() &&
                    hasPrecedence(tokens[i],
                            ops.peek()))
                values.push(applyOp(ops.pop(),
                        values.pop(),
                        values.pop()));

            // Push current token to 'ops'.
            ops.push(tokens[i]);
        }

    }


        // Entire expression has been
        // parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));

        // Top of 'values' contains
        // result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public  boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == 'X' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public  double applyOp(char op,
                              double b, double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'X':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a*1.0 / b;
        }
        return 0;
    }
}
public class control {
    public Button WeightField;
    public Button CurrencyField;
    public Button LengthField;
    public Button BaseID;
    //private Double currentDigit;
    ///private String currentOperation;
    Boolean resultOperation = false;
    EvaluateString EV=new EvaluateString();
    @FXML

    private TextField txtDisplay;



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
        //Double newDigit = Double.parseDouble(newText);
       // currentDigit = newDigit;
         String currentOperation = ((Button) event.getSource()).getText();
        txtDisplay.setText(newText + currentOperation);
    }

    public void handle_trigo_operations(ActionEvent actionEvent) {
        txtDisplay.clear();
        String text= ((Button) actionEvent.getSource()).getText();
        txtDisplay.setText(text);
        resultOperation=false;
    }
    @FXML
    private void handleEqualOperation(ActionEvent event) {
        Double num1, num2, result=0.0;
        String newText = txtDisplay.getText();
        System.out.println(newText);
//        Double newDigit = Double.parseDouble(newText);
//        if (newText.contains("+")) {
//            String[] parts = newText.split("\\+");
//            String part1 = parts[0];
//            String part2 = parts[1];
//            num1 = Double.parseDouble(part1);
//            num2 = Double.parseDouble(part2);
//            result = num1 + num2;
//            txtDisplay.setText(result.toString());
//        } else if (newText.contains("-")) {
//            String[] parts = newText.split("-");
//            String part1 = parts[0];
//            String part2 = parts[1];
//            num1 = Double.parseDouble(part1);
//            num2 = Double.parseDouble(part2);
//            result = num1 - num2;
//            txtDisplay.setText(result.toString());
//        } else if (newText.contains("/")) {
//            String[] parts = newText.split("/");
//            String part1 = parts[0];
//            String part2 = parts[1];
//            num1 = Double.parseDouble(part1);
//            num2 = Double.parseDouble(part2);
//            result = num1 / num2;
//            txtDisplay.setText(result.toString());
//        } else if (newText.contains("X")) {
//            String[] parts = newText.split("X");
//            String part1 = parts[0];
//            String part2 = parts[1];
//            num1 = Double.parseDouble(part1);
//            num2 = Double.parseDouble(part2);
//            result = num1 * num2;
//            txtDisplay.setText(result.toString());
       // }
        if(newText.contains("SIN")){
            String[] parts=newText.split("N");
            String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "π")){
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
            if(Objects.equals(part2, "π")){
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
            if(Objects.equals(part2, "π")){
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
            if(Objects.equals(part2, "π")){
                part2="0";
            }else if(Objects.equals(part2, "180")){
                part2="0";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            result=Math.tan(radiuns);
            txtDisplay.setText(result.toString());
        }
        else if(newText.contains("cot")){
            String[] parts=newText.split("t");
           String part2=parts[1];
//            if(part2=="π"){
//                part2="180";
//            }
            if(Objects.equals(part2, "π")){
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
            if(Objects.equals(part2, "π")){
                part2="180";
            }
            int num=Integer.parseInt(part2);
            double radiuns=Math.toRadians(num);
            double rev=Math.cos(radiuns);
            result=1/rev;
            txtDisplay.setText(result.toString());
        }else if(newText.contains("+")||newText.contains("-")||newText.contains("X")||newText.contains("/")){
            result=EV.evaluate(newText);
            txtDisplay.setText(result.toString());
        }
        try{
            Double res=result;
            String Exp=newText;
            database d=new database();
            String query="insert into history (Expression,Result) values('"+ Exp +"','"+ res +"')";
            d.statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
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
    public void switchToCurrencyConversion(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/Currency.fxml"));
        Scene scene=null;
        Stage stage=(Stage) CurrencyField.getScene().getWindow();
        try{
            scene=new Scene(loader.load(),340,340);
        }catch(IOException e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Currency Convertor");
    }

    public void switchToWeightConversion(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/Weight.fxml"));
        Scene scene=null;
        Stage stage=(Stage) WeightField.getScene().getWindow();
        try{
            scene=new Scene(loader.load(),323,231);
        }catch(IOException e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Weight Convertor");

    }

    public void switchToLengthConversion(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/length.fxml"));
        Scene scene=null;
        Stage stage=(Stage) WeightField.getScene().getWindow();
        try{
            scene=new Scene(loader.load(),373,271);
        }catch(IOException e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Weight Convertor");

    }

    public void SwitchToBaseConversion(ActionEvent actionEvent) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("../view/Base_conversion.fxml"));
        Scene scene=null;
        Stage stage=(Stage) WeightField.getScene().getWindow();
        try{
            scene=new Scene(loader.load(),298,262);
        }catch(IOException e){
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Base Convertor");

    }
}


