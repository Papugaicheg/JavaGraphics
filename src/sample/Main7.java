package sample;


import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import jdk.jfr.Category;

import java.awt.*;
import java.io.File;
import java.io.FileReader;


public class Main7 extends Application{

        private double f(double x){
        return (x/145975300)*100;
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("Лабораторная работа № 8");
            HBox root = new HBox();
            ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                    new PieChart.Data("Привитых "+Math.round(f(61222307))+"%", f(61222307)),
                    new PieChart.Data("Не привитых "+Math.round(f(145975300-61222307))+"%", f(145975300-61222307))
                    );

            PieChart pieChart = new PieChart(pieChartData);
            pieChart.setTitle("Вакцинация в России");

            root.getChildren().add(pieChart);

            Scene scene = new Scene(root, 500, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}
