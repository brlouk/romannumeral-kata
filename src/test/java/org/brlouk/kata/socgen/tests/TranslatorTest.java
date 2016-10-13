package org.brlouk.kata.socgen.tests;

import javax.annotation.Resource;

import org.brlouk.kata.socgen.services.TranslatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslatorTest {

	@Resource
	private TranslatorService translator;

	@Test
	public void simpleConvert() {
		Assert.assertEquals("", translator.convertToRomanNumeral(0));
		Assert.assertEquals("I", translator.convertToRomanNumeral(1));
		Assert.assertEquals("V", translator.convertToRomanNumeral(5));
		Assert.assertEquals("M", translator.convertToRomanNumeral(1000));

	}

	@Test
	public void convertToRomanNumerals() {
		Assert.assertEquals("X", translator.convertToRomanNumeral(10));
		Assert.assertEquals("VII", translator.convertToRomanNumeral(7));
		Assert.assertEquals("XIV", translator.convertToRomanNumeral(14));
		Assert.assertEquals("XIX", translator.convertToRomanNumeral(19));
		Assert.assertEquals("LXXX", translator.convertToRomanNumeral(80));
		Assert.assertEquals("XC", translator.convertToRomanNumeral(90));
		Assert.assertEquals("CD", translator.convertToRomanNumeral(400));
		Assert.assertEquals("CM", translator.convertToRomanNumeral(900));
		Assert.assertEquals("MMM", translator.convertToRomanNumeral(3000));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void convertToDigit() {
		translator.convertToDigit("V");
	}

}
