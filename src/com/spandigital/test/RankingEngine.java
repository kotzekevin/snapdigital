package com.spandigital.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Kevin Kotze
 *
 */
public class RankingEngine {
	
	private static List<String> ranking;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Please provide valid input file location.");
			System.exit(1);
		}
		
		String inputFile = args[0];
		
		Map<String, Integer> results = new HashMap<String, Integer>(); // stores the results unranked
		
		
		// start processing the input file
		try (
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				// loop each line of the input file
				String line = bufferedReader.readLine();
				while (line != null) {
					// extract the teams scores
					String[] scores = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
					
					// process the result of the teams scores
					processResult(results, scores);
					
					line = bufferedReader.readLine();
				}
				
				// process the ranking of all the results
				processRanking(results);
				
				// print out the ranking
				for (String team : ranking) {
					System.out.println(team);
				}
				System.out.println();
		} catch (Exception e) {
			System.err.println("Error occurred processing input file: " + e.getMessage());
			System.exit(1);
		}
	}
	
	private static void processResult(Map<String, Integer> results, String[] scores) {
		if (results == null || scores == null) {
			System.err.println("Invalid input while processing result.");
			System.exit(1);
		}
		
		// ensure valid result
		if (scores.length != 2 || scores[0] == null || scores[1] == null) {
			System.out.println("Invalid result from input file, skipping...");
			return;
		}
		
		String team1Score = scores[0]; // extract first teams score
		String team2Score = scores[1]; // extract second teams score
		
		// extract the first teams name and goals scored
		String team1Name = team1Score.substring(0, team1Score.lastIndexOf(" "));
		Integer team1Goals = Integer.valueOf(team1Score.substring(team1Score.lastIndexOf(" ") + 1));
		
		// extract the second teams name and goals scored
		String team2Name = team2Score.substring(0, team2Score.lastIndexOf(" "));
		Integer team2Goals = Integer.valueOf(team2Score.substring(team2Score.lastIndexOf(" ") + 1));
		
		int team1Points = 0;
		int team2Points = 0;
		
		// determine the points for each team based on goals scored
		if (team1Goals > team2Goals) {
			team1Points = 3;
			team2Points = 0;
		} else if (team1Goals < team2Goals) {
			team1Points = 0;
			team2Points = 3;
		} else {
			team1Points = 1;
			team2Points = 1;
		}
		
		// add first teams points to the results
		if (results.containsKey(team1Name)) {
			// team results already exist so increment the points
			results.put(team1Name, results.get(team1Name) + team1Points);
		} else {
			// team results does not exist so add the result
			results.put(team1Name, team1Points);
		}
		
		// add second teams points to the results
		if (results.containsKey(team2Name)) {
			// team results already exist so increment the points
			results.put(team2Name, results.get(team2Name) + team2Points);
		} else {
			// team results does not exist so add the result
			results.put(team2Name, team2Points);
		}
	}
	
	private static List<String> processRanking(Map<String, Integer> results) {
		if (results == null) {
			System.err.println("Invalid input while processing ranking.");
			System.exit(1);
		}
		
		ranking = new ArrayList<String>();
		
		// sort the results by team points in descending order highest to lowest
		// where points are equal, sort by team name
		results = 
			results.entrySet().stream()
				.sorted(new RankingComparator())
				.collect(Collectors.toMap(
					Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1, LinkedHashMap::new));
		
		int position = 0;
		int prevTeamPoints = -1;
		int prevTeamEqualCount = 0;
		
		// loop through each team ranking to process and display team position and points output
		for (Map.Entry<String, Integer> team : results.entrySet()) {
			int currTeamPoints = team.getValue();
			
			// determine the suffix to display for points indicator
			String pointsSuffix = (currTeamPoints == 1 ? " pt" : " pts");
			
			// check if previous team points is equal to current team points
			if (prevTeamPoints != currTeamPoints) {
				// if not equal, then increment the current position
				position++;
				
				// check if it was previously detected that the teams points were equal
				if (prevTeamEqualCount != 0) {
					// if so, increment the position by the count it was detected to be equal
					position = position + prevTeamEqualCount;
				}
				
				prevTeamEqualCount = 0; // reset the counter
			} else {
				// if equal, then increment the counter (leave current position unchanged)
				prevTeamEqualCount++;
			}
			
			// output the team position and points
			ranking.add(position + ". " + team.getKey() + ", " + team.getValue() + pointsSuffix);
			
			// set previous team points to current team points for later comparison
			prevTeamPoints = currTeamPoints;
		}
		
		return ranking;
	}

	public static List<String> getRanking() {
		return ranking;
	}
}
