/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finalproyect.dataestructure;

/**
 *
 * @author Arman
 */
public class LoginInterface extends javax.swing.JFrame {

    /**
     * Creates new form LoginInterface
     */
    public LoginInterface() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        AboutBtn1 = new javax.swing.JButton();
        startBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 450));

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 450));
        jPanel2.setLayout(null);

        exitBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        exitBtn.setText("Salir");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel2.add(exitBtn);
        exitBtn.setBounds(380, 390, 72, 33);

        startBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        startBtn.setText("Iniciar Partida");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });
        jPanel2.add(startBtn);
        startBtn.setBounds(330, 290, 157, 33);

        AboutBtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AboutBtn1.setText("Sobre la App");
        AboutBtn1.setBorderPainted(false);
        AboutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(AboutBtn1);
        AboutBtn1.setBounds(690, 420, 100, 23);

        startBtn1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        startBtn1.setText("Ver Puntaje");
        startBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(startBtn1);
        startBtn1.setBounds(330, 340, 157, 33);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LoginInterface-Background.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
         dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        // TODO add your handling code here:
        GameInterface GI1 = new GameInterface();
        GI1.setVisible(true);
        dispose();
    }//GEN-LAST:event_startBtnActionPerformed

    private void AboutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutBtn1ActionPerformed
        // TODO add your handling code here:
        MainCode MainC = new MainCode();
        MainC.AboutApp();
    }//GEN-LAST:event_AboutBtn1ActionPerformed

    private void startBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutBtn1;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton startBtn1;
    // End of variables declaration//GEN-END:variables
}
