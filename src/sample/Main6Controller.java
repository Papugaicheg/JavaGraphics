package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Main6Controller implements Initializable {



    @FXML
    private ImageView imageView;

    @FXML
    private Pane label;



    @FXML
    public MenuItem menuQuitButton;

    @FXML
    private MenuItem menuItem;



    @FXML
    private MenuItem open;

    @FXML
    private void selectFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выбрать фото");
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Картинки", "*.jpg", "*.png", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(Main6.javaFXC);
        Image im = new Image((file).toURI().toString());
        ImageView imv = new ImageView(im);
        imageView = imv;
        imv.setFitHeight(100);
        imv.setFitWidth(100);
        label.getChildren().add(imv);
    }


    @FXML
    private void plus(ActionEvent event){

        imageView.setFitHeight(imageView.getFitHeight()*1.2);
        imageView.setFitWidth(imageView.getFitWidth()*1.2);
    }

    @FXML
    private void minus(ActionEvent event){
        imageView.setFitHeight(imageView.getFitHeight()*0.8);
        imageView.setFitWidth(imageView.getFitWidth()*0.8);
    }
    @FXML
    private void left(ActionEvent event){
        imageView.setRotate(imageView.getRotate()-40);
    }
    @FXML
    private void right(ActionEvent event){
        imageView.setRotate(imageView.getRotate()+40);
    }

    @FXML
    private void close(ActionEvent event){
        imageView.setImage(null);
    }

    @FXML
    private void quit(ActionEvent event){
        Main6.javaFXC.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }




}