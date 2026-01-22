
package Vistas;

import Controladores.ControladorPago;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

public class FrmPagos extends javax.swing.JFrame {
    private ControladorPago controladorPago = new ControladorPago();

    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPagos.class.getName());

    
    public FrmPagos() {
        configurarApariencia();
        initComponents();
        personalizarDiseno();
        cargarTodosLosPagos();
//        configurarEventos();
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();
        btnExportarExcel = new javax.swing.JButton();
        btnExportarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Pagos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión de Pagos");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(164, 164, 164));
        jLabel7.setText("Administrar los pagos de las estadías");

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Fecha de pago", "Monto (S/.)", "Método de pago", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaPagos);

        btnExportarExcel.setText("Exportar Excel");
        btnExportarExcel.addActionListener(this::btnExportarExcelActionPerformed);

        btnExportarPDF.setText("Exportar PDF");
        btnExportarPDF.addActionListener(this::btnExportarPDFActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExportarPDF)
                        .addGap(28, 28, 28)
                        .addComponent(btnExportarExcel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportarExcel)
                    .addComponent(btnExportarPDF))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFActionPerformed
        var pagos = controladorPago.listarPagos();
        Utilidades.ExportarPagosPDF.exportar(pagos);
    }//GEN-LAST:event_btnExportarPDFActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed
        var pagos = controladorPago.listarPagos();
        Utilidades.ExportarPagosExcel.exportar(pagos);
    }//GEN-LAST:event_btnExportarExcelActionPerformed

//    private void configurarEventos() {
//
//        btnExportarPDF.addActionListener(e -> {
//            
//        });
//
//        btnExportarExcel.addActionListener(e -> {
//            
//        });
//    }

    
    private void configurarApariencia() {
        try {
            FlatIntelliJLaf.setup();
            // Configuración de bordes redondeados globales
            UIManager.put("Button.arc", 12);
            UIManager.put("Component.arc", 12);
            UIManager.put("TextComponent.arc", 12);
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error al configurar FlatLaf", ex);
        }
    }

    private void personalizarDiseno() {
        // Fondo del panel principal
        jPanel1.setBackground(new Color(250, 251, 253));
        
        // Estética de Títulos
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        jLabel1.setForeground(new Color(30, 41, 59)); // Slate 800
        
        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        jLabel7.setForeground(new Color(100, 116, 139)); // Slate 500

        // Botones de Exportación (Estilo con fondo sólido para mayor estética)
        btnExportarExcel.setBackground(new Color(22, 101, 52)); // Verde Excel sólido
        btnExportarExcel.setForeground(Color.WHITE);
        btnExportarExcel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnExportarExcel.setFocusPainted(false);

        btnExportarPDF.setBackground(new Color(153, 27, 27)); // Rojo PDF sólido
        btnExportarPDF.setForeground(Color.WHITE);
        btnExportarPDF.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnExportarPDF.setFocusPainted(false);

        // Estética de la Tabla de Pagos
        tablaPagos.setRowHeight(40);
        tablaPagos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaPagos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tablaPagos.getTableHeader().setBackground(new Color(241, 245, 249));
        tablaPagos.getTableHeader().setForeground(new Color(71, 85, 105));
        tablaPagos.setShowVerticalLines(false);
        tablaPagos.setGridColor(new Color(226, 232, 240));
        
        jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
        jScrollPane1.setBorder(null); // Quitar borde del scroll principal
    }
    
    private void cargarTodosLosPagos() {

        var modelo = new javax.swing.table.DefaultTableModel(
                new Object[]{"Fecha", "Monto (S/.)", "Método", "Estado", "Estadía"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        controladorPago.listarPagos().forEach(p -> {
            modelo.addRow(new Object[]{
                p.getFechaPago(),
                p.getMonto(),
                p.getMetodoPago(),
                p.getEstado(),
                "Estadía #" + p.getIdEstadia()
            });
        });

        tablaPagos.setModel(modelo);
    }


    private JPanel crearCampoEstilizado(String titulo, JTextField campo, String placeholder) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl.setForeground(new Color(71, 85, 105));

        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 36));
        campo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(campo);

        return panel;
    }

    private JPanel crearSelectorEstilizado(String titulo, JComboBox<?> combo) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl.setForeground(new Color(71, 85, 105));

        combo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        combo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 36));

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(combo);

        return panel;
    }

    private JPanel crearCampoFecha(String titulo, JDateChooser dateChooser) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl.setForeground(new Color(71, 85, 105));

        dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dateChooser.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 36));
        dateChooser.setDate(new java.util.Date()); // fecha actual por defecto

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(dateChooser);

        return panel;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FrmPagos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPagos;
    // End of variables declaration//GEN-END:variables
}
