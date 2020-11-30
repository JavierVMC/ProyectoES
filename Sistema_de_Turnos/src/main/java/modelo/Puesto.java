
package modelo;

public class Puesto implements Comparable<Puesto>{
    private String numero;
    private Medico medicoAsignado;
    
    private boolean disponible;

    public Puesto(String numero) {
        this.numero = numero;
        disponible = true;
    }
    
    public Puesto(String numero, Medico medicoAsignado) {
        this.numero = numero;
        this.medicoAsignado = medicoAsignado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return numero+"|"+medicoAsignado;
    }
    
    @Override
    public int compareTo(Puesto o) {
        if(this.disponible==false && o.isDisponible()==true)
            return -1;
        else if(this.disponible==true && o.isDisponible()==false)
            return 1;
        return 0;
    }
    

    
}
