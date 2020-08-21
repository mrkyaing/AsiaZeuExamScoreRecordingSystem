package com.asiazeu.controller;

import com.asiazeu.entity.Score;
import com.asiazeu.storagelayer.DBScoreOperations;

public class ScoreController {
//HAS-A relationship	
DBScoreOperations db;
public ScoreController() {
	db=new DBScoreOperations();
}

public void save(Score score) {
	db.saveScore(score);
}


}
