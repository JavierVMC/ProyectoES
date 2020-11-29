
package modelo;

public class Puesto {
    private String numero;
    private Medico medicoAsignado;

    public Puesto(String numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return numero+"|"+medicoAsignado;
    }
    
    
}
