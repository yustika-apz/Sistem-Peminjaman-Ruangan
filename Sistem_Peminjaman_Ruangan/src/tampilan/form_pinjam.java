/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import com.mysql.jdbc.PreparedStatement;
import java.awt.print.PrinterException;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sistem_peminjaman_ruangan.koneksi;

/**
 *
 * @author yusti
 */
public class form_pinjam extends javax.swing.JFrame {
    String pinjam_ruang, pinjam_gedung, tanggal_kegiatan, mulai_kegiatan, akhir_kegiatan, nama_kegiatan, nama_penanggungjawab, nim_penanggungjawab, prodi_penanggungjawab, nomor_penanggungjawab;

    /**
     * Creates new form form_pinjam
     */
    public form_pinjam() {
        initComponents();
    }
    
    public void loadData() {
        pinjam_ruang = tfruang.getText();
        pinjam_gedung = tfgedung.getText();
        tanggal_kegiatan = tftgl_kegiatan.getText();
        mulai_kegiatan = tfwaktu_mulai.getText();
        akhir_kegiatan = tfwaktu_akhir.getText();
        nama_kegiatan = tfnama_kegiatan.getText();
        nama_penanggungjawab = tfnama_mhs.getText();
        nim_penanggungjawab = tfnim_mhs.getText();
        prodi_penanggungjawab = tfprodi_mhs.getText();
        nomor_penanggungjawab = tfnohp_mhs.getText();
        
    }
    
   
    public void saveData() throws SQLException {
        loadData();
        
        //menyimpan data berdasarkan input dari user
        try{
       Statement stat = (Statement)koneksi.getkoneksi().createStatement();
       String sql = "INSERT INTO pinjam_ruang (nama_ruang,nama_gedung,tgl_kegiatan,jam_mulai,jam_selesai,nama_kegiatan,nama_mhs,nim_mhs,prodi,no_hp) VALUES ('"+pinjam_ruang+"','"+pinjam_gedung+"','"+tanggal_kegiatan+"','"+mulai_kegiatan+"','"+akhir_kegiatan+"','"+nama_kegiatan+"','"+nama_penanggungjawab+"','"+nim_penanggungjawab+"','"+prodi_penanggungjawab+"','"+nomor_penanggungjawab+"')";
       PreparedStatement p = (PreparedStatement)koneksi.getkoneksi().prepareStatement(sql);
       p.executeUpdate();
       JOptionPane.showMessageDialog(null, "Berhasil diSimpan!");
       
    }catch (SQLException err) {
        JOptionPane.showMessageDialog(null,err.getMessage());
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

        jPanel2 = new javax.swing.JPanel();
        tfruang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfnama_mhs = new javax.swing.JTextField();
        tfgedung = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tftgl_kegiatan = new javax.swing.JTextField();
        tfnim_mhs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfwaktu_mulai = new javax.swing.JTextField();
        tfprodi_mhs = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfnohp_mhs = new javax.swing.JTextField();
        tfwaktu_akhir = new javax.swing.JTextField();
        button_save = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfnama_kegiatan = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        label_judul = new javax.swing.JLabel();
        generate_form = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        reset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tfruang.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Mahasiswa yang Bertanggung Jawab");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Nama Gedung");

        tfnama_mhs.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        tfgedung.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("NIM");

        tftgl_kegiatan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        tfnim_mhs.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Tanggal Kegiatan");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Prodi");

        tfwaktu_mulai.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        tfprodi_mhs.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Waktu Kegiatan Dimulai");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Nomor Handphone");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Waktu Kegiatan Selesai");

        tfnohp_mhs.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        tfwaktu_akhir.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        button_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/19.jpg"))); // NOI18N
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Nama Kegiatan");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Ruangan yang diPinjam");

        tfnama_kegiatan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        label_judul.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label_judul.setForeground(new java.awt.Color(255, 255, 255));
        label_judul.setText("FORM PEMINJAMAN RUANGAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(label_judul)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_judul)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        generate_form.setBackground(new java.awt.Color(255, 255, 255));
        generate_form.setForeground(new java.awt.Color(51, 51, 51));
        generate_form.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/23.jpg"))); // NOI18N
        generate_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_formActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        reset.setBackground(new java.awt.Color(255, 255, 255));
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/23.jpg"))); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel1.setText("Generate Form");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel12.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_save, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfnohp_mhs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfprodi_mhs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnim_mhs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnama_kegiatan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfwaktu_akhir, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfwaktu_mulai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftgl_kegiatan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfgedung, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfruang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnama_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(generate_form, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel12)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfruang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfgedung, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tftgl_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfwaktu_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfwaktu_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfnama_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfnama_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnim_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfprodi_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfnohp_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(button_save)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(169, 169, 169))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(generate_form, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addGap(28, 28, 28)
                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addContainerGap()))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_saveActionPerformed
        try {
            // TODO add your handling code here:
            saveData();
        } catch (SQLException ex) {
            Logger.getLogger(form_pinjam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_saveActionPerformed

    private void generate_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_formActionPerformed
        // TODO add your handling code here:
        area.setText("==============================================================================\n");
        area.setText(area.getText()+"                                             Form Peminjaman Ruangan                           ");
        
        date obj = new date();
        String date = obj.toString();
        
        
        area.setText(area.getText()+"Ruangan yang Dipinjam  :      "+tfruang.getText()+"\n");
        area.setText(area.getText()+"Nama Gedung            :      "+tfgedung.getText()+"\n");
        area.setText(area.getText()+"Tanggal Kegiatan       :      "+tftgl_kegiatan.getText()+"\n");
        area.setText(area.getText()+"Waktu Kegiatan Dimulai :      "+tfwaktu_mulai.getText()+"\n");
        area.setText(area.getText()+"Waktu Kegiatan Selesai :      "+tfwaktu_akhir.getText()+"\n");
        area.setText(area.getText()+"Nama Kegiatan          :      "+tfnama_kegiatan.getText()+"\n");
        area.setText(area.getText()+"Nama Penanggungjawab   :      "+tfnama_mhs.getText()+"\n");
        area.setText(area.getText()+"NIM                    :      "+tfnim_mhs.getText()+"\n");
        area.setText(area.getText()+"Prodi                  :      "+tfprodi_mhs.getText()+"\n");
        area.setText(area.getText()+"Nomor Handphone        :      "+tfnohp_mhs.getText()+"\n");
        
                                                  
                  
    }//GEN-LAST:event_generate_formActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        area.setText("");
        tfruang.setText("");
        tfgedung.setText("");
        tftgl_kegiatan.setText("");
        tfwaktu_mulai.setText("");
        tfwaktu_akhir.setText("");
        tfnama_kegiatan.setText("");
        tfnama_mhs.setText("");
        tfnim_mhs.setText("");
        tfprodi_mhs.setText("");
        tfnohp_mhs.setText("");
    }//GEN-LAST:event_resetActionPerformed
   
    
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
            java.util.logging.Logger.getLogger(form_pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_pinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_pinjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton button_save;
    private javax.swing.JButton generate_form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_judul;
    private javax.swing.JButton reset;
    private javax.swing.JTextField tfgedung;
    private javax.swing.JTextField tfnama_kegiatan;
    private javax.swing.JTextField tfnama_mhs;
    private javax.swing.JTextField tfnim_mhs;
    private javax.swing.JTextField tfnohp_mhs;
    private javax.swing.JTextField tfprodi_mhs;
    private javax.swing.JTextField tfruang;
    private javax.swing.JTextField tftgl_kegiatan;
    private javax.swing.JTextField tfwaktu_akhir;
    private javax.swing.JTextField tfwaktu_mulai;
    // End of variables declaration//GEN-END:variables

   
}
