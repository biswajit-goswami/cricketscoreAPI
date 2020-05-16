package com.javatpoint.models;

public class ScoreResponse {
	private String team1;
	private String team2;
	private String winningScore;
	private String roundRotation;
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getWinningScore() {
		return winningScore;
	}
	public void setWinningScore(String winningScore) {
		this.winningScore = winningScore;
	}
	public String getRoundRotation() {
		return roundRotation;
	}
	public void setRoundRotation(String roundRotation) {
		this.roundRotation = roundRotation;
	}

}
