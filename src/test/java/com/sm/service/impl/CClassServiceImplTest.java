package com.sm.service.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.factory.DAOFactory;
import com.sm.factory.ServiceFactory;
import com.sm.service.CClassService;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CClassServiceImplTest {
    CClassService cClassService = ServiceFactory.getCClassServiceInstance();

    @Test
    public void selectByDepartmentId() {
        System.out.println(cClassService.selectByDepartmentId(4));
    }

    @Test
    public void deledeClassById() {
        int id = 13;
        cClassService.deledeClassById(13);
    }

    @Test
    public void insertClass() {
        CClass cClass = new CClass();
        cClass.setDepartmentId(16);
        cClass.setClassName("2222");
        int n = cClassService.insertClass(cClass);

    }
}