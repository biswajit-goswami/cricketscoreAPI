package com.javatpoint.controller;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatpoint.models.CricketScore;
import com.javatpoint.models.ScoreResponse;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
@RestController
public class HelloWorldController 
{
@RequestMapping("/score")
public ResponseEntity<ScoreResponse> hello() 
{
	OkHttpClient client = new OkHttpClient();//.newBuilder()
			  //.build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\r\n  \"unique_id\": \"1136617\",\r\n  \"apikey\": \"WmPJrX2s3KMyZVPFwlm1vxXLXKw1\"\r\n}");
			Request request = new Request.Builder()
			  .url("http://cricapi.com/api/cricketScore")
			  .method("POST", body)
			  .addHeader("Content-Type", "application/json")
			  .build();
			Response response = null;
			CricketScore cricketScore=null;
			try {
				response = client.newCall(request).execute();
				ObjectMapper objectMapper = new ObjectMapper(); 
				cricketScore=objectMapper.readValue(response.body().string(), CricketScore.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScoreResponse scoreResponse=new ScoreResponse();
			String score=cricketScore.getScore();
			String[] split1= score.split(" v ");
			String[] split2_team1=split1[0].split("/");
			String[] split3_team1=split2_team1[0].split(cricketScore.getteam_1());
			String score_team1=split3_team1[1].trim();
			int score_team1_int=Integer.parseInt(split3_team1[1].trim());

			String[] split2_team2=split1[1].split("/");
			String[] split3_team2=split2_team2[0].split(cricketScore.getteam_2());
			String score_team2=split3_team2[1].trim();

			int score_team2_int=Integer.parseInt(split3_team2[1].trim());
			scoreResponse.setTeam1(cricketScore.getteam_1());
			scoreResponse.setTeam2(cricketScore.getteam_2());
			int winningScore =0;
			if(score_team1_int>score_team2_int) {
				scoreResponse.setTeam1(cricketScore.getteam_1()+ " (Winner)");
				winningScore=score_team1_int;
				String[] split4_team1=score.split(score_team1);
				String wickets=split4_team1[1].substring(0, 2);
				scoreResponse.setWinningScore(score_team1+wickets);

			}else {
				scoreResponse.setTeam2(cricketScore.getteam_2()+ " (Winner)");
				winningScore=score_team2_int;
				String[] split4_team2=score.split(score_team2);
				String wickets=split4_team2[1].substring(0, 2);
				scoreResponse.setWinningScore(score_team2+wickets);
			}
			
			System.out.println(score_team1);

			return ResponseEntity.ok(scoreResponse);
}
}
