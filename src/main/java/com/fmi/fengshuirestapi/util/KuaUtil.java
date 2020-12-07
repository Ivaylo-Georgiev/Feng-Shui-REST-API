package com.fmi.fengshuirestapi.util;

import com.fmi.fengshuirestapi.enums.Gender;

public class KuaUtil {

	private final static int LAST_TWO_DIGITS_DIVISOR = 100;
	private final static int KUA_FIVE = 5;
	private final static int KUA_EIGHT = 8;
	private final static int KUA_TWO = 2;
	private final static int FEMALE_KUA_ADDEND = 4;
	private final static int MALE_KUA_MINUEND = 11;
	private final static int MALE_KUA_MINUEND_AFTER_2000 = 9;
	private final static int FEMALE_KUA_ADDEND_AFTER_2000 = 6;

	private int yearLastTwoDigits;
	private Gender gender;
	private boolean isAfter2000;

	public KuaUtil(int year, Gender gender) {
		this.yearLastTwoDigits = year % LAST_TWO_DIGITS_DIVISOR;
		this.gender = gender;
		if (year >= 2000) {
			this.isAfter2000 = true;
		} else {
			this.isAfter2000 = false;
		}
	}

	public String execute() {
		if (this.gender == Gender.MALE) {
			return Integer.toString(calculateMaleKuaNumber());
		}
		return Integer.toString(calculateFemaleKuaNumber());
	}

	private int calculateMaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.yearLastTwoDigits);
		if (isAfter2000) {
			return MALE_KUA_MINUEND_AFTER_2000 - reducedYear;
		} else {
			int kuaNumber = MALE_KUA_MINUEND - reducedYear;
			kuaNumber = reduceToSingleDigit(kuaNumber);
			return (kuaNumber == KUA_FIVE) ? KUA_TWO : kuaNumber;
		}
	}

	private int calculateFemaleKuaNumber() {
		int reducedYear = reduceToSingleDigit(this.yearLastTwoDigits);
		if (isAfter2000) {
			return reduceToSingleDigit(FEMALE_KUA_ADDEND_AFTER_2000 + reducedYear);
		} else {
			int kuaNumber = FEMALE_KUA_ADDEND + reducedYear;
			kuaNumber = reduceToSingleDigit(kuaNumber);
			return (kuaNumber == KUA_FIVE) ? KUA_EIGHT : kuaNumber;
		}
	}

	private int reduceToSingleDigit(int number) {
		int sum = 0;

		// iterate until the number is reduced to 1 digit
		while (number > 0 || sum > 9) {
			if (number == 0) {
				number = sum;
				sum = 0;
			}
			// remove last digit
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}

}
