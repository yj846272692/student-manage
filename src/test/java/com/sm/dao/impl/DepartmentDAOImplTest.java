package com.sm.dao.impl;

import com.sm.dao.DepartmentDAO;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDAOImplTest {
    private DepartmentDAO departmentDAO = DAOFactory.getDepartmentDAOInstance();

    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departmentList.forEach(department -> System.out.println(department));
    }


    @Test
    public void deleteDepartments1() throws SQLException {
        System.out.println(departmentDAO.deleteDepartments(10));
    }

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://soft1841-20.oss-cn-beijing.aliyuncs.com/img/4f2c199e-50af-4520-9419-5a08fea1d9d4.jpg?Expires=1558508371&OSSAccessKeyId=TMP.AgEa6PtMQP2COltIYbjZKCgLhSqyUelYKG7lkqt093qr2ZA1ySpHi_OiVpQHAAAwLAIUT2GlkhUQePQukELTA_qN7PlFkTECFG36kNZMMnMpAyX68_bRjjTdoMf-&Signature=9dgozvaJbGVlMqpb7aqcyYlrVSc%3D");
        try {
            int n = departmentDAO.insertDepartment(department);
            assertEquals(1, n);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}