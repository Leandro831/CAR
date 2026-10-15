package Graficos;

import java.awt.*;

public class Aplicacion extends javax.swing.JFrame 
{    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Aplicacion.class.getName());
    
    public Aplicacion() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenFondoInicioSesion = new ImagenFondoIniciarSesion();
        cuadroBlancoInicioSesion = new PanelRedondeado(30);
        logoAppCarInicioSesion = new LogoCar();
        textoIngresarUsuario = new javax.swing.JLabel();
        campoIngresarUsuario = new javax.swing.JTextField();
        textoIngresarContraseña = new javax.swing.JLabel();
        campoIngresarContraseña = new javax.swing.JPasswordField();
        botonIniciarSesion = new BotonRedondeado(50);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        imagenFondoInicioSesion.setBackground(new java.awt.Color(102, 102, 102));
        imagenFondoInicioSesion.setForeground(new java.awt.Color(234, 234, 234));
        imagenFondoInicioSesion.setPreferredSize(new java.awt.Dimension(1280, 720));

        cuadroBlancoInicioSesion.setBackground(new java.awt.Color(234, 234, 234, 204));
        cuadroBlancoInicioSesion.setForeground(new java.awt.Color(0, 0, 153));
        cuadroBlancoInicioSesion.setOpaque(false);
        cuadroBlancoInicioSesion.setPreferredSize(new java.awt.Dimension(1000, 600));

        logoAppCarInicioSesion.setBackground(new java.awt.Color(255, 255, 255, 0));
        logoAppCarInicioSesion.setPreferredSize(new java.awt.Dimension(768, 325));

        javax.swing.GroupLayout logoAppCarInicioSesionLayout = new javax.swing.GroupLayout(logoAppCarInicioSesion);
        logoAppCarInicioSesion.setLayout(logoAppCarInicioSesionLayout);
        logoAppCarInicioSesionLayout.setHorizontalGroup(
            logoAppCarInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        logoAppCarInicioSesionLayout.setVerticalGroup(
            logoAppCarInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        textoIngresarUsuario.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        textoIngresarUsuario.setText("Ingrese su usuario");
        textoIngresarUsuario.setName(""); // NOI18N
        textoIngresarUsuario.setPreferredSize(new java.awt.Dimension(94, 16));

        campoIngresarUsuario.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        campoIngresarUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoIngresarUsuario.setText("Ej. UsernameExample67");
        campoIngresarUsuario.setBorder(null);
        campoIngresarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoIngresarUsuario.setSelectionColor(new java.awt.Color(0, 102, 255));
        campoIngresarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campoIngresarUsuarioMousePressed(evt);
            }
        });
        campoIngresarUsuario.addActionListener(this::campoIngresarUsuarioActionPerformed);

        textoIngresarContraseña.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        textoIngresarContraseña.setText("Ingrese su contraseña");

        campoIngresarContraseña.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
        campoIngresarContraseña.setText("Password");
        campoIngresarContraseña.setBorder(null);
        campoIngresarContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campoIngresarContraseñaMousePressed(evt);
            }
        });
        campoIngresarContraseña.addActionListener(this::campoIngresarContraseñaActionPerformed);

        botonIniciarSesion.setBackground(new java.awt.Color(200, 0, 0));
        botonIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        botonIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonIniciarSesion.setText("Iniciar Sesión");
        botonIniciarSesion.setBorder(null);
        botonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIniciarSesionMouseClicked(evt);
            }
        });
        botonIniciarSesion.addActionListener(this::botonIniciarSesionActionPerformed);

        javax.swing.GroupLayout cuadroBlancoInicioSesionLayout = new javax.swing.GroupLayout(cuadroBlancoInicioSesion);
        cuadroBlancoInicioSesion.setLayout(cuadroBlancoInicioSesionLayout);
        cuadroBlancoInicioSesionLayout.setHorizontalGroup(
            cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGroup(cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(logoAppCarInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGap(0, 415, Short.MAX_VALUE)
                .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(415, 415, 415))
        );
        cuadroBlancoInicioSesionLayout.setVerticalGroup(
            cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoAppCarInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoIngresarContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout imagenFondoInicioSesionLayout = new javax.swing.GroupLayout(imagenFondoInicioSesion);
        imagenFondoInicioSesion.setLayout(imagenFondoInicioSesionLayout);
        imagenFondoInicioSesionLayout.setHorizontalGroup(
            imagenFondoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenFondoInicioSesionLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(cuadroBlancoInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        imagenFondoInicioSesionLayout.setVerticalGroup(
            imagenFondoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenFondoInicioSesionLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cuadroBlancoInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenFondoInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenFondoInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void campoIngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIngresarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIngresarUsuarioActionPerformed

    private void campoIngresarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIngresarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIngresarContraseñaActionPerformed

    private void campoIngresarUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIngresarUsuarioMousePressed
        if(campoIngresarUsuario.getText().equals("Ej. UsernameExample67"))
        {
            campoIngresarUsuario.setText("");
            campoIngresarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        }
        if(String.valueOf(campoIngresarContraseña.getPassword()).isEmpty())
        {
            campoIngresarContraseña.setText("Password");
            campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoIngresarUsuarioMousePressed

    private void campoIngresarContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoIngresarContraseñaMousePressed
        if(campoIngresarUsuario.getText().isEmpty())
        {
            campoIngresarUsuario.setText("Ej. UsernameExample67");
            campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        }
        if(String.valueOf(campoIngresarContraseña.getPassword()).equals("Password"))
        {
            campoIngresarContraseña.setText("");
            campoIngresarContraseña.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_campoIngresarContraseñaMousePressed

    private void botonIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciarSesionMouseClicked
        cuadroBlancoInicioSesion.setVisible(false);
        
        imagenFondoInicioSesion.revalidate();
        imagenFondoInicioSesion.repaint();
    }//GEN-LAST:event_botonIniciarSesionMouseClicked

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new Aplicacion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JPasswordField campoIngresarContraseña;
    private javax.swing.JTextField campoIngresarUsuario;
    private javax.swing.JPanel cuadroBlancoInicioSesion;
    private javax.swing.JPanel imagenFondoInicioSesion;
    private javax.swing.JPanel logoAppCarInicioSesion;
    private javax.swing.JLabel textoIngresarContraseña;
    private javax.swing.JLabel textoIngresarUsuario;
    // End of variables declaration//GEN-END:variables
}
