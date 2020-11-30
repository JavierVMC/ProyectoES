/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author test1
 */
public class Sistema {
    public static PriorityQueue<Paciente> colaPacientes;
    public static PriorityQueue<Puesto> colaPuestos;
    public static Stack<Puesto> pilaPuestos;
    
    public Sistema(){
        colaPacientes = new PriorityQueue<>((Paciente p1, Paciente p2)->(p1.getSintoma().getPrioridad()-p2.getSintoma().getPrioridad()));
        colaPuestos = new PriorityQueue<>();
        pilaPuestos = new Stack();
    }
    
    private static void llenarPila(){
        while(!colaPuestos.isEmpty()){
            pilaPuestos.push(colaPuestos.poll());
        }
    }
    
    
    public static void agregarPaciente(Paciente p){
        colaPacientes.offer(p);
    }
    
    public static void sacarPaciente(){
        Paciente p = colaPacientes.poll();
        colaPuestos.offer(p.getPuesto());
    }
    
    public static void agregarPuesto(Puesto p){
        colaPuestos.offer(p);
        llenarPila();
    }
    
    
    public static void asignarPuestoAPaciente(Paciente p){
        
    }
    
    
}
