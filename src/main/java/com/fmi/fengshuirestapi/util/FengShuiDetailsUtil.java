package com.fmi.fengshuirestapi.util;

import com.fmi.fengshuirestapi.enums.Direction;
import com.fmi.fengshuirestapi.enums.Gender;
import com.fmi.fengshuirestapi.pojo.FengShuiDetails;
import com.google.gson.Gson;

public class FengShuiDetailsUtil {

	public static String fengShuiDetails(int year, int hour, Gender gender) {
		FengShuiDetails fengShuiDetails = new FengShuiDetails();
		fengShuiDetails.setChineseHourSign(AnimalSignUtil.chineseHourSign(hour));
		fengShuiDetails.setChineseYearSign(AnimalSignUtil.chineseYearSign(year));
		fengShuiDetails.setSecretFriend(AnimalSignUtil.secretFriend(year));
		fengShuiDetails.setAstrologyAllies(AnimalSignUtil.astrologyAllies(year));
		fengShuiDetails.setAstrologyEnemy(AnimalSignUtil.astrologyEnemy(year));
		fengShuiDetails.setPeachBlossomAnimal(AnimalSignUtil.peachBlossomAnimal(year));
		int kuaNumber = Integer.parseInt(new KuaUtil(year, gender).execute());
		fengShuiDetails.setKuaNumber(kuaNumber);
		fengShuiDetails.setFourBestDirections(Direction.getFourBestDirections(kuaNumber));
		fengShuiDetails.setFourWorstDirections(Direction.getFourWorstDirections(kuaNumber));
		return new Gson().toJson(fengShuiDetails);
	}

}
