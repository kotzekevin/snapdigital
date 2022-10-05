package com.spandigital.test;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * @author Kevin Kotze
 *
 */
public class RankingComparator implements Comparator<Entry<String, Integer>> {
	@Override
	public int compare(Entry<String, Integer> team1, Entry<String, Integer> team2) {
		int pointsCompare = -(team1.getValue().compareTo(team2.getValue())); // compare points in descending order
		int namesCompare = team1.getKey().compareTo(team2.getKey()); // compare names in ascending order

		if (pointsCompare == 0) {
			// points are the same, so evaluate names comparison
			// unless names are also the same, then evaluate points comparison
			return ((namesCompare == 0) ? pointsCompare : namesCompare);
		} else {
			// points are not the same, so evaluate points comparison
			return pointsCompare;
		}
	}
}
