
package Logica;


public class Paciente extends Persona{
    ///nombres, apellidos, edad, género y el síntoma que presenta.
    private int edad;
    private String genero;
    
    public Paciente(String nombre, String apellido,int edad, String genero) {
        super(nombre, apellido);
        this.edad = edad;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return  super.toString()+','+edad+','+genero;
    }
    
    

   
}
