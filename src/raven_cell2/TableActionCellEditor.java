
package raven_cell2;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import raven_cell.TableActionEvent;

/**
 * Clase que proporciona un editor personalizado para las celdas de una tabla.
 * Este editor se utiliza para mostrar un panel con botones de acción (como editar y ver) dentro de una celda de la tabla.
 */
public class TableActionCellEditor extends DefaultCellEditor {

    /**
     * Evento que maneja las acciones realizadas sobre una fila de la tabla.
     * Se utiliza para definir el comportamiento cuando se hace clic en los botones de acción (editar, ver, etc.).
     */
    private raven_cell2.TableActionEvent event;

    /**
     * Constructor que inicializa el editor de celda con un evento de acción.
     * 
     * @param event El evento de acción que será manejado cuando se realicen interacciones sobre las celdas de acción.
     */
    public TableActionCellEditor(raven_cell2.TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    /**
     * Sobrescribe el método DefaultCellEditor#getTableCellEditorComponent para proporcionar un componente
     * personalizado un PanelAction en lugar de un simple componente de celda.
     * 
     * @param jtable La tabla en la que se está editando la celda.
     * @param o El valor de la celda (no utilizado en este caso).
     * @param bln Indica si la celda está seleccionada (no utilizado en este caso).
     * @param row El índice de la fila de la tabla donde se encuentra la celda.
     * @param column El índice de la columna de la tabla donde se encuentra la celda.
     * 
     * @return El componente que se mostrará en la celda un PanelAction que contiene los botones de acción.
     */
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        raven_cell2.PanelAction action = new raven_cell2.PanelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}