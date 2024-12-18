/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven_cell;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 * Clase personalizada que extiende DefaultCellEditor para permitir la edición de celdas en una tabla 
 * con botones de acción específicos (Editar, Eliminar, Ver). Esta clase proporciona un editor de celdas 
 * que contiene un panel con botones de acción y permite la interacción del usuario con las filas de la tabla.
 * 
 * El editor de celdas se usa cuando el usuario interactúa con una celda de la tabla para realizar una acción 
 * sobre la fila correspondiente. Los botones que se muestran en el editor permiten realizar diferentes operaciones 
 * como editar, eliminar o ver los detalles de la fila seleccionada.
 */
public class TableActionCellEditor extends DefaultCellEditor {

    /**
     * Evento que define las acciones a realizar al presionar los botones de acción
     */
    private TableActionEvent event;

    /**
     * Constructor de la clase TableActionCellEditor.
     * 
     * Este constructor recibe un objeto de tipo TableActionEvent que define los métodos de acción 
     * (editar, eliminar, ver) a ejecutar cuando el usuario presione los botones correspondientes.
     * 
     * @param event El objeto TableActionEvent que define las acciones para editar, eliminar o ver.
     */
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    /**
     * Devuelve el componente que se usará para editar la celda de la tabla.
     * 
     * Este método reemplaza el componente de edición predeterminado JCheckBox por un panel 
     * personalizado PanelAction que contiene los botones de acción (Editar, Eliminar, Ver).
     *
     * @param jtable La tabla en la que se encuentra la celda a editar.
     * @param o El valor actual de la celda que se está editando.
     * @param bln Indica si la celda está seleccionada o no.
     * @param row El índice de la fila de la celda que se está editando.
     * @param column El índice de la columna de la celda que se está editando.
     * @return Un componente PanelAction con los botones de acción.
     */
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}