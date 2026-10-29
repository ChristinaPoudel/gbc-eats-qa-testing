package ca.christinapoudel.gbceats;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Small, runnable promo-code module used to demonstrate QA test design.
 * This is a portfolio practice implementation, not the original course code.
 */
public final class PromoApplier {
    private final Map<String, Promo> promos = new HashMap<>();

    public PromoApplier() {
        addPromo(new Promo("EATSMART15", Promo.Type.PERCENTAGE,
                new BigDecimal("15"), new BigDecimal("25.00"),
                new BigDecimal("12.00")));
        addPromo(new Promo("TAKE8", Promo.Type.FIXED_AMOUNT,
                new BigDecimal("8.00"), BigDecimal.ZERO, null));
    }

    public void addPromo(Promo promo) {
        promos.put(promo.getCode(), promo);
    }

    public PromoResult applyPromo(String code, BigDecimal subtotal) {
        if (subtotal == null || subtotal.signum() < 0) {
            throw new IllegalArgumentException("Subtotal must be zero or greater");
        }

        BigDecimal original = money(subtotal);
        if (code == null || code.trim().isEmpty()) {
            return rejected("Invalid Promo Code", original);
        }

        String normalizedCode = code.trim().toUpperCase(Locale.ROOT);
        Promo promo = promos.get(normalizedCode);
        if (promo == null) {
            return rejected("Invalid Promo Code", original);
        }

        if (original.compareTo(promo.getMinimumSubtotal()) < 0) {
            return rejected("Minimum order not met", original);
        }

        BigDecimal discount;
        if (promo.getType() == Promo.Type.PERCENTAGE) {
            discount = original.multiply(promo.getValue())
                    .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        } else {
            discount = promo.getValue();
        }

        if (promo.getMaximumDiscount() != null
                && discount.compareTo(promo.getMaximumDiscount()) > 0) {
            discount = promo.getMaximumDiscount();
        }

        // A discount must never make the order subtotal negative.
        if (discount.compareTo(original) > 0) {
            discount = original;
        }

        BigDecimal finalSubtotal = money(original.subtract(discount));
        return new PromoResult(true, "Promo Applied!", original,
                money(discount), finalSubtotal);
    }

    private PromoResult rejected(String message, BigDecimal subtotal) {
        return new PromoResult(false, message, subtotal,
                money(BigDecimal.ZERO), subtotal);
    }

    private static BigDecimal money(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}
