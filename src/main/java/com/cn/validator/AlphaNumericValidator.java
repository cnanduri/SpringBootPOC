package com.cn.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphaNumericValidator
		implements ConstraintValidator<AlphaNumeric, String> {

	private Pattern pattern;

	private static final String ALPHA_NUM_REG_EXP = "[^0-9a-zA-Z]";

	@Override
	public void initialize(AlphaNumeric constraintAnnotation) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(constraintAnnotation);
		pattern = Pattern.compile(ALPHA_NUM_REG_EXP);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || pattern == null) {
			return true;
		}

		Matcher m = pattern.matcher(value);

		boolean found = m.find();

		return !found;
	}

}
