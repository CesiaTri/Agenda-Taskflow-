
package raven_cell2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase que extiende DefaultTableCellRenderer y proporciona un renderizador personalizado
 * para las celdas de acción de la tabla. Este renderizador se utiliza para mostrar un panel
 * con botones de acción (como editar, ver, etc.) dentro de una celda de la tabla.
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    /**
     * Constructor predeterminado de la clase TableActionCellRender.
     * Este constructor no realiza ninguna acción adicional, pero es necesario para crear una instancia de la clase.
     */
    public TableActionCellRender() {
        // Constructor por defecto
    }
    
    /**
     * Sobrescribe el método getTableCellRendererComponent para proporcionar un componente
     * personalizado (un PanelAction) en lugar de un simple componente de celda.
     * 
     * @param jtable La tabla en la que se está renderizando la celda.
     * @param o El valor de la celda (no utilizado en este caso).
     * @param isSeleted Indica si la celda está seleccionada.
     * @param bln1.
     * @param row El índice de la fila de la tabla donde se encuentra la celda.
     * @param column El índice de la columna de la tabla donde se encuentra la celda.
     * 
     * @return El componente que se mostrará en la celda (un PanelAction que contiene los botones de acción).
     */
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        raven_cell2.PanelAction action = new raven_cell2.PanelAction();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());
        }
        return action;
    }
}
