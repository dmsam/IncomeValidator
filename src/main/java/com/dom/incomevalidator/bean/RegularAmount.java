package com.dom.incomevalidator.bean;

import com.dom.incomevalidator.constraint.IncomeDivisible;
import com.dom.incomevalidator.enums.Frequency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IncomeDivisible(message = "Income not divisible by week frequencey")
public class RegularAmount {

	private Frequency frequency;

	private String amount;

}
