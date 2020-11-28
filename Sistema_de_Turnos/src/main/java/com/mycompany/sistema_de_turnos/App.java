package com.mycompany.sistema_de_turnos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.VistaMenu;

/**
 * JavaFX App
 */
public class App extends Application {

    VistaMenu vm;
    @Override
    public void start(Stage stage) {
        vm = new VistaMenu();
        Scene scene = new Scene(vm.getRoot(), 1280, 720);
        stage.setTitle("Sistema de turnos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}