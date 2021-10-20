package com.i170196_i170032_i170263.fastguide;

public class ReviewSummaryModel {
    String StudentName, StudentReview;

    public ReviewSummaryModel(String studentName, String studentReview) {
        StudentName = studentName;
        StudentReview = studentReview;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentReview() {
        return StudentReview;
    }

    public void setStudentReview(String studentReview) {
        StudentReview = studentReview;
    }
}



