package tubes;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Said
 */
public class main_Windows extends javax.swing.JFrame {

    /**
     * Creates new form main_Windows
     */
    
    int mousePX, mousePY;
    private DefaultTableModel model;
    
    public main_Windows() {
        initComponents();
        Show_Products_In_JTable();
        txt_id.setEnabled(true);
        txt_id.setEditable(true);
        
    }
    String ImgPath = null;
    int pos = 0;
    
    
    public Connection getConnection(){
        Connection con = null;
        try {   
            con = DriverManager.getConnection("jdbc:mysql://localhost/products_db2","root","");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(main_Windows.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public boolean checkInputs(){
        if(txt_name.getText()==null||
           txt_jumlah.getText()==null){
            return false;
        }else{
            try{
                Float.parseFloat(txt_jumlah.getText());
                return true;
            }catch (Exception ex){
                return false;
            }
        }
    }
    public ImageIcon ResizeImage(String imagePath,byte[] pic){
        ImageIcon myImage = null;
        
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
        
    }
    public ArrayList<Product> getProductList(){
         ArrayList<Product> productList = new ArrayList<Product>();
            Connection con = getConnection();
            String query = "SELECT * FROM products";
            Statement st;
            ResultSet rs;
        try {
       
            st = con.createStatement();
            rs=st.executeQuery(query);
            Product product;
            
            while(rs.next()){
                product = new Product(rs.getInt("id"), rs.getString("name"), Float.parseFloat(rs.getString("price")),rs.getInt("jumlah"),rs.getBytes("image"));
                productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(main_Windows.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }
    public void Show_Products_In_JTable(){
        ArrayList<Product> list = getProductList();
        DefaultTableModel model = (DefaultTableModel)JTable_Products.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i = 0 ; i<list.size();i++){
            row[0]= list.get(i).getId();
            row[1]= list.get(i).getName();
            row[2]= list.get(i).getPrice();
            row[3]= list.get(i).getJumlah();
            
            model.addRow(row);
        }
    }
    
    public void ShowItem(int index){
        txt_id.setText(Integer.toString(getProductList().get(index).getId()));
        txt_name.setText(getProductList().get(index).getName());
        txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
        txt_jumlah.setText(Integer.toString(getProductList().get(index).getJumlah()));
        lbl_image.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_jumlah = new javax.swing.JTextField();
        lbl_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        Btn_Choose_Image = new javax.swing.JButton();
        Btn_Insert = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Btn_Last = new javax.swing.JButton();
        Btn_Previous = new javax.swing.JButton();
        Btn_First = new javax.swing.JButton();
        Btn_Next = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID : ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(75, 70, 30, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nama Roti :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(21, 120, 80, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Harga : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 160, 60, 20);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Gambar :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(34, 260, 62, 20);

        txt_id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel1.add(txt_id);
        txt_id.setBounds(140, 60, 140, 37);

        txt_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_name);
        txt_name.setBounds(140, 110, 140, 37);

        txt_jumlah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_jumlah.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        jPanel1.add(txt_jumlah);
        txt_jumlah.setBounds(140, 210, 140, 37);

        lbl_image.setBackground(new java.awt.Color(204, 255, 255));
        lbl_image.setForeground(new java.awt.Color(204, 255, 255));
        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/icon/lolijump.gif"))); // NOI18N
        lbl_image.setOpaque(true);
        jPanel1.add(lbl_image);
        lbl_image.setBounds(140, 260, 176, 124);

        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Roti", "Harga", "Jumlah"
            }
        ));
        JTable_Products.setMaximumSize(new java.awt.Dimension(1500, 0));
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(330, 110, 452, 290);

        Btn_Choose_Image.setText("Masukkan Gambar");
        Btn_Choose_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Choose_ImageActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Choose_Image);
        Btn_Choose_Image.setBounds(120, 400, 205, 23);

        Btn_Insert.setText("Tambah");
        Btn_Insert.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                Btn_InsertComponentHidden(evt);
            }
        });
        Btn_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_InsertActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Insert);
        Btn_Insert.setBounds(40, 440, 71, 23);

        jButton3.setText("Delete");
        jButton3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jButton3ComponentHidden(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(260, 440, 63, 23);

        jButton4.setText("Update");
        jButton4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jButton4ComponentHidden(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(150, 440, 67, 23);

        Btn_Last.setText("Last");
        Btn_Last.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                Btn_LastComponentHidden(evt);
            }
        });
        Btn_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LastActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Last);
        Btn_Last.setBounds(730, 530, 53, 23);

        Btn_Previous.setText("Previous");
        Btn_Previous.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                Btn_PreviousComponentHidden(evt);
            }
        });
        Btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PreviousActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Previous);
        Btn_Previous.setBounds(90, 530, 73, 23);

        Btn_First.setBackground(new java.awt.Color(153, 255, 255));
        Btn_First.setText("First");
        Btn_First.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                Btn_FirstComponentHidden(evt);
            }
        });
        Btn_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FirstActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_First);
        Btn_First.setBounds(10, 530, 53, 23);

        Btn_Next.setText("next");
        Btn_Next.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                Btn_NextComponentHidden(evt);
            }
        });
        Btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NextActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Next);
        Btn_Next.setBounds(650, 530, 55, 23);

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 530, 77, 23);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Jumlah :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 210, 60, 20);

        txt_price.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_price.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_price);
        txt_price.setBounds(140, 160, 140, 37);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/icon/lolijump.gif"))); // NOI18N
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(370, 430, 60, 70);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/icon/lolijump.gif"))); // NOI18N
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(690, 430, 60, 70);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Daftar Roti");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/icon/stjohnneals2.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 900, 600);

        jLabel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel11MouseDragged(evt);
            }
        });
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 800, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_InsertComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Btn_InsertComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_InsertComponentHidden

    private void jButton3ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton3ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ComponentHidden

    private void jButton4ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton4ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ComponentHidden

    private void Btn_LastComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Btn_LastComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_LastComponentHidden

    private void Btn_PreviousComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Btn_PreviousComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_PreviousComponentHidden

    private void Btn_FirstComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Btn_FirstComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_FirstComponentHidden

    private void Btn_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LastActionPerformed
        // TODO add your handling code here:
        pos = getProductList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_LastActionPerformed

    private void Btn_NextComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Btn_NextComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_NextComponentHidden

    private void Btn_Choose_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Choose_ImageActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }else{
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_Btn_Choose_ImageActionPerformed

    private void Btn_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_InsertActionPerformed
        // TODO add your handling code here:
        if(checkInputs()&& ImgPath != null){
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO products(name,price,jumlah,image)"+"values(?,?,?,?)");
                ps.setString(1, txt_name.getText());
                ps.setString(2, txt_price.getText());
                ps.setString(3, txt_jumlah.getText());
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(4, img);
                ps.executeUpdate();
                Show_Products_In_JTable();
                 JOptionPane.showMessageDialog(null, "DATA TELAH TERSIMPAN");  
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Satu atau lebih field kosong");
        }
        System.out.println("Name => "+txt_name.getText());
         System.out.println("Name => "+txt_price.getText());
        System.out.println("Name => "+txt_jumlah.getText());
        System.out.println("Name => "+ImgPath);
    }//GEN-LAST:event_Btn_InsertActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(checkInputs()&&txt_id.getText() != null){
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = getConnection();
            if(ImgPath == null){
                try {
                    UpdateQuery = "UPDATE products SET name = ?, price = ?, jumlah = ?"
                            +"WHERE id = ?";
                    ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, txt_name.getText());
                    ps.setString(2, txt_price.getText());
                    ps.setString(3, txt_jumlah.getText());
                    ps.setInt(4,Integer.parseInt(txt_id.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "DATA TELAH TERUPDATE"); 
                } catch (SQLException ex) {
                    Logger.getLogger(main_Windows.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try{
                InputStream img = new FileInputStream(new File(ImgPath));
                
                UpdateQuery = "UPDATE products SET name = ?,price = ?,jumlah = ?"+",image = ? WHERE id = ?";
                ps = con.prepareStatement(UpdateQuery);
                    ps.setString(1, txt_name.getText());
                    ps.setString(2, txt_price.getText());
                    ps.setString(3, txt_jumlah.getText());
                    ps.setBlob(4, img);
                    ps.setInt(5,Integer.parseInt(txt_id.getText()));
                    ps.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "DATA TELAH TERUPDATE"); 
                
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Satu atau lebih field kosong atau salah input");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(!txt_id.getText().equals("")){
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM products WHERE id = ?");
                int id = Integer.parseInt(txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null, "Produk telah dihapus");
            } catch (SQLException ex) {
                Logger.getLogger(main_Windows.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Produk gagal dihapus");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Produk gagal dihapus : Mohon cek nomor Id");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        // TODO add your handling code here:
        int index = JTable_Products.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    private void Btn_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FirstActionPerformed
        // TODO add your handling code here:
        pos =0;
        ShowItem(pos);
    }//GEN-LAST:event_Btn_FirstActionPerformed

    private void Btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NextActionPerformed
        // TODO add your handling code here:
        pos++;
        if(pos>=getProductList().size()){
            pos = getProductList().size()-1;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_NextActionPerformed

    private void Btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PreviousActionPerformed
        // TODO add your handling code here:
        pos--;
        if(pos<0){
            pos=0;;
        }
        ShowItem(pos);
    }//GEN-LAST:event_Btn_PreviousActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormLogin().setVisible(true);
        JOptionPane.showMessageDialog(null, "Anda Telah Log Out");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel11MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        
        this.setLocation(kordinatX-mousePX, kordinatY-mousePY);
    }//GEN-LAST:event_jLabel11MouseDragged

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
        mousePX = evt.getX();
        mousePY = evt.getY();
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel12MousePressed

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
            java.util.logging.Logger.getLogger(main_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_Windows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_Windows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Choose_Image;
    private javax.swing.JButton Btn_First;
    private javax.swing.JButton Btn_Insert;
    private javax.swing.JButton Btn_Last;
    private javax.swing.JButton Btn_Next;
    private javax.swing.JButton Btn_Previous;
    private javax.swing.JTable JTable_Products;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
