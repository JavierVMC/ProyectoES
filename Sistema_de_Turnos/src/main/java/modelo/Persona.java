
package modelo;


public class Persona {
    private String nombres;
    private String apellidos;

    public Persona(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return nombres+" | "+apellidos;
    }
    
    
    
}
