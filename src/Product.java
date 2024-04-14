import java.time.LocalDate;

public class Product {
    private int id;
    private String type;
    private int price;
    private boolean discount;
    private LocalDate createDate;

    private Product(int id, String type, int price, boolean discount, LocalDate createDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public static ProductBuilder builder(String type, int Price) {
        return new ProductBuilder(type, Price);
    }

    public static class ProductBuilder {
        private int id;
        private String type;
        private int price;
        private boolean discount;
        private LocalDate createDate;

        public ProductBuilder(String type, int price) {
            this.type = type;
            this.price = price;
        }

        public ProductBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ProductBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ProductBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ProductBuilder isDiscount(boolean discount) {
            this.discount = discount;
            return this;
        }

        public ProductBuilder addDate(LocalDate createDate) {
            this.createDate = createDate;
            return this;
        }

        public Product build(){
            return new Product(id, type, price, discount, createDate);
        }
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void printTypeAndPrice() {
        System.out.printf("type: %s, price: %d\n", type, price);
    }

    public void printTypePriceDiscount() {
        System.out.printf("type: %s, price: %d, discount: %b\n", type, price, discount);
    }

    public void printTypePriceDiscountData() {
        System.out.printf("type: %s, price: %d, discount: %b, createDate: %s\n", type, price, discount, createDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type  +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
