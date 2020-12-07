package com.fmi.fengshuirestapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmi.fengshuirestapi.enums.AnimalSign;

@RestController
public class ResponseController {

	@RequestMapping("/ChineseHourSign/{hour}")
	public Response chineseHourSign(@PathVariable int hour) {
		AnimalSign animalSign = AnimalSign.mapHourToSign(hour);
		return new Response(animalSign.toString());
	}
	
	@RequestMapping("/ChineseYearSign/{year}")
	public Response chineseYearSign(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.mapYearToSign(year);
		return new Response(animalSign.toString());
	}

	@RequestMapping("/secretFriend/{year}")
	public Response secretFriend(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response(animalSign.getSecretFriend().toString());
	}

	@RequestMapping("/astrologyAllies/{year}")
	public Response astrologyAllies(@PathVariable int year) {
		AnimalSign animalSign = AnimalSign.valueOf(chineseYearSign(year).getContent());
		return new Response(animalSign.getAstrologyAllies().toString());
	}

}
