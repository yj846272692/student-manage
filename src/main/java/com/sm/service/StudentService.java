package com.sm.service;

import com.sm.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<StudentVO> selectAll();
    /**
     * @param departmentId
     * @return
     */
    List<StudentVO> selectByDepartmentId(int departmentId);

    /**
     * @param ClassId
     * @return
     */
    List<StudentVO> selectByClassId(int ClassId);

    /**
     * @param keywords
     * @return
     */
    List<StudentVO> selectByKeywords(String keywords);



    List<StudentRewards> selectRewardsById(String  id);

    List<StudentPunishments> selectPunishmentsById(String  id);

    List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId);

    List<StudentVO> selectStudentById(String id);



    List<StudentRewards> selectAllRewards();

    List<StudentPunishments> selectAllPunishments();

    void deleteStudent(String  id);


    void deletePunishmentsByPrimaryId(int primaryId);





    int updateStudent(Student student) throws SQLException;

    int deleteById(String id) throws SQLException;

    int insertStudent(Student student) throws SQLException;

    /**
     * @param classId
     * @return
     */
    int countStudentByClassId(int classId);


    int countStudent(int departmentId);
    int countPunishments();
    int countRewards();
    int insertRewards(StudentRewards rewards)throws SQLException;
    int insertPunishments(StudentPunishments punishments) throws SQLException;


    /**
     * 学生奖惩模块
     * @param words
     * @return
     */
    List<StudentVO1> selectByWords(String words);

    List<StudentVO1> selectById(String id);

    List<StudentVO1> selectBody();

    int updateStudentRp(StudentVO1 student);

    StudentVO1 selectByStudentId(String name) ;



}
