package com.asiazeu.storagelayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.asiazeu.applayer.ScoreDAO;
import com.asiazeu.entity.Score;

public class DBScoreOperations implements ScoreDAO{

	 //1 define db url ,user ,pass ,db driver
	private final static String url="jdbc:mysql://localhost/asiazeuexamscore";
	private final static String dbdriver="com.mysql.cj.jdbc.Driver";
	private final static String user="root";
	private final static String password="root@123";
	
	@Override
	public void saveScore(Score score) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="insert Score(studentId,examtypeid,mark) values(?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,score.getStudentId());
				pstmt.setInt(2,score.getExamtypeId());	
				pstmt.setInt(3,score.getMark());	
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("Score Save success .");
			}else {
				System.out.println("can't save .");
			}				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}
		
	}

	@Override
	public void getAllScore() {
		
		
	}

	@Override
	public void updateScore(int studentId, int examtypeid, int mark) {
		
	}

	@Override
	public void deleteScoreByStudentId(int studentId) {
		
		
	}

	@Override
	public void deleteScoreByExamTypeId(int examtypeid) {
		
		
	}

}
