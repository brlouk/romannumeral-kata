package org.brlouk.kata.socgen.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * A table used to map digit number to Roman numeral.
 *
 */
@Component
public class TranslationTable {

	/**
	 * MAP : Number -> Roman Numeral
	 */
	private Map<Integer, String> numberToRomanNumeral;

	/**
	 * Init table
	 */
	@PostConstruct
	public void init() {
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		// SET READ ONLY MAP
		numberToRomanNumeral = Collections.unmodifiableMap(map);
	}

	/**
	 * Return the nearest entry number in table based on the given number
	 * 
	 * @param number
	 * @return the nearest entry
	 */
	public Optional<Entry<Integer, String>> findFirstSymbol(int number) {
		return numberToRomanNumeral.entrySet()
				// RETURN STREAM OF ENTRY SET
				.stream()
				// SELECT NEAREST NUMBER IN THE TABLE in desc order
				.filter(e -> number - e.getKey() >= 0).findFirst();
	}

}
