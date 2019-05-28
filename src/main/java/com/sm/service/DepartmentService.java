package com.sm.service;
import com.sm.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Department> selectAll();
    void deledeDepartment(int id);
    /**
     * 新增院系
     * @param department
     * @return int
     */
    int addDepartment(Department department);

    /**
     * 获取所有院系得完整信息（包括每个学院得自身信息，班级数，学生数）
     * @return
     */
    List<Map> selectDepartmentInfo();
}