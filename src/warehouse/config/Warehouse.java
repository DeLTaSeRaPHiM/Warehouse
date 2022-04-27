package warehouse.config;

import java.sql.Date;

public class Warehouse {
    private int id;
    private String name;
    private String productCategory;
    private String productType;
    private String vendor;
    private int quantity;
    private double purchasePrice;
    private double sellPrice;
    private String lastUpdateDate;

    public Warehouse(int id, String name, String productCategory,
                     String productType, String vendor, int quantity,
                     double purchasePrice, double sellPrice, String lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.productType = productType;
        this.vendor = vendor;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Warehouse() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
