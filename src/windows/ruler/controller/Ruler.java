package windows.ruler.controller;

import codesoftware.ora.SQLString;
import codesoftware.ora.connect.SQLConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    SQLConnect sqlConnect = new SQLConnect();

    @FXML
    private void initialize() {
        comboboxOptions.getItems().add("Одобрение Шага навстручу");
        textfieldEnter.setText("12345678");
        String username = System.getProperty("user.name");
        printLog("Программа запущена от имени: " + username);


    }
    public void action_buttonRun(ActionEvent actionEvent) throws SQLException {

        String contract = textfieldEnter.getText();
        if (contract.length() != 8) printLog("Недопустимая длина договора.");
        else {
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(contract);
            if (m.matches() == false) printLog("В названии договора содержатся недопустимые символы");
            else {
                printLog(sqlConnect.SQLOpenConnect());
                String jobquery = "begin get_emp_info(?, ?, ?); end;";
                CallableStatement callStmt = sqlConnect.c.prepareCall(jobquery);
                printLog(sqlConnect.SQLCloseConnect());
            }
        }
    }

    public void action_buttonExit(ActionEvent actionEvent) {
        Stage stage = (Stage) buttonExit.getScene().getWindow();
        stage.close();
    }

    public void action_textfieldEnter(ActionEvent actionEvent) {
    }

    public void printLog(String text) {
        Date curTime = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss]");
        String data = formatDate.format(curTime);
        textareaLog.appendText(data + ": " + text + "\n");
    }
}
