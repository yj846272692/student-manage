package com.sm.dao;

import com.sm.entity.*;

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


    List<StudentRewards> selectAllRewards() throws SQLException;

    List<StudentPunishments> selectAllPunishments() throws SQLException;
    List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId) throws SQLException;
    List<StudentVO> selectStudentById(String id)throws SQLException;
    List<StudentRewards> selectRewardsById(String id) throws  SQLException;
    List<StudentPunishments> selectPunishmentsById(String id) throws  SQLException; int insertRewards(StudentRewards rewards)throws SQLException;

    int insertPunishments(StudentPunishments punishments) throws SQLException;

    int deletePunishmentsByPrimaryId(int primaryId) throws SQLException;

    int countPunishments() throws SQLException;
    int countRewards() throws SQLException;

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

    /**
     * 新增学生
     * @param student
     * @return
     * @throws SQLException
     */
    int insertStudent(Student student) throws SQLException;

    /**
     * 批量导入
     * @param studentList
     * @return
     * @throws SQLException
     */
    int batchInsertStudent(List<Student> studentList) throws  SQLException;

    /**
     * 根据院系ID统计学生人数
     * @param departmentId
     * @return
     * @throws SQLException
     */
    int countByDepartmentId(int departmentId) throws  SQLException;

    /**
     * 根据班级Id统计学生人数
     *
     * @param classId
     * @return int
     * @throws SQLException
     */
    int countByClassId(int classId) throws SQLException;


    /**
     * 奖惩模块
     */

    List<StudentVO1> selectBody() throws SQLException;
    List<StudentVO1> selectById(String id) throws SQLException;
    List<StudentVO1> selectByWords(String words) throws SQLException;
    int updateStudentRp(StudentVO1 student) throws  SQLException;

    StudentVO1 selectByStudentId(String name) throws SQLException;




}
