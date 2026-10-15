package Graficos;

import javax.swing.*;
import java.awt.*;

public class BotonRedondeado extends JButton
{
    private int radio;
    
    public BotonRedondeado(int radio)
    {
        this.radio = radio;
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (this.getModel().isPressed()) 
        {
            g2.setColor(this.getBackground().darker());
        } 
        else if (this.getModel().isRollover()) 
        {
            g2.setColor(this.getBackground().brighter());
        } 
        else 
        {
            g2.setColor(this.getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), this.radio, this.radio);
        g2.dispose();

        super.paintComponent(g);
    }
}
