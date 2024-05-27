/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class productForm extends javax.swing.JFrame {

    /**
     * Creates new form productForm
     */
    public productForm() {
        initComponents(); // Inisialisasi komponen GUI
        Connect(); // Memanggil metode untuk membuat koneksi ke database
        LoadProductNo(); // Memuat nomor produk dari database ke komponen JComboBox
        Fetch();
    }

    Connection con; // Deklarasi variabel untuk koneksi database
    PreparedStatement pst; // Deklarasi variabel untuk statement SQL
    ResultSet rs; // Deklarasi variabel untuk hasil kueri SQL
    
    // Metode untuk membuat koneksi ke database
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Memuat driver JDBC MySQL
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lat-java-crud-1","root",""); // Mendapatkan koneksi ke database MySQL
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika kelas driver tidak ditemukan
        } catch(SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika koneksi ke database gagal
        }
    }
    
    // Metode untuk memuat nomor produk dari database ke komponen JComboBox
    public void LoadProductNo(){
        try {
            pst = con.prepareStatement("SELECT id FROM product"); // Membuat pernyataan SQL untuk memilih nomor produk dari tabel 'product'
            rs = pst.executeQuery(); // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya
            txtId.removeAllItems(); // Menghapus semua item dari komponen JComboBox
            while(rs.next()){
                txtId.addItem(rs.getString(1)); // Menambahkan nomor produk ke dalam komponen JComboBox
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika terjadi kesalahan dalam eksekusi kueri SQL
        }
    }
    
    private void Fetch(){
        try {
            int g;
            pst = con.prepareStatement("SELECT * FROM product");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            g = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=g; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("qty"));
                }
                df.addRow(v2);
            }
                    } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("JAVA CRUD OPERATIONS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Product Price");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Product Qty");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Product Id");

        txtId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("New");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName)
                                    .addComponent(txtPrice)
                                    .addComponent(txtQty))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
    String pname = txtName.getText(); // Mengambil teks dari JTextField txtName dan menyimpannya dalam variabel pname
    String price = txtPrice.getText(); // Mengambil teks dari JTextField txtPrice dan menyimpannya dalam variabel price
    String qty = txtQty.getText(); // Mengambil teks dari JTextField txtQty dan menyimpannya dalam variabel qty

    pst = con.prepareStatement("INSERT INTO product (name, price, qty) VALUES(?,?,?)"); // Membuat pernyataan SQL untuk memasukkan data ke tabel 'product'
    pst.setString(1, pname); // Mengatur nilai parameter pertama (?) dengan nilai dari variabel pname
    pst.setString(2, price); // Mengatur nilai parameter kedua (?) dengan nilai dari variabel price
    pst.setString(3, qty); // Mengatur nilai parameter ketiga (?) dengan nilai dari variabel qty

    int k = pst.executeUpdate(); // Mengeksekusi pernyataan SQL untuk memasukkan data ke dalam tabel dan mendapatkan jumlah baris yang terpengaruh

    if(k == 1){
        JOptionPane.showMessageDialog(this, "Record Added Successfully"); // Menampilkan pesan dialog jika data berhasil dimasukkan
        txtName.setText(""); // Mengosongkan JTextField txtName
        txtPrice.setText(""); // Mengosongkan JTextField txtPrice
        txtQty.setText(""); // Mengosongkan JTextField txtQty
        LoadProductNo(); // Memuat nomor produk dari database ke komponen JComboBox
        Fetch();
    }else{
        JOptionPane.showMessageDialog(this, "Record Failed to save"); // Menampilkan pesan dialog jika data gagal disimpan
    }
} catch (SQLException ex) {
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex); // Menangani kesalahan jika terjadi kesalahan dalam eksekusi kueri SQL
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
    // Mengambil ID produk yang dipilih dari JComboBox dan menyimpannya dalam variabel pid
    String pid = txtId.getSelectedItem().toString();

    // Membuat pernyataan SQL untuk memilih data produk berdasarkan ID dari tabel 'product'
    pst = con.prepareStatement("SELECT * FROM product WHERE id=?");
    pst.setString(1, pid); // Mengatur nilai parameter pertama (?) dengan nilai dari variabel pid
    rs = pst.executeQuery(); // Mengeksekusi pernyataan SQL dan mendapatkan hasilnya

    // Memeriksa apakah hasil kueri mengandung baris data
    if(rs.next() == true) {
        // Jika ada data, mengatur nilai JTextField txtName, txtPrice, dan txtQty dengan nilai dari hasil kueri
        txtName.setText(rs.getString(2)); // Mengatur nilai txtName dengan nilai dari kolom kedua (nama produk)
        txtPrice.setText(rs.getString(3)); // Mengatur nilai txtPrice dengan nilai dari kolom ketiga (harga produk)
        txtQty.setText(rs.getString(4)); // Mengatur nilai txtQty dengan nilai dari kolom keempat (jumlah produk)
        LoadProductNo(); // Memuat nomor produk dari database ke komponen JComboBox
        Fetch();
    } else {
        // Jika tidak ada data yang cocok dengan ID yang dipilih, menampilkan pesan dialog bahwa tidak ada data yang ditemukan
        JOptionPane.showMessageDialog(this, "No Record Found");
    }
} catch (SQLException ex) {
    // Menangani kesalahan jika terjadi kesalahan dalam eksekusi kueri SQL
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
    // Mengambil nilai teks dari JTextField txtName, txtPrice, dan txtQty serta ID produk dari JComboBox txtId
    String pname = txtName.getText(); // Mengambil nama produk
    String price = txtPrice.getText(); // Mengambil harga produk
    String qty = txtQty.getText(); // Mengambil jumlah produk
    String pid = txtId.getSelectedItem().toString(); // Mengambil ID produk yang dipilih

    // Membuat pernyataan SQL untuk melakukan pembaruan data produk berdasarkan ID
    pst = con.prepareStatement("UPDATE product SET name=?,price=?,qty=? WHERE id=?");
    
    // Mengatur nilai parameter (?) pada pernyataan SQL dengan nilai dari variabel pname, price, qty, dan pid
    pst.setString(1, pname); // Mengatur nama produk
    pst.setString(2, price); // Mengatur harga produk
    pst.setString(3, qty); // Mengatur jumlah produk
    pst.setString(4, pid); // Mengatur ID produk

    // Mengeksekusi pernyataan SQL untuk melakukan pembaruan data dalam tabel 'product' dan mendapatkan jumlah baris yang terpengaruh
    int k = pst.executeUpdate();
    if(k==1){
        // Jika pembaruan berhasil, menampilkan pesan dialog bahwa data berhasil diperbarui
        JOptionPane.showMessageDialog(this, "Record Update Successfully");
        // Mengosongkan nilai JTextField txtName, txtPrice, dan txtQty serta mengatur fokus kembali ke txtName
        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtName.requestFocus();
        // Memuat ulang nomor produk ke dalam JComboBox txtId
        LoadProductNo(); // Memuat nomor produk dari database ke komponen JComboBox
        Fetch();
    }else{
        // Jika pembaruan gagal, menampilkan pesan dialog bahwa pembaruan data gagal
        JOptionPane.showMessageDialog(this, "Record Update Failed");
    }
} catch (SQLException ex) {
    // Menangani kesalahan jika terjadi kesalahan dalam eksekusi kueri SQL
    Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            String pid = txtId.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM product WHERE id=?");
            pst.setString(1, pid);
            
            int k = pst.executeUpdate();
    if(k==1){
        // Jika pembaruan berhasil, menampilkan pesan dialog bahwa data berhasil diperbarui
        JOptionPane.showMessageDialog(this, "Record Delete Successfully");
        // Mengosongkan nilai JTextField txtName, txtPrice, dan txtQty serta mengatur fokus kembali ke txtName
        txtName.setText("");
        txtPrice.setText("");
        txtQty.setText("");
        txtName.requestFocus();
        // Memuat ulang nomor produk ke dalam JComboBox txtId
        LoadProductNo(); // Memuat nomor produk dari database ke komponen JComboBox
        Fetch();
    }else{
        // Jika pembaruan gagal, menampilkan pesan dialog bahwa pembaruan data gagal
        JOptionPane.showMessageDialog(this, "Record Delete Failed");
    }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productForm().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
}
