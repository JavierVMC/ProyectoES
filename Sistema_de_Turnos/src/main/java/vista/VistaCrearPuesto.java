/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.Data;
import excepciones.VentanaAviso;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import modelo.Medico;
import modelo.Puesto;

/**
 *
 * @author dianademera
 */
public class VistaCrearPuesto {
    /**
     * Root de la clase VistaCrearPuesto
     */
    private HBox root;
    /**
     * GridPane para el formulario
     */
    private GridPane grid;
    
    private VBox vboxOpciones;
    private Button btCrearPuesto;
    private Button btEliminarPuesto;
    
    private VBox vboxCrearPuesto;
    private Button btCrear;
    private Label numPuesto;
    private Label medicoAsignado;
    private TextField tfnumPuesto;
    private ComboBox comboMedicos;
    
    private VBox vboxEliminarPuesto;
    private Button btEliminar;
    private Label nombrePuesto;
    private ComboBox comboPuestos;
    
    private TableView tabla;
    TableColumn<String, Puesto> numero; 
    TableColumn<Medico, Puesto> medico;
    
    
    private static final String DISENIOROOT = "-fx-background-color: rgba(219, 219, 219, 0.5);";
    private static final String DISENIOLABELS = "-fx-font-size: 20;-fx-font-weight: bold;";
    private static final String DISENIOBOTONES = "-fx-font-type: Tahoma;-fx-font-size: 20;-fx-background-color:rgba(63, 127, 191, 0.4);"; 
    
    
    public VistaCrearPuesto(){
        root = new HBox();
        disenioRoot();
        btCrear = new Button("Crear");
        btCrearPuesto = new Button("Crear Puesto");
        btEliminarPuesto = new Button("Eliminar Puesto");
        btEliminar = new Button("Eliminar");
        comboPuestos = new ComboBox();
        comboMedicos = new ComboBox();
        agregarTableView();
        crearVBoxOpciones();
        eventos();
    }
    /**
     * VBox que muestra las opciones
     */
    private void crearVBoxOpciones(){
        vboxOpciones = new VBox();
        disenioVBox(vboxOpciones);
        btCrearPuesto.setStyle(DISENIOBOTONES);
        btEliminarPuesto.setStyle(DISENIOBOTONES);
        
        vboxOpciones.getChildren().addAll(btCrearPuesto,btEliminarPuesto);
        root.getChildren().add(vboxOpciones);
        
    }
    /**
     * VBox mostrado al seleccionar la opcion Crear Puesto
     */
    private void crearVBoxCrearPuesto(){
        vboxCrearPuesto = new VBox();
        disenioVBox(vboxCrearPuesto);
        crearGrid();
        
        numPuesto = new Label("No. Puesto: ");
        medicoAsignado = new Label("Medico: ");
        
        numPuesto.setStyle(DISENIOLABELS);
        medicoAsignado.setStyle(DISENIOLABELS);
        
        grid.add(numPuesto, 0, 1);
        grid.add(medicoAsignado, 0, 2);
        
        tfnumPuesto = new TextField();
        
        tfnumPuesto.setPrefHeight(30);
        
        List<Medico> medicos = Data.leerArchivoMedicos();
        comboMedicos.setItems(FXCollections.observableArrayList(medicos));
        
        grid.add(tfnumPuesto, 1, 1);
        grid.add(comboMedicos, 1, 2);
        
        btCrear.setMinSize(150, 50);
        btCrear.setStyle(DISENIOBOTONES);
        
        Text scenetitle = new Text("Datos del puesto a crear");
        scenetitle.setStrokeWidth(1);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        
        vboxCrearPuesto.getChildren().addAll(scenetitle ,grid,btCrear);
        root.getChildren().add(vboxCrearPuesto);
        
    }
    /**
     * VBox mostrado al seleccionar la opcion Eliminar Puesto
     */
    private void crearVBoxEliminarPuesto(){
        vboxEliminarPuesto = new VBox();
        disenioVBox(vboxEliminarPuesto);
        crearGrid();
        
        nombrePuesto = new Label("Puesto: ");
        nombrePuesto.setStyle(DISENIOLABELS);
        
        List<Puesto> puestos = Data.leerArchivoPuestos();
        List<String> spuestos = new ArrayList<>();
        for(Puesto p:puestos){
            spuestos.add(p.toString());
        }
        comboPuestos.setItems(FXCollections.observableArrayList(spuestos));
        

        grid.add(nombrePuesto, 0, 1);
        grid.add(comboPuestos, 1, 1);
        
        btEliminar.setMinSize(150, 50);
        btEliminar.setStyle(DISENIOBOTONES);
        
        Text scenetitle = new Text("Seleccione el puesto a eliminar");
        scenetitle.setStrokeWidth(1);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        
        
        vboxEliminarPuesto.getChildren().addAll(scenetitle,grid,btEliminar);
        root.getChildren().add(vboxEliminarPuesto);
    }
    /**
     * Establece el estilo del root
     */
    private void disenioRoot(){
        root.setStyle(DISENIOROOT);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);
    }
    /**
     * Establece el estilo del VBox pasado como parametro
     * @param vbox 
     */
    private void disenioVBox(VBox vbox){
        vbox.setMinWidth(700);
        vbox.setStyle(DISENIOROOT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(50);
    }
    /**
     * Crear el gridPane donde se ponen los formularios
     */
    private void crearGrid(){
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(10, 100, 50, 10));
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(35);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(65);
        grid.getColumnConstraints().addAll(column1, column2);
        column1.setHalignment(HPos.RIGHT);

        RowConstraints row1 = new RowConstraints();
        row1.setValignment(VPos.CENTER);
        column1.setHgrow(Priority.ALWAYS);
    }

    /**
     * Agrega la tabla de puestos al root
     */
    private void agregarTableView(){
                tabla = new TableView();
                
                numero = new TableColumn("Numero del Puesto");
                numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
                
                medico = new TableColumn("Medico Asignado");
                medico.setCellValueFactory(new PropertyValueFactory<>("medicoAsignado"));
                
                tabla.getColumns().add(numero);
                tabla.getColumns().add(medico);
                
                List<Puesto> lista = Data.leerArchivoPuestos();
                llenarTabla(lista);
                
                tabla.setEditable(false);
                
                numero.setMinWidth(200);
                medico.setMinWidth(300);
                
                numero.setMaxWidth(200);
                medico.setMaxWidth(300);
                
                tabla.setMaxSize(800, 700);
                
                root.getChildren().add(tabla);
    }
    
    /**
     * Llena la tabla con datos
     * @param lista 
     */
    private void llenarTabla(List<Puesto> lista){
        tabla.getItems().clear();
        for(Puesto p:lista){
            tabla.getItems().add(p);
        }
    }
    /**
     * Get del root de la clase VistaCrearPuesto
     * @return 
     */
    public Pane getRoot() {
        return root;
    }
    
    private void eventos(){
        eventobtCrearPuesto();
        eventobtCrear();
        eventobtEliminarPuesto();
        eventobtEliminar();
    }
    
    
    
    private void eventobtCrearPuesto(){
        btCrearPuesto.setOnAction(
                e ->{
                    root.getChildren().clear();
                    agregarTableView();
                    crearVBoxCrearPuesto();
                    
                }
        );
    }
    
    private void eventobtEliminarPuesto(){
        btEliminarPuesto.setOnAction(
                e ->{
                    root.getChildren().clear();
                    agregarTableView();
                    crearVBoxEliminarPuesto();
                }
        );
    }
    
    private void eventobtCrear(){
        btCrear.setOnAction(
                e ->{
                    if(!tfnumPuesto.getText().isBlank() && comboMedicos.getValue()!=null){
                        Medico m = (Medico)comboMedicos.getValue();
                        Puesto p = new Puesto(tfnumPuesto.getText(),m);
                        Data.guardarPuesto(p);

                        root.getChildren().clear();
                        agregarTableView();
                        crearVBoxOpciones();
                    }else{
                        VentanaAviso.mostrarAviso("Advertencia","Todos los campos son obligatorios.",Color.RED);
                    }
                }
        );
    }
    
    private void eventobtEliminar(){
        btEliminar.setOnAction(
                e ->{
                    if(comboPuestos.getValue()!=null){
                        Data.eliminarPuesto((String)comboPuestos.getValue());

                        root.getChildren().clear();
                        agregarTableView();
                        crearVBoxOpciones();
                    }else{
                        VentanaAviso.mostrarAviso("Advertencia","Todos los campos son obligatorios.",Color.RED);
                    }
                }
        );
    }
    
    
    
}
