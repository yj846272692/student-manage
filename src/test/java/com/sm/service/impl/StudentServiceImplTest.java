package com.sm.service.impl;

import com.sm.entity.Student;
import com.sm.entity.StudentRewards;
import com.sm.entity.StudentVO1;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    StudentService studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void selectAll() {
        System.out.println(studentService.selectAll());
    }

    @Test
    public void selectByDepartmentId() {
        System.out.println(studentService.selectByClassId(1));
    }

    @Test
    public void selectByClassId() {
        System.out.println(studentService.selectByClassId(1));
    }

    @Test
    public void selectByKeywords() {
        System.out.println(studentService.selectByKeywords("江苏"));
    }

    @Test
    public void updateStudent() throws SQLException {
        Student student = new Student();
        student.setId("4");
        student.setAddress("湖北");
        student.setPhone("18854125691");
        studentService.updateStudent(student);

    }

    @Test
    public void deleteById() {

        try {
            studentService.deleteById("2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertStudent() throws SQLException {
        Student student = new Student();
        student.setId("1802345311");
        student.setClassId(2);
        student.setStudentName("丝丝");
        System.out.println(" ");
        student.setAvatar(null);
        student.setBirthday(new Date());
        student.setGender("女");
        student.setAddress("江苏南京");
        student.setPhone("18475155744");
        studentService.insertStudent(student);
    }

    @Test
    public void updateStudentRp() {
        StudentVO1 studentVO1 = new StudentVO1();
        studentVO1.setId("1802343301");
        studentVO1.setRewards("2131323213321");
        studentVO1.setPunishments("21312");
        studentService.updateStudentRp(studentVO1);
    }

    @Test
    public void selectByStudentId() {
        StudentVO1 studentVO1 = studentService.selectByStudentId("一号");
        System.out.println(studentVO1.getId());


    }

    @Test
    public void countPunishments() {
        int n = studentService.countPunishments();
        System.out.println(n);

    }

    @Test
    public void countRewards() {
    }

    @Test
    public void insertRewards() throws SQLException {
        StudentRewards rewards = new StudentRewards();
        rewards.setPrimaryId(5);
        rewards.setId("1802343301");
        rewards.setRewardsDate(new Date(2012-02-12));
        rewards.setRewards("优秀团支书");
        studentService.insertRewards(rewards);

    }

    @Test
    public void insertPunishments() {
    }
}