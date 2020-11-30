/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.Data;
import excepciones.VentanaAviso;
import java.util.HashMap;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import modelo.Paciente;
import modelo.Sintoma;
import modelo.Sistema;

/**
 *
 * @author dianademera
 */
public class VistaCrearPaciente{
    private VBox root;
    private GridPane grid;
    private TextField tfNombres;
    private TextField tfApellidos;
    private TextField tfEdad;
    private TextField tfSintoma;
    private Label nombres;
    private Label apellidos;
    private Label edad;
    private Label genero;
    private Label sintoma;
    private Button btingresar;
    private ToggleGroup group;
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOLABELS = "-fx-font-size: 30;-fx-font-weight: bold;";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 20;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    
    public VistaCrearPaciente(){
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
        agregarRButtons();
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
        Text scenetitle = new Text("Datos del paciente a ingresar");
        scenetitle.setStrokeWidth(1);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        root.getChildren().add(scenetitle);
    }
    
    
    private void agregarLabels(){
        nombres = new Label("Nombres: ");
        apellidos = new Label("Apellidos: ");
        edad = new Label("Edad: ");
        genero = new Label("Genero: ");
        sintoma = new Label("Sintoma: ");
        
        grid.add(nombres, 0, 1);
        grid.add(apellidos, 0, 2);
        grid.add(edad, 0, 3);
        grid.add(genero, 0, 4);
        grid.add(sintoma, 0, 6);
        
        
    }
    
    private void agregarTextfields(){
        tfNombres = new TextField();
        tfApellidos = new TextField();
        tfEdad = new TextField();
        tfSintoma = new TextField();
        
        grid.add(tfNombres, 1, 1);
        grid.add(tfApellidos, 1, 2);
        grid.add(tfEdad, 1, 3);
        grid.add(tfSintoma, 1, 6);
    }
    
    private void agregarRButtons(){
        group = new ToggleGroup(); 

        RadioButton rb1 = new RadioButton("Masculino"); 
        rb1.setUserData("Masculino"); 
        rb1.setToggleGroup(group); 

        RadioButton rb2 = new RadioButton("Femenino"); 
        rb2.setUserData("Femenino"); 
        rb2.setToggleGroup(group); 
        
        grid.add(rb1, 1, 4);
        grid.add(rb2, 1, 5);
        
    }
    
    private void disenioLabels(){
        nombres.setStyle(DISENIOLABELS);
        apellidos.setStyle(DISENIOLABELS);
        edad.setStyle(DISENIOLABELS);
        genero.setStyle(DISENIOLABELS);
        sintoma.setStyle(DISENIOLABELS);

    }
    
    private void disenioTextfields(){
        tfNombres.setPrefHeight(30);
        tfApellidos.setPrefHeight(30);
        tfEdad.setPrefHeight(30);
        tfSintoma.setPrefHeight(30);
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
        btingresar.setOnMouseClicked(
                e ->{
                    if(!tfNombres.getText().isBlank() && !tfApellidos.getText().isBlank() 
                            && group.getSelectedToggle()!=null && !tfEdad.getText().isBlank() && !tfSintoma.getText().isBlank()){
                        String fname = tfNombres.getText();
                        String lname = tfApellidos.getText();
                        String gen = group.getSelectedToggle().getUserData().toString();
                        String sint = tfSintoma.getText();
                        int age;

                        if(isNumeric(tfEdad.getText())){
                            age = Integer.parseInt(tfEdad.getText());
                            
                            HashMap<String,Integer> mapa = Data.leerArchivoSintomas();
                            if(mapa.containsKey(sint)){
                                Sintoma s = new Sintoma(sint,1);
                                Paciente p = new Paciente(fname, lname,age,gen,s);
                                Data.guardarPaciente(p);

                                Sistema.agregarPaciente(p);

                                tfNombres.clear();
                                tfApellidos.clear();
                                tfSintoma.clear();
                                tfEdad.clear();
                                group.getSelectedToggle().setSelected(false);

                                VentanaAviso.mostrarAviso("Estado del Registro","Paciente registrado con exito.",Color.GREEN);
                            }else{
                                VentanaAviso.mostrarAviso("Advertencia","Sintoma ingresado no valido",Color.RED);
                            }
                        }
                        else{
                            VentanaAviso.mostrarAviso("Advertencia","La edad ingresada debe ser un numero.",Color.RED);
                        }
                    }else{
                        VentanaAviso.mostrarAviso("Advertencia","Todos los campos son obligatorios.",Color.RED);
                    }      
                }
        );
    }
    
    private static boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
    
    
}
