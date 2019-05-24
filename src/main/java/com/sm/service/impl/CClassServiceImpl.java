package com.sm.service.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.factory.DAOFactory;
import com.sm.service.CClassService;

import java.sql.SQLException;
import java.util.List;

public class CClassServiceImpl implements CClassService {
    private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    @Override
    public List<CClass> selectByDepartmentId(int departmentId) {
        List<CClass> classList = null;
        try {
            classList = cClassDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classList;
    }

    @Override
    public void deledeClassById(int id) {
        try {
            cClassDAO.deleteClassById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertClass(CClass cClass) {
        int n = 0;
        try {
            cClassDAO.insertClass(cClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }


}
