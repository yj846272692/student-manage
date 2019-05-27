package com.sm.dao;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    /**
     * 查询所有学生（视图对象）
     * @return  List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectAll() throws SQLException;

    /**
     * 根据院系ID查询所有学生
     * @param departmentId
     * @return List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 根据班级ID查询所有学生
     * @param classID
     * @return List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectByClassId(int classID) throws  SQLException;

    /**
     * 根据关键词模糊查询
     * @param keywords
     * @return List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectByKeywords(String keywords) throws  SQLException;

    /**
     * 根据ID删除学生
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(String id) throws SQLException;

    /**
     * 更新学生信息
     * @param student
     * @return
     * @throws SQLException
     */

    int updateStudent(Student student) throws SQLException;




}