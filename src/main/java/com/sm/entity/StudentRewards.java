package com.sm.entity;



import java.util.Date;

public class StudentRewards {
    private Integer primaryId;
    private String id;
    private String departmentName;
    private String className;
    private String studentName;
    private Date rewardsDate;
    private String gender;
    private String rewards;

    @Override
    public String toString() {
        return "StudentRewards{" +
                "primaryId=" + primaryId +
                ", id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", className='" + className + '\'' +
                ", studentName='" + studentName + '\'' +
                ", rewardsDate=" + rewardsDate +
                ", gender='" + gender + '\'' +
                ", rewards='" + rewards + '\'' +
                '}';
    }

    public Date getRewardsDate() {
        return rewardsDate;
    }

    public void setRewardsDate(Date rewardsDate) {
        this.rewardsDate = rewardsDate;
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

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

}
