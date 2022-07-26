package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Небо в малооблачную погоду");
        Scene scene = new Scene(root, 300, 900);

        scene.setFill(Color.web("#7fc7ff"));


        InputStream iconStream = getClass().getResourceAsStream("/images/img.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);
    primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
