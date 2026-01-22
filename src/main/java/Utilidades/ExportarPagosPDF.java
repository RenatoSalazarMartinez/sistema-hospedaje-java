package Utilidades;

import DTO.Pago;
import com.itextpdf.kernel.colors.Color; // Importante: usar la clase base Color
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import javax.swing.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExportarPagosPDF {

    // Cambiamos el tipo a Color para evitar conflictos de casteo
    private static final Color COLOR_PRIMARIO = new DeviceRgb(30, 41, 59);
    private static final Color COLOR_ACCENTO = new DeviceRgb(37, 99, 235);
    private static final Color COLOR_FONDO_HEADER = new DeviceRgb(241, 245, 249);

    public static void exportar(List<Pago> pagos) {

        if (pagos == null || pagos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pagos para exportar");
            return;
        }

        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File("Reporte_Pagos_" + System.currentTimeMillis() + ".pdf"));

            if (chooser.showSaveDialog(null) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            PdfWriter writer = new PdfWriter(chooser.getSelectedFile());
            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);
            
            doc.setMargins(40, 40, 40, 40);

            // --- ENCABEZADO ---
            Table header = new Table(UnitValue.createPointArray(new float[]{1, 1}));
            header.setWidth(UnitValue.createPercentValue(100));
            
            Cell titulo = new Cell().add(new Paragraph("REPORTE DE PAGOS")
                    .setBold()
                    .setFontSize(20)
                    .setFontColor(COLOR_PRIMARIO));
            titulo.setBorder(null);
            header.addCell(titulo);

            String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            Cell infoFecha = new Cell().add(new Paragraph("Fecha de emisión: " + fechaActual)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(10)
                    .setFontColor(ColorConstants.GRAY));
            infoFecha.setBorder(null);
            header.addCell(infoFecha);
            
            doc.add(header);
            doc.add(new Paragraph("\n"));

            // --- TABLA DE DATOS ---
            Table table = new Table(UnitValue.createPercentArray(new float[]{20, 20, 25, 20, 15}));
            table.setWidth(UnitValue.createPercentValue(100));

            String[] columnas = {"Fecha", "Monto", "Método", "Estado", "Estadía"};
            for (String col : columnas) {
                Cell cell = new Cell().add(new Paragraph(col).setBold());
                cell.setBackgroundColor(COLOR_PRIMARIO);
                cell.setFontColor(ColorConstants.WHITE);
                cell.setPadding(8);
                cell.setTextAlignment(TextAlignment.CENTER);
                table.addHeaderCell(cell);
            }

            // Filas de la Tabla
            int count = 0;
            for (Pago p : pagos) {
                // CORRECCIÓN: Usamos el tipo Color para que acepte tanto WHITE como DeviceRgb
                Color filaColor = (count % 2 == 0) ? ColorConstants.WHITE : COLOR_FONDO_HEADER;

                table.addCell(crearCelda(p.getFechaPago().toString(), filaColor));
                table.addCell(crearCelda(String.format("S/. %.2f", p.getMonto()), filaColor));
                table.addCell(crearCelda(p.getMetodoPago(), filaColor));
                
                Paragraph pEstado = new Paragraph(p.getEstado().toUpperCase()).setBold().setFontSize(9);
                if(p.getEstado().equalsIgnoreCase("Pagado")) pEstado.setFontColor(new DeviceRgb(22, 101, 52));
                
                Cell cellEstado = new Cell().add(pEstado)
                        .setBackgroundColor(filaColor)
                        .setPadding(8)
                        .setTextAlignment(TextAlignment.CENTER);
                table.addCell(cellEstado);

                table.addCell(crearCelda("#" + p.getIdEstadia(), filaColor));
                
                count++;
            }

            doc.add(table);

            // --- RESUMEN FINAL ---
            doc.add(new Paragraph("\n"));
            double total = pagos.stream().mapToDouble(Pago::getMonto).sum();
            doc.add(new Paragraph("Total Recaudado: S/. " + String.format("%.2f", total))
                    .setBold()
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontColor(COLOR_ACCENTO));

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte PDF generado con éxito");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF técnico: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // CORRECCIÓN: El parámetro fondo ahora es de tipo Color
    private static Cell crearCelda(String texto, Color fondo) {
        return new Cell().add(new Paragraph(texto).setFontSize(10))
                .setBackgroundColor(fondo)
                .setPadding(8)
                .setBorder(null)
                .setBorderBottom(new com.itextpdf.layout.borders.SolidBorder(new DeviceRgb(226, 232, 240), 1))
                .setTextAlignment(TextAlignment.CENTER);
    }
}