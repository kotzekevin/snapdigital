package com.spandigital.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RankingEngineTest {

	@Test
	public void testMainScores1() {
		RankingEngine.main(new String[] {".\\input\\scores_1.txt"});

		List<String> expected = Arrays.asList(
			"1. Tarantulas, 6 pts",
			"2. Lions, 5 pts",
			"3. FC Awesome, 1 pt",
			"3. Snakes, 1 pt",
			"5. Grouches, 0 pts"
		);

		List<String> actual = RankingEngine.getRanking();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMainScores2() {
		RankingEngine.main(new String[] {".\\input\\scores_2.txt"});
		
		List<String> expected = Arrays.asList(
			"1. Tarantulas, 6 pts",
			"2. Lions, 5 pts",
			"3. FC Awesome, 1 pt",
			"3. Grouches, 1 pt",
			"3. Snakes, 1 pt",
			"3. Tigers, 1 pt"
		);

		List<String> actual = RankingEngine.getRanking();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMainScores3() {
		RankingEngine.main(new String[] {".\\input\\scores_3.txt"});
		
		List<String> expected = Arrays.asList(
			"1. Tarantulas, 6 pts",
			"2. Lions, 5 pts",
			"3. Tigers, 4 pts",
			"4. FC Awesome, 1 pt",
			"4. Grouches, 1 pt",
			"4. Snakes, 1 pt",
			"7. Rabbits, 0 pts"
		);

		List<String> actual = RankingEngine.getRanking();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMainScores4() {
		RankingEngine.main(new String[] {".\\input\\scores_4.txt"});
		
		List<String> expected = Arrays.asList(
			"1. Lions, 5 pts",
			"2. Tarantulas, 3 pts",
			"3. FC Awesome, 1 pt",
			"3. Grouches, 1 pt",
			"3. Snakes, 1 pt",
			"3. Tigers, 1 pt"
		);

		List<String> actual = RankingEngine.getRanking();

		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testMainScores5() {
		RankingEngine.main(new String[] {".\\input\\scores_5.txt"});
		
		List<String> expected = Arrays.asList(
			"1. Tarantulas, 7 pts",
			"2. Grouches, 5 pts",
			"2. Lions, 5 pts",
			"4. Rabbits, 3 pts",
			"5. FC Awesome, 2 pts",
			"5. Snakes, 2 pts",
			"7. Tigers, 1 pt"
		);

		List<String> actual = RankingEngine.getRanking();

		Assert.assertEquals(expected, actual);
	}

}
