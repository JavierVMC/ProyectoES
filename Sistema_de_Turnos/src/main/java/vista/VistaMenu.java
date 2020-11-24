/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author test1
 */
public class VistaMenu {
    private VBox root;
    private Text titulo;
    private Button principal;
    private Button crearMedico;
    private Button crearPuesto;
    private Button crearPaciente;
    private Button salir;
    
    private final String diseñoBotones = "-fx-font-size: 20;-fx-font-weight: bold;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    private final String diseñoRoot = "";
    
    public VistaMenu(){
        root = new VBox();
        diseñoRoot();
        crearTitulo();
        crearBotones();
        agregarBoton(principal);
        agregarBoton(crearMedico);
        agregarBoton(crearPuesto);
        agregarBoton(crearPaciente);
        agregarBoton(salir);
        diseñoBotones();
        
        
    }
    
    private void crearTitulo(){
        
    }
    
    
    private void crearBotones(){
        principal = new Button("Vista Principal");
        crearMedico = new Button("Crear Medico");
        crearPuesto = new Button("Crear Puesto");
        crearPaciente = new Button("Crear Paciente");
        salir = new Button("Salir");
    }
    
    private void diseñoBotones(){
        principal.setMaxWidth(100);
        principal.setMinSize(400, 100);
        principal.setStyle(diseñoBotones);
        
        crearMedico.setMaxWidth(100);
        crearMedico.setMinSize(400, 100);
        crearMedico.setStyle(diseñoBotones);
        
        crearPuesto.setMaxWidth(100);
        crearPuesto.setMinSize(400, 100);
        crearPuesto.setStyle(diseñoBotones);
        
        crearPaciente.setMaxWidth(100);
        crearPaciente.setMinSize(400, 100);
        crearPaciente.setStyle(diseñoBotones);
        
        salir.setMaxWidth(100);
        salir.setMinSize(400, 100);
        salir.setStyle(diseñoBotones);
    }
    
    private void diseñoRoot(){
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        root.setStyle("-fx-background.color: black;");
    }
    
    private void agregarBoton(Button btn){
        HBox h = new HBox();
        h.setAlignment(Pos.CENTER);
        h.setSpacing(20);
        h.getChildren().add(btn);
        root.getChildren().add(h);
    }
    
    
    
    
    
    public Pane getRoot(){
        return root;
    }
    
}
