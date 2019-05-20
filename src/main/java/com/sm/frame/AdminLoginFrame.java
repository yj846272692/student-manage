package com.sm.frame;

import com.sm.factory.ServiceFactory;
import com.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame {
    private JPanel rootPanel;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private JTextField accountField;
    private JTextField passwordField;
    private JButton 登录Button;
    private JButton 取消Button;


    public AdminLoginFrame() {
        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获得输入的账号和密码，注意密码框组件的使用方法
                String account = accountField.getText().trim();
                String password = new String(passwordField.getText()).trim();
                ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                JOptionPane.showMessageDialog(rootPanel, resultEntity);
                accountField.setText("");
                passwordField.setText("");

            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                passwordField.setText("");

            }
        });
    }

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("AdminLoginFrame");
        frame.setContentPane(new AdminLoginFrame().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
