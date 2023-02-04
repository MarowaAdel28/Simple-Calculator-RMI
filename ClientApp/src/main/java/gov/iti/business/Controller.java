package gov.iti.business;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    TextField firstNum;

    @FXML
    TextField operation;

    @FXML
    TextField secondNum;

    @FXML
    Button resultBtn;

    @FXML
    Button exitBtn;

    @FXML
    TextField resultTextField;

    @FXML
    void getStatement() {

        BigDecimal result;
        System.out.println(firstNum.getText());
        BigDecimal fBigDecimal=getBigDecimal(firstNum);
        BigDecimal sBigDecimal=getBigDecimal(secondNum);
        String Oper=getoperation(operation);

        if(fBigDecimal!=null && sBigDecimal!=null && Oper!=null) {
            OperationInfo.getInstance().setFirstNum(fBigDecimal);
            OperationInfo.getInstance().setSecondNum(sBigDecimal);
            OperationInfo.getInstance().setOpertion(Oper);
            OperationInfo.getInstance().setTrue(true);
            result=Connection.getInstance().calculate();
            displyResult(result);
        } else {
            OperationInfo.getInstance().setTrue(false);
            System.out.println("null");
            //result=null;
        }
    }
    @FXML
    void exitApp() {
        System.exit(0);
    }

    BigDecimal getBigDecimal(TextField text) {

        if(text.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Enter all required fields!");
            return null;
        }
        if(verfiyNumbers(text)) {
            return new BigDecimal(text.getText().trim());
        }
            
        return null;
    }

    String getoperation(TextField text) {
        String operation = text.getText().trim();
        String operationRegex = "[-|*|/|+]";
        boolean isoperationValid = text.getText().matches(operationRegex);
        if(!isoperationValid) {
            JOptionPane.showMessageDialog(null, "Enter valid operation * / - + !");
            return null;
        } 
        return operation;
    }

    void displyResult(BigDecimal result) {
        resultTextField.setText(""+result);
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    boolean verfiyNumbers(TextField num) {
        String numRegex = "[0-9]+", phone;
        phone=num.getText();
        boolean isPhoneValid =phone.matches(numRegex);
        if(!isPhoneValid) {
            JOptionPane.showMessageDialog(null, "Enter valid numbers contain only numbers!");
            return false;
        }
        return true; 
    }
    
}
