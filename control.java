
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class control {

    private Double currentDigit, finalResult;
    private String currentOperation;
    Boolean resultOperation = false;
    @FXML

    private TextField txtDisplay;//=new TextField();
    //you can not write in textfield
    //txtDisplay.setEditable();


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


