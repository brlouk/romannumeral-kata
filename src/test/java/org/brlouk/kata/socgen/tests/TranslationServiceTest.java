package org.brlouk.kata.socgen.tests;

import javax.annotation.Resource;

import org.brlouk.kata.socgen.services.TranslationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslationServiceTest {

	@Resource
	private TranslationService service;

	@Test
	public void basicConverter() {
		Assert.assertEquals("", service.convertToRomanNumeral(0));
		Assert.assertEquals("I", service.convertToRomanNumeral(1));
		Assert.assertEquals("V", service.convertToRomanNumeral(5));
		Assert.assertEquals("M", service.convertToRomanNumeral(1000));

	}

	@Test
	public void convertToRomanNumerals() {
		Assert.assertEquals("X", service.convertToRomanNumeral(10));
		Assert.assertEquals("VII", service.convertToRomanNumeral(7));
		Assert.assertEquals("XIV", service.convertToRomanNumeral(14));
		Assert.assertEquals("XIX", service.convertToRomanNumeral(19));
		Assert.assertEquals("LXXX", service.convertToRomanNumeral(80));
		Assert.assertEquals("XC", service.convertToRomanNumeral(90));
		Assert.assertEquals("CD", service.convertToRomanNumeral(400));
		Assert.assertEquals("CM", service.convertToRomanNumeral(900));
		Assert.assertEquals("MMM", service.convertToRomanNumeral(3000));
		Assert.assertEquals("MMVIII", service.convertToRomanNumeral(2008));
	}
	

	@Test(expected = UnsupportedOperationException.class)
	public void convertToDigit() {
		service.convertToDigit("V");
	}

}
