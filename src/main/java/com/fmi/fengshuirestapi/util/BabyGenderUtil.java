package com.fmi.fengshuirestapi.util;

import com.fmi.fengshuirestapi.enums.Gender;

public class BabyGenderUtil {

	private static final int CONSTANT = 19;

	private int fatherBirthYear;
	private int fatherBirthMonth;
	private int fatherBirthDay;
	private int motherBirthYear;
	private int motherBirthMonth;
	private int motherBirthDay;
	private int conceptionMonth;

	public BabyGenderUtil(int fatherBirthYear, int fatherBirthMonth, int fatherBirthDay, int motherBirthYear,
			int motherBirthMonth, int motherBirthDay, int conceptionMonth) {
		this.fatherBirthYear = fatherBirthYear;
		this.fatherBirthMonth = fatherBirthMonth;
		this.fatherBirthDay = fatherBirthDay;
		this.motherBirthYear = motherBirthYear;
		this.motherBirthMonth = motherBirthMonth;
		this.motherBirthDay = motherBirthDay;
		this.conceptionMonth = conceptionMonth;
	}

	public Gender determineBabyGender() {
		int sum = getLastDigits(this.fatherBirthYear) + this.fatherBirthMonth + this.fatherBirthDay
				+ getLastDigits(this.motherBirthYear) + this.motherBirthMonth + this.motherBirthDay
				+ this.conceptionMonth - CONSTANT;

		boolean isGirl = isGirl(isOdd(sum));
		if (isGirl) {
			return Gender.FEMALE;
		}

		return Gender.MALE;

	}

	private int getLastDigits(int number) {
		return number % 100;
	}

	private boolean isOdd(int number) {
		if (number / 2 != 0) {
			return true;
		}

		return false;
	}

	private boolean isGirl(boolean isOdd) {
		if (isOdd) {
			return false;
		}

		return true;
	}

}
