
package modelo;


public class Paciente extends Persona{
    ///nombres, apellidos, edad, género y el síntoma que presenta.
    private int edad;
    private String genero;
    private String sintoma;
    
    public Paciente(String nombre, String apellido,int edad, String genero, String sintoma) {
        super(nombre, apellido);
        this.edad = edad;
        this.genero = genero;
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return  super.toString()+" | "+edad+" | "+genero+" | "+sintoma;
    }
    
    

   
}
