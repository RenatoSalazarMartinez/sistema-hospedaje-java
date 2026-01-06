
package DTO;

import java.time.LocalDateTime;


public class Estadia {
    private int idEstadia;
    private int idHuesped;
    private int idHabitacion;
    
    private LocalDateTime fechaHoraIngreso, fechaHoraSalidaProgramada, fechaHoraSalidaReal;
    
    private int noches;
    
    private double precioPorNoche, total;
    private int cantidadPersonas;
    private String estado;

    public Estadia() {
    }

    public Estadia(int idEstadia, int idHuesped, int idHabitacion, LocalDateTime fechaHoraIngreso, 
            LocalDateTime fechaHoraSalidaProgramada, LocalDateTime fechaHoraSalidaReal, int noches, double precioPorNoche, 
            double total, int cantidadPersonas, String estado) {
        
        this.idEstadia = idEstadia;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.fechaHoraSalidaProgramada = fechaHoraSalidaProgramada;
        this.fechaHoraSalidaReal = fechaHoraSalidaReal;
        this.noches = noches;
        this.precioPorNoche = precioPorNoche;
        this.total = total;
        this.cantidadPersonas = cantidadPersonas;
        this.estado = estado;
    }

    public int getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(int idEstadia) {
        this.idEstadia = idEstadia;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalidaProgramada() {
        return fechaHoraSalidaProgramada;
    }

    public void setFechaHoraSalidaProgramada(LocalDateTime fechaHoraSalidaProgramada) {
        this.fechaHoraSalidaProgramada = fechaHoraSalidaProgramada;
    }

    public LocalDateTime getFechaHoraSalidaReal() {
        return fechaHoraSalidaReal;
    }

    public void setFechaHoraSalidaReal(LocalDateTime fechaHoraSalidaReal) {
        this.fechaHoraSalidaReal = fechaHoraSalidaReal;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
