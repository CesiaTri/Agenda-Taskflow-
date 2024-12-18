
package raven_cell2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * Clase que extiende JButton y personaliza su apariencia visual para simular un botón circular.
 * El color de fondo cambia cuando el botón es presionado, proporcionando retroalimentación visual al usuario.
 */
public class ActionButton extends JButton {
    
    /**
     * Atributo que indica si el botón ha sido presionado 
     */
    private boolean mousePress;

    /**
     * Constructor por defecto que configura el botón y le agrega un mouse listener.
     * Este constructor configura el botón para que no tenga relleno y no tenga borde.
     * Además, se agrega un mouse listener para detectar los eventos de presionar y soltar el botón.
     */
    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress = false;
            }
        });
    }
    
    /**
     * Método que se sobrescribe para personalizar la pintura del botón.
     * Dibuja un círculo dentro del área del botón que cambia de color dependiendo
     * de si el botón está presionado o no.
     *
     * @param grphcs El objeto Graphics utilizado para realizar el dibujo del botón.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        if (mousePress) {
            g2.setColor(new Color(158, 158, 158));
        } else {
            g2.setColor(new Color(199, 199, 199));
        }
        g2.fill(new Ellipse2D.Double(x, y, size, size));
        g2.dispose();
        super.paintComponent(grphcs);
    }
}
