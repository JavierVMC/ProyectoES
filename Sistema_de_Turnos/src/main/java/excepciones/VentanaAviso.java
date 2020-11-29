/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.io.FileInputStream;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VentanaAviso {
    private Stage alerta;
    private HBox root;
    private static final String DISENIOLABEL = "-fx-font-size: 20;-fx-font-weight: bold;-fx-text-fill: red;";
    
    public VentanaAviso(String mensaje) {
        Label l = new Label(mensaje);
        l.setStyle(DISENIOLABEL);
        root = new HBox();
        
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(l);
    }

    public static void mostrarAviso(String mensaje) {
        Stage sAviso = new Stage();
        sAviso.setTitle("Advertencia");
        VentanaAviso va = new VentanaAviso(mensaje);
        Scene aviso = new Scene(va.getRoot(), 500, 150);
        sAviso.setScene(aviso);
        sAviso.setAlwaysOnTop(true);
        sAviso.show();
    }

    public Pane getRoot() {
        return root;
    }
}
