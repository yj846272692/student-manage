package com.sm.dao.impl;



import com.sm.dao.CClassDAO;
import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


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
}