
package raven_cell;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase personalizada que extiende DefaultTableCellRenderer para renderizar celdas en una tabla con 
 * un panel que contiene botones de acción (Editar, Eliminar, Ver).
 * 
 * Esta clase se usa para personalizar la forma en que se renderizan las celdas de la tabla que contienen botones
 * de acción. Modifica el comportamiento de la celda dependiendo de si está seleccionada o no y también ajusta el
 * fondo de las celdas dependiendo de si la fila es par o impar.
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    /**
     * Constructor predeterminado de la clase TableActionCellRender.
     * (Si no hace nada en este caso, se puede aclarar que no tiene funcionalidad adicional por ahora).
     */
    public TableActionCellRender() {
        // Constructor por defecto
    }
    
    /**
     * Devuelve el componente que se usará para renderizar la celda de la tabla.
     * 
     * Este método reemplaza el componente de renderizado predeterminado por un panel personalizado 
     * PanelAction que contiene los botones de acción. Además, personaliza el fondo de la celda dependiendo
     * de si está seleccionada o no y si la fila es par o impar.
     *
     * @param jtable La tabla en la que se encuentra la celda que se está renderizando.
     * @param o El valor actual de la celda que se está renderizando.
     * @param isSeleted Indica si la celda está seleccionada o no.
     * @param bln1 Un parámetro adicional que indica si la celda tiene el foco.
     * @param row El índice de la fila de la celda que se está renderizando.
     * @param column El índice de la columna de la celda que se está renderizando.
     * @return Un componente PanelAction con los botones de acción y el fondo correspondiente.
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        PanelAction action = new PanelAction();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
}
