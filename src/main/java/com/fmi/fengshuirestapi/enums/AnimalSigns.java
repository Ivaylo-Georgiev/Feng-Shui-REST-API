package com.fmi.fengshuirestapi.enums;

public enum AnimalSign {

	RAT(4, 23, "OX", "DRAGON,MONKEY", "HORSE"), OX(5, 1, "RAT", "SNAKE,ROOSTER", "SHEEP"), TIGER(6, 3, "PIG",
			"HORSE,DOG", "MONKEY"), RABBIT(7, 5, "DOG", "SHEEP,PIG", "ROOSTER"), DRAGON(8, 7, "ROOSTER", "MONKEY,RAT",
					"DOG"), SNAKE(9, 9, "MONKEY", "OX,ROOSTER", "PIG"), HORSE(10, 11, "SHEEP", "TIGER,DOG",
							"RAT"), SHEEP(11, 13, "HORSE", "RABBIT,PIG", "OX"), MONKEY(0, 15, "SNAKE", "DRAGON,RAT",
									"TIGER"), ROOSTER(1, 17, "DRAGON", "OX,SNAKE", "RABBIT"), DOG(2, 19, "RABBIT",
											"TIGER,HORSE", "DRAGON"), PIG(3, 21, "TIGER", "RABBIT,SHEEP", "SNAKE");

	private int yearModulo;
	private int fromHour;
	private String secretFriend;
	private String astrologyAllies;
	private String enemy;

	private AnimalSign(int yearModulo, int fromHour, String secretFriend, String astrologyAllies, String enemy) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
		this.secretFriend = secretFriend;
		this.astrologyAllies = astrologyAllies;
		this.enemy = enemy;
	}

	public static AnimalSign mapYearToSign(int year) {
		final int signsCount = values().length;
		int yearModulo = year % signsCount;
		for (AnimalSign sign : values()) {
			if (yearModulo == sign.yearModulo) {
				return sign;
			}
		}

		return null;
	}

	public static AnimalSign mapHourToSign(int hour) {
		final int offset = 2;
		for (AnimalSign sign : values()) {
			if (hour >= sign.fromHour && hour < sign.fromHour + offset) {
				return sign;
			}
		}

		// cover the case for 24, which is ignored by the checks above
		return RAT;
	}

	public AnimalSign getSecretFriend() {
		return valueOf(this.secretFriend);
	}

	public String getAstrologyAllies() {
		return this.astrologyAllies;
	}

	public String getEnemy() {
		return this.enemy;
	}

}
