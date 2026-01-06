
package Controladores;

import DAO.HabitacionDAO;
import DTO.Habitacion;
import java.util.List;


public class ControladorHabitacion {
    private HabitacionDAO habitacionDAO;

    public ControladorHabitacion() {
        this.habitacionDAO = new HabitacionDAO();
    }

    // REGISTRAR una nueva habitación
    public boolean crearHabitacion(Habitacion h) {
        if(h.getNumero() <= 0) {
            throw new IllegalArgumentException("El número de habitación debe ser mayor que cero.");
        }
        if(h.getCapacidad() <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        if(h.getEstado() == null || h.getEstado().isEmpty()) {
            throw new IllegalArgumentException("El estado de la habitación es obligatorio.");
        }

        return habitacionDAO.registrar(h);
    }

    // MODIFICAR habitación
    public boolean modificarHabitacion(Habitacion h) {
        if(h.getIdHabitacion() <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido.");
        }
        return habitacionDAO.modificar(h);
    }

    // ELIMINAR habitación
    public boolean eliminarHabitacion(int idHabitacion) {
        if(idHabitacion <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido.");
        }
        return habitacionDAO.eliminar(idHabitacion);
    }

    // BUSCAR habitación por ID
    public Habitacion buscarHabitacion(int idHabitacion) {
        if(idHabitacion <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido.");
        }
        return habitacionDAO.buscar(idHabitacion);
    }

    // LISTAR todas las habitaciones
    public List<Habitacion> listarHabitaciones() {
        return habitacionDAO.listar();
    }

    // LISTAR solo habitaciones DISPONIBLES
    public List<Habitacion> listarHabitacionesDisponibles() {
        return habitacionDAO.listarDisponibles();
    }

    // ACTUALIZAR solo el estado de la habitación
    public boolean actualizarEstado(int idHabitacion, String estado) {
        if(idHabitacion <= 0) {
            throw new IllegalArgumentException("ID de habitación inválido.");
        }
        if(estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }

        return habitacionDAO.actualizarEstado(idHabitacion, estado);
    }
}
