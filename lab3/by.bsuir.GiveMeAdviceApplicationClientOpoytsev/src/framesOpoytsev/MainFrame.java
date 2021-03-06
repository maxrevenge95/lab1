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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import remoteOpoytsev.MyRemote;

/**
 *
 * @author макс
 */
public class MainFrame extends javax.swing.JFrame {

    static String username;
    static int ID;
    protected DefaultTableModel dtm = new DefaultTableModel();
    protected int current;
    protected static int size;
    protected static int postID;

    public void refresh() throws RemoteException, NotBoundException, SQLException {
        setTitle("Give Me Advice Application | Главная");
        Registry registry = LocateRegistry.getRegistry("localhost", 1112);
        MyRemote remoteObject = (MyRemote) registry
                .lookup("RemoteObject");
        dtm = remoteObject.getPosts();
        if (dtm.getRowCount() > 0) {
            size = dtm.getRowCount();
            current = 0;
            init(current, dtm.getRowCount(), dtm);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Здесь пока нет записей", "Информация!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void blockUser(int id) throws RemoteException, NotBoundException, SQLException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1112);
        MyRemote remoteObject = (MyRemote) registry
                .lookup("RemoteObject");
        remoteObject.blockingUser(id, true);
    }

    /**
     * Creates new form MainFrame
     */
    public void init(int curr, int size, DefaultTableModel dtm) {
        postID = Integer.parseInt(dtm.getValueAt(curr, 0).toString());
        int uID = Integer.parseInt(dtm.getValueAt(curr, 7).toString());
        title.setText(dtm.getValueAt(curr, 1).toString());
        text.setText(dtm.getValueAt(curr, 2).toString());
        if (username.equalsIgnoreCase("admin")) {
            delP.setVisible(true);

        } else if (uID == ID) {
            delP.setVisible(true);

        } else {
            delP.setVisible(false);

        }
        if (dtm.getValueAt(curr, 3).toString().equals("")
                && dtm.getValueAt(curr, 4).toString().equals("")
                && dtm.getValueAt(curr, 5).toString().equals("")
                && dtm.getValueAt(curr, 6).toString().equals("")) {
            tags.setText("");
        } else {
            tags.setText(dtm.getValueAt(curr, 3).toString() + " "
                    + dtm.getValueAt(curr, 4).toString() + " "
                    + dtm.getValueAt(curr, 5).toString() + " "
                    + dtm.getValueAt(curr, 6).toString());
        }
        datetime.setText(dtm.getValueAt(curr, 8).toString());
    }

    public MainFrame(String userName, int id) throws RemoteException, NotBoundException, SQLException {
        initComponents();
        setTitle("Give Me Advice Application | Главная");
        Image image = new ImageIcon("ico.png").getImage();
        setIconImage(image);
        setResizable(false);
        username = userName;
        ID = id;
        login.setText(username);
        current = 0;
        refresh();

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
        delP = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tags = new javax.swing.JTextField();
        datetime = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        toComment = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        login = new javax.swing.JTextField();
        MyPosts = new javax.swing.JButton();
        OPTIONS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NewPost = new javax.swing.JButton();
        MAIN = new javax.swing.JButton();
        SEARCH = new javax.swing.JButton();
        sTag = new javax.swing.JTextField();
        EXIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        delP.setBackground(new java.awt.Color(51, 51, 51));
        delP.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        delP.setForeground(new java.awt.Color(255, 255, 255));
        delP.setText("Х");
        delP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delPActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Chiller", 1, 24)); // NOI18N
        title.setText("Заголовок");
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleMouseClicked(evt);
            }
        });

        text.setEditable(false);
        text.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        jLabel2.setText("Теги");

        tags.setEditable(false);
        tags.setBackground(new java.awt.Color(255, 255, 255));

        datetime.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        datetime.setText("Дата");

        prev.setBackground(new java.awt.Color(51, 51, 51));
        prev.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.setText("<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(51, 51, 51));
        next.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        toComment.setBackground(new java.awt.Color(51, 51, 51));
        toComment.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        toComment.setForeground(new java.awt.Color(255, 255, 255));
        toComment.setText("К комментариям");
        toComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tags, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(toComment, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datetime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prev, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        login.setEditable(false);
        login.setBackground(new java.awt.Color(204, 204, 204));
        login.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N

        MyPosts.setBackground(new java.awt.Color(51, 51, 51));
        MyPosts.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        MyPosts.setForeground(new java.awt.Color(255, 255, 255));
        MyPosts.setText("Мои Посты");
        MyPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyPostsActionPerformed(evt);
            }
        });

        OPTIONS.setBackground(new java.awt.Color(51, 51, 51));
        OPTIONS.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        OPTIONS.setForeground(new java.awt.Color(255, 255, 255));
        OPTIONS.setText("Настройки");
        OPTIONS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OPTIONSActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Chiller", 1, 36)); // NOI18N
        jLabel1.setText("GiveMeAdvice");

        NewPost.setBackground(new java.awt.Color(51, 51, 51));
        NewPost.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        NewPost.setForeground(new java.awt.Color(255, 255, 255));
        NewPost.setText("Написать пост");
        NewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NewPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OPTIONS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MyPosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(login))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MyPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OPTIONS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        MAIN.setBackground(new java.awt.Color(51, 51, 51));
        MAIN.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        MAIN.setForeground(new java.awt.Color(255, 255, 255));
        MAIN.setText("Главная");
        MAIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAINActionPerformed(evt);
            }
        });

        SEARCH.setBackground(new java.awt.Color(51, 51, 51));
        SEARCH.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        SEARCH.setForeground(new java.awt.Color(255, 255, 255));
        SEARCH.setText("Поиск по тегу");
        SEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEARCHActionPerformed(evt);
            }
        });

        EXIT.setBackground(new java.awt.Color(51, 51, 51));
        EXIT.setFont(new java.awt.Font("Chiller", 0, 24)); // NOI18N
        EXIT.setForeground(new java.awt.Color(255, 255, 255));
        EXIT.setText("Выход");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(MAIN, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(SEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sTag, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EXIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(EXIT))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SEARCH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MAIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sTag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MyPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyPostsActionPerformed
        // TODO add your handling code here:

        current = 0;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1112);
            MyRemote remoteObject = (MyRemote) registry
                    .lookup("RemoteObject");
            dtm = remoteObject.getAllPostFromUser(ID);
            if (dtm.getRowCount() > 0) {
                setTitle("Give Me Advice Application | Мои посты");
                size = dtm.getRowCount();
                init(current, dtm.getRowCount(), dtm);
            } else {
                JOptionPane.showMessageDialog(this,
                        "У вас пока нет записей", "Информация!",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (RemoteException e) {
        } catch (NotBoundException e) {
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_MyPostsActionPerformed

    private void MAINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAINActionPerformed
        try {
            // TODO add your handling code here:
            refresh();
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MAINActionPerformed

    private void SEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEARCHActionPerformed
        // TODO add your handling code here:
        current = 0;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1112);
            MyRemote remoteObject = (MyRemote) registry
                    .lookup("RemoteObject");
            if (!sTag.getText().equals("")) {

                dtm = remoteObject.getPostByTag(sTag.getText());
                if (dtm.getRowCount() > 0) {
                    setTitle("Give Me Advice Application | Поиск");
                    size = dtm.getRowCount();
                    current=0;
                    init(current, dtm.getRowCount(), dtm);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Поиск результатов не дал", "Информация!",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Введите тег!", "Ошибка!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException e) {
        } catch (NotBoundException e) {
        } catch (SQLException e) {
        } finally {
            sTag.setText("");
        }
    }//GEN-LAST:event_SEARCHActionPerformed

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_EXITActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if (current < size) {
            if (current != size - 1) {
                current++;
            }
            if (current != size) {
                init(current, size, dtm);
            }
        }
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
        if (current > -1) {
            if (current != 0) {
                current--;
            }
            if (current != -1) {
                init(current, size, dtm);
            }
        }
    }//GEN-LAST:event_prevActionPerformed

    private void delPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delPActionPerformed
        // TODO add your handling code here:
        try {
            if (size > 0) {
                Registry registry = LocateRegistry.getRegistry("localhost", 1112);
                MyRemote remoteObject = (MyRemote) registry
                        .lookup("RemoteObject");
                remoteObject.deletePost(Integer.parseInt(dtm.getValueAt(current, 0).toString()));
                JOptionPane.showMessageDialog(this,
                        "пост удален", "Информация!",
                        JOptionPane.INFORMATION_MESSAGE);
                int user = Integer.parseInt(dtm.getValueAt(current, 7).toString());
                //System.out.println(user+" "+ID);
                if (user != ID) {
                    if (ID == 1) {
                        blockUser(Integer.parseInt(dtm.getValueAt(current, 7).toString()));
                        JOptionPane.showMessageDialog(this,
                                "пользователь блокирован", "Информация!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                refresh();
            }
        } catch (RemoteException e) {
        } catch (NotBoundException e) {
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_delPActionPerformed

    private void NewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPostActionPerformed

        // TODO add your handling code here:
        setVisible(false);
        new NewPost(ID, username).setVisible(true);
    }//GEN-LAST:event_NewPostActionPerformed

    private void OPTIONSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OPTIONSActionPerformed
        // TODO add your handling code here:
        try {
            if (username.equals("admin")) {
                new AdminOptionsFrame().setVisible(true);
            } else {
                new OptionsFrame(username).setVisible(true);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OPTIONSActionPerformed

    private void toCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCommentActionPerformed
        try {
            // TODO add your handling code here:
            new PostFrame(postID, ID).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_toCommentActionPerformed

    private void titleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseClicked
        try {
            // TODO add your handling code here:
            new PostFrame(postID, ID).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_titleMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EXIT;
    private javax.swing.JButton MAIN;
    private javax.swing.JButton MyPosts;
    private javax.swing.JButton NewPost;
    private javax.swing.JButton OPTIONS;
    private javax.swing.JButton SEARCH;
    private javax.swing.JLabel datetime;
    private javax.swing.JButton delP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField login;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTextField sTag;
    private javax.swing.JTextField tags;
    private javax.swing.JTextField text;
    private javax.swing.JLabel title;
    private javax.swing.JButton toComment;
    // End of variables declaration//GEN-END:variables
}
