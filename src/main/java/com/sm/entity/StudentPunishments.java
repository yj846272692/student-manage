package com.sm.entity;

import java.util.Date;

public class StudentPunishments {
    private Integer primaryId;
    private String id;
    private String departmentName;
    private String className;
    private String studentName;
    private String gender;
    private String punishments;
    private Date punishmentsDate;

    @Override
    public String toString() {
        return "StudentPunishments{" +
                "primaryId=" + primaryId +
                ", id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", className='" + className + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", punishments='" + punishments + '\'' +
                ", punishmentsDate=" + punishmentsDate +
                '}';
    }

    public Integer getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPunishments() {
        return punishments;
    }

    public void setPunishments(String punishments) {
        this.punishments = punishments;
    }

    public Date getPunishmentsDate() {
        return punishmentsDate;
    }

    public void setPunishmentsDate(Date punishmentsDate) {
        this.punishmentsDate = punishmentsDate;
    }
}
