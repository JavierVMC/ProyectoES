
package modelo;


public class Paciente extends Persona{
    ///nombres, apellidos, edad, género y el síntoma que presenta.
    private int edad;
    private String genero;
    private Sintoma sintoma;
    
    private String turno;
    private Puesto puesto;
    private String nomPuesto;
    
    public Paciente(String nombre, String apellido,int edad, String genero, Sintoma sintoma) {
        super(nombre, apellido);
        this.edad = edad;
        this.genero = genero;
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return  super.toString()+"|"+edad+"|"+genero+"|"+sintoma;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getNomPuesto() {
        return nomPuesto;
    }

    public void setNomPuesto(String nomPuesto) {
        this.nomPuesto = nomPuesto;
    }
    
    

   
}
