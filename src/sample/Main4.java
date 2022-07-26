package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Лабораторная работа № 4");







                Label label1 = new Label("Подпись1");
                Label label2 = new Label("Подпись2");
                Label label3 = new Label("Подпись3");
                Label label4 = new Label("Подпись4");
                Label label5 = new Label("Подпись5");
                Label label6 = new Label("Подпись6");
                Label label7 = new Label("Подпись7");
                Label label8 = new Label("Подпись8");
                Label label9 = new Label("Подпись9");

                FlowPane root = new FlowPane(Orientation.VERTICAL,10, 10, label1, label2, label3, label4,
                        label5, label6, label7, label8, label9);
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