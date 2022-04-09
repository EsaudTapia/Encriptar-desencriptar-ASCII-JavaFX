package cipher;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class Cipher extends Application {
 
    @Override
    public void start(Stage primaryStage) {
 
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Cipher.class.getResource("Interfaz.fxml"));
            Pane ventana = (Pane) loader.load();
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.resizableProperty().set(false);
            primaryStage.setMinWidth(700);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setMaxWidth(805);
            primaryStage.setMaxHeight(500);
            primaryStage.setTitle("Descargando virus");
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
