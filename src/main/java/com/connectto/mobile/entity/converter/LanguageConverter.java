package com.connectto.mobile.entity.converter;

import com.connectto.mobile.domain.lcp.Language;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LanguageConverter implements AttributeConverter<Language, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Language status) {
		return status.getValue();
	}

	@Override
	public Language convertToEntityAttribute(Integer value) {
		return Language.valueOf(value);
	}
}