
package DTO;

public class Huesped {
    private int idHuesped;
    private String dni, nombres, telefono;

    public Huesped() {
    }

    public Huesped(String dni, String nombres, String telefono) {
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public Huesped(int idHuesped, String dni, String nombres, String telefono) {
        this.idHuesped = idHuesped;
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return dni + " - " +nombres;
    }
    
    
    
}
