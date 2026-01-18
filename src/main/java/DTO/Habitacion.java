
package DTO;

public class Habitacion {
    private int idHabitacion, numero, capacidad;
    private String estado;
    
    public Habitacion(){
        
    }

    //Constructor para INSERTS (Sin ID)
    public Habitacion(int numero, int capacidad, String estado) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    
    //Constructor para SELECTS
    public Habitacion(int idHabitacion, int numero, int capacidad, String estado) {
        this.idHabitacion = idHabitacion;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Hab " + numero;
    }
      
}
