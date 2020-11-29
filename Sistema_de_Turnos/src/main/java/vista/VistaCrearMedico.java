/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import excepciones.VentanaAviso;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.Medico;

/**
 *
 * @author dianademera
 */
public class VistaCrearMedico{
private VBox root;
    private GridPane grid;
    private TextField tfNombres;
    private TextField tfApellidos;
    private TextField tfEspecialidad;
    private Label nombres;
    private Label apellidos;
    private Label especialidad;
    private Button btingresar;
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOLABELS = "-fx-font-size: 30;-fx-font-weight: bold;";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 20;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    
    public VistaCrearMedico(){
        root = new VBox();
        grid = new GridPane();
        disenioRoot();
        disenioGrid();
        agregarTitulo();
        agregarLabels();
        agregarTextfields();
        disenioLabels();
        disenioTextfields();
        agregarGrid();
        agregarButton();
        eventoBtingresar();
    }
    
    private void disenioRoot(){
        root.setAlignment(Pos.CENTER);
        root.setStyle(DISENIOROOT);
        root.setSpacing(20);
    }
    
    private void disenioGrid(){
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 100, 50, 25));
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(80);
        grid.getColumnConstraints().addAll(column1, column2);
        column1.setHalignment(HPos.RIGHT);

        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        column1.setHgrow(Priority.ALWAYS);
    }    
    
    private void agregarTitulo(){
        Text scenetitle = new Text("Datos del medico a ingresar");
        scenetitle.setStrokeWidth(1);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        root.getChildren().add(scenetitle);
    }
    
    
    private void agregarLabels(){
        nombres = new Label("Nombres: ");
        apellidos = new Label("Apellidos: ");
        especialidad = new Label("Especialidad: ");
        
        grid.add(nombres, 0, 1);
        grid.add(apellidos, 0, 2);
        grid.add(especialidad, 0, 3);
        
    }
    
    private void agregarTextfields(){
        tfNombres = new TextField();
        tfApellidos = new TextField();
        tfEspecialidad = new TextField();
        
        grid.add(tfNombres, 1, 1);
        grid.add(tfApellidos, 1, 2);
        grid.add(tfEspecialidad, 1, 3);
    }
    
    private void disenioLabels(){
        nombres.setStyle(DISENIOLABELS);
        apellidos.setStyle(DISENIOLABELS);
        especialidad.setStyle(DISENIOLABELS);

    }
    
    private void disenioTextfields(){
        tfNombres.setPrefHeight(30);
        tfApellidos.setPrefHeight(30);
        tfEspecialidad.setPrefHeight(30);
    }
    
    private void agregarGrid(){
        root.getChildren().add(grid);
    }
    
    private void agregarButton(){
        btingresar = new Button("Ingresar");
        btingresar.setMinSize(150, 50);
        btingresar.setStyle(DISENIOBOTONES);
        root.getChildren().add(btingresar);
    }

    public Pane getRoot() {
        return root;
    }
    
    private void eventoBtingresar(){
        btingresar.setOnAction(
                e ->{
                    if(!tfNombres.getText().isBlank() && !tfApellidos.getText().isBlank() 
                            && !tfEspecialidad.getText().isBlank()){
                        
                        String fname = tfNombres.getText();
                        String lname = tfApellidos.getText();
                        String esp = tfEspecialidad.getText();
                        Medico m = new Medico(fname,lname,esp);
                        
                        tfNombres.clear();
                        tfApellidos.clear();
                        tfEspecialidad.clear();
                        
                        VentanaAviso.mostrarAviso("Estado del Registro","Medico registrado con exito.",Color.GREEN);
                        
                        
                    }else{
                        VentanaAviso.mostrarAviso("Advertencia","Todos los campos son obligatorios.",Color.RED);
                    }      
                
                }
        );
    }
    
}
