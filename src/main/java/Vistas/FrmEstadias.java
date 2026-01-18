
package Vistas;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import Controladores.*;
import DTO.Estadia;
import DTO.Habitacion;
import DTO.Huesped;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class FrmEstadias extends javax.swing.JFrame {
    private DefaultTableModel modeloEstadias;
    private ControladorEstadia controladorEstadia = new ControladorEstadia();
    private Map<Integer, TarjetaHabitacion> tarjetasHabitaciones = new HashMap<>();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEstadias.class.getName());

    
    public FrmEstadias() {
        configurarApariencia();
        initComponents();
        configurarTablaEstadias();
        listarEstadias();
        aplicarRenderersTabla();
        inyectarMonitorCuadricula();
        personalizarDiseno();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnNuevaHabitacion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEstadias = new javax.swing.JTable();
        panelGraficos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Estadías");
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Gestión de Estadías");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(164, 164, 164));
        jLabel7.setText("Administrar las estadías del hospedaje");

        btnNuevaHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevaHabitacion.setText("Nueva Estadía");
        btnNuevaHabitacion.addActionListener(this::btnNuevaHabitacionActionPerformed);

        tablaEstadias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Huésped", "Habitación", "Ingreso", "Salida Programada", "Noches", "Precio por noche", "Total", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaEstadias);

        javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
        panelGraficos.setLayout(panelGraficosLayout);
        panelGraficosLayout.setHorizontalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        panelGraficosLayout.setVerticalGroup(
            panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevaHabitacion))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnNuevaHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHabitacionActionPerformed
        abrirDialogoNuevaEstadia();
    }//GEN-LAST:event_btnNuevaHabitacionActionPerformed

    private void inyectarMonitorCuadricula() {
        // Rediseño a Cuadrícula de 3 filas x 6 columnas para las 18 habitaciones
        // Esto hace que el panel sea más ancho y menos alto, optimizando el espacio.
        JPanel panelCuadricula = new JPanel(new GridLayout(3, 6, 12, 12));
        panelCuadricula.setBackground(new Color(250, 251, 253));
        panelCuadricula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ControladorHabitacion ctrl = new ControladorHabitacion();
        
        for (Habitacion hab : ctrl.listarHabitaciones()) {
            int numHab = hab.getNumero();
            String estado = hab.getEstado(); // tomamos el estado real de la BD

            TarjetaHabitacion tarjeta = new TarjetaHabitacion(numHab, estado);
            panelCuadricula.add(tarjeta);

            tarjetasHabitaciones.put(numHab, tarjeta);
        }
        
        // Reemplazar el panel anterior por la nueva cuadrícula
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) jPanel1.getLayout();
        layout.replace(panelGraficos, panelCuadricula);
        panelGraficos = panelCuadricula;
        
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void configurarApariencia() {
        try {
            FlatIntelliJLaf.setup();
            UIManager.put("Button.arc", 12);
            UIManager.put("Component.arc", 12);
            UIManager.put("TextComponent.arc", 12);
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void personalizarDiseno() {
        jPanel1.setBackground(new Color(250, 251, 253));
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 28));
        jLabel1.setForeground(new Color(30, 41, 59));
        jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jLabel7.setForeground(new Color(100, 116, 139));

        btnNuevaHabitacion.setBackground(new Color(37, 99, 235));
        btnNuevaHabitacion.setForeground(Color.WHITE);
        btnNuevaHabitacion.setFont(new Font("Segoe UI", Font.BOLD, 14));

        tablaEstadias.setRowHeight(35);
        jScrollPane2.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));
        jScrollPane1.setBorder(null);
    }

    private void configurarTablaEstadias() {

        modeloEstadias = new DefaultTableModel(
                new Object[]{
                    "Huésped",
                    "Habitación",
                    "Ingreso",
                    "Salida Programada",
                    "Noches",
                    "Precio x Noche",
                    "Total",
                    "Estado"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // tabla solo lectura
            }
        };

        tablaEstadias.setModel(modeloEstadias);
        tablaEstadias.setRowHeight(35);
    }

    private void aplicarRenderersTabla() {
    tablaEstadias.getColumnModel()
        .getColumn(7) // columna "Estado"
        .setCellRenderer(new EstadoEstadiaRenderer());
}    
    
    // COMPONENTE DE TARJETA INDIVIDUAL 
    private class TarjetaHabitacion extends JPanel {

        private final int numero;
        private String estado;
        private Color colorFondo;
        private Color colorTexto;

        public TarjetaHabitacion(int numero, String estado) {
            this.numero = numero;
            this.estado = estado;
            configurarColores();
            setPreferredSize(new Dimension(130, 90)); // Ajustado para que entren 6 por fila
            setBackground(Color.WHITE);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
        }

        public void setEstado(String nuevoEstado) {
            this.estado = nuevoEstado;
            configurarColores();
            repaint(); // repinta la tarjeta con el nuevo color
        }

        
        private void configurarColores() {
            switch (estado) {
                case "DISPONIBLE" -> {
                    colorFondo = new Color(34, 197, 94); // Verde
                    colorTexto = Color.WHITE;
                }
                case "OCUPADA" -> {
                    colorFondo = new Color(255,0,6); // Rojo
                    colorTexto = Color.WHITE;
                }
                case "LIMPIEZA" -> {
                    colorFondo = new Color(37, 99, 235); // Azul
                    colorTexto = Color.WHITE;
                }
                default -> {
                    colorFondo = new Color(234, 88, 12); // Naranja
                    colorTexto = Color.WHITE;
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar fondo de color según estado
            g2.setColor(colorFondo);
            g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 15, 15);

            // Dibujar Texto
            g2.setColor(colorTexto);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 16));
            g2.drawString("HAB " + numero, 15, 35);

            g2.setFont(new Font("Segoe UI", Font.BOLD, 11));
            g2.drawString(estado, 15, 55);
        }
    }

    private void abrirDialogoNuevaEstadia() {
        JDialog dialog = new JDialog(this, "Registrar Estadía", true);
        dialog.setLayout(new BorderLayout());

        // === PANEL PRINCIPAL ===
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
        pnlForm.setBackground(Color.WHITE);

        // Título y subtítulo
        JLabel lblTituloDl = new JLabel("Nueva Estadía");
        lblTituloDl.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTituloDl.setForeground(new Color(30, 41, 59));
        lblTituloDl.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSubtituloDl = new JLabel("Complete los datos para el registro de la estadía");
        lblSubtituloDl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtituloDl.setForeground(new Color(100, 116, 139));
        lblSubtituloDl.setAlignmentX(Component.LEFT_ALIGNMENT);

        pnlForm.add(lblTituloDl);
        pnlForm.add(lblSubtituloDl);
        pnlForm.add(Box.createVerticalStrut(25));

        // === CAMPOS DEL FORMULARIO ===
        JPanel pnlGrid = new JPanel(new GridLayout(4, 2, 20, 15));
        pnlGrid.setBackground(Color.WHITE);
        pnlGrid.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Combos
        final JComboBox<Huesped> cbHuesped = new JComboBox<>();
        final JComboBox<Habitacion> cbHabitacion = new JComboBox<>();
        cargarComboHuesped(cbHuesped);
        cargarComboHabitacion(cbHabitacion);
        pnlGrid.add(crearComboEstilizado("Huésped", cbHuesped));
        pnlGrid.add(crearComboEstilizado("Habitación", cbHabitacion));

        // Fechas
        final JDateChooser dcEntrada = new JDateChooser();
        final JDateChooser dcSalida = new JDateChooser();
        pnlGrid.add(crearCampoFecha("Fecha de Ingreso", dcEntrada));
        pnlGrid.add(crearCampoFecha("Salida Programada", dcSalida));

        
        // Cantidades y precios
        final JTextField txtNoches = new JTextField();
        final JTextField txtPrecio = new JTextField();
        final JTextField txtAdelanto = new JTextField();
        pnlGrid.add(crearCampoEstilizado("Cant. Noches", txtNoches, "Autocalcular..."));
        pnlGrid.add(crearCampoEstilizado("Precio x Noche", txtPrecio, "0.00"));
        pnlGrid.add(crearCampoEstilizado("Adelanto (S/.)", txtAdelanto, "0.00"));

        // Estado
        final JComboBox<String> cbEstado = new JComboBox<>(new String[]{"Ocupada", "Reservada"});
        pnlGrid.add(crearSelectorEstilizado("Estado Inicial", cbEstado));

        pnlForm.add(pnlGrid);

        // Autocalcular Noches al cambiar las fechas
        PropertyChangeListener calcularNochesListener = evt -> {
            if ("date".equals(evt.getPropertyName())) {
                if (dcEntrada.getDate() != null && dcSalida.getDate() != null) {
                    long diffMillis = dcSalida.getDate().getTime() - dcEntrada.getDate().getTime();
                    int noches = (int) (diffMillis / (1000 * 60 * 60 * 24));
                    if (noches < 0) {
                        noches = 0; // evitar negativos
                    }
                    txtNoches.setText(String.valueOf(noches));
                }
            }
        };

        dcEntrada.addPropertyChangeListener(calcularNochesListener);
        dcSalida.addPropertyChangeListener(calcularNochesListener);
        
        // === BOTONERA ===
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        pnlBotones.setBackground(new Color(248, 250, 252));
        JButton btnCan = new JButton("Cancelar");
        JButton btnGuar = new JButton("Confirmar Registro");
        btnGuar.setBackground(new Color(37, 99, 235));
        btnGuar.setForeground(Color.WHITE);
        btnGuar.setPreferredSize(new Dimension(150, 35));
        btnCan.addActionListener(e -> dialog.dispose());
        pnlBotones.add(btnCan);
        pnlBotones.add(btnGuar);

        dialog.add(pnlForm, BorderLayout.CENTER);
        dialog.add(pnlBotones, BorderLayout.SOUTH);

        // === ACCION DEL BOTÓN GUARDAR ===
        btnGuar.addActionListener(e -> {
            if (!validarFormulario(dialog, cbHuesped, cbHabitacion, txtNoches, txtPrecio, txtAdelanto, dcEntrada, dcSalida, cbEstado)) {
                return;
            }

            try {
                Huesped h = (Huesped) cbHuesped.getSelectedItem();
                Habitacion hab = (Habitacion) cbHabitacion.getSelectedItem();

                int noches = Integer.parseInt(txtNoches.getText());
                double precio = Double.parseDouble(txtPrecio.getText());
                double adelanto = txtAdelanto.getText().isEmpty() ? 0 : Double.parseDouble(txtAdelanto.getText());
                double total = noches * precio;

                Estadia eNueva = new Estadia();
                eNueva.setIdHuesped(h.getIdHuesped());
                eNueva.setIdHabitacion(hab.getIdHabitacion());
                eNueva.setFechaHoraIngreso(dcEntrada.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
                eNueva.setFechaHoraSalidaProgramada(dcSalida.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
                eNueva.setNoches(noches);
                eNueva.setPrecioPorNoche(precio);
                eNueva.setTotal(total);
                eNueva.setCantidadPersonas(hab.getCapacidad());
                eNueva.setEstado(cbEstado.getSelectedItem().toString());

                if (controladorEstadia.crearEstadia(eNueva)) {
                    JOptionPane.showMessageDialog(dialog, "Estadía registrada correctamente");
                    listarEstadias();
                    
                    // actualizar tarjeta de la habitación
                    TarjetaHabitacion tarjeta = tarjetasHabitaciones.get(hab.getNumero());
                    if (tarjeta != null) {
                        tarjeta.setEstado("OCUPADA"); // o el estado que corresponda
                    }
                    
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Error al registrar estadía");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.pack();
        dialog.setSize(650, 550);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private boolean validarFormulario(
            JDialog dialog,
            JComboBox<Huesped> cbHuesped,
            JComboBox<Habitacion> cbHabitacion,
            JTextField txtNoches,
            JTextField txtPrecio,
            JTextField txtAdelanto,
            JDateChooser dcEntrada,
            JDateChooser dcSalida,
            JComboBox<String> cbEstado
    ) {
        // Huésped
        if (cbHuesped.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(dialog, "Seleccione un huésped");
            cbHuesped.requestFocus();
            return false;
        }

        // Habitación
        if (cbHabitacion.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(dialog, "Seleccione una habitación");
            cbHabitacion.requestFocus();
            return false;
        }

        // Fechas
        if (dcEntrada.getDate() == null || dcSalida.getDate() == null) {
            JOptionPane.showMessageDialog(dialog, "Seleccione ambas fechas");
            return false;
        }

        if (dcSalida.getDate().before(dcEntrada.getDate())) {
            JOptionPane.showMessageDialog(dialog, "La fecha de salida no puede ser menor que la de entrada");
            return false;
        }

        // Noches
        try {
            int noches = Integer.parseInt(txtNoches.getText());
            if (noches <= 0) {
                JOptionPane.showMessageDialog(dialog, "Las noches deben ser mayores a cero");
                txtNoches.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(dialog, "Noches debe ser un número entero");
            txtNoches.requestFocus();
            return false;
        }

        // Precio
        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            if (precio <= 0) {
                JOptionPane.showMessageDialog(dialog, "El precio debe ser mayor a cero");
                txtPrecio.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(dialog, "Precio inválido");
            txtPrecio.requestFocus();
            return false;
        }

        // Adelanto (opcional)
        if (!txtAdelanto.getText().isEmpty()) {
            try {
                double adelanto = Double.parseDouble(txtAdelanto.getText());
                if (adelanto < 0) {
                    JOptionPane.showMessageDialog(dialog, "El adelanto no puede ser negativo");
                    txtAdelanto.requestFocus();
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(dialog, "Adelanto inválido");
                txtAdelanto.requestFocus();
                return false;
            }
        }

        // Estado
        if (cbEstado.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(dialog, "Seleccione el estado de la estadía");
            return false;
        }

        return true; // todo correcto
    }

    
    private JPanel crearCampoFecha(String titulo, JDateChooser dateChooser) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        dateChooser.setPreferredSize(new Dimension(200, 35));
        dateChooser.setBackground(Color.WHITE);
        dateChooser.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        p.add(lbl, BorderLayout.NORTH);
        p.add(dateChooser, BorderLayout.CENTER);
        return p;
    }

    private JPanel crearCampoEstilizado(String titulo, JTextField txt, String placeholder) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        txt.setPreferredSize(new Dimension(200, 35));
        txt.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, placeholder);
        p.add(lbl, BorderLayout.NORTH);
        p.add(txt, BorderLayout.CENTER);
        return p;
    }

    private JPanel crearSelectorEstilizado(String titulo, JComboBox<String> combo) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        combo.setPreferredSize(new Dimension(200, 35));
        p.add(lbl, BorderLayout.NORTH);
        p.add(combo, BorderLayout.CENTER);
        return p;
    }

    
    private JPanel crearComboEstilizado(String titulo, JComboBox<?> combo) {
        JPanel p = new JPanel(new BorderLayout(0, 5));
        p.setOpaque(false);

        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));

        combo.setPreferredSize(new Dimension(200, 35));

        p.add(lbl, BorderLayout.NORTH);
        p.add(combo, BorderLayout.CENTER);

        return p;
    }
    
    //Metoodo para aplicar un render a la columna de estado de acuerdo al tipo de estado
    private class EstadoEstadiaRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            if (value != null) {
                String estado = value.toString().toUpperCase();

                switch (estado) {
                    case "OCUPADA" ->
                        c.setForeground(new Color(220, 38, 38)); // rojo
                    case "RESERVADA" ->
                        c.setForeground(new Color(37, 99, 235)); // azul
                    case "FINALIZADA" ->
                        c.setForeground(new Color(22, 163, 74)); // verde
                    default ->
                        c.setForeground(new Color(100, 116, 139));
                }
            }

            if (isSelected) {
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    }

    private void cargarComboHuesped(JComboBox<Huesped> combo) {
        combo.removeAllItems();

        ControladorHuesped controlador = new ControladorHuesped();
        for (Huesped h : controlador.listarHuespedes()) {
            combo.addItem(h);
        }
    }
      
    private void cargarComboHabitacion(JComboBox<Habitacion> combo) {
        combo.removeAllItems();

        ControladorHabitacion controlador = new ControladorHabitacion();
        for (Habitacion h : controlador.listarHabitacionesDisponibles()) {
            combo.addItem(h);
        }
    }

    private void listarEstadias() {
    modeloEstadias.setRowCount(0); // Limpiar tabla
    for (Estadia e : controladorEstadia.listarEstadias()) {
        Huesped h = new ControladorHuesped().buscarHuesped(e.getIdHuesped());
        Habitacion hab = new ControladorHabitacion().buscarHabitacion(e.getIdHabitacion());

        modeloEstadias.addRow(new Object[]{
            h != null ? h.toString() : "",
            hab != null ? hab.toString() : "",
            e.getFechaHoraIngreso(),
            e.getFechaHoraSalidaProgramada(),
            e.getNoches(),
            e.getPrecioPorNoche(),
            e.getTotal(),
            e.getEstado()
        });
    }
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
        java.awt.EventQueue.invokeLater(() -> new FrmEstadias().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelGraficos;
    private javax.swing.JTable tablaEstadias;
    // End of variables declaration//GEN-END:variables
}
