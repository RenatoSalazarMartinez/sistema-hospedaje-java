
package Controladores;

import DAO.PagoDAO;
import DTO.Pago;
import java.util.List;

public class ControladorPago {
    private final PagoDAO pagoDAO;

    public ControladorPago() {
        this.pagoDAO = new PagoDAO();
    }

    // REGISTRAR un nuevo pago
    public boolean registrarPago(Pago p) {
        if (p.getIdEstadia() <= 0) throw new IllegalArgumentException("ID de estadía inválido.");
        if (p.getMonto() <= 0) throw new IllegalArgumentException("Monto del pago inválido.");
        if (p.getMetodoPago() == null || p.getMetodoPago().isEmpty())
            throw new IllegalArgumentException("Debe especificar un método de pago.");
        return pagoDAO.registrar(p);
    }

    // MODIFICAR un pago existente
    public boolean modificarPago(Pago p) {
        if (p.getIdPago() <= 0) throw new IllegalArgumentException("ID de pago inválido.");
        if (p.getMonto() <= 0) throw new IllegalArgumentException("Monto del pago inválido.");
        if (p.getMetodoPago() == null || p.getMetodoPago().isEmpty())
            throw new IllegalArgumentException("Debe especificar un método de pago.");
        return pagoDAO.modificar(p);
    }

    // ANULAR un pago
    public boolean anularPago(int idPago) {
        if (idPago <= 0) throw new IllegalArgumentException("ID de pago inválido.");
        return pagoDAO.eliminar(idPago);
    }

    // BUSCAR un pago por ID
    public Pago buscarPago(int idPago) {
        if (idPago <= 0) throw new IllegalArgumentException("ID de pago inválido.");
        return pagoDAO.buscar(idPago);
    }

    // LISTAR todos los pagos
    public List<Pago> listarPagos() {
        return pagoDAO.listar();
    }

    // LISTAR pagos de una estadía específica
    public List<Pago> listarPagosPorEstadia(int idEstadia) {
        if (idEstadia <= 0) throw new IllegalArgumentException("ID de estadía inválido.");
        return pagoDAO.listarPorEstadia(idEstadia);
    }
}
