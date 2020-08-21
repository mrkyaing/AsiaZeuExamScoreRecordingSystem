package com.asiazeu.applayer;


import com.asiazeu.entity.ExamType;


public interface ExamTypeDAO {
void SaveExamType(ExamType examType);
void updateExamType(int id);
void deleteExamType(int id);
void getAllExamType();

}
