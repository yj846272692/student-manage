package com.sm.frame;

import com.eltima.components.ui.DatePicker;
import com.sm.entity.*;
import com.sm.ui.ImgPanel;
import com.sm.utils.AliOSSUtil;

import com.sm.factory.ServiceFactory;
import com.sm.thread.TimeThread;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static javax.swing.JOptionPane.YES_OPTION;

public class AdminMainFrame extends JFrame {
    private JPanel rootPanel;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JButton 院系管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPunishPanel;
    private JPanel topPanel;
    private JButton 新增院系Button;
    private JButton 刷新数据Button;
    private JTextField depNameField;
    private JPanel leftPanel;
    private JButton 选择Logo图Button;
    private JButton 新增Button;
    private JScrollPane scrollPane;
    private JPanel contentPanel;
    private JLabel adminNameLabel;
    private JLabel timeLabel;
    private JLabel logoLabel;
    private JButton 重新选择;
    private JTextField classTextField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JButton delBtn;
    private String uploadFileUrl;
    private File file;
    private int departmentId;
    private JComboBox<Department> depComboBox;
    private JPanel stuTopPanel;
    private JComboBox<Department> comboBox1;
    private JComboBox<CClass> comboBox2;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 新增学生Button;
    private JButton 初始化数据Button;
    private ImgPanel infoPanel;
    private JLabel stuAvatarLabel;
    private JTextField stuAddressField;
    private JTextField stuPhoneField;
    private JLabel stuGenderLabel;
    private JLabel stuNameLabel;
    private JLabel stuClassLabel;
    private JLabel stuIdLabel;
    private JLabel stuDepLabel;
    private JPanel tablePanel;
    private JLabel stuBirthdayLabel;
    private JButton 编辑Button;
    private JTextField rp搜索Field;
    private JButton 搜索Button1;
    private JButton 更改奖惩信息Button;
    private JButton 修改完成Button;
    private JLabel 姓名Label;
    private JLabel 院系Label;
    private JLabel 班级Label;
    private JTextArea 奖励TextArea;
    private JTextArea 惩罚TextArea;
    private JLabel 性别Label;
    private JPanel rewardsPanel;
    private JPanel punishmentsPanel;
    private JComboBox comboBox3;
    private JButton timeBtn;
    private JButton 惩处记录增加完成Button;
    private JComboBox comboBox4;
    private JButton 奖励增加完成Button;
    private JButton 刷新Button;
    private JComboBox comboBox5;
    private  int row;


    private Admin admin;


    public AdminMainFrame(Admin admin) {

        final DatePicker datepick;
        datepick = getDatePicker();
        timeBtn.add(datepick);

        this.admin = admin;
        adminNameLabel.setText(admin.getAdminName());
        //窗体基本属性的设置
        setTitle("管理员主界面");
        setContentPane(rootPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        showDepartments();
        //获取centerPanel的布局,获得的事LayoutManager，向下转型为CardLayout
        final CardLayout cardLayout = (CardLayout) centerPanel.getLayout();


        院系管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card1");
            }
        });
        班级管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card2");
                showClassPanel();


            }
        });

        新增院系Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = leftPanel.isVisible();
                if (flag == false) {
                    leftPanel.setVisible(true);
                } else {
                    leftPanel.setVisible(false);
                }

            }
        });
        刷新数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDepartments();

            }
        });


        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });
        选择Logo图Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:\\"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    //选中文件
                    file = fileChooser.getSelectedFile();
                    //通过文件创建icon对象
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                    //将按钮隐藏
                    选择Logo图Button.setVisible(false);
                }
            }
        });


        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //上传文件到OSS并返回外链
                uploadFileUrl = AliOSSUtil.ossUpload(file);
                //创建Department对象，并设置相应属性
                Department department = new Department();
                department.setDepartmentName(depNameField.getText().trim());
                department.setLogo(uploadFileUrl);

                //调用service实现新增功能
                int n = ServiceFactory.getDepartmentServiceImpl().addDepartment(department);
                if (n == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系成功");
                    //新增成功后，将侧边栏隐藏
                    leftPanel.setVisible(false);
                    //刷新界面数据
                    showDepartments();
                    //将图片预览标签隐藏
                    logoLabel.setVisible(false);
                    //将选择图片的按钮可见
                    选择Logo图Button.setVisible(true);
                    //清空文本框
                    depNameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "新增院系失败");
                }
            }
        });
        重新选择.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("D:\\"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    //选中文件
                    file = fileChooser.getSelectedFile();
                    //通过文件创建icon对象
                    Icon icon = new ImageIcon(file.getAbsolutePath());
                    //通过标签显示图片
                    logoLabel.setIcon(icon);
                    //设置标签可见
                    logoLabel.setVisible(true);
                    //将按钮隐藏
                    选择Logo图Button.setVisible(false);
                }
            }

        });
        depComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //得到选中项的索引
                int index = depComboBox.getSelectedIndex();
                //按照索引取出项，就是一个Department对象，然后取出其id备用
                departmentId = depComboBox.getItemAt(index).getId();
            }
        });


        新增班级Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s  = classTextField.getText();
                CClass cClass = new CClass();
                cClass.setClassName(s);
                cClass.setDepartmentId(departmentId);
                ServiceFactory.getCClassServiceInstance().insertClass(cClass);
                showClassPanel();
                classTextField.setText("");


            }
        });
        学生管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card3");
                infoPanel.setFileName("13.jpg");
                infoPanel.repaint();
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(studentList);

                Department tip1 = new Department();
                tip1.setDepartmentName("请选择院系");
                comboBox1.addItem(tip1);
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);

                //初始化院系下拉框数据
                List<Department> departmentList = ServiceFactory.getDepartmentServiceImpl().selectAll();
                for (Department department : departmentList){
                    comboBox1.addItem(department);
                }
                //初始化班级下拉框数据
                List<CClass> cClasses = ServiceFactory.getCClassServiceInstance().selectAll();
                for (CClass cClass : cClasses) {
                    comboBox2.addItem(cClass);
                }
                comboBox1.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED){
                            int index = comboBox1.getSelectedIndex();
                            if (index !=0){
                                departmentId = comboBox1.getItemAt(index).getId();
                                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByDepartmentId(departmentId);
                                showStudentTable(studentList);
                                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(departmentId);
                                comboBox2.removeAllItems();
                                CClass tip  = new CClass();
                                tip.setClassName("请选择班级");
                                comboBox2.addItem(tip);
                                for (CClass cClass : cClassList){
                                    comboBox2.addItem(cClass);
                                }
                            }
                        }
                    }
                });

                comboBox2.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED){
                            int index = comboBox2.getSelectedIndex();
                            if (index !=0){
                                int classId = comboBox2.getItemAt(index).getId();
                                List<StudentVO> studentList  = ServiceFactory.getStudentServiceInstance().selectByClassId(classId);
                                showStudentTable(studentList);
                            }
                        }
                    }
                });
            }

        });
        初始化数据Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<StudentVO> students = ServiceFactory.getStudentServiceInstance().selectAll();
                showStudentTable(students);
                comboBox1.setSelectedIndex(0);
                comboBox2.removeAllItems();
                CClass tip2 = new CClass();
                tip2.setClassName("请选择班级");
                comboBox2.addItem(tip2);
                List<CClass> cClassList = ServiceFactory.getCClassServiceInstance().selectAll();
                for (CClass cClass : cClassList) {
                    comboBox2.addItem(cClass);
                }

                stuAvatarLabel.setText("");
                stuIdLabel.setText("");
                stuDepLabel.setText("");
                stuClassLabel.setText("");
                stuNameLabel.setText("");
                stuGenderLabel.setText("");
                stuAddressField.setText("");
                stuBirthdayLabel.setText("");
                stuPhoneField.setText("");

            }
        });
        搜索Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keywords =  searchField.getText().trim();
                List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectByKeywords(keywords);
                if (studentList != null){
                    showStudentTable(studentList);
                }
            }
        });

        新增学生Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               new AddStudentFrame(AdminMainFrame.this);
               AdminMainFrame.this.setEnabled(true);
            }
        });
        奖惩管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel,"Card4");
                List<StudentRewards> studentList= ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field.getText());
                List<StudentPunishments> studentPunishments= ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field.getText());
                showRewards(studentList);
                showPunishments(studentPunishments);
            }
        });
        rp搜索Field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rp搜索Field.setText(" ");
            }
        });

        搜索Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int m = ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field.getText()).size();
                int n = ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field.getText()).size();
                if (m != 0 & n != 0){
                    String id =rp搜索Field.getText().trim();
                    List<StudentRewards> studentList= ServiceFactory.getStudentServiceInstance().selectRewardsById(id);
                    List<StudentPunishments> studentPunishmentsList= ServiceFactory.getStudentServiceInstance().selectPunishmentsById(id);
                    if (studentList!=null){
                        showRewards(studentList);
                        showPunishments(studentPunishmentsList);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "查无此学生", null, JOptionPane.ERROR_MESSAGE);
                    try {
                        Thread.sleep(800);
                        rp搜索Field.setText("请输入你要查询的学生姓名或者学号");
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        });


        刷新Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<StudentRewards> studentList= ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field.getText());
                List<StudentPunishments> studentPunishments= ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field.getText());
                showRewards(studentList);
                showPunishments(studentPunishments);
            }
        });



        comboBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox3.getSelectedIndex();
                if (index == 1){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 2){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 3){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 4){
                    奖励增加完成Button.setVisible(true);
                }
                if (index == 5){
                    奖励增加完成Button.setVisible(true);
                }
            }
        });

        comboBox4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox4.getSelectedIndex();
                if (index ==1){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==2){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==3){
                    惩处记录增加完成Button.setVisible(true);
                }
                if (index ==4){
                    惩处记录增加完成Button.setVisible(true);
                }
            }
        });

        comboBox5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int index = comboBox5.getSelectedIndex();
                if (index == 1){
                    comboBox3.setVisible(true);
                    timeBtn.setVisible(true);
                }
                if (index == 2){
                    comboBox4.setVisible(true);
                    timeBtn.setVisible(true);
                }
            }
        });


        奖励增加完成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "奖励增加完成 ", null, JOptionPane.INFORMATION_MESSAGE);
                StudentRewards rewards = new StudentRewards();
                rewards.setPrimaryId(ServiceFactory.getStudentServiceInstance().countRewards()+1);
                rewards.setId(rp搜索Field.getText());
                int index = comboBox3.getSelectedIndex();
                if (index == 1){
                    rewards.setRewards("优秀团员");
                }
                if (index == 2){
                    rewards.setRewards("优秀班干部");
                }
                if (index == 3){
                    rewards.setRewards("优秀");
                }
                if (index == 4){
                    rewards.setRewards("优秀");
                }
                if (index == 5){
                    rewards.setRewards("优秀");
                }
                rewards.setRewardsDate((Date) datepick.getValue());
                try {
                    ServiceFactory.getStudentServiceInstance().insertRewards(rewards);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                rewardsPanel.revalidate();
                comboBox3.setVisible(false);
                timeBtn.setVisible(false);
                奖励增加完成Button.setVisible(false);
            }
        });

        惩处记录增加完成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "惩处记录增加完成 ", null, JOptionPane.INFORMATION_MESSAGE);

                StudentPunishments punishments = new StudentPunishments();
                punishments.setPrimaryId(ServiceFactory.getStudentServiceInstance().countPunishments()+1);
                punishments.setId(rp搜索Field.getText());
                int index = comboBox4.getSelectedIndex();
                if (index == 1){
                    punishments.setPunishments("记过");
                }
                if (index == 2){
                    punishments.setPunishments("记大过");
                }
                if (index == 3){
                    punishments.setPunishments("处分");
                }
                if (index == 4){
                    punishments.setPunishments("开除");
                }
                punishments.setPunishmentsDate((Date) datepick.getValue());
                try {
                    ServiceFactory.getStudentServiceInstance().insertPunishments(punishments);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                punishmentsPanel.revalidate();
                comboBox4.setVisible(false);
                timeBtn.setVisible(false);
                惩处记录增加完成Button.setVisible(false);



            }
        });




        更改奖惩信息Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = JOptionPane.showInputDialog("请输入管理员密码");
                if (inputValue.equals("123456") == true) {
                    JOptionPane.showMessageDialog(null, "密码正确", "输入正确", JOptionPane.INFORMATION_MESSAGE);
                    奖励TextArea.setEditable(true);
                    惩罚TextArea.setEditable(true);
                    修改完成Button.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误", "输入错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        修改完成Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                奖励TextArea.setEditable(false);
                惩罚TextArea.setEditable(false);
                StudentVO1 studentVO1 = new StudentVO1();
                studentVO1.setId(ServiceFactory.getStudentServiceInstance().selectByStudentId(rp搜索Field.getText().trim()).getId());
                System.out.println(rp搜索Field.getText());
                studentVO1.setRewards(奖励TextArea.getText());
                studentVO1.setPunishments(惩罚TextArea.getText());
                int n = ServiceFactory.getStudentServiceInstance().updateStudentRp(studentVO1);
                奖励TextArea.repaint();
                惩罚TextArea.repaint();
                if (n == 0) {
                    JOptionPane.showMessageDialog(null, "已修改", null, JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }

    /**
     * 自定义一个showDepartments方法，用来读取后台数据并展示在界面
     */
    private void showDepartments() {
        //移除原有数据
        contentPanel.removeAll();
        //从service层获取到所有院系列表
        List<Map> departmentList = ServiceFactory.getDepartmentServiceImpl().selectDepartmentInfo();
        int len = departmentList.size();
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        GridLayout gridLayout = new GridLayout(row, 4, 15, 15);
        contentPanel.setLayout(gridLayout);
        for (Map map : departmentList) {
            //给每个院系对象创建一个面板
            Department department = (Department) map.get("department");
            int classCount = (int) map.get("classCount");
            int studentCount = (int) map.get("studentCount");
            JPanel depPanel = new JPanel();
            //删除功能键
            delBtn = new JButton("删除");
            delBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int n = JOptionPane.showConfirmDialog(null,
                            "确认删除吗",
                            "警告！",JOptionPane.YES_NO_OPTION);
                    if (n == YES_OPTION){
                        contentPanel.remove(depPanel);
                        contentPanel.repaint();
                        ServiceFactory.getDepartmentServiceImpl().
                                deledeDepartment(department.getId());

                    }
                }
            });

            depPanel.setPreferredSize(new Dimension(200, 200));
            //将院系名称设置给面板标题
            depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个Label用来放置院系logo，并指定大小
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' width=200 height=200/></html>");
            //图标标签加入院系面板
            depPanel.add(logoLabel);




            JLabel infoLabel = new JLabel("班级" + classCount + "个,学生" + studentCount + "人");
            //院系面板加入主体内容面板
            depPanel.add(infoLabel,BorderLayout.SOUTH);
            depPanel.add(delBtn,BorderLayout.EAST);
            contentPanel.add(depPanel);

            //刷新主体内容面板
            contentPanel.revalidate();
        }

        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
    }
    private void showClassPanel(){
        List<Department> departmentList = ServiceFactory.getDepartmentServiceImpl().selectAll();
        showCombobox(departmentList);
        showTree(departmentList);
        showClasses(departmentList);

    }
    private void showCombobox(List<Department> departmentList){
        for (Department department : departmentList) {
            depComboBox.addItem(department);
        }

    }
    private void showTree(List<Department> departmentList){
        treePanel.removeAll();
        //左侧根节点
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("南工院");
        for (Department department:departmentList) {
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            top.add(group);
            List<CClass> classList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            for (CClass cClass:classList) {
                int num = ServiceFactory.getStudentServiceInstance().countStudentByClassId(cClass.getId());
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(cClass.getClassName() + "  :" + num + "人");
                group.add(node);
            }
        }
        final  JTree tree = new JTree(top);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑",Font.PLAIN,20));
        treePanel.add(tree);
        treePanel.revalidate();

    }
    private void showClasses(List<Department> departmentList){
        classContentPanel.removeAll();
        Font titleFont = new Font("微软雅黑",Font.PLAIN,22);
        for (Department department:departmentList) {
            ImgPanel depPanel = new ImgPanel();
            depPanel.setFileName("12.jpeg");
            depPanel.repaint();
            depPanel.setPreferredSize(new Dimension(350,500));
            depPanel.setLayout(null);
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setBounds(130,15,200,30);
            //获取这个院系的所有班级
            List<CClass> classList = ServiceFactory.getCClassServiceInstance().selectByDepartmentId(department.getId());
            //数据模型
            DefaultListModel listModel = new DefaultListModel();
            //遍历班级集合，依次加入数据模型
            for (CClass cClass:classList) {
                listModel.addElement(cClass);
            }
            //使用数据模型创建一个JList组件
            JList<CClass> jList = new JList<>(listModel);
            //JList加入滚动面板
            JScrollPane listScrollPane = new JScrollPane(jList);
            listScrollPane.setBounds(90,120,200,260);
            depPanel.add(depNameLabel);
            depPanel.add(listScrollPane);
            classContentPanel.add(depPanel);
           //对每个JList增加弹出菜单
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item1 = new JMenuItem("修改");
            JMenuItem item2 = new JMenuItem("删除");
            jPopupMenu.add(item1);
            jPopupMenu.add(item2);
            jList.add(jPopupMenu);
            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //选中项的下标
                    int index = jList.getSelectedIndex();
                    //点击鼠标右键
                    if (e.getButton() == 3){
                        //在鼠标位置弹出菜单
                        jPopupMenu.show(jList,e.getX(),e.getY());
                        //取出选中选项项数据
                        CClass cClass = jList.getModel().getElementAt(index);
                        //对删除菜单项添加监听
                        item2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int choice = JOptionPane.showConfirmDialog(depPanel,"确定删除吗");
                                if (choice ==0){
                                    ServiceFactory.getCClassServiceInstance().deledeClassById(cClass.getId());
                                    listModel.remove(index);
                                    showClassPanel();
                                }
                            }
                        });
                    }
                }
            });


        }



    }
    public void showStudentTable(List<StudentVO> studentList){
        tablePanel.removeAll();

//        List<StudentVO> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
        JTable table = new JTable();
//        table.setBackground(new Color(0,0,0));

        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"学号", "院系", "班级", "姓名", "性别",
                "地址", "手机号", "出生日期", "头像"});
        for (StudentVO student : studentList) {
            Object[] objects = new Object[]{
                    student.getId(), student.getDepartmentName(), student.getClassName(),
                    student.getStudentName(), student.getGender(), student.getAddress(),
                    student.getPhone(), student.getBirthday(), student.getAvatar()
            };
            model.addRow(objects);
            TableColumn tc = table.getColumnModel().getColumn(8);
            tc.setMinWidth(0);
            tc.setMaxWidth(0);
            JTableHeader header = table.getTableHeader();
            DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
            hr.setHorizontalAlignment(JLabel.CENTER);
            header.setDefaultRenderer(hr);
            header.setPreferredSize(new Dimension(header.getWidth(), 40));
            header.setFont(new Font("微软雅黑", 0, 22));
            table.setRowHeight(35);
            DefaultTableCellHeaderRenderer r = new DefaultTableCellHeaderRenderer();
            r.setHorizontalAlignment(JLabel.CENTER);
            table.setDefaultRenderer(Object.class, r);
            JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            table.setBackground(new Color(62, 134, 160));

            tablePanel.add(scrollPane);
            tablePanel.revalidate();

            //弹出菜单
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item = new JMenuItem("删除");
            jPopupMenu.add(item);
            table.add(jPopupMenu);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    row = table.getSelectedRow();
                    stuIdLabel.setText(table.getValueAt(row, 0).toString());
                    stuDepLabel.setText(table.getValueAt(row, 1).toString());
                    stuClassLabel.setText(table.getValueAt(row, 2).toString());
                    stuNameLabel.setText(table.getValueAt(row, 3).toString());
                    stuGenderLabel.setText(table.getValueAt(row, 4).toString());
                    stuAddressField.setText(table.getValueAt(row, 5).toString());
                    stuPhoneField.setText(table.getValueAt(row, 6).toString());
                    stuBirthdayLabel.setText(table.getValueAt(row, 7).toString());
                    stuAvatarLabel.setText("<html><img src='" + table.getValueAt(row, 8).toString() + "' width=200 height=200/></html>");
                    编辑Button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getActionCommand().equals("编辑")) {
                                stuAddressField.setEditable(true);
                                stuAddressField.setEnabled(true);
                                stuPhoneField.setEditable(true);
                                stuPhoneField.setEnabled(true);
                                编辑Button.setText("保存");
                            }
                            if (e.getActionCommand().equals("保存")) {
                                Student student = new Student();
                                student.setId(stuIdLabel.getText());
                                student.setPhone(stuPhoneField.getText());
                                student.setAddress(stuAddressField.getText());
                                int n = 0;
                                try {
                                    n = ServiceFactory.getStudentServiceInstance().updateStudent(student);
                                } catch (SQLException e1) {
                                    e1.printStackTrace();
                                }
                                if (n == 1) {
                                    model.setValueAt(stuAddressField.getText(), row, 5);
                                    model.setValueAt(stuPhoneField.getText(), row, 6);
                                    stuAddressField.setEditable(false);
                                    stuAddressField.setEnabled(false);
                                    stuPhoneField.setEditable(false);
                                    stuPhoneField.setEnabled(false);
                                    编辑Button.setText("编辑");

                                }
                            }
                        }
                    });
                    if (e.getButton() == 3) {
                        jPopupMenu.show(table, e.getX(), e.getY());
                    }
                }
            });
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = (String) table.getValueAt(row,0);
                    int choice = JOptionPane.showConfirmDialog(tablePanel, "确认删除吗");
                    if (choice == 0) {
                        if (row != -1) {
                            model.removeRow(row);
                        }
                        try {
                            ServiceFactory.getStudentServiceInstance().deleteById(id);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }

    }

    private void showRewards(List<StudentRewards> studentList){
        Font font = new Font("微软雅黑",Font.BOLD,18);
        //移除原有数据
        rewardsPanel.removeAll();
        for (StudentRewards student : studentList){
            姓名Label.setText("姓名："+student.getStudentName());
            性别Label.setText("性别："+student.getGender());
            班级Label.setText("班级："+student.getClassName());
            院系Label.setText("院系："+student.getDepartmentName());
        }
        List<StudentRewards> rewardsList = ServiceFactory.getStudentServiceInstance().selectRewardsById(rp搜索Field.getText());
        int len = rewardsList.size();
        int row = len % 1== 0 ? len / 1 : len / 1 + 1;
        GridLayout gridLayout = new GridLayout(row, 1, 0, 15);
        rewardsPanel.setLayout(gridLayout);
        for (StudentRewards studentRewards : rewardsList) {
            //给每个院系对象创建一个面板
            JPanel allPanel = new JPanel();

            allPanel.setPreferredSize(new Dimension(300, 400));
            //将院系名称设置给面板标题
            allPanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(studentRewards.getRewardsDate())));
            JLabel jLabel = new JLabel(studentRewards.getRewards());
            allPanel.add(jLabel);
            rewardsPanel.add(allPanel);
            //刷新主体内容面板
            rewardsPanel.revalidate();

        }
    }

    private void showPunishments(List<StudentPunishments> studentList){
        Font font = new Font("微软雅黑",Font.BOLD,18);
        punishmentsPanel.removeAll();
        List<StudentPunishments> punishmentsList = ServiceFactory.getStudentServiceInstance().selectPunishmentsById(rp搜索Field.getText());
        int len = punishmentsList.size();
        int row = len % 1== 0 ? len / 1 : len / 1 + 1;
        GridLayout gridLayout = new GridLayout(row, 1, 0, 15);
        punishmentsPanel.setLayout(gridLayout);
        for (StudentPunishments studentPunishments : punishmentsList) {
            //给每个院系对象创建一个面板
            JPanel rightPanel = new JPanel();
//
            rightPanel.setPreferredSize(new Dimension(300, 400));
            //将院系名称设置给面板标题
            rightPanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(studentPunishments.getPunishmentsDate())));
            JLabel jLabel = new JLabel(studentPunishments.getPunishments());
            rightPanel.add(jLabel);
            punishmentsPanel.add(rightPanel);
            //刷新主体内容面板
            punishmentsPanel.revalidate();
            rightPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int n = JOptionPane.showConfirmDialog(null,"确认删除吗？","警告",JOptionPane.YES_NO_OPTION);
                    if (n == YES_OPTION){
                        punishmentsPanel.remove(rightPanel);
                        punishmentsPanel.repaint();
                        ServiceFactory.getStudentServiceInstance().deletePunishmentsByPrimaryId(studentPunishments.getPrimaryId());
                        punishmentsPanel.revalidate();
                    }
                }
            });
        }
    }

    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = { 1, 3, 5, 7 };
        int[] disabledDays = { 4, 6, 5, 9 };
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
        datepick.setLocation(137, 83);//设置起始位置
    /*
    //也可用setBounds()直接设置大小与位置
    datepick.setBounds(137, 83, 177, 24);
    */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CANADA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }










    public static void main(String[] args) throws Exception {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        new AdminMainFrame(new Admin());
    }
}
