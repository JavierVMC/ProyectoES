/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VentanaError {
    /**
     * Root de la clase VentanaError
     */
    HBox root;
    /**
     * Constructor de la clase VentanaError
     * @param mensaje 
     */
    public VentanaError(String mensaje) {
        Label l = new Label(mensaje);
        root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(l);
    }
    /**
     * Muestra una ventana con la excepcion producida
     * @param ex 
     */
    public static void mostrarError(Exception ex) {
        Stage serror = new Stage();
        VentanaError ve = new VentanaError(ex.getMessage());
        Scene error = new Scene(ve.getRoot(), 500, 150);
        serror.setScene(error);
        serror.setAlwaysOnTop(true);
        serror.show();
    }
    /**
     * Get del root de la clase VentanaError
     * @return 
     */
    public HBox getRoot() {
        return root;
    }

}
