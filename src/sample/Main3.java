package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Лабораторная работа № 3");



        Label lbl = new Label("Button");
        lbl.setPrefWidth(70);
        Button btn = new Button("Click");
        btn.setPrefWidth(130);

        Label lbl2 = new Label("CheckBox");
        lbl2.setPrefWidth(70);
        CheckBox chk = new CheckBox();

        Label lbl3 = new Label("Radio");
        lbl3.setPrefWidth(70);
        RadioButton radio = new RadioButton();

        Label lbl4 = new Label("TextField");
        lbl4.setPrefWidth(70);
        TextField text = new TextField();

        Label lbl5 = new Label("TextArea");
        lbl5.setPrefWidth(70);
        TextArea textArea = new TextArea();

        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Java");
        Label lbl6 = new Label("List");
        lbl6.setPrefWidth(70);



        GridPane root = new GridPane();



        root.add(lbl,0,0);
        root.add(btn,1,0);

        root.add(lbl2,0,1);
        root.add(chk,1,1);

        root.add(lbl3,0,2);
        root.add(radio,1,2);

        root.add(lbl4,0,3);
        root.add(text,1,3);

        root.add(lbl5,0,4);
        root.add(textArea,1,4);

        root.add(lbl6,0,5);
        root.add(langsComboBox,1,5);

        root.getColumnConstraints().add(new ColumnConstraints(130));
        root.getColumnConstraints().add(new ColumnConstraints(130));
        root.getRowConstraints().add(new RowConstraints(30));


        root.getRowConstraints().add(new RowConstraints(30));
        root.getRowConstraints().add(new RowConstraints(30));
        root.getRowConstraints().add(new RowConstraints(30));
        root.getRowConstraints().add(new RowConstraints(60));

        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
