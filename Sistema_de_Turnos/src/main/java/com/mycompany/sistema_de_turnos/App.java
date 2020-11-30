package com.mycompany.sistema_de_turnos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Sistema;
import vista.VistaMenu;

/**
 * JavaFX App
 */
public class App extends Application {

    VistaMenu vm;
    @Override
    public void start(Stage stage) {
        vm = new VistaMenu();
        Sistema s = new Sistema();
        Scene scene = new Scene(vm.getRoot(), 1280, 720);
        stage.setResizable(false);
        stage.setTitle("Sistema de turnos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop(){
        vm.terminarHilos();
    }

}