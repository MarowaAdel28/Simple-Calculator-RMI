package gov.iti.presentation;

import gov.iti.business.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    public static void main( String[] args )
    {
        launch();
        
        /* 
        System.out.println( "Hello World!" );
        try {
            System.out.println(BigDecimalFormat.getInstance().parse("10"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub
        //OperationInfo operationStatment = new OperationInfo();
        Controller control= new Controller();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(control);
        Parent root = loader.load(getClass().getResource("/Calculator.fxml").openStream());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
}
