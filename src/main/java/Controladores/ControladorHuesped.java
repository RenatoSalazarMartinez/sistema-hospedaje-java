
package Controladores;

import DAO.HuespedDAO;
import DTO.Huesped;
import java.util.List;

public class ControladorHuesped {
    private HuespedDAO huespedDAO;
    
    public ControladorHuesped(){
        this.huespedDAO = new HuespedDAO();
    }
    
     // CREAR un nuevo huésped
    public boolean crearHuesped(Huesped h) {
        // Validaciones básicas
        if(h.getDni() == null || h.getDni().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        if(h.getNombres() == null || h.getNombres().isEmpty()) {
            throw new IllegalArgumentException("El nombre del huésped es obligatorio.");
        }

        // Llamar al DAO
        return huespedDAO.registrar(h);
    }

    // MODIFICAR un huésped existente
    public boolean modificarHuesped(Huesped h) {
        if(h.getIdHuesped() <= 0) {
            throw new IllegalArgumentException("ID de huésped inválido.");
        }
        return huespedDAO.modificar(h);
    }

    // ELIMINAR un huésped
    public boolean eliminarHuesped(int idHuesped) {
        if(idHuesped <= 0) {
            throw new IllegalArgumentException("ID de huésped inválido.");
        }
        return huespedDAO.eliminar(idHuesped);
    }

    // BUSCAR un huésped por ID
    public Huesped buscarHuesped(int idHuesped) {
        if(idHuesped <= 0) {
            throw new IllegalArgumentException("ID de huésped inválido.");
        }
        return huespedDAO.buscar(idHuesped);
    }

    // LISTAR todos los huéspedes
    public List<Huesped> listarHuespedes() {
        return huespedDAO.listar();
    }

    // BUSCAR un huésped por DNI
    public Huesped buscarPorDni(String dni) {
        if(dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("DNI no puede estar vacío.");
        }
        return huespedDAO.buscarPorDni(dni);
    }
}
