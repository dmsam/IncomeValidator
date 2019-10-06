# IncomeValidator

This project is to create a JSR 303 validator annotation to validate income divisible to whole number to pence per week.

## Getting Started

Clone project to your local machine. Then import as a maven project. The build output is  a jar which can included in any java project for validation

### Prerequisites

Install maven on your machine and then you can run project from maven. Install IDE like eclipse if you need to run from IDE.


### Installing

Please build project using maven

```
mvn clean install
```

## Running application

To use this JSR validator annotation '@IncomeDivisible' it can be applied on 'RegularAmount' bean

## Input argument sample

```
100.25 FOUR WEEK
```
Here above monetary value is validated to be divisible based on weekly frequency to whole number

## Output sample for above input

Validation message will be thrown if validation is failed

## Authors

* **Doma Samson**

 
