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

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class length_scene_controller implements Initializable {
    public ComboBox<String> FomComboboxID;
    public ComboBox<String> ToComboBoxID;
    public TextField FromTextField;
    public TextField TOTextField;
    public Button ConvertButton;
    public Hyperlink HYperLinkID;

    public void onActionConvert(ActionEvent actionEvent) {
            String FromcomboBoxTxt = FomComboboxID.getValue();
            String TocomboBoxtXt = ToComboBoxID.getValue();
            String TXTfield = FromTextField.getText();
            Double Number = Double.parseDouble(TXTfield);
            Double res = 0.0;
            if (Objects.equals(FromcomboBoxTxt, "Km") & Objects.equals(TocomboBoxtXt, "Km")) {
                res = Number;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "Km") & Objects.equals(TocomboBoxtXt, "m")) {
                res = Number * 1000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "Km") & Objects.equals(TocomboBoxtXt, "cm")) {
                res = Number * 100000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "Km") & Objects.equals(TocomboBoxtXt, "mm")) {
                res = Number * 1000000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "m") & Objects.equals(TocomboBoxtXt, "Km")) {
                res = Number / 1000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "m") & Objects.equals(TocomboBoxtXt, "m")) {
                res = Number;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "m") & Objects.equals(TocomboBoxtXt, "cm")) {
                res = Number * 100;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "m") & Objects.equals(TocomboBoxtXt, "mm")) {
                res = Number * 1000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "cm") & Objects.equals(TocomboBoxtXt, "Km")) {
                res = Number / 100000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "cm") & Objects.equals(TocomboBoxtXt, "m")) {
                res = Number / 100;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "cm") & Objects.equals(TocomboBoxtXt, "mm")) {
                res = Number * 10;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "mm") & Objects.equals(TocomboBoxtXt, "Km")) {
                res = Number / 1000000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "mm") & Objects.equals(TocomboBoxtXt, "m")) {
                res = Number / 1000;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "mm") & Objects.equals(TocomboBoxtXt, "cm")) {
                res = Number / 10;
                TOTextField.setText(res.toString());
            } else if (Objects.equals(FromcomboBoxTxt, "mm") & Objects.equals(TocomboBoxtXt, "mm")) {
                res = Number;
                TOTextField.setText(res.toString());
            } else {
                TOTextField.setText("Invalid Conversion");
            }
            try{
                double Fromval=Number;
                double rse=res;
                database d1=new database();
                String query="insert into history2 (selectedType,toType) values('"+ Fromval +"','"+ rse +"')";
                d1.statement.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }


    }
    public void SwitchToHomePage(ActionEvent actionEvent) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../view/view1.fxml"));
        Stage stage= (Stage) HYperLinkID.getScene().getWindow();
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

        FomComboboxID.setItems(FXCollections.observableArrayList("Km","m","cm","mm"));
        ToComboBoxID.setItems(FXCollections.observableArrayList("Km","m","cm","mm"));
    }
}
