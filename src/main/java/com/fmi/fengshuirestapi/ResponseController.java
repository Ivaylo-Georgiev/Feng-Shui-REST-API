package com.fmi.fengshuirestapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmi.fengshuirestapi.enums.AnimalSign;
import com.fmi.fengshuirestapi.enums.Gender;
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

	@RequestMapping("/kuaNumber/{year}/{gender}")
	public Response kuaNumber(@PathVariable int year, @PathVariable Gender gender) {
		KuaUtil kuaUtil = new KuaUtil(year, gender);
		return new Response("KUA Number", kuaUtil.execute());
	}

}
