import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ProductExecutor {
    private List<Product> products;

    public ProductExecutor(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProductsByTypeAndPrice() {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .toList();
    }

    public List<Product> getProductsWithDiscount() {
        return products.stream()
                .filter(product -> product.getType().equals("Book") && product.isDiscount())
                .peek(product -> product.setPrice((int) (product.getPrice() * 0.9)))
                .toList();
    }

    public Product getCheapestProduct() {
        return products.stream()
                .filter(product -> product.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("No product from the Book category was found!"));
    }

    public List<Product> getLastAddedProducts() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .toList();
    }

    public int getGeneralPriceForBookInThisYear() {
        return products.stream()
                .filter(p -> p.getCreateDate().getYear() == 2024)
                .filter(p -> p.getType().equals("Book") && p.getPrice() <= 75)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public Map<String, List<Product>> groupByType(){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
