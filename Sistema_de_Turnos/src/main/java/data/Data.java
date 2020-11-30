
package data;

import excepciones.VentanaError;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sintoma;


public class Data {
    /**
     * Path del video 1
     */
    private final static String FILE_VIDEO1 = Constants.RESOURCE_FOLDER_VIDEO+"/";
    /**
     * Path del archivo sintomas
     */
    private final static String FILE_SINTOMAS = Constants.RESOURCE_FOLDER_ARCHIVOS+"/sintomas.txt";
    /**
     * Path del archivo pacientes
     */
    private final static String FILE_PACIENTES = Constants.RESOURCE_FOLDER_ARCHIVOS+"/pacientes.txt";
    /**
     * Path del archivo medicos
     */
    private final static String FILE_MEDICOS = Constants.RESOURCE_FOLDER_ARCHIVOS+"/medicos.txt";
    /**
     * Path del archivo puestos
     */
    private final static String FILE_PUESTOS = Constants.RESOURCE_FOLDER_ARCHIVOS+"/puestos.txt";

    /**
     * Retorna un HashMap con el nombre del sintoma como clave y la prioridad como valor
     * @return 
     */
    public static HashMap<String,Integer> leerArchivoSintomas() {
            HashMap<String,Integer> mapa = new HashMap<>();
            try(BufferedReader bf=new BufferedReader(new FileReader(FILE_SINTOMAS))){
                String linea;
                while((linea=bf.readLine())!=null){
                    String[] l = linea.split("\\|");
                    Sintoma s = new Sintoma(l[0],Integer.parseInt(l[1]));
                    mapa.put(s.getSintoma(), s.getPrioridad());
                }  
            }catch(FileNotFoundException ex){
                VentanaError.mostrarError(ex);
            }catch (IOException ex){
                VentanaError.mostrarError(ex);
            }
            return mapa;
    }
    /**
     * Guarda al paciente pasado como parametro en el archivo pacientes
     * @param p 
     */
    public static void guardarPaciente(Paciente p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PACIENTES,true))) {
            bw.write(p.toString());
            bw.newLine();
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
    
    }
    /**
     * Guarda al medico pasado como parametro en el archivo medicos
     * @param m 
     */
    public static void guardarMedico(Medico m){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_MEDICOS,true))) {
            bw.write(m.toString());
            bw.newLine();
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
    
    }
    /**
     * Guarda el puesto pasado como parametro en el archivo puestos
     * @param p 
     */
    public static void guardarPuesto(Puesto p){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PUESTOS,true))) {
            bw.write(p.toString());
            bw.newLine();
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
    
    }
    /**
     * Retorna una lista con los pacientes registrados
     * @return 
     */
    public static List<Paciente> leerArchivoPacientes(){
        List<Paciente> pacientes = new LinkedList<>();
        HashMap<String,Integer> sintomas = leerArchivoSintomas();
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_PACIENTES))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] l = linea.split("\\|");
                Sintoma s = new Sintoma(l[4],sintomas.get(l[4]));
                Paciente p = new Paciente(l[0], l[1],Integer.parseInt(l[2]),l[3],s);
                pacientes.add(p);
            }
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
        return pacientes;
    }
    /**
     * Retorna una lista con los medicos registrados
     * @return 
     */
    public static List<Medico> leerArchivoMedicos(){
        List<Medico> medicos = new LinkedList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_MEDICOS))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] l = linea.split("\\|");
                Medico m = new Medico(l[0], l[1],l[2]);
                medicos.add(m);
            }
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
        return medicos;
    }
    /**
     * Retorna una lista con los puestos registrados
     * @return 
     */
    public static List<Puesto> leerArchivoPuestos(){
        List<Puesto> puestos = new LinkedList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_PUESTOS))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] l = linea.split("\\|");
                Medico m = new Medico(l[1],l[2],l[3]);
                Puesto p = new Puesto(l[0], m);
                puestos.add(p);
            }
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
        return puestos;
    }
    
    /**
     * Elimina del archivo puestos el puesto pasado como parametro
     * @param puesto
     */
    public static void eliminarPuesto(String puesto){
        List<String> puestos = lineasPuestos();
        puestos.remove(puesto);
        
        vaciarArchivoPuestos();
        reescribirArchivoPuestos(puestos);
    }
    
    private static List<String> lineasPuestos(){
        List<String> puestos = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_PUESTOS))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                puestos.add(linea);
            }
        } catch (FileNotFoundException ex) {
            VentanaError.mostrarError(ex);
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
        return puestos;
    }
    
    private static void reescribirArchivoPuestos(List<String> puestos){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PUESTOS,true))) {
            for(int i=0;i<puestos.size();i++){
                bw.write(puestos.get(i));
                bw.newLine();
            }
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
    }
    
    private static void vaciarArchivoPuestos(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PUESTOS))) {
            bw.write("");
        } catch (IOException ex) {
            VentanaError.mostrarError(ex);
        }
    }
}
