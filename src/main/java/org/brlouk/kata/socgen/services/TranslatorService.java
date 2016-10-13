package org.brlouk.kata.socgen.services;

import java.util.Map.Entry;
import java.util.Optional;

import javax.annotation.Resource;

import org.brlouk.kata.socgen.model.TranslationTable;
import org.springframework.stereotype.Service;

/**
 * Service to translate
 * 
 * @author brlouk
 *
 */
@Service
public class TranslatorService {

	@Resource
	private TranslationTable translation;

	public String convertToRomanNumeral(int digit) {
		StringBuilder numeralBuilder = new StringBuilder();
		return convertToRomanNumeral(digit, numeralBuilder);
	}

	private String convertToRomanNumeral(int digit, StringBuilder numeralBuilder) {
		if (digit == 0) {
			return numeralBuilder.toString();
		}
		Optional<Entry<Integer, String>> symbol = translation.findFirstSymbol(digit);
		if (symbol.isPresent()) {
			Entry<Integer, String> entry = symbol.get();
			numeralBuilder.append(entry.getValue());
			return convertToRomanNumeral(digit - entry.getKey(),numeralBuilder);
		} else {
			throw new IllegalStateException("check Translation Table");
		}
	}

	public String convertToDigit(String numeral) {
		throw new UnsupportedOperationException("not implemented yet!");
	}

}
