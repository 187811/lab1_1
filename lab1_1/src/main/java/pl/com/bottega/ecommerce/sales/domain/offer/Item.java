package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

/**
 * Created by student on 2016-03-17.
 */
public class Item {

    private String productId;

    private double productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public Item(String productId, double productPrice, String productName, Date productSnapshotDate, String productType) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }
}
