package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CClassDAOImplTest {
    CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    @Test
    public void deleteClassById() throws SQLException {
        System.out.println(cClassDAO.deleteClassById(14));
    }

    @Test
    public void insertClass() {
        CClass cClass = new CClass();
        cClass.setDepartmentId(16);
       cClass.setClassName("1111");

        try {
            int n = cClassDAO.insertClass(cClass);
            assertEquals(1, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
        try {
            System.out.println(cClassDAO.selectAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countByDepartmentId() {
        try {
            System.out.println(cClassDAO.countByDepartmentId(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}