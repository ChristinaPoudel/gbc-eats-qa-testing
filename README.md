# GBC Eats — Promo Code QA Testing

## Project Overview

This project demonstrates software quality assurance (QA) practices through testing a promo code module for a food-ordering application.

The project focuses on designing test scenarios, automating unit tests, evaluating test coverage, and documenting testing results.

## Objectives

- Design black-box test cases using equivalence partitioning and boundary value analysis.
- Implement automated unit tests using JUnit 5.
- Execute tests and document the results.
- Measure code coverage using JaCoCo.
- Identify testing limitations and opportunities for further improvement.

## Technology Stack

- **Language:** Java 17
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5
- **Code Coverage:** JaCoCo
- **Version Control:** Git and GitHub

## Project Structure

```text
gbc-eats-qa-project/
├── src/
│   ├── main/java/ca/christinapoudel/gbceats/
│   │   ├── Promo.java
│   │   ├── PromoApplier.java
│   │   └── PromoResult.java
│   └── test/java/ca/christinapoudel/gbceats/
│       └── PromoApplierTest.java
├── pom.xml
└── README.md
```

## Automated Test Results

The latest recorded Maven test run completed successfully.

| Metric | Result |
|---|---:|
| Tests executed | 17 |
| Passed | 17 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |
| Build status | BUILD SUCCESS |

## Code Coverage

The latest recorded JaCoCo report showed the following overall coverage:

| Coverage Metric | Result |
|---|---:|
| Instructions | 95% |
| Branches | 91% |
| Lines | 95.4% |
| Methods | 89.5% |
| Classes | 100% |

The `PromoApplier` class achieved 100% instruction coverage and 95% branch coverage.

Coverage percentages indicate which parts of the code were exercised by the tests. They do not, by themselves, prove that every possible defect has been detected.

## Test Design Approach

The documented black-box test scenarios use:

- **Equivalence Partitioning (EP):** Grouping inputs expected to behave similarly.
- **Boundary Value Analysis (BVA):** Examining values around important limits.
- **White-box testing:** Considering internal logic and execution paths.
- **Grey-box testing:** Considering internal state and conditions when designing additional scenarios.

The 16 documented black-box cases represent designed test scenarios. They should not be interpreted as executed unless execution results have been recorded separately. The 17 automated Java unit tests are a separate test suite.

## Limitations and Future Improvements

- Record execution evidence for each designed black-box scenario.
- Expand testing to cover additional edge cases and execution paths.
- Add automated integration tests where appropriate.
- Investigate how the testing approach could be extended to data-processing workflows.

## Learning Outcomes

This project provides practical experience with test design, automated unit testing, test execution, code coverage analysis, and QA documentation. It also demonstrates the importance of reporting test results accurately and distinguishing planned tests from tests that have actually been executed.
