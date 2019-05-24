package com.sm.service;

import com.sm.entity.CClass;
import com.sm.entity.Department;

import java.util.List;

public interface CClassService {
    List<CClass> selectByDepartmentId(int departmentId);

    void deledeClassById(int id);

    int insertClass(CClass cClass);
}
