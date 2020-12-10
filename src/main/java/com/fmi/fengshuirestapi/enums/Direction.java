package com.fmi.fengshuirestapi.enums;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	NORTH(Arrays.asList(1, 3, 4, 9), Arrays.asList(2, 6, 7, 8)), EAST(Arrays.asList(1, 3, 4, 9),
			Arrays.asList(2, 6, 7, 8)), SOUTH(Arrays.asList(1, 3, 4, 9), Arrays.asList(2, 6, 7, 8)), WEST(
					Arrays.asList(2, 6, 7, 8), Arrays.asList(1, 3, 4, 9)), NORTH_EAST(Arrays.asList(2, 6, 7, 8),
							Arrays.asList(1, 3, 4, 9)), NORTH_WEST(Arrays.asList(2, 6, 7, 8),
									Arrays.asList(1, 3, 4, 9)), SOUTH_EAST(Arrays.asList(1, 3, 4, 9),
											Arrays.asList(2, 6, 7, 8)), SOUTH_WEST(Arrays.asList(2, 6, 7, 8),
													Arrays.asList(1, 3, 4, 9));

	private List<Integer> kuaNumbersWithBestDirection;
	private List<Integer> kuaNumbersWithWorstDirection;

	private Direction(List<Integer> kuaNumbersWithBestDirection, List<Integer> kuaNumbersWithWorstDirection) {
		this.kuaNumbersWithBestDirection = kuaNumbersWithBestDirection;
		this.kuaNumbersWithWorstDirection = kuaNumbersWithWorstDirection;
	}

	public static String getFourBestDirections(int kuaNumber) {
		String fourBestDirections = "";
		int i = 0;
		for (Direction direction : Direction.values()) {
			if (direction.kuaNumbersWithBestDirection.contains(kuaNumber)) {
				fourBestDirections += direction.name() + ((i < 3) ? "," : "");
				++i;
			}
		}
		return fourBestDirections;
	}

	public static String getFourWorstDirections(int kuaNumber) {
		String fourWorstDirections = "";
		int i = 0;
		for (Direction direction : Direction.values()) {
			if (direction.kuaNumbersWithWorstDirection.contains(kuaNumber)) {
				fourWorstDirections += direction.name() + ((i < 3) ? "," : "");
				++i;
			}
		}
		return fourWorstDirections;
	}

}
