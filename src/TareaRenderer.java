import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase TareaRenderer que extiende DefaultTableCellRenderer para personalizar la representación de celdas en una tabla.
 * Este renderer se utiliza para cambiar el color de fondo de las celdas dependiendo de la prioridad de la tarea y su fecha de entrega.
 * Las celdas de prioridad se colorean según la prioridad de la tarea, y las celdas de fecha de entrega se colorean si la tarea está atrasada.
 */
public class TareaRenderer extends DefaultTableCellRenderer {

    /**
     * Lista de objetos Tarea que contiene todas las tareas.
     */
    private ArrayList<Tarea> lista;  

    /**
     * Constructor de la clase TareaRenderer2.
     * 
     * @param lista Lista de tareas asociadas a las filas de la tabla.
     */
    public TareaRenderer(ArrayList<Tarea> lista) {
        this.lista = lista;
    }

    /**
     * Método sobrescrito de DefaultTableCellRenderer para personalizar la representación de una celda de la tabla.
     * Este método cambia el color de fondo de la celda dependiendo de la prioridad de la tarea asociada con esa fila.
     * También marca las celdas con una fecha de entrega pasada con un color de fondo especial.
     *
     * @param table La tabla en la que se está renderizando la celda.
     * @param value El valor que se muestra en la celda.
     * @param isSelected Indica si la celda está seleccionada.
     * @param hasFocus Indica si la celda tiene el foco.
     * @param row El índice de la fila en la que se encuentra la celda.
     * @param column El índice de la columna en la que se encuentra la celda.
     * @return El componente renderizado que se muestra en la celda.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        
        Integer tareaId = (Integer) table.getValueAt(row, 0); 
        
        Tarea tarea = obtenerTareaPorId(tareaId);

        if (tarea != null) {
            Date fechaEntrega = tarea.getFechaEntrega();  
            String prioridad = tarea.getPrioridad();  
            
            Date fechaActual = new Date();
            
            if (column == 2) {  
                switch (prioridad) {
                    case "Baja":
                        c.setBackground(new Color(245, 243, 230));  
                        break;
                    case "Media":
                        c.setBackground(new Color(252, 112, 59, 200));  
                        break;
                    case "Alta":
                        c.setBackground(new Color(92, 7, 2, 200));  
                        break;
                    default:
                        c.setBackground(Color.WHITE);  
                        break;
                }
            } else {
                //if(!tarea.getEstado().equals("Completada")){
                    if (fechaEntrega.before(fechaActual)) {
                        c.setBackground(new Color(48 , 114, 126)); 
                    } else {
                        c.setBackground(Color.WHITE);  
                    }
                //}
            }
        }

        if (isSelected) {
            c.setBackground(Color.LIGHT_GRAY);
        }

        return c;
    }

    /**
     * Busca la tarea en la lista de tareas mediante el ID de la tarea.
     * 
     * @param id El ID de la tarea que se busca.
     * @return La tarea correspondiente al ID, o null si no se encuentra.
     */
    private Tarea obtenerTareaPorId(int id) {
        for (Tarea tarea : lista) {
            if (tarea.getNumeroTarea() == id) {
                return tarea;
            }
        }
        return null;  
    }
}
