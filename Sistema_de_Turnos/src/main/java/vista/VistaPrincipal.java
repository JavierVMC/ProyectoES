
package vista;

import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;


public class VistaPrincipal {
    //private VBox root;
    private BorderPane root;
    private HBox top;
   
    
    public VistaPrincipal(){
        root = new BorderPane();
    }
    
    
    
    public Pane getRoot(){
        return root;
    }

     

    
       
}
