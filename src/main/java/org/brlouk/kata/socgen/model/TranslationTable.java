package org.brlouk.kata.socgen.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;



@Component
public class TranslationTable {

	private Map<Integer, String> digitToRomanNumeral;

	@PostConstruct
	public void init() {
		digitToRomanNumeral= new LinkedHashMap<>();
		digitToRomanNumeral.put(1000, "M");
		digitToRomanNumeral.put(900, "CM");
		digitToRomanNumeral.put(500, "D");
		digitToRomanNumeral.put(400, "CD");
		digitToRomanNumeral.put(100, "C");
		digitToRomanNumeral.put(90, "XC");
		digitToRomanNumeral.put(50, "L");
		digitToRomanNumeral.put(10, "X");
		digitToRomanNumeral.put(9, "IX");
		digitToRomanNumeral.put(5, "V");
		digitToRomanNumeral.put(4, "IV");
		digitToRomanNumeral.put(1, "I");
	}

	public Optional<Entry<Integer, String>> findFirstSymbol(int digit) {
		return digitToRomanNumeral.entrySet().stream()/* return stream */
				.filter(e -> digit - e.getKey() >= 0).findFirst();
	}

}
