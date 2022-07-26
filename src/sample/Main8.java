package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import java.security.interfaces.DSAPublicKey;
import java.text.DecimalFormat;

public class Main8 extends Application {
    int a = -250;
    int b = 250;
    double step = 1;
    int k = 50;
    boolean first = true;



    private double f(double x){ return x*x*x; }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Лабораторная работа № 7");


        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        ScatterChart<Number, Number> numberLineChart = new ScatterChart<Number, Number>(x,y);
        numberLineChart.setTitle("График функции");
        numberLineChart.getStylesheets().add(Main.class.getResource("1.css").toExternalForm());
        XYChart.Series series = new XYChart.Series();

        series.setName("f(x)");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();

        for(double i=-3; i<=3; i+=0.1) {
            Double value = (Double) f(i);

            double scale = Math.pow(10, 3);
            i = Math.ceil(i * scale) / scale;

            if (value != Double.POSITIVE_INFINITY & value != Double.NEGATIVE_INFINITY)  {
                    datas.add(new XYChart.Data(i, f(i)));
            }
        }
        series.setData(datas);
        Scene scene = new Scene(numberLineChart, 600,300);
        numberLineChart.getData().add(series);
        primaryStage.setScene(scene);
        primaryStage.show();
    }







    public static void main(String[] args) {
        launch(args);
    }

}