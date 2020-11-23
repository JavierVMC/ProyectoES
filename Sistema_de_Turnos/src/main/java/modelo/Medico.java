package modelo;


public class Medico extends Persona {
    private String especialidad;

    public Medico(String nombre, String apellido,String especialidad) {
        super(nombre, apellido);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return  super.toString()+','+especialidad;
    }
   
}
