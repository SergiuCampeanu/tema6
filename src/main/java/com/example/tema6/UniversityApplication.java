package com.example.tema6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UniversityApplication extends Application {
    private static Stage stage0;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UniversityApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage0=stage;
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void Menu(String file) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UniversityApplication.class.getResource(file));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        Stage stage1 = new Stage();
        stage1.setTitle("Log In");
        stage1.initModality(Modality.WINDOW_MODAL); //de cautat
        stage1.initOwner(stage0);
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        launch();
    }
}