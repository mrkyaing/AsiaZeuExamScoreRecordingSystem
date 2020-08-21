package com.asiazeu.controller;

import com.asiazeu.entity.ExamType;
import com.asiazeu.storagelayer.DBExamTypeOperations;

public class ExamTypeController {
DBExamTypeOperations dbExamTypeOperations;
public ExamTypeController() {
	this.dbExamTypeOperations=new DBExamTypeOperations();
}
public void Save(ExamType examtype) {
	dbExamTypeOperations.SaveExamType(examtype);
}
public void getAllExamType() {
	dbExamTypeOperations.getAllExamType();
}
}
