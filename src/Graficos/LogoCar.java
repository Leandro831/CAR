package Graficos;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class LogoCar extends JPanel
{
    private Image logoCar;
    
    public LogoCar()
    {
        logoCar = new ImageIcon(getClass().getResource("/Imagenes/Car_logo.png")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(logoCar, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
