
package raven_cell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel personalizado que contiene botones de acción (Editar, Eliminar, Ver) para ser utilizados en una tabla. 
 * Cada uno de los botones tiene asignado un evento para realizar una acción específica sobre una fila de la tabla 
 * al ser presionado. Esta clase proporciona la lógica para manejar eventos asociados a los botones de acción.
 * 
 * La clase está diseñada para integrarse con una tabla donde cada fila puede tener botones para editar, eliminar 
 * o ver más detalles de la fila. Los botones permiten que el usuario realice diferentes acciones en función de la fila 
 * seleccionada.
 */
public class PanelAction extends javax.swing.JPanel {

    /**
     * Constructor de la clase PanelAction. Inicializa los componentes del panel.
     */
    public PanelAction() {
        initComponents();
    }
    
    /**
     * Inicializa los eventos para los botones (Editar, Eliminar, Ver) de la fila específica.
     * 
     * Este método establece los oyentes de eventos (action listeners) para los botones, de modo que cuando el 
     * usuario haga clic en uno de los botones, se ejecute el evento correspondiente para la fila seleccionada.
     *
     * @param event El objeto TableActionEvent que define los métodos de acción (editar, eliminar, ver) a ejecutar.
     * @param row El índice de la fila que será afectada por la acción.
     */
    public void initEvent(TableActionEvent event, int row) {
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onEdit(row);
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onDelete(row);
            }
        });
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onView(row);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new raven_cell.ActionButton();
        cmdDelete = new raven_cell.ActionButton();
        cmdView = new raven_cell.ActionButton();

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven_cell/edit.png"))); // NOI18N

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven_cell/delete.png"))); // NOI18N

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven_cell/view.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven_cell.ActionButton cmdDelete;
    private raven_cell.ActionButton cmdEdit;
    private raven_cell.ActionButton cmdView;
    // End of variables declaration//GEN-END:variables
}
