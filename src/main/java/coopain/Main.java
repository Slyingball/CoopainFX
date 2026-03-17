package coopain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/coopain/vue/tournee.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 450); // Hauteur augmentée pour le TextArea Historique
        stage.setTitle("LogiSemin - Gestion des Tournées (Test M5)");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) { 
        launch(); 
    }
}
