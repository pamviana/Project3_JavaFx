package scenebuilder;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scenebuilder extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    
    
     @Override
    public void start(Stage stage) {
  
        MenusController.setStage(stage);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("menus.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Scenebuilder.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    
        Scene scene = new Scene(root, 800, 800);
    
        stage.setScene(scene);
        stage.show();
        
    }
    
}
