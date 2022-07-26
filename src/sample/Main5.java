package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main5 extends Application {
    CheckBox first;
    CheckBox second;
    CheckBox third;
    Label selectedCB;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Лабораторная работа № 5");
        final String[] clicks = {"Жми"};
        final int[] i = {0};




        Label lbl = new Label("Кнопка-счётчик");
        lbl.setPrefWidth(100);
        Button btn = new Button(clicks[0]);
        btn.setPrefWidth(80);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                clicks[0] = String.valueOf(++i[0]);
                btn.setText(clicks[0]);
            }
        });


        selectedCB = new Label("Не выбран ни один CheckBox");

        first = new CheckBox("Первый CB");
        second = new CheckBox("Второй CB");
        third = new CheckBox("Третий CB");

        first.setOnAction(event -> show());
        second.setOnAction(event -> show());
        third.setOnAction(event -> show());



        ToggleButton lightBtn = new ToggleButton("Включить");
        Label stateLbl = new Label();

        stateLbl.setText("Выключено");
        // обработка нажатия
        lightBtn.setOnAction(event -> {

            if(lightBtn.isSelected()){
                lightBtn.setText("Выключить");
                stateLbl.setText("Включено");
            }
            else{
                lightBtn.setText("Включить");
                stateLbl.setText("Выключено");
            }
        });


        Label lblText = new Label();
        lblText.setText("Input: Clear");
        TextField textField = new TextField();
        textField.setPrefColumnCount(11);
        Button btnText = new Button("Input");
        btnText.setOnAction(event -> lblText.setText("Input: " + textField.getText()));






        Label lblSlider = new Label("Значение");

        Slider slider = new Slider(0, 100, 25);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(2.0);
        slider.setMajorTickUnit(5.0);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.valueProperty().addListener(new ChangeListener<Number>(){

            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                lblSlider.setText("Значение: " + String.format("%.3f",newValue));
            }
        });






        GridPane root = new GridPane();
        root.add(lbl,0,0);
        root.add(btn,1,0);
        root.add(first,0,1);
        root.add(second,0,2);
        root.add(third,0,3);
        root.add(selectedCB,0,4);
        root.add(lightBtn,1,5);
        root.add(stateLbl,0,5);

        root.add(textField,0,6);
        root.add(btnText,0,7);
        root.add(lblText,0,8);
        root.add(lblSlider,0,9);
        root.add(slider,0,10);


        root.setHgap(50);
        root.setVgap(10);

    
                Scene scene = new Scene(root);


                primaryStage.setScene(scene);

                primaryStage.setWidth(300);
                primaryStage.setHeight(500);

                primaryStage.show();


    }
    private void show(){

        String allSelected = "";

        if(first.isSelected()) allSelected += "First";
        if(second.isSelected()) allSelected += "Second";
        if(third.isSelected()) allSelected += "Third";

        if(allSelected.equals(""))
            selectedCB.setText("No CB Selected");
        else
            selectedCB.setText(allSelected);
    }



    public static void main(String[] args) {
        launch(args);
    }

}