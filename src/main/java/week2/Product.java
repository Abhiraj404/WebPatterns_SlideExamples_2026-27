package week2;

import java.util.Objects;

public class Product {
        String productCode;
        String productName;
        String productLine;
        String productScale;
        String productVendor;
        String productDescription;
        int quantityInStock;
        double buyPrice;
        double MSRP;

    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getMSRP() {
        return MSRP;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productCode, product.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice +
                ", MSRP=" + MSRP +
                '}';
    }
}
