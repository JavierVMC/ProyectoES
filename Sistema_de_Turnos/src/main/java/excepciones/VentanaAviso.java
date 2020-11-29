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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VentanaAviso {
    private HBox root;
    private final String DISENIOLABEL = "-fx-font-size: 20;-fx-font-weight: bold;";
    
    public VentanaAviso(String mensaje, Paint color) {
        
        Label l = new Label(mensaje);
        l.setStyle(DISENIOLABEL);
        l.setTextFill(color);
        root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(l);
    }

    public static void mostrarAviso(String titulo, String mensaje, Paint color) {
        
        Stage sAviso = new Stage();
        sAviso.setTitle(titulo);
        VentanaAviso va = new VentanaAviso(mensaje,color);
        Scene aviso = new Scene(va.getRoot(), 500, 150);
        sAviso.setScene(aviso);
        sAviso.setAlwaysOnTop(true);
        sAviso.show();
    }

    public Pane getRoot() {
        return root;
    }
}
