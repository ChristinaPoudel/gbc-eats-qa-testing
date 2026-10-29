package ca.christinapoudel.gbceats;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;

/**
 * Represents a configured promotional code.
 */
public final class Promo {
    public enum Type {
        PERCENTAGE,
        FIXED_AMOUNT
    }

    private final String code;
    private final Type type;
    private final BigDecimal value;
    private final BigDecimal minimumSubtotal;
    private final BigDecimal maximumDiscount;

    public Promo(String code, Type type, BigDecimal value,
                 BigDecimal minimumSubtotal, BigDecimal maximumDiscount) {
        this.code = Objects.requireNonNull(code, "code").trim().toUpperCase(Locale.ROOT);
        this.type = Objects.requireNonNull(type, "type");
        this.value = requireNonNegative(value, "value");
        this.minimumSubtotal = requireNonNegative(minimumSubtotal, "minimumSubtotal");
        this.maximumDiscount = maximumDiscount == null
                ? null : requireNonNegative(maximumDiscount, "maximumDiscount");
    }

    private static BigDecimal requireNonNegative(BigDecimal amount, String field) {
        Objects.requireNonNull(amount, field);
        if (amount.signum() < 0) {
            throw new IllegalArgumentException(field + " cannot be negative");
        }
        return amount;
    }

    public String getCode() { return code; }
    public Type getType() { return type; }
    public BigDecimal getValue() { return value; }
    public BigDecimal getMinimumSubtotal() { return minimumSubtotal; }
    public BigDecimal getMaximumDiscount() { return maximumDiscount; }
}
