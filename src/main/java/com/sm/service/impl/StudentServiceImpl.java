package com.sm.service.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.*;
import com.sm.factory.DAOFactory;
import com.sm.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
    @Override
    public List<StudentVO> selectAll() {
        List<StudentVO> students = null;
        try {
            students = studentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentVO> selectByDepartmentId(int departmentId) {
        List<StudentVO> students = null;
        try {
            students = studentDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentVO> selectByClassId(int ClassId) {
        List<StudentVO> students = null;
        try {
            students = studentDAO.selectByClassId(ClassId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;    }

    @Override
    public List<StudentVO> selectByKeywords(String keywords) {
        List<StudentVO> students = null;
        try {
            students = studentDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentRewards> selectRewardsById(String id) {
        List<StudentRewards> rewards = null;
        try {
            rewards= studentDAO.selectRewardsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rewards;    }

    @Override
    public List<StudentPunishments> selectPunishmentsById(String id) {
        List<StudentPunishments> studentPunishments = null;
        try {
            studentPunishments= studentDAO.selectPunishmentsById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentPunishments;    }

    @Override
    public List<StudentPunishments> selectPunishmentsByPrimaryId(int primaryId) {
        List<StudentPunishments> studentPunishments = null;
        try {
            studentPunishments= studentDAO.selectPunishmentsByPrimaryId(primaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentPunishments;    }

    @Override
    public List<StudentVO> selectStudentById(String id) {
        List<StudentVO> studentVOList = null;
        try {
            studentVOList= studentDAO.selectStudentById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVOList;
    }

    @Override
    public List<StudentRewards> selectAllRewards() {
        List<StudentRewards> studentList = null;
        try {
            studentList = studentDAO.selectAllRewards();
        } catch (SQLException e) {
            System.err.print("查询学生得奖信息出现异常");
        }
        return studentList;    }

    @Override
    public List<StudentPunishments> selectAllPunishments() {
        List<StudentPunishments> studentList = null;
        try {
            studentList = studentDAO.selectAllPunishments();
        } catch (SQLException e) {
            System.err.print("查询学生得奖信息出现异常");
        }
        return studentList;
    }

    @Override
    public void deleteStudent(String id) {
        try {
            studentDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deletePunishmentsByPrimaryId(int primaryId) {
        try {
            studentDAO.deletePunishmentsByPrimaryId(primaryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int updateStudent(Student student) {
        int n = 0;
        try {
            n = studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteById(String id)  {
        int n = 0;
        try {
            n = studentDAO.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertStudent(Student student) {
        int n = 0;
        try {
            n = studentDAO.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countStudentByClassId(int classId) {
        int n = 0;
        try {
            n = studentDAO.countByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countStudent(int departmentId) {
        int n = 0;
        try {
            n = studentDAO.countByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countPunishments() {
        int n = 0;
        try {
            n=studentDAO.countPunishments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countRewards() {
        int n = 0;
        try {
            n=studentDAO.countRewards();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }


    @Override
    public int insertRewards(StudentRewards rewards) throws SQLException {
        int n = 0;
        try {
            n=studentDAO.insertRewards(rewards);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertPunishments(StudentPunishments punishments) throws SQLException {
        int n = 0;
        try {
            n=studentDAO.insertPunishments(punishments);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<StudentVO1> selectByWords(String words) {
        List<StudentVO1> students = null;
        try {
            students = studentDAO.selectByWords(words);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentVO1> selectById(String id) {
        List<StudentVO1> students = null;
        try {
            students = studentDAO.selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<StudentVO1> selectBody() {
        List<StudentVO1> studentList = null;
        try {
            studentList = studentDAO.selectBody();
        } catch (SQLException e) {
            System.err.print("查询学生信息出现异常");
        }
        return studentList;
    }

    @Override
    public int updateStudentRp(StudentVO1 student) {
        try {
            studentDAO.updateStudentRp(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public StudentVO1 selectByStudentId(String name) {
        StudentVO1 studentVO1 = null;
        try {
            studentVO1 = studentDAO.selectByStudentId(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVO1;
    }
}


