package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.Map;
import java.util.Vector;

public class FinalProject extends Application {

    private boolean isD(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Курсовая работа");
        GridPane root = new GridPane();
        GridPane root2 = new GridPane();
        Scene scene2 = new Scene(root, 600, 200);

        root.getColumnConstraints().add(new ColumnConstraints(200));
        root.getColumnConstraints().add(new ColumnConstraints(200));
        root.getColumnConstraints().add(new ColumnConstraints(200));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));
        root.getRowConstraints().add(new RowConstraints(50));
        TextField textField = new TextField();

        Label lblTextstart = new Label();
        lblTextstart.setText("Начало диапазона");
        TextField textFieldstart = new TextField();

        Label lblTextend = new Label();
        lblTextend.setText("Конец диапазона");
        TextField textFieldend = new TextField();



        Button btnText = new Button("Input");





        GridPane.setHalignment(textField, HPos.CENTER);
        GridPane.setValignment(textField, VPos.CENTER);
        GridPane.setHalignment(btnText, HPos.CENTER);
        GridPane.setValignment(lblTextstart,VPos.CENTER);
        GridPane.setHalignment(lblTextstart,HPos.CENTER);
        GridPane.setValignment(lblTextend,VPos.CENTER);
        GridPane.setHalignment(lblTextend,HPos.CENTER);
        GridPane.setValignment(btnText, VPos.CENTER);
        Button btnText2 = new Button("Back");
        root2.add(btnText2,0,0);
        root.add(textField, 0, 0, 3, 1);
        root.add(textFieldstart,0,1);
        root.add(lblTextstart,0,2);
        root.add(textFieldend,2,1);
        root.add(lblTextend,2,2);
        btnText.maxWidth(200);
        btnText.setMaxSize(50,200);
        root.add(btnText, 0, 4, 3, 1);


        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        ScatterChart<Number, Number> numberLineChart = new ScatterChart<Number, Number>(x, y);
        numberLineChart.getStylesheets().add(Main.class.getResource("1.css").toExternalForm());
        numberLineChart.setMaxSize(500,600);

        XYChart.Series series = new XYChart.Series();
        series.setName("f(x)");


        numberLineChart.getData().add(series);

        Group group = new Group();


        group.getChildren().add(root2);


        Scene scene = new Scene(group, 500, 450);
        primaryStage.setScene(scene2);
        btnText2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                primaryStage.setScene(scene2);
            }
        });
        btnText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String s = textField.getText();
                Double start = Double.parseDouble(textFieldstart.getText());
                Double end = Double.parseDouble(textFieldend.getText());
                s = s.replaceAll("\\s+","");
                String newS = "";
                System.out.println(s);
                String ars[] = s.split("");
                System.out.println(ars);
                for (int i = 0; i < ars.length; i++) {

                    if (ars[i].equals("x")){
                        if(i<ars.length-1){
                            if(ars[i+1].equals("x") ||  isD(ars[i+1])){

                                newS+=ars[i]+"*";
                            }else {
                                newS+=ars[i];
                            }
                        }else{newS+=ars[i];}
                    }else if(isD(ars[i])) {
                        if(i<ars.length-1){
                            if(ars[i+1].equals("x")){
                                newS+=ars[i]+"*";

                            }}else {newS+=ars[i];}
                    }else {newS+=ars[i];}
                }
                System.out.println(newS);


                ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();

                series.setData(datas);
                for (double i = start; i <= end; i += 0.1) {

                    double scale = Math.pow(10, 3);
                    i = Math.ceil(i * scale) / scale;
                    Map<Double, Double> value = Ideone.main(newS, i);
                    if(value.get(i)!=null){
                    if ((value.get(i) != Double.POSITIVE_INFINITY) & (value.get(i) != Double.NEGATIVE_INFINITY)) {
                        datas.add(new XYChart.Data(i, value.get(i)));
            }}
        }

                numberLineChart.setTitle("График функции");
                group.getChildren().add(numberLineChart);
                primaryStage.setScene(scene);}});

                primaryStage.show();


}

    public static void main(String[] args) {
        launch(args);
    }
}