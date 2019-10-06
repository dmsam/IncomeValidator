package com.dom.IncomeValidator.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.dom.incomevalidator.bean.RegularAmount;
import com.dom.incomevalidator.enums.Frequency;

public class IncomeDivisibleValidatorTest {

	private RegularAmount regularAmount;
	private Validator validator;

	@Before
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		regularAmount = RegularAmount.builder().amount("101.2").frequency(Frequency.FOUR_WEEK).build();
	}

	@Test
	public void testForWholeNumber() {
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}

	@Test
	public void testWeeklyFrequencyValidIncome() {
		regularAmount = RegularAmount.builder().amount("101.22").frequency(Frequency.WEEK).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}

	@Test
	public void testMothlyFrequencyValidIncome() {
		regularAmount = RegularAmount.builder().amount("101.22").frequency(Frequency.MONTH).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}

	@Test
	public void testTwoWeeklyFrequencyValidIncome() {
		regularAmount = RegularAmount.builder().amount("101.22").frequency(Frequency.TWO_WEEK).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}

	@Test
	public void testQuarterlyFrequencyInValidIncome() {
		regularAmount = RegularAmount.builder().amount("101.22").frequency(Frequency.QUARTER).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertEquals("Income not divisible by week frequencey",
				validtionResults.stream().findFirst().get().getMessage());
	}

	@Test
	public void testYearlyFrequencyInValidIncome() {
		regularAmount = RegularAmount.builder().amount("101.22").frequency(Frequency.YEAR).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertEquals("Income not divisible by week frequencey",
				validtionResults.stream().findFirst().get().getMessage());
	}
	
	
	@Test
	public void testQuarterlyFrequencyValidIncome() {
		regularAmount = RegularAmount.builder().amount("39.39").frequency(Frequency.QUARTER).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}

	@Test
	public void testYearlyFrequencyValidIncome() {
		regularAmount = RegularAmount.builder().amount("157.04").frequency(Frequency.YEAR).build();
		final Set<ConstraintViolation<RegularAmount>> validtionResults = validator.validate(regularAmount);
		assertTrue(validtionResults.size() == 0);
	}


}
