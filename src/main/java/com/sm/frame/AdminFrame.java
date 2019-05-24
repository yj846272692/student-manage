package com.sm.frame;

import javax.swing.*;

public class AdminFrame extends JFrame  {
    private JPanel rootPanel;
    private JLabel 管理员界面;



    public AdminFrame() {
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }


}
