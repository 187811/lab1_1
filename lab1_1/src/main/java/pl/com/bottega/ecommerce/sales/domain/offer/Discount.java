package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by student on 2016-03-17.
 */
public class Discount {

    private final Integer id;

    private final String discountCause;

    private final BigDecimal discount;

    public Discount(Integer id, String discountCause, BigDecimal discount) {
        this.id = id;
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount1 = (Discount) o;

        if (id != null ? !id.equals(discount1.id) : discount1.id != null) return false;
        if (discountCause != null ? !discountCause.equals(discount1.discountCause) : discount1.discountCause != null)
            return false;
        return discount != null ? discount.equals(discount1.discount) : discount1.discount == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (discountCause != null ? discountCause.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

}
