package com.asiazeu.applayer;
import com.asiazeu.entity.Student;
public interface StudentDAO {
void saveStudent(Student studentEntity);
void updateStudent(int id,Student studentEntity);
void deleteStudent(int id);
void getAllStudent();
}
