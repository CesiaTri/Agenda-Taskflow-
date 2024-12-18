
package raven_cell;

/**
 * Interfaz para manejar eventos de acción en una tabla, como editar, eliminar y ver.
 * Esta interfaz define tres métodos que deben ser implementados por cualquier clase que maneje los eventos de acción
 * en una tabla. Los eventos incluyen la acción de editar, eliminar o ver una fila específica de la tabla, indicada por el
 * índice de la fila.
 */
public interface TableActionEvent {
    
    /**
     * Método para manejar el evento de edición de una fila en la tabla.
     * @param row El índice de la fila que se está editando.
     */
    public void onEdit(int row);
    
    /**
     * Método para manejar el evento de eliminación de una fila en la tabla.
     * @param row El índice de la fila que se está eliminando.
     */
    public void onDelete(int row);
    
    /**
     * Método para manejar el evento de visualización de una fila en la tabla.
     * @param row El índice de la fila que se está visualizando.
     */
    public void onView(int row);
}
