package Graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class UIModernaMenu extends BasicComboBoxUI {
    
    @Override
    protected JButton createArrowButton() {
        JButton boton = new JButton();
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setOpaque(false);
        boton.setPreferredSize(new Dimension(28, 28)); 
        return boton;
        }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boolean activo = c.isEnabled();
        g2.setColor(activo ? new Color(255, 255, 255) : new Color(235, 235, 235));
        g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        g2.setColor(activo ? new Color(200, 200, 200) : new Color(215, 215, 215));
        g2.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
        g2.setStroke(new BasicStroke(1.8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(activo ? new Color(60, 60, 60) : new Color(170, 170, 170));
        int cx = c.getWidth() - 16;
        int cy = c.getHeight() / 2;
        g2.drawLine(cx - 4, cy - 2, cx, cy + 2);
        g2.drawLine(cx, cy + 2, cx + 4, cy - 2);
        g2.dispose();
        super.paint(g, c);
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        // no pintar el fondo por defecto
    }
    
    @Override
    public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus)
    {
        comboBox.setForeground(comboBox.isEnabled() ? new Color(40, 40, 40) : new Color(150, 150, 150));
        super.paintCurrentValue(g, bounds, hasFocus);
    }
}
