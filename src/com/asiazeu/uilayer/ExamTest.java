package com.asiazeu.uilayer;
import java.util.Scanner;
public class ExamTest {
static ExamScoreMenuList menu=new ExamScoreMenuList();//static object of ExamScoreMenuList
	public static void main(String[] args) {
		System.out.println("welcome to Asia Zeu Exam record keeping System :) ");    
        System.out.print("Choice the Menu :(1:Student Menu,2:Exam Type Menu,3:Score Menu)");
        int choice=0;
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        if(choice==1) {
        	menu.StudentMenu();
        }else if(choice==2) {
        	menu.ExamTypeMenu();
        }else if (choice==3) {
        	menu.ScoreMenu();
        }
        
	}

}
