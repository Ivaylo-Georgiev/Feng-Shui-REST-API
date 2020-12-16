package com.fmi.fengshuirestapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmi.fengshuirestapi.enums.AnimalSign;
import com.fmi.fengshuirestapi.enums.Direction;
import com.fmi.fengshuirestapi.enums.Gender;
import com.fmi.fengshuirestapi.pojo.FengShuiDetails;
import com.fmi.fengshuirestapi.util.BabyGenderUtil;
import com.fmi.fengshuirestapi.util.KuaUtil;

@RestController
public class ResponseController {

	@RequestMapping("/ChineseHourSign/{hour}")
	public Response chineseHourSign(@PathVariable int hour) {
		AnimalSign animalSign = AnimalSign.mapHourToSign(hour);
		return new Response("Chinese Hour Sign", animalSign.toString());
	}

	@RequestMapping("/ChineseYearSign/{year}")
	public Response chineseYearSign(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return new Response("Chinese Year Sign", animalSign.toString());
	}

	@RequestMapping("/secretFriend/{year}")
	public Response secretFriend(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response("Secret Friend", animalSign.getSecretFriend().toString());
	}

	@RequestMapping("/astrologyAllies/{year}")
	public Response astrologyAllies(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response("Astrology Allies", animalSign.getAstrologyAllies().toString());
	}

	@RequestMapping("/astrologyEnemy/{year}")
	public Response astrologyEnemy(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response("Astrology Enemy", animalSign.getEnemy().toString());
	}

	@RequestMapping("/kuaNumber/{year}/{gender}")
	public Response kuaNumber(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		return new Response("KUA Number", kuaUtil.execute());
	}

	@RequestMapping("/fourBestDirections/{year}/{gender}")
	public Response fourBestDirections(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		int kua = Integer.parseInt(kuaUtil.execute());
		return new Response("Four Best Directions", Direction.getFourBestDirections(kua));
	}

	@RequestMapping("/fourWorstDirections/{year}/{gender}")
	public Response fourWorstDirections(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		int kua = Integer.parseInt(kuaUtil.execute());
		return new Response("Four Worst Directions", Direction.getFourWorstDirections(kua));
	}

	@RequestMapping("/peachBlossomAnimal/{year}")
	public Response peachBlossomAnimal(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response("Peach Blossom Animal", animalSign.getPeachBlossomAnimal());
	}

	@RequestMapping("/babyGender/{fatherBirthYear}/{fatherBirthMonth}/{fatherBirthDay}/{motherBirthYear}/{motherBirthMonth}/{motherBirthDay}/{conceptionMonth}")
	public Response peachBlossomAnimal(@PathVariable int fatherBirthYear, @PathVariable int fatherBirthMonth,
			@PathVariable int fatherBirthDay, @PathVariable int motherBirthYear, @PathVariable int motherBirthMonth,
			@PathVariable int motherBirthDay, @PathVariable int conceptionMonth) {
		BabyGenderUtil babyGenderUtil = new BabyGenderUtil(fatherBirthYear, fatherBirthMonth, fatherBirthDay,
				motherBirthYear, motherBirthMonth, motherBirthDay, conceptionMonth);
		return new Response("Baby Gender", babyGenderUtil.determineBabyGender().toString());
	}

	@RequestMapping("/fengShuiDetails/{year}/{hour}/{gender}")
	public FengShuiDetails fengShuiDetails(@PathVariable int year, @PathVariable int hour,
			@PathVariable Gender gender) {
		FengShuiDetails fengShuiDetails = new FengShuiDetails();
		fengShuiDetails.setChineseYearSign(chineseYearSign(year).getContent());
		fengShuiDetails.setChineseHourSign(chineseHourSign(hour).getContent());
		fengShuiDetails.setSecretFriend(secretFriend(year).getContent());
		fengShuiDetails.setAstrologyAllies(astrologyAllies(year).getContent());
		fengShuiDetails.setAstrologyEnemy(astrologyEnemy(year).getContent());
		fengShuiDetails.setPeachBlossomAnimal(peachBlossomAnimal(year).getContent());
		fengShuiDetails.setKuaNumber(Integer.parseInt(kuaNumber(year, gender).getContent()));
		fengShuiDetails.setFourBestDirections(fourBestDirections(year, gender).getContent());
		fengShuiDetails.setFourWorstDirections(fourWorstDirections(year, gender).getContent());

		return fengShuiDetails;
	}

}
