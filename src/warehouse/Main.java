package warehouse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("windows/MainWindow.fxml"));
        primaryStage.setTitle("Склад");
        primaryStage.setScene(new Scene(root, 1150, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
