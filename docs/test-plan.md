# Test Plan — GBC-Eats Promo Code Module

## Purpose

Demonstrate practical software QA skills by implementing a small Java promo-code module and running automated unit tests against it.

## Scope

* Percentage and fixed-amount discounts
* Minimum subtotal checks
* Maximum discount cap
* Rounding to cents
* Prevention of negative subtotals
* Unknown, blank, and case-insensitive promo codes

## Techniques represented

* **Equivalence Partitioning:** eligible/ineligible subtotals and known/unknown codes
* **Boundary Value Analysis:** $24.99/$25.00/$25.01, $79.99/$80.00/$80.01, and $7.99/$8.00/$8.01
* **Black-box testing:** assertions focus on input and observable result
* **White-box awareness:** tests are mapped to behaviour in the implementation; coverage is not claimed unless measured by a coverage tool
* **Grey-box scenario:** the original assignment discusses usage-limit database checks. This demo does not implement a database or usage limits, so those checks are listed as future work rather than claimed as tested.

## Test execution

Run `mvn test`. Maven Surefire should report the test count and pass/fail result.

## Limitations

* This is a small portfolio practice project inspired by the topic of a COMP 2136 assignment. It is not the original course starter code or an official CIBC/banking application.
* The module does not have a UI, persistence layer, promo usage counters, expiry checks, or order-session state.
* The TC008 assignment scenario about applying a second promo depends on order/session state. This standalone module does not implement that state; the test currently verifies rejection of an unknown code, not the full one-code-per-order workflow.
* JaCoCo coverage is measured separately from the designed black-box test scenarios. The latest recorded report shows 95% instruction coverage, 91% branch coverage, 95.4% line coverage, 89.5% method coverage, and 100% class coverage. Coverage indicates which code was exercised; it does not prove that all possible defects were detected.



