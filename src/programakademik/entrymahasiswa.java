package programakademik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class entrymahasiswa extends javax.swing.JFrame {

    private Connection con;
    private Statement stat;
    private ResultSet res;
    private String tgl1;

    public entrymahasiswa() {
        initComponents();
        koneksi();
        bersih();
        isicomboKELAS();
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
        vnobp.setText("");
        vnama.setText("");
        vkelas.setSelectedIndex(-1);
        vtglultah.setDate(null);
        vnomorhp.setText("");
        vnobp.requestFocus();
    }

    private void isicomboKELAS() {
        vkelas.addItem("SI-1");
        vkelas.addItem("SI-2");
        vkelas.addItem("SI-3");
        vkelas.addItem("SI-4");
        vkelas.addItem("SI-5");
        vkelas.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vnobp = new javax.swing.JTextField();
        vnama = new javax.swing.JTextField();
        vnomorhp = new javax.swing.JTextField();
        vkelas = new javax.swing.JComboBox<>();
        vtglultah = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("ENTRY DATA MAHASISWA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 195, 20);

        jLabel2.setText("NOBP");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 60, 60, 16);

        jLabel3.setText("NAMA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 90, 80, 16);

        jLabel4.setText("KELAS");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 120, 90, 16);

        jLabel5.setText("TANGGAL ULTAH");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 150, 140, 16);

        jLabel6.setText("NOMOR HP");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 180, 110, 16);

        vnobp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnobpActionPerformed(evt);
            }
        });
        getContentPane().add(vnobp);
        vnobp.setBounds(190, 60, 190, 22);

        vnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnamaActionPerformed(evt);
            }
        });
        getContentPane().add(vnama);
        vnama.setBounds(190, 90, 190, 22);

        vnomorhp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vnomorhpActionPerformed(evt);
            }
        });
        getContentPane().add(vnomorhp);
        vnomorhp.setBounds(190, 180, 190, 22);

        getContentPane().add(vkelas);
        vkelas.setBounds(190, 120, 190, 22);

        vtglultah.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                vtglultahPropertyChange(evt);
            }
        });
        getContentPane().add(vtglultah);
        vtglultah.setBounds(190, 150, 190, 22);

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 260, 80, 23);

        jButton2.setText("Batal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 260, 80, 23);

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(180, 230, 80, 23);

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(270, 230, 80, 23);

        jButton5.setText("Simpan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(90, 230, 80, 23);

        setBounds(0, 0, 458, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void vnobpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnobpActionPerformed
        String query = "SELECT * FROM mahasiswa WHERE nobp='" + vnobp.getText() + "'";
        try (ResultSet res = stat.executeQuery(query)) {
            while (res.next()) {
                vnama.setText(res.getString("nama"));
                vkelas.setSelectedItem(res.getString("kelas"));
                vtglultah.setDate(res.getDate("tglultah"));
                vnomorhp.setText(res.getString("nomorhp"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_vnobpActionPerformed

    private void vnomorhpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnomorhpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vnomorhpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        bersih();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String query = "UPDATE mahasiswa SET "
                    + "nama='" + vnama.getText() + "', "
                    + "kelas='" + vkelas.getSelectedItem() + "', "
                    + "tglultah='" + tgl1 + "', "
                    + "nomorhp='" + vnomorhp.getText() + "' "
                    + "WHERE nobp='" + vnobp.getText() + "'";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil diperbarui.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String query = "DELETE FROM mahasiswa WHERE nobp='" + vnobp.getText() + "'";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dihapus.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String query = "INSERT INTO mahasiswa VALUES ("
                    + "'" + vnobp.getText() + "', "
                    + "'" + vnama.getText() + "', "
                    + "'" + vkelas.getSelectedItem() + "', "
                    + "'" + tgl1 + "', "
                    + "'" + vnomorhp.getText() + "')";
            stat.executeUpdate(query);
            bersih();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil disimpan.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Keterangan error: " + e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void vtglultahPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_vtglultahPropertyChange
        if (vtglultah.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl1 = format.format(vtglultah.getDate());
        }
    }//GEN-LAST:event_vtglultahPropertyChange

    private void vnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vnamaActionPerformed

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
            java.util.logging.Logger.getLogger(entrymahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entrymahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entrymahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entrymahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entrymahasiswa().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> vkelas;
    private javax.swing.JTextField vnama;
    private javax.swing.JTextField vnobp;
    private javax.swing.JTextField vnomorhp;
    private com.toedter.calendar.JDateChooser vtglultah;
    // End of variables declaration//GEN-END:variables
}
