package com.dom.incomevalidator.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.dom.incomevalidator.validator.IncomeDivisibleValidator;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IncomeDivisibleValidator.class)
@Documented
public @interface IncomeDivisible {
	String message() default "{income should be divisible by week}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
