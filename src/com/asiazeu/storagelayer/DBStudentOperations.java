package com.asiazeu.storagelayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.asiazeu.applayer.StudentDAO;
import com.asiazeu.entity.Student;

public class DBStudentOperations implements StudentDAO{

	 //1 define db url ,user ,pass ,db driver
	private final static String url="jdbc:mysql://localhost/asiazeuexamscore";
	private final static String dbdriver="com.mysql.cj.jdbc.Driver";
	private final static String user="root";
	private final static String password="root@123";
	
	@Override
	public void saveStudent(Student studentEntity) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="insert student(name,email,phone,address) values(?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,studentEntity.getName());
				pstmt.setString(2,studentEntity.getEmail());
				pstmt.setString(3,studentEntity.getPhone());
				pstmt.setString(4,studentEntity.getAddress());				
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Student Save success .");
			}else {
				System.out.println("can't save .");
			}				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
	}

	@Override
	public void updateStudent(int studentId,Student studentEntity) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="Update student set name=?,email=?,phone=?,address=? where id=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,studentEntity.getName());		
				pstmt.setString(2,studentEntity.getEmail());		
				pstmt.setString(3,studentEntity.getPhone());		
				pstmt.setString(4,studentEntity.getAddress());		
				pstmt.setInt(5,studentId);						
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Student update success .");
			}else {
				System.out.println("can't upate .");
			}				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
		
	}

	@Override
	public void deleteStudent(int studentId) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="delete from student where id=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,studentId);
							
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Student Delete success .");
			}else {
				System.out.println("can't Delete .");
			}				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}		
	}

	@Override
	public void getAllStudent() {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="select * from student";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				System.out.println(String.format("%-15s %-30s %-30s %-30s %-30s", "Id","Name","Email","Phone","Address"));
			    while(rs.next()) {
			    	System.out.println(String.format("%-15d %-30s %-30s %-30s %-30s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));		    	    	
			    }
			}
			
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
	}//end of get all student

}//end of class 
