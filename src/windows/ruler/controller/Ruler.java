package windows.ruler.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ruler {
/*
    @FXML
    private Button buttonRun;
*/
    @FXML
    private TextArea textareaLog;

    @FXML
    private ComboBox comboboxOptions;

    @FXML
    private Button buttonExit;

    @FXML
    private TextField textfieldEnter;

    @FXML
    private void initialize() {
        comboboxOptions.getItems().add("Одобрение Шага навстручу");

    }
    public void action_buttonRun(ActionEvent actionEvent) {

        String contract = textfieldEnter.getText();

        if (contract.length() != 8) textareaLog.appendText("Недопустимая длина договора + \n");
        String username = System.getProperty("user.name");
        Date curTime = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        textareaLog.appendText(formatDate.format(curTime)+ ": " + username + "\n");
    }

    public void action_buttonExit(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }

    public void action_textfieldEnter(ActionEvent actionEvent) {
    }
}
