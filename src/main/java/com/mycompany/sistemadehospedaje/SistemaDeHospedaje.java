
package com.mycompany.sistemadehospedaje;

import DAO.HabitacionDAO;
import DTO.Habitacion;
import Vistas.FrmLogin;
import java.util.List;


public class SistemaDeHospedaje {

    public static void main(String[] args) {
        Conexion.ConexionSQL.conectar();
//        FrmLogin frm = new FrmLogin();
//        frm.setVisible(true);
        
//        HabitacionDAO dao = new HabitacionDAO();
//        List<Habitacion> habitaciones = dao.listar();
//        
//        for (Habitacion h : habitaciones) {
//            System.out.println("Habitacion "+ h.getNumero() + " | Capacidad: "+ h.getCapacidad()+" | Estado: "+h.getEstado());
//        }
    }
}
