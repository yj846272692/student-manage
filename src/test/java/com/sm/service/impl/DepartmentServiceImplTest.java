package com.sm.service.impl;

import com.sm.entity.Department;
import com.sm.factory.ServiceFactory;
import com.sm.service.DepartmentService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class DepartmentServiceImplTest {

    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceImpl();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(department -> System.out.println(department));
    }



    @Test
    public void deledeDepartment() {
        int id = 11;
        departmentService.deledeDepartment(id);
    }

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://soft1841-20.oss-cn-beijing.aliyuncs.com/img/4f2c199e-50af-4520-9419-5a08fea1d9d4.jpg?Expires=1558508371&OSSAccessKeyId=TMP.AgEa6PtMQP2COltIYbjZKCgLhSqyUelYKG7lkqt093qr2ZA1ySpHi_OiVpQHAAAwLAIUT2GlkhUQePQukELTA_qN7PlFkTECFG36kNZMMnMpAyX68_bRjjTdoMf-&Signature=9dgozvaJbGVlMqpb7aqcyYlrVSc%3D");
        int n = departmentService.addDepartment(department);
        assertEquals(1, n);
    }

    @Test
    public void selectDepartmentInfo() {
        List<Map> mapList = departmentService.selectDepartmentInfo();
        mapList.forEach(map -> {
            System.out.println(map.get("department") + "," + map.get("classCount")+ "个班，" +map.get("studentCount")+ "个学生");
        });
    }
}