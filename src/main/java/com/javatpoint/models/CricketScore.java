package com.javatpoint.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CricketScore {
	 private String stat;
	 private String score;
	 private String description;
	 private boolean matchStarted;
	 private String team_1;
	 private String team_2;
	 private String v;
	 private float ttl;
	 Provider ProviderObject;
	 private float creditsLeft;


	 // Getter Methods 

	 public String getStat() {
	  return stat;
	 }

	 public String getScore() {
	  return score;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public boolean getMatchStarted() {
	  return matchStarted;
	 }
	 @JsonProperty("team-1")
	 public String getteam_1() {
	  return team_1;
	 }
	 @JsonProperty("team-2")
	 public String getteam_2() {
	  return team_2;
	 }

	 public String getV() {
	  return v;
	 }

	 public float getTtl() {
	  return ttl;
	 }

	 public Provider getProvider() {
	  return ProviderObject;
	 }

	 public float getCreditsLeft() {
	  return creditsLeft;
	 }

	 // Setter Methods 

	 public void setStat(String stat) {
	  this.stat = stat;
	 }

	 public void setScore(String score) {
	  this.score = score;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setMatchStarted(boolean matchStarted) {
	  this.matchStarted = matchStarted;
	 }
	 @JsonProperty("team-1")
	 public void setteam_1(String team_1) {
	  this.team_1 = team_1;
	 }
	 @JsonProperty("team-2")
	 public void setteam_2(String team_2) {
	  this.team_2 = team_2;
	 }

	 public void setV(String v) {
	  this.v = v;
	 }

	 public void setTtl(float ttl) {
	  this.ttl = ttl;
	 }

	 public void setProvider(Provider providerObject) {
	  this.ProviderObject = providerObject;
	 }

	 public void setCreditsLeft(float creditsLeft) {
	  this.creditsLeft = creditsLeft;
	 }
	}