package com.fmi.fengshuirestapi.app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmi.fengshuirestapi.enums.Direction;
import com.fmi.fengshuirestapi.enums.Gender;
import com.fmi.fengshuirestapi.pojo.FengShuiResponse;
import com.fmi.fengshuirestapi.util.AnimalSignUtil;
import com.fmi.fengshuirestapi.util.BabyGenderUtil;
import com.fmi.fengshuirestapi.util.KuaUtil;

@RestController
@CrossOrigin(origins = "http://13.59.137.69:3000")
public class FengShuiResponseController {

	@RequestMapping("/chineseHourSign/{hour}")
	public FengShuiResponse chineseHourSign(@PathVariable int hour) {
		return new FengShuiResponse("Chinese Hour Sign", AnimalSignUtil.chineseHourSign(hour));
	}

	@RequestMapping("/chineseYearSign/{year}")
	public FengShuiResponse chineseYearSign(@PathVariable int year) {
		return new FengShuiResponse("Chinese Year Sign", AnimalSignUtil.chineseYearSign(year));
	}

	@RequestMapping("/secretFriend/{year}")
	public FengShuiResponse secretFriend(@PathVariable int year) {
		return new FengShuiResponse("Secret Friend", AnimalSignUtil.secretFriend(year));
	}

	@RequestMapping("/astrologyAllies/{year}")
	public FengShuiResponse astrologyAllies(@PathVariable int year) {
		return new FengShuiResponse("Astrology Allies", AnimalSignUtil.astrologyAllies(year));
	}

	@RequestMapping("/astrologyEnemy/{year}")
	public FengShuiResponse astrologyEnemy(@PathVariable int year) {
		return new FengShuiResponse("Astrology Enemy", AnimalSignUtil.astrologyEnemy(year));
	}

	@RequestMapping("/peachBlossomAnimal/{year}")
	public FengShuiResponse peachBlossomAnimal(@PathVariable int year) {
		return new FengShuiResponse("Peach Blossom Animal", AnimalSignUtil.peachBlossomAnimal(year));
	}

	@RequestMapping("/kuaNumber/{year}/{gender}")
	public FengShuiResponse kuaNumber(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		return new FengShuiResponse("KUA Number", kuaUtil.execute());
	}

	@RequestMapping("/fourBestDirections/{year}/{gender}")
	public FengShuiResponse fourBestDirections(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		int kua = Integer.parseInt(kuaUtil.execute());
		return new FengShuiResponse("Four Best Directions", Direction.getFourBestDirections(kua));
	}

	@RequestMapping("/fourWorstDirections/{year}/{gender}")
	public FengShuiResponse fourWorstDirections(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		int kua = Integer.parseInt(kuaUtil.execute());
		return new FengShuiResponse("Four Worst Directions", Direction.getFourWorstDirections(kua));
	}

	@RequestMapping("/babyGender/{fatherBirthYear}/{fatherBirthMonth}/{fatherBirthDay}/{motherBirthYear}/{motherBirthMonth}/{motherBirthDay}/{conceptionMonth}")
	public FengShuiResponse peachBlossomAnimal(@PathVariable int fatherBirthYear, @PathVariable int fatherBirthMonth,
			@PathVariable int fatherBirthDay, @PathVariable int motherBirthYear, @PathVariable int motherBirthMonth,
			@PathVariable int motherBirthDay, @PathVariable int conceptionMonth) {
		BabyGenderUtil babyGenderUtil = new BabyGenderUtil(fatherBirthYear, fatherBirthMonth, fatherBirthDay,
				motherBirthYear, motherBirthMonth, motherBirthDay, conceptionMonth);
		return new FengShuiResponse("Baby Gender", babyGenderUtil.determineBabyGender().toString());
	}

}
