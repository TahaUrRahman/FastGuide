package com.i170196_i170032_i170263.fastguide;

public class ProfessorModel {
    String ProfessorName,ProfessorCourse;

    public ProfessorModel(String professorName, String professorCourse) {
        ProfessorName = professorName;
        ProfessorCourse = professorCourse;
    }

    public String getProfessorName() {
        return ProfessorName;
    }

    public void setProfessorName(String professorName) {
        ProfessorName = professorName;
    }

    public String getProfessorCourse() {
        return ProfessorCourse;
    }

    public void setProfessorCourse(String professorCourse) {
        ProfessorCourse = professorCourse;
    }

}
