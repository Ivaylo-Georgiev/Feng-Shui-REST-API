package com.fmi.fengshuirestapi.util;

import com.fmi.fengshuirestapi.enums.AnimalSign;

public class AnimalSignUtil {

	public static String chineseHourSign(int hour) {
		AnimalSign animalSign = AnimalSign.mapHourToSign(hour);
		return animalSign.toString();
	}

	public static String chineseYearSign(int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return animalSign.toString();
	}

	public static String secretFriend(int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return animalSign.getSecretFriend().toString();
	}

	public static String astrologyAllies(int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return animalSign.getAstrologyAllies();
	}

	public static String astrologyEnemy(int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return animalSign.getAstrologyEnemy().toString();
	}

	public static String peachBlossomAnimal(int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return animalSign.getPeachBlossomAnimal().toString();
	}

}
