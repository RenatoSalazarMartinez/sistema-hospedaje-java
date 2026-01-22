package Utilidades;

import DTO.Pago;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Utilidad para exportar la lista de pagos a un archivo Excel (.xlsx)
 * Versión optimizada para evitar errores de archivo dañado al abrir.
 */
public class ExportarPagosExcel {

    public static void exportar(List<Pago> pagos) {
        if (pagos == null || pagos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pagos para exportar");
            return;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar Reporte de Excel");
        // Nombre por defecto sugerido
        String defaultFileName = "Reporte_Pagos_" + System.currentTimeMillis() + ".xlsx";
        chooser.setSelectedFile(new File(defaultFileName));

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            
            // Asegurar que tenga la extensión correcta
            if (!archivo.getName().toLowerCase().endsWith(".xlsx")) {
                archivo = new File(archivo.getParentFile(), archivo.getName() + ".xlsx");
            }

            generarExcel(pagos, archivo);
        }
    }

    private static void generarExcel(List<Pago> pagos, File archivo) {
        // Usamos try-with-resources para asegurar el cierre de los recursos
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(archivo)) {
            
            Sheet sheet = workbook.createSheet("Historial de Pagos");

            // --- ESTILOS ---
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            
            Font headerFont = workbook.createFont();
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 11);
            headerStyle.setFont(headerFont);

            CellStyle currencyStyle = workbook.createCellStyle();
            DataFormat df = workbook.createDataFormat();
            currencyStyle.setDataFormat(df.getFormat("S/ #,##0.00"));
            currencyStyle.setAlignment(HorizontalAlignment.RIGHT);
            
            CellStyle centerStyle = workbook.createCellStyle();
            centerStyle.setAlignment(HorizontalAlignment.CENTER);

            // --- CABECERAS ---
            String[] columnas = {"Fecha", "Monto", "Método de Pago", "Estado", "ID Estadía"};
            Row headerRow = sheet.createRow(0);
            headerRow.setHeightInPoints(25);

            for (int i = 0; i < columnas.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerStyle);
            }

            // --- DATOS ---
            int rowIdx = 1;
            for (Pago p : pagos) {
                Row row = sheet.createRow(rowIdx++);

                Cell fechaCell = row.createCell(0);
                fechaCell.setCellValue(p.getFechaPago() != null ? p.getFechaPago().toString() : "N/A");
                fechaCell.setCellStyle(centerStyle);
                
                Cell montoCell = row.createCell(1);
                montoCell.setCellValue(p.getMonto());
                montoCell.setCellStyle(currencyStyle);
                
                Cell metodoCell = row.createCell(2);
                metodoCell.setCellValue(p.getMetodoPago());
                metodoCell.setCellStyle(centerStyle);

                Cell estadoCell = row.createCell(3);
                estadoCell.setCellValue(p.getEstado() != null ? p.getEstado().toUpperCase() : "");
                estadoCell.setCellStyle(centerStyle);

                Cell estadiaCell = row.createCell(4);
                estadiaCell.setCellValue("Estadía #" + p.getIdEstadia());
                estadiaCell.setCellStyle(centerStyle);
            }

            // Ajustar columnas
            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
                sheet.setColumnWidth(i, sheet.getColumnWidth(i) + 1000);
            }

            // Escribir y finalizar
            workbook.write(fileOut);
            fileOut.flush(); // Forzar la escritura de cualquier buffer pendiente

            JOptionPane.showMessageDialog(null, "¡Excel generado exitosamente!\nArchivo: " + archivo.getName());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error crítico al guardar Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }
}