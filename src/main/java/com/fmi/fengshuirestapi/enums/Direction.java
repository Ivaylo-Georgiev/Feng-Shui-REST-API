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

	private List<Integer> kuaNumbersWithLuckyDirection;
	private List<Integer> kuaNumbersWithUnluckyDirection;

	private Direction(List<Integer> kuaNumbersWithLuckyDirection, List<Integer> kuaNumbersWithUnluckyDirection) {
		this.kuaNumbersWithLuckyDirection = kuaNumbersWithLuckyDirection;
		this.kuaNumbersWithUnluckyDirection = kuaNumbersWithUnluckyDirection;
	}

	public static String getLuckyDirections(int kuaNumber) {
		String luckyDirections = "";
		int i = 0;
		for (Direction direction : Direction.values()) {
			if (direction.kuaNumbersWithLuckyDirection.contains(kuaNumber)) {
				luckyDirections += direction.name() + ((i < 3) ? "," : "");
				++i;
			}
		}
		return luckyDirections;
	}

	public static String getUnluckyDirections(int kuaNumber) {
		String unluckyDirections = "";
		int i = 0;
		for (Direction direction : Direction.values()) {
			if (direction.kuaNumbersWithUnluckyDirection.contains(kuaNumber)) {
				unluckyDirections += direction.name() + ((i < 3) ? "," : "");
				++i;
			}
		}
		return unluckyDirections;
	}

}
