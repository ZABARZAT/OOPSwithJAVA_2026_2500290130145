import java.util.*;

class Product {
    int productId;
    String productName;
    double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    void display() {
        System.out.println(productId + "\t" + productName + "\t" + price);
    }
}

class ProductPriceSorting {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(101, "Laptop", 60000));
        products.add(new Product(102, "Mobile", 60000));
        products.add(new Product(103, "Tablet", 30000));
        products.add(new Product(104, "Mouse", 1000));

        // Sort by price: highest to lowest
        // If price is same: sort by product name alphabetically
        Collections.sort(products, new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {

                if (p1.price != p2.price) {
                    return Double.compare(p2.price, p1.price);
                }

                return p1.productName.compareTo(p2.productName);
            }
        });

        System.out.println("Product ID\tProduct Name\tPrice");
        System.out.println("----------------------------------------");

        for (Product p : products) {
            p.display();
        }
    }
}