/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {

    // product
    private final Item item;

    private final int quantity;

    private final BigDecimal totalCost;

    private final String currency;

    // discount
    private Discount discount;

    public OfferItem(Item item, int quantity, String currency, Discount discount) {
        this.item = item;
        this.quantity = quantity;
        this.totalCost = item.getProductPrice().multiply(new BigDecimal(quantity)).subtract(discount.getDiscount());
        this.currency = currency;
        this.discount = discount;
    }


    public Discount getDiscount() {
        return discount;
    }

    public Item getItem() {
        return item;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public String getTotalCostCurrency() {
        return currency;
    }


    public int getQuantity() {
        return quantity;
    }


    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + quantity;
        result = 31 * result + (totalCost != null ? totalCost.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null)
                return false;
        } else if (!discount.equals(other.discount))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        }
        if (quantity != other.quantity)
            return false;
        if (totalCost == null) {
            if (other.totalCost != null)
                return false;
        } else if (!totalCost.equals(other.totalCost))
            return false;
        return true;
    }

    /**
     * @param item
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;

        if (quantity != other.quantity)
            return false;

        BigDecimal max, min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
