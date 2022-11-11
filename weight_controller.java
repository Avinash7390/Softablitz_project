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
import java.util.Stack;

public class weight_controller implements Initializable {

    public TextField From_txtField;
    public TextField ToTxtField;
    public ComboBox<String> from_dropbox;
    public ComboBox<String> To_Dropbox;
    public Button convertButton;
    public Hyperlink Hyperlinkid;

    public void onActionToDropbox(ActionEvent actionEvent) {
    }

    public void onActionConvert(ActionEvent actionEvent) {
            String TodropBoxTxt = To_Dropbox.getValue();
            String fromdropboxTxT = from_dropbox.getValue();
            String txtfieldtext = From_txtField.getText();
            Double Number = Double.parseDouble(txtfieldtext);
            Double rse = 0.0;
            if (Objects.equals(fromdropboxTxT, "Kg") && Objects.equals(TodropBoxTxt, "Kg")) {
                rse = Number;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "Kg") && Objects.equals(TodropBoxTxt, "gm")) {
                rse = 1000 * Number;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "Kg") && Objects.equals(TodropBoxTxt, "mg")) {
                rse = 1000000 * Number;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "mg") && Objects.equals(TodropBoxTxt, "Kg")) {
                rse = Number / 1000000;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "gm") && Objects.equals(TodropBoxTxt, "Kg")) {
                rse = Number / 1000;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "gm") && Objects.equals(TodropBoxTxt, "gm")) {
                rse = Number;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "gm") && Objects.equals(TodropBoxTxt, "mg")) {
                rse = Number * 1000;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "mg") && Objects.equals(TodropBoxTxt, "mg")) {
                rse = Number;
                ToTxtField.setText(rse.toString());
            } else if (Objects.equals(fromdropboxTxT, "mg") && Objects.equals(TodropBoxTxt, "gm")) {
                rse = Number / 1000;
                ToTxtField.setText(rse.toString());
            }
            try{
                double Fromval=Number;
                double res= rse;
                database d1=new database();
                String query="insert into history1 (selctedType,Totype) values('"+ Fromval +"','"+ res +"')";
                d1.statement.executeUpdate(query);

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    public void onActionFromDropbox(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        from_dropbox.setItems(FXCollections.observableArrayList("Kg","gm","mg"));
        To_Dropbox.setItems(FXCollections.observableArrayList("Kg","gm","mg"));

    }

    public void ReturnToHomePage(ActionEvent actionEvent) {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../view/view1.fxml"));
        Stage stage= (Stage) Hyperlinkid.getScene().getWindow();
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
