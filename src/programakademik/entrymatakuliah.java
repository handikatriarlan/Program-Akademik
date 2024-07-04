package programakademik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class entrymatakuliah extends javax.swing.JFrame {

    private Connection con;
    private Statement stat;
    private ResultSet res;

    public entrymatakuliah() {
        initComponents();
        koneksi();
    }

    private void koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dbakademik", "root", "");
            stat = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void bersih() {
        vkdmtk.setText("");
        vnamamtk.setText("");
        vsks.setText("");
        //Arahkan fokus pointer mouse pada textfield yang kita inginkan
        vkdmtk.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        vsks = new javax.swing.JTextField();
        vkdmtk = new javax.swing.JTextField();
        vnamamtk = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("ENTRY DATA MATA KULIAH");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 30, 190, 16);

        jLabel2.setText("KODE MATA KULIAH");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 90, 130, 16);

        jLabel3.setText("NAMA MATA KULIAH");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 120, 130, 16);

        jLabel4.setText("SKS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 150, 30, 16);

        vsks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsksActionPerformed(evt);
            }
        });
        getContentPane().add(vsks);
        vsks.setBounds(180, 150, 190, 22);

        vkdmtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vkdmtkActionPerformed(evt);
            }
        });
        getContentPane().add(vkdmtk);
        vkdmtk.setBounds(180, 90, 190, 22);
        getContentPane().add(vnamamtk);
        vnamamtk.setBounds(180, 120, 190, 22);

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 230, 80, 23);

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(110, 230, 80, 23);

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(160, 200, 80, 23);

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(250, 200, 80, 23);

        jButton5.setText("Simpan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(70, 200, 80, 23);

        setSize(new java.awt.Dimension(426, 307));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vsksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vsksActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bersih();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String query = "UPDATE matakuliah SET "
                    + "namamtk='" + vnamamtk.getText() + "', "
                    + "sks='" + vsks.getText() + "' "
                    + "WHERE kdmtk='" + vkdmtk.getText() + "'";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil diperbarui.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String query = "DELETE FROM matakuliah WHERE kdmtk='" + vkdmtk.getText() + "'";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String query = "INSERT INTO matakuliah VALUES ("
                    + "'" + vkdmtk.getText() + "', "
                    + "'" + vnamamtk.getText() + "', "
                    + "'" + vsks.getText() + "')";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void vkdmtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vkdmtkActionPerformed
        String query = "SELECT * FROM matakuliah WHERE kdmtk='" + vkdmtk.getText() + "'";
        try (ResultSet res = stat.executeQuery(query)) {
            while (res.next()) {
                vnamamtk.setText(res.getString("namamtk"));
                vsks.setText(res.getString("sks"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_vkdmtkActionPerformed

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
            java.util.logging.Logger.getLogger(entrymatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entrymatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entrymatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entrymatakuliah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entrymatakuliah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField vkdmtk;
    private javax.swing.JTextField vnamamtk;
    private javax.swing.JTextField vsks;
    // End of variables declaration//GEN-END:variables
}
