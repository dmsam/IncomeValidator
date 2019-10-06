package com.dom.incomevalidator.enums;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.dom.incomevalidator.util.IncomeCheckUtil;

import lombok.Getter;

@Getter
public enum Frequency {
	WEEK(income -> true),
	TWO_WEEK(income -> IncomeCheckUtil.checkWeeklyIncomeISWholeNumber()
			.test((IncomeCheckUtil.convertToWeeklyIncome().apply(income, new BigDecimal(2))))),
	FOUR_WEEK(
			income -> IncomeCheckUtil.checkWeeklyIncomeISWholeNumber()
					.test((IncomeCheckUtil.convertToWeeklyIncome().apply(income, new BigDecimal(4))))),
	MONTH(income -> true),
	QUARTER(income -> IncomeCheckUtil.checkWeeklyIncomeISWholeNumber()
			.test((IncomeCheckUtil.convertToWeeklyIncome().apply(income, new BigDecimal(13))))),
	YEAR(income -> IncomeCheckUtil.checkWeeklyIncomeISWholeNumber()
			.test((IncomeCheckUtil.convertToWeeklyIncome().apply(income, new BigDecimal(52)))));

	Frequency(Predicate<BigDecimal> checkDivisibleperWeek) {

		this.checkDivisibleperWeek = checkDivisibleperWeek;
	}

	private Predicate<BigDecimal> checkDivisibleperWeek;
}
