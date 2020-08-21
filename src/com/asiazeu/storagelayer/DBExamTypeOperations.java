package com.asiazeu.storagelayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.asiazeu.applayer.ExamTypeDAO;
import com.asiazeu.entity.ExamType;

public class DBExamTypeOperations implements ExamTypeDAO{
	 //1 define db url ,user ,pass ,db driver
		private final static String url="jdbc:mysql://localhost/asiazeuexamscore";
		private final static String dbdriver="com.mysql.cj.jdbc.Driver";
		private final static String user="root";
		private final static String password="root@123";
	@Override
	public void SaveExamType(ExamType examType) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="insert ExamType(name,totalquestions) values(?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,examType.getName());
				pstmt.setInt(2,examType.getTotalquestions());				
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Exam Type Save success .");
			}else {
				System.out.println("can't save .");
			}				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
		
	}

	@Override
	public void updateExamType(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExamType(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllExamType() {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="select * from ExamType";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				System.out.println(String.format("%-15s %-30s %-30s", "Id","Name","Total Questions"));
			    while(rs.next()) {
			    	System.out.println(String.format("%-15d %-30s %-30d",rs.getInt(1),rs.getString(2),rs.getInt(3)));		    	    	
			    }
			}
			
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
		
	}

}
