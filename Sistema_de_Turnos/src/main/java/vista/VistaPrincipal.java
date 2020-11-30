
package vista;

import data.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sistema;


public class VistaPrincipal {
    private BorderPane root;
    private HBox top;
    private HBox center;
    private HBox bot;
    private boolean pararHilo = false;
    
    private TableView tabla;
    private TableColumn<String, Paciente> cPuesto;
    private TableColumn<String, Paciente> cTurno;
    
    
    private static final String DISENIOTOP = "-fx-background-color:rgb(136, 204, 235);";
    private static final String DISENIOTITULOS = "-fx-font-type: Tahoma;-fx-font-size: 50;";
    private static final String DISENIOLBTURNOS = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgb(48, 166, 221);-fx-text-fill:WHITESMOKE;-fx-text-stroke: 2;";
    private static final String DISENIOLBPUESTOS = "-fx-font-type: Tahoma;-fx-font-size: 30;-fx-background-color:rgb(84, 153, 185);-fx-text-fill:WHITESMOKE;-fx-text-stroke: 2;";
    
    public VistaPrincipal(){
        root = new BorderPane();
        crearTop();
        crearCenter();
        crearBot();
        
    }
    
    
    private void crearTop(){
        top = new HBox();
        
        top.setAlignment(Pos.CENTER);
        top.setSpacing(20);
        top.setStyle(DISENIOTOP);
        
        Text titulo = new Text("Sala de espera");
        titulo.setStrokeWidth(2);
        titulo.setFill(Color.WHITESMOKE);
        titulo.setStroke(Color.WHITESMOKE);
        titulo.setStyle(DISENIOTITULOS);
        
        top.getChildren().add(titulo);
        root.setTop(top);
    }
    
    private void crearBot(){
        bot = new HBox();
        
        bot.setAlignment(Pos.CENTER);
        bot.setSpacing(20);
        bot.setStyle(DISENIOTOP);
        
        Text titulo = new Text("Horario de atencion de lunes a viernes de 10 a 18hs");
        titulo.setStrokeWidth(2);
        titulo.setFill(Color.WHITESMOKE);
        titulo.setStroke(Color.WHITESMOKE);
        titulo.setStyle(DISENIOTITULOS);
        
        bot.getChildren().add(titulo);
        root.setBottom(bot);
    }
    
    private void crearCenter(){
        center = new HBox();
        center.setAlignment(Pos.CENTER);
        crearTabla();
        center.getChildren().add(tabla);
        root.setCenter(center);
    }
    
    private void crearTabla() {
        tabla = new TableView();
        cTurno = new TableColumn("Turno");
        cTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));

        cPuesto = new TableColumn("Puesto");
        cPuesto.setCellValueFactory(new PropertyValueFactory<>("nomPuesto"));

        tabla.getColumns().add(cTurno);
        tabla.getColumns().add(cPuesto);
        
        
        List<Paciente> lista = new ArrayList<>();
        Queue<Paciente> colaPacientes = Sistema.colaPacientes;
        
        while(!colaPacientes.isEmpty())
            lista.add(colaPacientes.poll());
        
        
        
        llenarTabla(lista);

        tabla.setEditable(false);

        cTurno.setMinWidth(225);
        cPuesto.setMinWidth(225);

        cTurno.setMaxWidth(225);
        cPuesto.setMaxWidth(225);

        tabla.setMaxSize(500, 500);

    }
    
    private void llenarTabla(List<Paciente> lista){
        tabla.getItems().clear();
        for(Paciente p:lista){
            tabla.getItems().add(p);
        }
    }
    
    public Pane getRoot(){
        return root;
    }
    
    public void terminarHiloReloj(){
        pararHilo = true;
    }
}
