package Graficos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PanelOscuro extends JPanel {
    private JComponent resaltado;
    
    public PanelOscuro() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
    }
    
    public void mostrarComponente(JComponent componente) {
        this.resaltado = componente;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(new Color(0, 0, 0, 153));
        g2.fillRect(0, 0, getWidth(), getHeight());
        if (resaltado != null && resaltado.isShowing()) {
            Point p = SwingUtilities.convertPoint(resaltado, 0, 0, this);
            g2.translate(p.x, p.y);
            resaltado.paint(g2);
        }
        g2.dispose();
    }
    
    public void mostrarCentrado(JComponent contenido)
    {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        this.add(contenido);
        contenido.setVisible(true);
        this.revalidate();
        this.repaint();
    }
    
    public void mostrarEn(JComponent contenido, int x, int y)
    {
        this.removeAll();
        this.setLayout(null);  
        Dimension dimension = contenido.getPreferredSize();
        contenido.setBounds(x, y, dimension.width, dimension.height);
        this.add(contenido);
        this.revalidate();
        this.repaint();
    }
}
