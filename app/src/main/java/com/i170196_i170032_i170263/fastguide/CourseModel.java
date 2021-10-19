package com.i170196_i170032_i170263.fastguide;

public class CourseModel {
    String CourseName,DepartmentName;

    public CourseModel(String courseName, String departmentName) {
        CourseName = courseName;
        DepartmentName = departmentName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }
}
