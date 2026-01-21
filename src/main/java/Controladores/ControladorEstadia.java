
package Controladores;

import DAO.EstadiaDAO;
import DTO.Estadia;
import java.util.List;


public class ControladorEstadia {
    private EstadiaDAO estadiaDAO;

    public ControladorEstadia() {
        this.estadiaDAO = new EstadiaDAO();
    }

     // REGISTRAR una nueva estadía
    public boolean crearEstadia(Estadia e) {
        if (e.getIdHuesped() <= 0) throw new IllegalArgumentException("ID de huésped inválido.");
        if (e.getIdHabitacion() <= 0) throw new IllegalArgumentException("ID de habitación inválido.");
        if (e.getNoches() <= 0) throw new IllegalArgumentException("Número de noches inválido.");
        if (e.getCantidadPersonas() <= 0) throw new IllegalArgumentException("Cantidad de personas inválida.");
        return estadiaDAO.registrar(e);
    }
    
    public int registrarEstadiaConID(Estadia e) {

        if (e.getIdHuesped() <= 0) {
            throw new IllegalArgumentException("Huésped inválido");
        }

        if (e.getIdHabitacion() <= 0) {
            throw new IllegalArgumentException("Habitación inválida");
        }

        if (e.getNoches() <= 0) {
            throw new IllegalArgumentException("Cantidad de noches inválida");
        }

        return estadiaDAO.registrarYRetornarID(e);
    }

    // MODIFICAR una estadía existente
    public boolean modificarEstadia(Estadia e) {
        if (e.getIdEstadia() <= 0) throw new IllegalArgumentException("ID de estadía inválido.");
        return estadiaDAO.modificar(e);
    }

    // ANULAR una estadía (cambiar estado a 'ANULADA')
    public boolean anularEstadia(int idEstadia) {
        if (idEstadia <= 0) throw new IllegalArgumentException("ID de estadía inválido.");
        return estadiaDAO.eliminar(idEstadia);
    }

    // FINALIZAR una estadía (cambiar estado a 'FINALIZADA')
    public boolean finalizarEstadia(int idEstadia, int idHabitacion) {
        if (idEstadia <= 0 || idHabitacion <= 0)
            throw new IllegalArgumentException("ID de estadía o habitación inválido.");
        return estadiaDAO.finalizarEstadia(idEstadia, idHabitacion);
    }

    // BUSCAR estadía por ID
    public Estadia buscarEstadia(int idEstadia) {
        if (idEstadia <= 0) throw new IllegalArgumentException("ID de estadía inválido.");
        return estadiaDAO.buscar(idEstadia);
    }

    // LISTAR todas las estadías
    public List<Estadia> listarEstadias() {
        return estadiaDAO.listar();
    }

    // LISTAR solo las estadías activas
    public List<Estadia> listarEstadiasActivas() {
        return estadiaDAO.listarEstadiasActivas();
    }
    
    public int obtenerNumeroHabitacionPorEstadia(int idEstadia) {
        return estadiaDAO.obtenerNumeroHabitacionPorEstadia(idEstadia);
    }

    public int obtenerIdHabitacionPorEstadia (int idEstadia){
        return estadiaDAO.obtenerIdHabitacionPorEstadia(idEstadia);
    }
}
