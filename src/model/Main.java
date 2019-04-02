package model;

import controller.ImageViewController;
import controller.ImportDetailsViewController;
import controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.SendingContext.RunTime;

import java.io.IOException;

public class Main extends Application {


    public static void main(String[] args) {
        PictureDataParser pictureDataParser= new PictureDataParser();
        pictureDataParser.parsePictureData();
        launch(args);
    }

    private Stage primaryStage;
    AnchorPane pane;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showMainWindow();
    }

    public void setSceneDefault(){
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        setStageExtremes();
        primaryStage.show();
    }

    public void setStageExtremes(){
        primaryStage.setMinWidth(860);
        primaryStage.setMinHeight(580);
        primaryStage.setMaxHeight(700);
        primaryStage.setMaxWidth(1000);
    }

    public void showMainWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainView.fxml"));
            pane = loader.load();
            MainViewController mainViewController = loader.getController();
            mainViewController.setMain(this);
            setSceneDefault();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showImageWindow(Picture picture){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ImageView.fxml"));
            pane = loader.load();
            ImageViewController imageViewController = loader.getController();
            imageViewController.setMain(this);
            imageViewController.setImage(picture);
            imageViewController.setText();
            setSceneDefault();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void showImportDetailsWindow(){
        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ImportDetailsView.fxml"));
            pane = loader.load();
            ImportDetailsViewController importDetailsViewController = loader.getController();
            importDetailsViewController.setMain(this);
            setSceneDefault();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void close(){
        primaryStage.close();
    }
}
