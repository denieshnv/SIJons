/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Said
 */
public class FormLogin extends javax.swing.JFrame {
     Connection conn =null;
     Statement st = null;
    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
        initComponents();
        try {
Class.forName("com.mysql.jdbc.Driver");
conn=DriverManager.getConnection("jdbc:mysql://localhost/products_db2","root","");
st=conn.createStatement();
}
catch(Exception ex){
JOptionPane.showMessageDialog(null,"Gagal terkoneksi Karena " + ex);
}
    }

  
    private void CekLogin(){
        try{
            if(txtusername.getText().equals("")||txtpass.getPassword().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Data Tidak terisi Lengkap","Pesan",JOptionPane.ERROR_MESSAGE);
                txtusername.requestFocus();
                hapuslayar();
                
            }else{
                st = conn.createStatement();
                String sql = ("SELECT * FROM login WHERE username='"+txtusername.getText()+"'AND password ='"+String.valueOf(txtpass.getPassword())+"'");
                System.out.println(txtusername.getText());
                System.out.println(String.valueOf(txtpass.getPassword()));
                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    this.dispose();
                    new main_Windows().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username dan Password Salah \nAtau Akun Belum Terdaftar","Pesan",JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void hapuslayar(){
        txtusername.setText("");
        txtpass.setText("");
        txtusername.setEnabled(true);
        txtpass.setEnabled(true);
        
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
        txtusername = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        Btn_Login = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Password :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 150, 80, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Username : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(48, 105, 80, 16);

        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtusername);
        txtusername.setBounds(140, 100, 149, 22);

        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        jPanel1.add(txtpass);
        txtpass.setBounds(137, 150, 151, 22);

        Btn_Login.setText("Login");
        Btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_Login);
        Btn_Login.setBounds(55, 255, 63, 25);

        jButton2.setText("Registrasi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(199, 255, 89, 25);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 30, 60, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubes/icon/johns.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 400, 310);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 309));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void Btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LoginActionPerformed
        // TODO add your handling code here:
        try{
            if(txtusername.getText().equals("")||txtpass.getPassword().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Data Tidak terisi Lengkap","Pesan",JOptionPane.ERROR_MESSAGE);
                txtusername.requestFocus();
                txtpass.requestFocus();
                hapuslayar();
                
            }else{
                st = conn.createStatement();
                String sql = ("SELECT * FROM login WHERE username='"+txtusername.getText()+"'AND password ='"+String.valueOf(txtpass.getPassword())+"'");
                System.out.println(txtusername.getText());
                System.out.println(String.valueOf(txtpass.getPassword()));
                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    this.dispose();
                    new main_Windows().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username dan Password Salah \nAtau Akun Belum Terdaftar","Pesan",JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_Btn_LoginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new FormRegistrasi().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed

    }//GEN-LAST:event_txtpassActionPerformed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Login;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
