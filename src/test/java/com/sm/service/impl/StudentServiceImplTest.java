package com.sm.service.impl;

import com.sm.entity.Student;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.sql.SQLException;

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
}