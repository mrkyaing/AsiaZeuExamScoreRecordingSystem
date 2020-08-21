package com.asiazeu.controller;

import com.asiazeu.entity.Student;
import com.asiazeu.storagelayer.DBStudentOperations;

public class StudentController {
	
DBStudentOperations dboperation;

public StudentController() {
	dboperation=new DBStudentOperations();
}
//C
public void save(Student studentEntity) {
	dboperation.saveStudent(studentEntity);
}
//R
public void getAllStudent() {
	dboperation.getAllStudent();
}
//U
public void update(int studentId,Student studentEntity) {
	dboperation.updateStudent(studentId, studentEntity);
}

//D
public void delete(int studentid) {
	dboperation.deleteStudent(studentid);
}


}
