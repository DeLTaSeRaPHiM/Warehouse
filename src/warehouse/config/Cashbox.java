package warehouse.config;

public class Cashbox {
    private int id;
    private String productName;
    private String vendor;
    private String customer;
    private int purchaseQuantity;
    private double purchasePrice;
    private String date;

    public Cashbox(int id, String productName, String vendor,
                   String customer, int purchaseQuantity, double purchasePrice, String date) {
        this.id = id;
        this.productName = productName;
        this.vendor = vendor;
        this.customer = customer;
        this.purchaseQuantity = purchaseQuantity;
        this.purchasePrice = purchasePrice;
        this.date = date;
    }

    public Cashbox() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
