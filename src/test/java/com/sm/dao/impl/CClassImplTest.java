package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CClassImplTest {
    CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    @Test
    public void selectByDepartmentId() {
        try {
            System.out.println(cClassDAO.selectByDepartmentId(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}