package com.i170196_i170032_i170263.fastguide;

public class CourseModel {
    int CourseID;
    String CourseName,DepartmentName;

    public CourseModel() {

    }

    public CourseModel(int courseID, String courseName, String departmentName) {
        CourseName = courseName;
        CourseID = courseID;
        DepartmentName = departmentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}