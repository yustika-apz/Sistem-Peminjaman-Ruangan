/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistem_peminjaman_ruangan.koneksi;

/**
 *
 * @author yusti
 */
public class jadwal_peminjaman extends javax.swing.JFrame {
    //membuat variabel model untuk tabel
    private DefaultTableModel model;
    //mmebuat variabel untuk menampung nilai
    String pinjam_ruang, pinjam_gedung, tgl_pinjam, mulai_pinjam, akhir_pinjam,nama_kegiatan, nama_mhs, nim_mhs, prodi_mhs, nohp_mhs;
    
    public void loadData() {
        //memberi nilai pada variabel
        pinjam_ruang = tfnama_ruangan.getText();
        pinjam_gedung = tfgedung.getText();
        tgl_pinjam = tftgl_kegiatan.getText();
        mulai_pinjam = tfwaktu_mulai.getText();
        akhir_pinjam = tfwaktu_akhir.getText();
        nama_kegiatan = tfnama_kegiatan.getText();
        nama_mhs = tfnama_mhs.getText();
        nim_mhs = tfnim_mhs.getText();
        prodi_mhs = tfprodi.getText();
        nohp_mhs = tfnomor_hp.getText();
    }
    
    public void saveData() throws SQLException {
        loadData();
        
        //menyimpan data berdasarkan input dari user
        try{
       Statement stat = (Statement)koneksi.getkoneksi().createStatement();
       String sql = "INSERT INTO pinjam_ruang(nama_ruang, nama_gedung, tgl_kegiatan, jam_mulai, jam_selesai, nama_kegiatan, nama_mhs, nim_mhs, prodi, no_hp) VALUES ('"+pinjam_ruang+"','"+pinjam_gedung+"','"+tgl_pinjam+"','"+mulai_pinjam+"','"+akhir_pinjam+"','"+nama_kegiatan+"','"+nama_mhs+"','"+nim_mhs+"','"+prodi_mhs+"','"+nohp_mhs+"')";
       PreparedStatement p = (PreparedStatement)koneksi.getkoneksi().prepareStatement(sql);
       p.executeUpdate();
       getData();
       JOptionPane.showMessageDialog(null, "Berhasil DiSimpan");
    }catch (SQLException err) {
        JOptionPane.showMessageDialog(null,err.getMessage());
    }
    }
    
    public void Reset() {
        //untuk mengosongkan nilai pada variable-variable yang ada
        pinjam_ruang="";
        pinjam_gedung="";
        tgl_pinjam="";
        mulai_pinjam="";
        akhir_pinjam="";
        nama_kegiatan="";
        nama_mhs="";
        nim_mhs="";
        prodi_mhs="";
        nohp_mhs="";
        
        tfnama_ruangan.setText(pinjam_ruang);
        tfgedung.setText(pinjam_gedung);
        tftgl_kegiatan.setText(tgl_pinjam);
        tfwaktu_mulai.setText(mulai_pinjam);
        tfwaktu_akhir.setText(akhir_pinjam);
        tfnama_kegiatan.setText(nama_kegiatan);
        tfnama_mhs.setText(nama_mhs);
        tfnim_mhs.setText(nim_mhs);
        tfprodi.setText(prodi_mhs);
        tfnomor_hp.setText(nohp_mhs);
        
    }
   
    public void dataSelect() {
        //untuk melakukan penentuan data
     
        int i = tabel_pinjam.getSelectedRow();
        if (i == -1) {
            //tidak ada terpilih
            return;
        } 
        tfnama_ruangan.setText(""+model.getValueAt(i, 0));
        tfgedung.setText(""+model.getValueAt(i, 1));
        tftgl_kegiatan.setText(""+model.getValueAt(i, 2));
        tfwaktu_mulai.setText(""+model.getValueAt(i, 3));
        tfwaktu_akhir.setText(""+model.getValueAt(i, 4));
        tfnama_kegiatan.setText(""+model.getValueAt(i, 5));
        tfnama_mhs.setText(""+model.getValueAt(i, 6));
        tfnim_mhs.setText(""+model.getValueAt(i, 7));
        tfprodi.setText(""+model.getValueAt(i, 8));
        tfnomor_hp.setText(""+model.getValueAt(i, 9));
        
   
    }
    
    

    /**
     * Creates new form jadwal_peminjaman
     */
    public jadwal_peminjaman() {
        initComponents();
        
        //Memberi penamaan pada judul kolom tblGaji
        model = new DefaultTableModel();
        tabel_pinjam.setModel(model);
        model.addColumn("Nama Ruangan");
        model.addColumn("Nama Gedung");
        model.addColumn("Tgl Peminjaman");
        model.addColumn("Waktu Mulai");
        model.addColumn("Waktu Selesai");
        model.addColumn("Nama Kegiatan");
        model.addColumn("Mahasiswa yang Bertanggungjawab");
        model.addColumn("NIM");
        model.addColumn("Prodi");
        model.addColumn("Nomor Handphone");
        
        getData();
        
    }
    public void getData() {
        //menghapus isi table tabel_pinjam
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            //membuat statement pemanggilan data pada tabel tabel_pinjam dari database
            Statement stat = (Statement)koneksi.getkoneksi().createStatement();
            String sql = "SELECT nama_ruang, nama_gedung, tgl_kegiatan, jam_mulai, jam_selesai, nama_kegiatan, nama_mhs, nim_mhs, prodi, no_hp FROM pinjam_ruang";
            ResultSet res = stat.executeQuery(sql);
            
            //penelurusan baris pada tabel tabbel_pinjam dari database
            while(res.next()) {
                Object[] obj = new Object[10];
                obj[0]=res.getString("nama_ruang");
                obj[1]=res.getString("nama_gedung");
                obj[2]=res.getString("tgl_kegiatan");
                obj[3]=res.getString("jam_mulai");
                obj[4]=res.getString("jam_selesai");
                obj[5]=res.getString("nama_kegiatan");
                obj[6]=res.getString("nama_mhs");
                obj[7]=res.getString("nim_mhs");
                obj[8]=res.getString("prodi");
                obj[9]=res.getString("no_hp");
                
                model.addRow(obj);
                
                
            }
        }catch(SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void updateData() {
        //memanggil class loadData() untuk menentukan kondisi atau variable ruangan yang akan diubah, berdasarkan yang di pilih
        loadData();
        
        try{
            Statement stat = (Statement)koneksi.getkoneksi().createStatement();
            String sql = "UPDATE pinjam_ruang SET nama_ruang ='"+pinjam_ruang+"' WHERE nama_gedung='"+pinjam_gedung+"' OR tgl_kegiatan='"+tgl_pinjam+"' OR jam_mulai='"+mulai_pinjam+"' OR jam_selesai='"+akhir_pinjam+"' OR nama_kegiatan='"+nama_kegiatan+"' OR nama_mhs='"+nama_mhs+"' OR nim_mhs='"+nim_mhs+"' OR prodi='"+prodi_mhs+"' OR no_hp='"+nohp_mhs+"'";
            PreparedStatement p = (PreparedStatement)koneksi.getkoneksi().prepareStatement(sql);
            p.executeUpdate();
            getData();   
            Reset();
            JOptionPane.showMessageDialog(null, "Update berhasil");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,err.getMessage());
        }
    }
    
    public void  deleteData() {
        loadData();
        //pesan konfirmasi untuk menghapus data
        
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin menghapus data?" +pinjam_ruang ,"Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
        //jika user mengklik tomol OK maka proses delete dilakukan
        if(pesan == JOptionPane.OK_OPTION) {
            try {
            Statement stat = (Statement)koneksi.getkoneksi().createStatement();
            String sql = "DELETE from pinjam_ruang WHERE nama_ruang = '"+pinjam_ruang+"' ";
            PreparedStatement p = (PreparedStatement)koneksi.getkoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            getData();   
            Reset();
            JOptionPane.showMessageDialog(null, "Delete berhasil");
            }catch(SQLException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
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

        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pinjam = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        button_keluar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tftgl_kegiatan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfwaktu_mulai = new javax.swing.JTextField();
        tfwaktu_akhir = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfnama_kegiatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfgedung = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfnama_ruangan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfnim_mhs = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfnama_mhs = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        tfprodi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfnomor_hp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        button_update = new javax.swing.JButton();
        button_reset = new javax.swing.JButton();
        button_tambah = new javax.swing.JButton();
        button_hapus = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jLabel15.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel15.setText("Reset");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel_pinjam.setBackground(new java.awt.Color(0, 0, 0));
        tabel_pinjam.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        tabel_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        tabel_pinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Ruangan", "Gedung", "Tgl_Kegiatan", "Waktu Mulai", "Waktu Akhir"
            }
        ));
        tabel_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pinjam);
        if (tabel_pinjam.getColumnModel().getColumnCount() > 0) {
            tabel_pinjam.getColumnModel().getColumn(0).setMinWidth(150);
            tabel_pinjam.getColumnModel().getColumn(0).setMaxWidth(150);
            tabel_pinjam.getColumnModel().getColumn(1).setMinWidth(80);
            tabel_pinjam.getColumnModel().getColumn(1).setMaxWidth(80);
            tabel_pinjam.getColumnModel().getColumn(2).setMinWidth(120);
            tabel_pinjam.getColumnModel().getColumn(2).setMaxWidth(120);
            tabel_pinjam.getColumnModel().getColumn(3).setMinWidth(120);
            tabel_pinjam.getColumnModel().getColumn(3).setMaxWidth(120);
            tabel_pinjam.getColumnModel().getColumn(4).setMinWidth(120);
            tabel_pinjam.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel6.setText("JADWAL PEMINJAMAN RUANGAN");

        button_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/18.jpg"))); // NOI18N
        button_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_keluarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tftgl_kegiatan.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel4.setText("Waktu Mulai");

        tfwaktu_mulai.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        tfwaktu_akhir.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel5.setText("Prodi");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel1.setText("Nama Ruangan");

        tfnama_kegiatan.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel2.setText("Gedung");

        tfgedung.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel3.setText("Tanggal Kegiatan");

        tfnama_ruangan.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel12.setText("Waktu Akhir");

        jLabel13.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel13.setText("Nama Kegiatan");

        jLabel17.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel17.setText("Mahasiswa yang Bertanggungjawab");

        jLabel18.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel18.setText("Nomor Handphone");

        jLabel19.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel19.setText("NIM");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel7.setText("TAMBAH PEMINJAMAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(324, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfnomor_hp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfprodi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfnama_kegiatan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                                        .addComponent(tfgedung, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tftgl_kegiatan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfwaktu_mulai, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfwaktu_akhir, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfnama_mhs, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnama_ruangan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnim_mhs, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tfnama_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfgedung, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftgl_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfwaktu_mulai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfwaktu_akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnama_kegiatan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(tfnama_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnim_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfnomor_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/16.jpg"))); // NOI18N
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/15.jpg"))); // NOI18N
        button_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_resetActionPerformed(evt);
            }
        });

        button_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/19.jpg"))); // NOI18N
        button_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tambahActionPerformed(evt);
            }
        });

        button_hapus.setBackground(new java.awt.Color(255, 255, 255));
        button_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/17.jpg"))); // NOI18N
        button_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hapusActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel10.setText("Save");

        jLabel11.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel11.setText("Hapus");

        jLabel14.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel14.setText("Reset");

        jLabel16.setFont(new java.awt.Font("Sylfaen", 1, 12)); // NOI18N
        jLabel16.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(82, 82, 82)))
                                .addGap(91, 91, 91))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(50, 50, 50)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(348, 348, 348))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_tambah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hapusActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_button_hapusActionPerformed

    private void button_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tambahActionPerformed
        try {
            saveData();
            /*  try {
            // TODO add your handling code here:
            saveData();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            } catch (SQLException ex) {
            Logger.getLogger(jadwal_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(jadwal_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button_tambahActionPerformed

    private void tabel_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pinjamMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tabel_pinjamMouseClicked

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_keluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_button_keluarActionPerformed

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_button_resetActionPerformed

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
            java.util.logging.Logger.getLogger(jadwal_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jadwal_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jadwal_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jadwal_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jadwal_peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_hapus;
    private javax.swing.JButton button_keluar;
    private javax.swing.JButton button_reset;
    private javax.swing.JButton button_tambah;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_pinjam;
    private javax.swing.JTextField tfgedung;
    private javax.swing.JTextField tfnama_kegiatan;
    private javax.swing.JTextField tfnama_mhs;
    private javax.swing.JTextField tfnama_ruangan;
    private javax.swing.JTextField tfnim_mhs;
    private javax.swing.JTextField tfnomor_hp;
    private javax.swing.JTextField tfprodi;
    private javax.swing.JTextField tftgl_kegiatan;
    private javax.swing.JTextField tfwaktu_akhir;
    private javax.swing.JTextField tfwaktu_mulai;
    // End of variables declaration//GEN-END:variables
}
