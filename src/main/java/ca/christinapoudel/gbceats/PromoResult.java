package ca.christinapoudel.gbceats;

import java.math.BigDecimal;

public class PromoResult {
    private final boolean applied;
    private final String message;
    private final BigDecimal originalSubtotal;
    private final BigDecimal discount;
    private final BigDecimal finalSubtotal;

    public PromoResult(boolean applied, String message,
                       BigDecimal originalSubtotal, BigDecimal discount,
                       BigDecimal finalSubtotal) {
        this.applied = applied;
        this.message = message;
        this.originalSubtotal = originalSubtotal;
        this.discount = discount;
        this.finalSubtotal = finalSubtotal;
    }

    public boolean applied() {
        return applied;
    }

    public String message() {
        return message;
    }

    public BigDecimal originalSubtotal() {
        return originalSubtotal;
    }

    public BigDecimal discount() {
        return discount;
    }

    public BigDecimal finalSubtotal() {
        return finalSubtotal;
    }
}