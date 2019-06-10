package com.sm.entity;

public class StudentVO1 {
    private String id;
    private String departmentName;
    private String className;
    private String studentName;
    private String gender;
    private String rewards;
    private String punishments;

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

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getPunishments() {
        return punishments;
    }

    public void setPunishments(String punishments) {
        this.punishments = punishments;
    }

    @Override
    public String toString() {
        return "StudentVO1{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", className='" + className + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", rewards='" + rewards + '\'' +
                ", punishments='" + punishments + '\'' +
                '}';
    }
}
