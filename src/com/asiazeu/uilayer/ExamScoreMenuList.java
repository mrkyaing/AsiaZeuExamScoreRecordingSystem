package com.asiazeu.uilayer;

import java.util.Scanner;

import com.asiazeu.controller.ExamTypeController;
import com.asiazeu.controller.ScoreController;
import com.asiazeu.controller.StudentController;
import com.asiazeu.entity.ExamType;
import com.asiazeu.entity.Score;
import com.asiazeu.entity.Student;

public class ExamScoreMenuList {
	
	public  void StudentMenu() {
		 //create student controller 
        StudentController stcontroller=new StudentController();
        //create the student entity
        Student studentEntity=new Student();
		int choice=0;
		System.out.print("1:Add,2:Select,3:Update,4:Delete");
	    Scanner yourchoice=new Scanner(System.in);
	    choice=yourchoice.nextInt();
	    if(choice==1) {
	    	Scanner sc=new Scanner(System.in);
			System.out.print("Enter student Name:");
	        String name=sc.nextLine();
	        sc=new Scanner(System.in);
	        System.out.print("Enter student Email:");
	        String email=sc.nextLine();
	        System.out.print("Enter student Phone:");
	        String phone=sc.nextLine();
	        System.out.print("Enter student Address:");
	        String address=sc.nextLine();     
	        studentEntity.setName(name);
	        studentEntity.setEmail(email);
	        studentEntity.setPhone(phone);
	        studentEntity.setAddress(address);
	        //saving the student data with Student Entity 
	        stcontroller.save(studentEntity);
	    }
	    else if(choice==2) {
	    	stcontroller.getAllStudent();
	    }
	    
	    else if(choice==4) {
	    	stcontroller.getAllStudent();
	    	System.out.print("please choice student id that you want to delete:");
	    	Scanner sc=new Scanner(System.in);
	    	int studentid=sc.nextInt();
	    	stcontroller.delete(studentid);
	    }
	    else if(choice==3) {
	    	stcontroller.getAllStudent();
	    	System.out.print("please choice student id that you want to Update:");
	    	Scanner sc=new Scanner(System.in);
	    	int studentid=sc.nextInt();
	    	
	    	//for name
			System.out.print("Enter student Name:");
	        sc=new Scanner(System.in);  
	        String name=sc.nextLine();   
	       
	       //for email
	        System.out.print("Enter student Email:");	
	        sc=new Scanner(System.in);  
	        String email=sc.nextLine();
	        //for phone
	        System.out.print("Enter student Phone:");
	        sc=new Scanner(System.in);
	        String phone=sc.nextLine();
	        //for address
	        sc=new Scanner(System.in);
	        System.out.print("Enter student Address:");
	        String address=sc.nextLine();   
	        //setting the data to the entity
	        studentEntity.setName(name);
	        studentEntity.setEmail(email);
	        studentEntity.setPhone(phone);
	        studentEntity.setAddress(address);
	    	stcontroller.update(studentid,studentEntity);
	    }
	}
	
	public  void ExamTypeMenu() {
		ExamTypeController examTypeController=new ExamTypeController();
		ExamType examTypeEntity=new ExamType();	
    	int choice=0;
		System.out.print("1:Add,2:Select,3:Update,4:Delete");
	    Scanner yourchoice=new Scanner(System.in);
	    choice=yourchoice.nextInt();
	    if(choice==1) {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("Enter Exam Type Name:");
	    	String examtypename=sc.nextLine();
	    	System.out.print("Enter Total Number of Questions:");
	    	int totalQ=sc.nextInt();	    	
	    	examTypeEntity.setName(examtypename);
	    	examTypeEntity.setTotalquestions(totalQ);	    	
	    	examTypeController.Save(examTypeEntity);
	    	
	    }else if(choice==2) {
	    	examTypeController.getAllExamType();
	    }
	}
	
	public void ScoreMenu() {		
    	//for showing data before save the score .
    	ExamTypeController examTypeController=new ExamTypeController();
		StudentController stcontroller=new StudentController();
    	stcontroller.getAllStudent();
    	examTypeController.getAllExamType();
    	/////
    	
    	ScoreController scoreController=new ScoreController();
		Score scoreEntity=new Score();	
    	int choice=0;
    	
		System.out.print("1:Add,2:Select,3:Update,4:Delete");
	    Scanner yourchoice=new Scanner(System.in);
	    choice=yourchoice.nextInt();
	    if(choice==1) {    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.print("Enter Student Id:");
	    	int studentId=sc.nextInt();
	    	System.out.print("Enter Exam type Id:");
	    	int examtypeid=sc.nextInt();
	    	System.out.print("Enter Mark(S):");
	    	int mark=sc.nextInt();	
	    	scoreEntity.setStudentId(studentId);
	    	scoreEntity.setExamtypeId(examtypeid);
	    	scoreEntity.setMark(mark);    	
	    	scoreController.save(scoreEntity);
	    	
	    }else if(choice==2) {
	    	
	    }
	}
	
}
