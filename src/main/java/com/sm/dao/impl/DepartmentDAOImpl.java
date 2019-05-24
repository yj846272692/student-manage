package com.sm.dao.impl;

import com.sm.dao.DepartmentDAO;
import com.sm.entity.Department;
import com.sm.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> getAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "SELECT * FROM t_department ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLogo(rs.getString("logo"));
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return departmentList;
    }

    @Override
    public int deleteDepartments(Integer id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE FROM t_department WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        return pstmt.executeUpdate();


    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_department (department_name,logo) VALUES (?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, department.getDepartmentName());
        pstmt.setString(2, department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}