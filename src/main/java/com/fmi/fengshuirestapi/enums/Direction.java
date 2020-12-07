package com.fmi.fengshuirestapi.enums;

import java.util.Arrays;
import java.util.List;

public enum Direction {

	NORTH(Arrays.asList(1, 3, 4, 9)), EAST(Arrays.asList(1, 3, 4, 9)), SOUTH(Arrays.asList(1, 3, 4, 9)), WEST(
			Arrays.asList(2, 6, 7, 8)), NORTH_EAST(Arrays.asList(2, 6, 7, 8)), NORTH_WEST(
					Arrays.asList(2, 6, 7, 8)), SOUTH_EAST(
							Arrays.asList(1, 3, 4, 9)), SOUTH_WEST(Arrays.asList(2, 6, 7, 8));

	private List<Integer> kuaNumbersWithLuckyDirection;

	private Direction(List<Integer> kuaNumbersWithLuckyDirection) {
		this.kuaNumbersWithLuckyDirection = kuaNumbersWithLuckyDirection;
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

}
