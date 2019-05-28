package com.sm.service;

import com.sm.entity.Student;
import com.sm.entity.StudentVO;

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



    int updateStudent(Student student) throws SQLException;

    int deleteById(String id) throws SQLException;

    int insertStudent(Student student) throws SQLException;

    /**
     * @param classId
     * @return
     */
    int countStudentByClassId(int classId);



}
