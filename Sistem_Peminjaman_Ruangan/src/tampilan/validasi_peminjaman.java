/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sistem_peminjaman_ruangan.koneksi;

/**
 *
 * @author yusti
 */
public class validasi_peminjaman extends javax.swing.JFrame {
    //membuat variabel model dengan DefaultTableModel
    private DefaultTableModel model;
    String pinjam_ruang, pinjam_gedung, tanggal_kegiatan, mulai_kegiatan, akhir_kegiatan, nama_kegiatan, nama_penanggungjawab, nim_penanggungjawab, prodi_penanggungjawab, nomor_penanggungjawab;

    /**
     * Creates new form validasi_peminjaman
     */
    public validasi_peminjaman() {
        initComponents ( );
        
        //memberi penamaan pada judul kolom tabel_form_pinjam
        model = new DefaultTableModel();
        tabel_form_pinjam.setModel(model);
        model.addColumn("Ruangan yang Dipinjam");
        model.addColumn("Nama Gedung");
        model.addColumn("Tanggal Kegiatan");
        model.addColumn("Waktu Kegiatan Dimulai");
        model.addColumn("Waktu Kegiatan Selesai");
        model.addColumn("Nama Kegiatan");
        model.addColumn("Mahasiswa yang Bertanggungjawab ");
        model.addColumn("NIM");
        model.addColumn("Prodi");
        model.addColumn("Nomor Handphone");
        
        getData();
    }
    
    public void getData() {
        //menghapus isi tabel_form_pinjam
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            //membuat statement pemanggilan data pada tabel_form_pinjam
            Statement stat = (Statement)koneksi.getkoneksi().createStatement();
            String sql = "SELECT nama_ruang, nama_gedung, tgl_kegiatan, jam_mulai, jam_selesai, nama_kegiatan, nama_mhs, nim_mhs, prodi,no_hp FROM pinjam_ruang";
            ResultSet res = stat.executeQuery(sql);
            
            //penelurusan baris pada tabel_form_pinjam
            while(res.next()) {
                Object[] obj = new Object[10];
                obj[0] = res.getString("nama_ruang");
                obj[1] = res.getString("nama_gedung");
                obj[2] = res.getString("tgl_kegiatan");
                obj[3] = res.getString("jam_mulai");
                obj[4] = res.getString("jam_selesai");
                obj[5] = res.getString("nama_kegiatan");
                obj[6] = res.getString("nama_mhs");
                obj[7] = res.getString("nim_mhs");
                obj[8] = res.getString("prodi");
                obj[9] = res.getString("no_hp");
                
                model.addRow(obj);
                
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
    }
    }
    
  
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_form_pinjam = new javax.swing.JTable();
        button_setuju = new javax.swing.JButton();
        button_tdk_setuju = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        button_print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabel_form_pinjam.setBackground(new java.awt.Color(0, 0, 0));
        tabel_form_pinjam.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        tabel_form_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        tabel_form_pinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        jScrollPane1.setViewportView(tabel_form_pinjam);

        button_setuju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/23.jpg"))); // NOI18N
        button_setuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_setujuActionPerformed(evt);
            }
        });

        button_tdk_setuju.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/23.jpg"))); // NOI18N
        button_tdk_setuju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tdk_setujuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Setuju");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Tidak Setuju");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel3.setText("VALIDASI PEMINJAMAN RUANG");

        button_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/23.jpg"))); // NOI18N
        button_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_printActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Print");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_print, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_setuju, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_tdk_setuju, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_setuju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_tdk_setuju)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(button_print, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_setujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_setujuActionPerformed
        // TODO add your handling code here:
        getData();
        JOptionPane.showMessageDialog(null, "Peminjaman di Validasi");
    }//GEN-LAST:event_button_setujuActionPerformed

    private void button_tdk_setujuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tdk_setujuActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Peminjaman Tidak Divalidasi");
    }//GEN-LAST:event_button_tdk_setujuActionPerformed

    private void button_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_printActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Data Form Peminjaman Ruangan");
        MessageFormat footer = new MessageFormat("");
        try {
            tabel_form_pinjam.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            getData();
        } catch (PrinterException ex) {
            Logger.getLogger(validasi_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_printActionPerformed

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
            java.util.logging.Logger.getLogger(validasi_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(validasi_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(validasi_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(validasi_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new validasi_peminjaman().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_print;
    private javax.swing.JButton button_setuju;
    private javax.swing.JButton button_tdk_setuju;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_form_pinjam;
    // End of variables declaration//GEN-END:variables

}

