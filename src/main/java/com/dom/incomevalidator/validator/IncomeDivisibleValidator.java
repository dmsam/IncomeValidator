package com.dom.incomevalidator.validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.math.NumberUtils;

import com.dom.incomevalidator.bean.RegularAmount;
import com.dom.incomevalidator.constraint.IncomeDivisible;

public class IncomeDivisibleValidator implements ConstraintValidator<IncomeDivisible, RegularAmount> {

	public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext context) {
		if (regularAmount.getAmount() != null && NumberUtils.isParsable(regularAmount.getAmount())
				&& regularAmount.getFrequency() != null) {
			String incomeInString = regularAmount.getAmount();
			BigDecimal income = new BigDecimal(incomeInString);
			income = income.setScale(2, RoundingMode.FLOOR);
			income = income.movePointRight(income.scale());
			return regularAmount.getFrequency().getCheckDivisibleperWeek().test(income);
		} else {
			return true;
		}

	}

}
