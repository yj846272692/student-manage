package com.sm.dao.impl;



import com.sm.dao.CClassDAO;
import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentPunishments;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO1;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class StudentDAOImplTest {
    StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Test
    public void selectAll() {
        try {
            System.out.println(studentDAO.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void selectByDepartmentId() {
        try {
            System.out.println(studentDAO.selectByDepartmentId(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void selectByKeywords() {
        try {
            System.out.println(studentDAO.selectByKeywords("江苏"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectByClassId() {

        try {
            System.out.println(studentDAO.selectByClassId(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById() throws SQLException {
        System.out.println(studentDAO.deleteById("1"));


    }

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student();
        student.setId("2");
        student.setAddress("湖北");
        student.setPhone("18854125691");
        studentDAO.updateStudent(student);
    }


    @Test
    public void insertStudent() throws SQLException {
        Student student = new Student();
        student.setId("1802345767");
        student.setClassId(2);
        student.setStudentName("三三");
        student.setAvatar(null);
        student.setBirthday(new Date());
        student.setGender("男");
        student.setAddress("江苏南京");
        student.setPhone("18475155744");
        studentDAO.insertStudent(student);
    }

    @Test
    public void countByDepartmentId() throws SQLException {
        System.out.println(studentDAO.countByDepartmentId(1));
    }

    @Test
    public void updateStudentRp() throws SQLException {
        StudentVO1 studentVO1 = new StudentVO1();
        studentVO1.setId("1802343301");
        studentVO1.setRewards("1231wqeq23");
        studentVO1.setPunishments("2123132");
        studentDAO.updateStudentRp(studentVO1);
    }

    @Test
    public void selectByStudentId() throws SQLException {
        StudentVO1 studentVO1 = studentDAO.selectByStudentId("一号");
        System.out.println(studentVO1);

    }

    @Test
    public void selectAll1() {
    }

    @Test
    public void selectByDepartmentId1() {
    }

    @Test
    public void selectByClassId1() {
    }

    @Test
    public void selectByKeywords1() {
    }

    @Test
    public void selectAllRewards() {
    }

    @Test
    public void selectAllPunishments() {
    }

    @Test
    public void selectPunishmentsByPrimaryId() {
    }

    @Test
    public void selectStudentById() {
    }

    @Test
    public void selectRewardsById() {
    }

    @Test
    public void selectPunishmentsById() {
    }

    @Test
    public void insertRewards() throws SQLException {
        StudentRewards rewards = new StudentRewards();
        rewards.setPrimaryId(6);
        rewards.setId("1802343301");
        rewards.setRewards("先进个人");
        rewards.setRewardsDate(new Date(2018-06-06));
        int n = studentDAO.insertRewards(rewards);
        assertEquals(1,n);
    }

    @Test
    public void insertPunishments() throws SQLException {
        StudentPunishments punishments = new StudentPunishments();
        punishments.setPrimaryId(3);
        punishments.setId("1802343301");
        punishments.setPunishments("惩罚");
        punishments.setPunishmentsDate(new Date(2018-06-06));
        int n = studentDAO.insertPunishments(punishments);
        assertEquals(1,n);
    }

    @Test
    public void deletePunishmentsByPrimaryId() {
    }

    @Test
    public void countPunishments() throws SQLException {
        int n = studentDAO.countPunishments();
        System.out.println(n);
    }

    @Test
    public void countRewards() throws SQLException {
        int n = studentDAO.countRewards();
        System.out.println(n);
    }

    @Test
    public void deleteById1() {
    }

    @Test
    public void updateStudent1() {
    }

    @Test
    public void insertStudent1() {
    }

    @Test
    public void batchInsertStudent() {
    }

    @Test
    public void countByDepartmentId1() {
    }

    @Test
    public void countByClassId() {
    }

    @Test
    public void selectBody() {
    }

    @Test
    public void selectById() {
    }

    @Test
    public void selectByWords() {
    }

    @Test
    public void updateStudentRp1() {
    }

    @Test
    public void selectByStudentId1() {
    }
}