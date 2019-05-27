package com.sm.dao;

import com.sm.entity.CClass;
import com.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * 班级DAO接口
 */

public interface CClassDAO {
    /**
     * 按照院系id查询班级
     * @param departmentId
     * @return List<CClass>
     * @throws SQLException
     */
    List<CClass> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 删除班级
     * @return int
     * @throws SQLException
     */
    int deleteClassById(int id) throws  SQLException;

    /**
     * 新增班级
     * @param cClass
     * @return int
     * @throws SQLException
     */
    int insertClass(CClass cClass) throws SQLException;

    /**
     * 查询所有班级
     * @return List<CClass>
     * @throws SQLException
     */
    List<CClass> selectAll()throws SQLException;

}
