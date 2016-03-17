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

public class OfferItem {

    // product
    private final Item item;
    private final int quantity;
    private final Money money;
    private final Discount discount;

    public OfferItem(Item item, int quantity, Money money, Discount discount) {
        this.item = item;
        this.quantity = quantity;
        this.money = money;
        this.discount = discount;
    }


    public Discount getDiscount() {
        return discount;
    }

    public Item getItem() {
        return item;
    }


    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferItem offerItem = (OfferItem) o;

        if (quantity != offerItem.quantity) return false;
        if (!item.equals(offerItem.item)) return false;
        if (!money.equals(offerItem.money)) return false;
        return discount.equals(offerItem.discount);

    }

    @Override
    public int hashCode() {
        int result = item.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + money.hashCode();
        result = 31 * result + discount.hashCode();
        return result;
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

        double max, min;
        if (money.getTotalCost() > other.money.getTotalCost()) {
            max = money.getTotalCost();
            min = other.money.getTotalCost();
        } else {
            max = other.money.getTotalCost();
            min = money.getTotalCost();
        }

        double difference = max - min;
        double acceptableDelta = delta / 100;

        return acceptableDelta <= delta;
    }

}
