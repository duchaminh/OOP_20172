package view;

import model.*;

/**
 *
 * @author hai
 */
public class LoginView extends javax.swing.JFrame {

	 /*================== ATTRIBUTEs ==========================================*/
 /*================== CONSTRUCTORs ==========================================*/
	 /**
	  * Creates new form LoginView
	  *
	  * @param listAdmin
	  * @param listSinhVien
	  */
	 public LoginView() {
		  initComponents();
		  this.setLocationRelativeTo(null);//cho xuat hien o giua screen	  
		  
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
        jTextFieldUsername = new javax.swing.JTextField();
        jButtonDangNhap = new javax.swing.JButton();
        jPasswordFieldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");

        jLabel1.setText("Quản lý sinh viên - WakaiBuffalo team");

        jLabel2.setText("Đăng nhập để sử dụng");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jButtonDangNhap.setText("Đăng nhập");
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(3, 3, 3))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonDangNhap)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	 /*================== ACTIONPERFORMED ==========================================*/

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
		  // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
		  // TODO add your handling code here:
		  //neu tim thay user thoa man
		  if (xacThucUser(jTextFieldUsername.getText(), String.valueOf(jPasswordFieldPassword.getPassword())) != null) {
				//khoi tao phien lam viec tuong ung voi userID
				HeThong.initUserSession(xacThucUser(jTextFieldUsername.getText(), String.valueOf(jPasswordFieldPassword.getPassword())));
		  }
		  this.dispose();//xoa phien lam viec
		
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

	 /*================== OTHER METHODs ==========================================*/
	 public User xacThucUser(String username, String password) {
		  for (Admin a : HeThong.getListAdmin()) {//tim trong listAdmin
				if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
					 return a;
				}
		  }
		  
		  for (SinhVien a : HeThong.getListSinhVien()) {//tim trong listAdmin
				if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
					 return a;
				}
		  }
		  return null;
	 }

	 /*================== Main  ==========================================*/
	 /**
	  * @param args the command line arguments
	  */
//	 public static void main(String args[]) {//loginView tu no khong khoi tao duoc
//		  /* Set the Nimbus look and feel */
//		  //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//		  /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//		   */
//		  try {
//				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//					 if ("Nimbus".equals(info.getName())) {
//						  javax.swing.UIManager.setLookAndFeel(info.getClassName());
//						  break;
//					 }
//				}
//		  } catch (ClassNotFoundException ex) {
//				java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		  } catch (InstantiationException ex) {
//				java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		  } catch (IllegalAccessException ex) {
//				java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//				java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		  }
//		  //</editor-fold>
//
//
//	 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
