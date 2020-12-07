package com.fmi.fengshuirestapi.enums;

/**
 * Stores information about the 12 Chinese zodiac animal signs, needed for the
 * execution of numerous Feng Shui commands.
 * 
 *
 * @author Ivaylo Georgiev
 */
public enum AnimalSign {

	RAT(4, 23, "OX", "DRAGON,MONKEY"), OX(5, 1, "RAT", "SNAKE,ROOSTER"), TIGER(6, 3, "PIG", "HORSE,DOG"), RABBIT(7, 5,
			"DOG", "SHEEP,PIG"), DRAGON(8, 7, "ROOSTER", "MONKEY,RAT"), SNAKE(9, 9, "MONKEY", "OX,ROOSTER"), HORSE(10,
					11, "SHEEP", "TIGER,DOG"), SHEEP(11, 13, "HORSE", "RABBIT,PIG"), MONKEY(0, 15, "SNAKE",
							"DRAGON,RAT"), ROOSTER(1, 17, "DRAGON", "OX,SNAKE"), DOG(2, 19, "RABBIT",
									"TIGER,HORSE"), PIG(3, 21, "TIGER", "RABBIT,SHEEP");

	/**
	 * Maps an animal sign to the result of the division (modulo) of a specified
	 * year with 12 (the count of all animal signs)
	 */
	private int yearModulo;

	/**
	 * Marks the starting hour for each animal sign
	 */
	private int fromHour;

	/**
	 * Specifies the secret friend of every animal sign. Each sign can have only one
	 * secret friend
	 */
	private String secretFriend;

	/**
	 * Specifies the astrology allies of every animal sign. Each sign has two
	 * astrology allies
	 */
	private String astrologyAllies;

	/**
	 * Constructs an animal sign with the corresponding information about year
	 * modulo value, starting hour, secret friend and astrolgy allies
	 */
	private AnimalSign(int yearModulo, int fromHour, String secretFriend, String astrologyAllies) {
		this.yearModulo = yearModulo;
		this.fromHour = fromHour;
		this.secretFriend = secretFriend;
		this.astrologyAllies = astrologyAllies;
	}

	/**
	 * Maps the year, provided by the user to an animal sign. Every year can
	 * possibly match to only one sign
	 * 
	 * @param year
	 *            A positive integer, that corresponds to a Chinese animal sign
	 * @return AnimalSign The animal sign, corresponding to the specified year
	 */
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

	/**
	 * Maps the hour, provided by the user to an animal sign. Every hour can
	 * possibly match to only one sign
	 * 
	 * @param hour
	 *            A positive integer, between 1 and 24, that corresponds to a
	 *            Chinese animal sign
	 * @return AnimalSign The animal sign, corresponding to the specified hour
	 */
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

	/**
	 * Gets the single secret friend, related to the specified animal sign
	 * 
	 * @return AnimalSign The secret friend, corresponding to the specified year
	 */
	public AnimalSign getSecretFriend() {
		return valueOf(this.secretFriend);
	}

	/**
	 * Gets the two astrollogy allies, related to the specified animal sign
	 * 
	 * @return String The astrology allies, corresponding to the specified year
	 */
	public String getAstrologyAllies() {
		return this.astrologyAllies;
	}

}
