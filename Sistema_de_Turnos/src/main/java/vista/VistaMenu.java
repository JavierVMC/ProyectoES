/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author test1
 */
public class VistaMenu {
    private VBox root;
    private Button principal;
    private Button crearMedico;
    private Button crearPuesto;
    private Button crearPaciente;
    private Button salir;
    
    private static final String DISENIOBOTONES = "-fx-font-size: 20;-fx-font-weight: bold;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    
    public VistaMenu(){
        root = new VBox();
        disenioRoot();
        crearTitulo();
        crearBotones();
        disenioBotones();
        eventos();
    }
    
    private void crearTitulo(){
        Text titulo = new Text("Sistema de turnos");
        HBox h = new HBox();
        h.setAlignment(Pos.TOP_CENTER);
        h.setSpacing(100);
        titulo.setFill(Color.BLACK);
        titulo.setStroke(Color.BLACK);
        titulo.setStrokeWidth(5);
        titulo.setFont(new Font("Arial",80));
        
        h.getChildren().add(titulo);
        root.getChildren().add(h);
    }
    
    
    private void crearBotones(){
        principal = new Button("Vista Principal");
        crearMedico = new Button("Crear Medico");
        crearPuesto = new Button("Crear Puesto");
        crearPaciente = new Button("Crear Paciente");
        salir = new Button("Salir");
        
        root.getChildren().addAll(principal,crearMedico,crearPuesto,crearPaciente,salir);
        
    }
    
    private void disenioBotones(){
        principal.setMinSize(400, 100);
        principal.setStyle(DISENIOBOTONES);
        
        crearMedico.setMinSize(400, 100);
        crearMedico.setStyle(DISENIOBOTONES);
        
        crearPuesto.setMinSize(400, 100);
        crearPuesto.setStyle(DISENIOBOTONES);
        
        crearPaciente.setMinSize(400, 100);
        crearPaciente.setStyle(DISENIOBOTONES);
        
        salir.setMinSize(400, 100);
        salir.setStyle(DISENIOBOTONES);
    }
    
    private void disenioRoot(){
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
    }
    
    
    
    public Pane getRoot(){
        return root;
    }
    
    
    private void eventos(){
        eventoSalir();
        eventoPrincipal();
        eventoCrearMedico();
        eventoCrearPuesto();
        eventoCrearPaciente();
    }
    
    
    
    
    private void eventoSalir(){
        salir.setOnAction(
                e -> {
                    Stage st = (Stage) salir.getScene().getWindow();
                    st.close();
                }
        );
    }
    
    private void eventoPrincipal(){
        principal.setOnAction(
                e -> {
                    VistaPrincipal vp = new VistaPrincipal();
                    Stage st = new Stage();
                    Scene sc = new Scene(vp.getRoot(), 1280, 720);
                    st.setScene(sc);
                    st.setTitle("Principal");
                    st.show();
                }
        );
    }
    
    private void eventoCrearMedico(){
        crearMedico.setOnAction(
                e -> {

                }
        );

    }
    private void eventoCrearPuesto(){
        crearPuesto.setOnAction(
                e -> {

                }
        );
    }
    private void eventoCrearPaciente(){
        crearPaciente.setOnAction(
                e -> {

                }
        );
    }
    
    
    
    
    
}
