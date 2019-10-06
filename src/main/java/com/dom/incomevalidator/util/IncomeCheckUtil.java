package com.dom.incomevalidator.util;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class IncomeCheckUtil {

	private IncomeCheckUtil() {
	}

	public static BiFunction<BigDecimal, BigDecimal, BigDecimal[]> convertToWeeklyIncome() {
		return (income, frequency) -> income.divideAndRemainder(frequency);
	}

	public static Predicate<BigDecimal[]> checkWeeklyIncomeISWholeNumber() {
		return weeklyIncomeWithRemainder -> weeklyIncomeWithRemainder[1].compareTo(BigDecimal.ZERO) == 0;
	}
}
