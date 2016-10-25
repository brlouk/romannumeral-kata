package org.brlouk.kata.socgen.services;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.brlouk.kata.socgen.model.TranslationTable;
import org.springframework.stereotype.Service;

/**
 * A translation Service to convert Roman numeral to normal number and vice
 * versa.
 * 
 */
@Service
public class TranslationService {

	/**
	 * Table of Translation
	 */
	@Resource
	private TranslationTable translation;

	/**
	 * Convert numeric number to Roman numeral based on recursive overloading
	 * method
	 * 
	 * @param number
	 *            : number to convert
	 * @return roman numeral
	 */
	public String convertToRomanNumeral(int number) {
		StringBuilder numeralBuilder = new StringBuilder();
		return convertToRomanNumeral(number, numeralBuilder);
	}

	/**
	 * Convert number to Roman Numeral in recursive way
	 * 
	 * @param number:
	 *            number to convert
	 * @param numeralBuilder:
	 *            String appender
	 * @return Roman numeral
	 */
	private String convertToRomanNumeral(int number, StringBuilder numeralBuilder) {
		if (number == 0) {
			return numeralBuilder.toString();
		}
		Optional<Entry<Integer, String>> symbol = translation.findFirstSymbol(number);
		if (symbol.isPresent()) {
			Entry<Integer, String> entry = symbol.get();
			numeralBuilder.append(entry.getValue());
			return convertToRomanNumeral(number - entry.getKey(), numeralBuilder);
		} else {
			throw new IllegalStateException("check Translation Table");
		}
	}

	/**
	 * Convert Roman numeral to normal number
	 * 
	 * @param romanNumeral
	 *            : numeral to convert
	 * @return number
	 */
	public int convertToDigit(String romanNumeral) {
		int sum = 0;
		List<String> numeralList = romanNumeral.chars()
				// Convert to String
				.mapToObj(c -> String.valueOf((char) c))
				// Collect to LIST
				.collect(Collectors.toList());

		for (int i = 0; i < numeralList.size(); i++) {
			String numeral = numeralList.get(i);
			String nextNumeral = i + 1 < numeralList.size() ? numeralList.get(i + 1) : "";
			sum += translation.isPlus(numeral, nextNumeral) * translation.findDigit(numeral);
		}

		return sum;
	}

}
