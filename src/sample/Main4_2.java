package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main4_2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Лабораторная работа № 4");



        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");
        Label label4 = new Label("Label4");
        Label label5 = new Label("Label5");
        Label label6 = new Label("Label6");
        Label label7 = new Label("Label7");

        VBox root = new VBox(10, label1, label2, label3, label4, label5, label6, label7);
                Scene scene = new Scene(root);


                primaryStage.setScene(scene);

                primaryStage.setWidth(300);
                primaryStage.setHeight(200);

                primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

}