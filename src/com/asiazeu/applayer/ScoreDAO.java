package com.asiazeu.applayer;

import com.asiazeu.entity.Score;

public interface ScoreDAO {
void saveScore(Score score);
void getAllScore();
void updateScore(int studentId,int examtypeid,int mark);
void deleteScoreByStudentId(int studentId);
void deleteScoreByExamTypeId(int examtypeid);
}
