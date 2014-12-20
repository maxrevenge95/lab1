/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framesOpoytsev;

import java.awt.Image;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import remoteOpoytsev.MyRemote;
import javax.swing.*;

/**
 *
 * @author макс
 */
public class AuthFrame extends javax.swing.JFrame {

    public AuthFrame() {
        initComponents();
        setLocation(400, 300);
        setTitle("Give Me Advice Application");
        Image image = new ImageIcon("ico.png").getImage();
        setIconImage(image);
        setResizable(false);
    }

 public boolean isBlocking(int ID) throws RemoteException, NotBoundException, SQLException
 {
        Registry registry = LocateRegistry.getRegistry("localhost", 1112);
                MyRemote remoteObject = (MyRemote) registry
                        .lookup("RemoteObject");
                boolean state = remoteObject.blocked(ID);
                if (state)
                    return true;
                else
                    return false;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        LOGIN = new javax.swing.JButton();
        REG = new javax.swing.JButton();
        EXIT = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 204, 172));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Авторизация", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Chiller", 0, 24), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        jLabel1.setText("Логин:");

        jLabel2.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        jLabel2.setText("Пароль:");

        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });

        LOGIN.setBackground(new java.awt.Color(51, 51, 51));
        LOGIN.setFont(new java.awt.Font("Chiller", 0, 18)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("Войти");
        LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGINActionPerformed(evt);
            }
        });

        REG.setBackground(new java.awt.Color(51, 51, 51));
        REG.setFont(new java.awt.Font("Chiller", 0, 18)); // NOI18N
        REG.setForeground(new java.awt.Color(255, 255, 255));
        REG.setText("Регистрация");
        REG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGActionPerformed(evt);
            }
        });

        EXIT.setBackground(new java.awt.Color(51, 51, 51));
        EXIT.setFont(new java.awt.Font("Chiller", 0, 18)); // NOI18N
        EXIT.setForeground(new java.awt.Color(255, 255, 255));
        EXIT.setText("Выход");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        CLEAR.setBackground(new java.awt.Color(51, 51, 51));
        CLEAR.setFont(new java.awt.Font("Chiller", 0, 18)); // NOI18N
        CLEAR.setForeground(new java.awt.Color(255, 255, 255));
        CLEAR.setText("Очистить");
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(CLEAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(login)))
                    .addComponent(REG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EXIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LOGIN)
                    .addComponent(CLEAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(REG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EXIT)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGINActionPerformed
        // TODO add your handling code here:
        try {
            if (!login.getText().equals("")) {
                Registry registry = LocateRegistry.getRegistry("localhost", 1112);
                MyRemote remoteObject = (MyRemote) registry
                        .lookup("RemoteObject");
                int id = remoteObject.logIn(login.getText(),
                        String.valueOf(password.getPassword()));
                if (id != 0) {
                    if (isBlocking(id)) {
                        JOptionPane.showMessageDialog(this,
                                "Ваш профиль заблокирован!",
                                "Отказано!", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new MainFrame(login.getText(), id).setVisible(true);
                        setVisible(false);
                    }
                    login.setText("");
                    password.setText("");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Вы ввели неверный логин или пароль.",
                            "Отказано!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Введите логин и пароль или зарегистрируйтесь", "Ошибка!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Сервер не доступен.",
                    "Ошибка", JOptionPane.ERROR_MESSAGE, null);
            ex.printStackTrace();
        }
        password.setText("");
        login.grabFocus();


    }//GEN-LAST:event_LOGINActionPerformed

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        // TODO add your handling code here:
        login.setText("");
        password.setText("");
    }//GEN-LAST:event_CLEARActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_EXITActionPerformed

    private void REGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGActionPerformed
        // TODO add your handling code here:
        new RegFrame().setVisible(true);
        
    }//GEN-LAST:event_REGActionPerformed

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        // TODO add your handling code here:
        password.setText("");
    }//GEN-LAST:event_passwordMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLEAR;
    private javax.swing.JButton EXIT;
    private javax.swing.JButton LOGIN;
    private javax.swing.JButton REG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
