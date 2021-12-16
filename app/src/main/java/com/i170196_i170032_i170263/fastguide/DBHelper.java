package com.i170196_i170032_i170263.fastguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_COURSES = "courses";
    public  static final String COLUMN_ID = "id";
    public static final String COLUMN_COURSENAME = "name";
    public static final String  COLUMN_DEPARTMENTNAME = "receiver";
    public static final String COLUMN_MESSAGE = "message";
    public  static  final String COLUMN_time = "time";

    public DBHelper(@Nullable Context context) {
        super(context, "fastguide.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createQuery1 = "CREATE TABLE " + TABLE_COURSES + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_COURSENAME + " TEXT, " + COLUMN_DEPARTMENTNAME + " TEXT)";
//        String createQuery2 = "CREATE TABLE " + TABLE_CALLS + " (" + CALLS_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CALLS_COLUMN_CALLER + " TEXT, " + CALLS_COLUMN_CALLEE + " TEXT, " + CALLS_COLUMN_TIME + " TEXT )";
        sqLiteDatabase.execSQL(createQuery1);
//        sqLiteDatabase.execSQL(createQuery2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    //------------------------------------------------------------------------Courses Table Methods------------------------------------//
    public boolean addCourse(CourseModel courseModel){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, courseModel.getCourseID());
        cv.put(COLUMN_COURSENAME, courseModel.getCourseName());
        cv.put(COLUMN_DEPARTMENTNAME, courseModel.getDepartmentName());
        long insert = db.insert(TABLE_COURSES, null, cv);
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }
//    public List<CourseModel> getCourses(String sender, String receiver){
//        List<CourseModel> allCourses = new ArrayList<CourseModel>();
//        String query = "Select * from "+TABLE_COURSES+" where "+COLUMN_SENDER+" = ?"+" AND "+COLUMN_receiver+" = ? ";
//        Cursor cursor = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        try {
//            cursor = db.rawQuery(query,new String[]{sender,receiver});
//            if (cursor.moveToFirst()) {
//                do {
//                    int id = cursor.getInt(0);
//                    String sen = cursor.getString(1);
//                    String rec = cursor.getString(2);
//                    String text = cursor.getString(3);
//                    String time = cursor.getString(4);
//                    CourseModel message = new messageModel(sen, rec, text, time);
//                    allCourses.add(message);
//                } while (cursor.moveToNext());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            cursor.close();
//            db.close();
//        }
//        return allCourses;
//    }
    public List<CourseModel> getCourses(){
        List<CourseModel> allCourses = new ArrayList<CourseModel>();
        String query = "Select * from "+TABLE_COURSES;
        Cursor cursor = null;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            cursor = db.rawQuery(query,null);
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    String department = cursor.getString(2);
                    CourseModel course = new CourseModel(id,name, department);
                    allCourses.add(course);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
            db.close();
        }
        return allCourses;
    }
    public void deleteCourses(){
        List<CourseModel> allCourses = new ArrayList<CourseModel>();
        String query = "DELETE  from "+TABLE_COURSES;
        Cursor cursor = null;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            cursor = db.rawQuery(query,null);
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            cursor.close();
            db.close();
        }
    }

//    public List<String> getReceivers(String sender){
//        List<String> allReceivers = new ArrayList<String>();
//        String query = "Select * from "+TABLE_MESSAGES+" where "+COLUMN_SENDER+" = ?";
//        Cursor cursor = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        try {
//            cursor = db.rawQuery(query,new String[]{sender});
//            if (cursor.moveToFirst()) {
//                do {
//                    int id = cursor.getInt(0);
//                    String sen = cursor.getString(1);
//                    String rec = cursor.getString(2);
//                    String text = cursor.getString(3);
//                    String time = cursor.getString(4);
//                    allReceivers.add(rec);
//                } while (cursor.moveToNext());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            cursor.close();
//            db.close();
//        }
//        return allReceivers;
//    }
//    public messageModel getLastMessage(String sender, String receiver){
//        String query = "Select * from "+TABLE_MESSAGES+" where "+COLUMN_SENDER+" = ?"+" AND "+COLUMN_receiver+" = ?"+ " ORDER BY " + COLUMN_ID +" DESC LIMIT 1";
//        Cursor cursor = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        messageModel message = new messageModel(sender,receiver,"...","...");
//        try {
//            cursor = db.rawQuery(query,new String[]{sender,receiver});
//            if (cursor.moveToFirst()) {
//                do {
//                    int id = cursor.getInt(0);
//                    String sen = cursor.getString(1);
//                    String rec = cursor.getString(2);
//                    String text = cursor.getString(3);
//                    if (text.contains("content://media")){
//                        text = "Photo";
//                    }
//                    String time = cursor.getString(4);
//                    message = new messageModel(sen, rec, text, time);
//                } while (cursor.moveToNext());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            cursor.close();
//            db.close();
//        }
//        return message;
//    }

    //------------------------------------------------------------------------ Teachers Table Methods------------------------------------//
    public static final String TABLE_CALLS = "CALLS";
    public static final String CALLS_COLUMN_ID = "id";
    public static final String CALLS_COLUMN_CALLER = "caller";
    public static final String CALLS_COLUMN_CALLEE = "callee";
    public static final String CALLS_COLUMN_TIME = "time";

//    public boolean addOneCall(callModel call){
//        SQLiteDatabase db =  this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//        cv.put(CALLS_COLUMN_CALLER,call.getCaller());
//        cv.put(CALLS_COLUMN_CALLEE,call.getCallee());
//        cv.put(CALLS_COLUMN_TIME,call.getTime());
//        long insert = db.insert(TABLE_CALLS,null, cv);
//        if (insert>0){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    public List<callModel> getCalls(String tempcaller){
//        List<callModel> allCalls = new ArrayList<callModel>();
//        String query = "Select * from "+TABLE_CALLS+" where "+CALLS_COLUMN_CALLER+" = ?";
//        Cursor cursor = null;
//        SQLiteDatabase db = this.getReadableDatabase();
//        try {
//            cursor = db.rawQuery(query,new String[]{tempcaller});
//            if (cursor.moveToNext()) {
//                do {
//                    int id = cursor.getInt(0);
//                    String caller = cursor.getString(1);
//                    String callee = cursor.getString(2);
//                    String time = cursor.getString(3);
//                    callModel call = new callModel(caller, callee, time);
//                    allCalls.add(call);
//                } while (cursor.moveToNext());
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            cursor.close();
//            db.close();
//        }
//        return allCalls;
//    }
}