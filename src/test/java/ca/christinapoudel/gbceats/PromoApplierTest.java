package ca.christinapoudel.gbceats;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PromoApplierTest {

    @Test
    void testPercentageDiscount() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("60.00"));

        assertEquals("9.00", result.discount().toPlainString());
        assertEquals("51.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testFixedDiscount() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "TAKE8", new BigDecimal("20.00"));

        assertEquals("8.00", result.discount().toPlainString());
        assertEquals("12.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testOrderBelowMinimum() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("24.99"));

        assertFalse(result.applied());
        assertEquals("24.99", result.finalSubtotal().toPlainString());
    }

    @Test
    void testOrderAtMinimum() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("25.00"));

        assertEquals("3.75", result.discount().toPlainString());
        assertEquals("21.25", result.finalSubtotal().toPlainString());
    }

    @Test
    void testMaximumDiscount() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("100.00"));

        assertEquals("12.00", result.discount().toPlainString());
        assertEquals("88.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testFixedDiscountBelowSubtotal() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "TAKE8", new BigDecimal("5.00"));

        assertEquals("5.00", result.discount().toPlainString());
        assertEquals("0.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testDiscountRounding() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("27.33"));

        assertEquals("4.10", result.discount().toPlainString());
        assertEquals("23.23", result.finalSubtotal().toPlainString());
    }

    @Test
    void testUnknownCode() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "FAKECD12", new BigDecimal("50.00"));

        assertFalse(result.applied());
        assertEquals("50.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testOrderJustAboveMinimum() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("25.01"));

        assertEquals("3.75", result.discount().toPlainString());
        assertEquals("21.26", result.finalSubtotal().toPlainString());
    }

    @Test
    void testDiscountAtMaximumLimit() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("80.00"));

        assertEquals("12.00", result.discount().toPlainString());
        assertEquals("68.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testDiscountAboveMaximumLimit() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "EATSMART15", new BigDecimal("100.00"));

        assertEquals("12.00", result.discount().toPlainString());
        assertEquals("88.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testFixedDiscountEqualToSubtotal() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "TAKE8", new BigDecimal("8.00"));

        assertEquals("8.00", result.discount().toPlainString());
        assertEquals("0.00", result.finalSubtotal().toPlainString());
    }

    @Test
    void testFixedDiscountLeavesOneCent() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "TAKE8", new BigDecimal("8.01"));

        assertEquals("8.00", result.discount().toPlainString());
        assertEquals("0.01", result.finalSubtotal().toPlainString());
    }

    @Test
    void testLowercaseCode() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "eatsmart15", new BigDecimal("60.00"));

        assertTrue(result.applied());
        assertEquals("9.00", result.discount().toPlainString());
    }

    @Test
    void testBlankCode() {
        PromoApplier promo = new PromoApplier();

        PromoResult result = promo.applyPromo(
                "  ", new BigDecimal("30.00"));

        assertFalse(result.applied());
    }

    @Test
    void testNegativeSubtotal() {
        PromoApplier promo = new PromoApplier();

        assertThrows(IllegalArgumentException.class, () ->
                promo.applyPromo("TAKE8", new BigDecimal("-1.00")));
    }
    @Test
    void testNullSubtotal() {
        PromoApplier promo = new PromoApplier();

        assertThrows(IllegalArgumentException.class, () ->
                promo.applyPromo("TAKE8", null));
    }
}