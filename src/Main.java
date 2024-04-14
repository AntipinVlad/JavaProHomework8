import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder("Book", 100).id(0).isDiscount(true)
                .addDate(LocalDate.of(2022, 3, 12)).build());
        products.add(Product.builder("Book", 250).id(1).isDiscount(false)
                .addDate(LocalDate.of(2023, 8, 20)).build());
        products.add(Product.builder("Book", 115).id(2).isDiscount(true)
                .addDate(LocalDate.of(2019, 2, 12)).build());
        products.add(Product.builder("Mirror", 250).id(3).isDiscount(false)
                .addDate(LocalDate.of(2024, 2, 28)).build());
        products.add(Product.builder("Book", 325).id(4).isDiscount(true)
                .addDate(LocalDate.of(2020, 2, 20)).build());
        products.add(Product.builder("Book", 430).id(5).isDiscount(false)
                .addDate(LocalDate.of(2012, 12, 10)).build());
        products.add(Product.builder("Book", 25).id(6).isDiscount(true)
                .addDate(LocalDate.of(2024, 1, 3)).build());
        products.add(Product.builder("Book", 70).id(7).isDiscount(false)
                .addDate(LocalDate.of(2024, 2, 4)).build());
        products.add(Product.builder("Box", 20).id(8).isDiscount(true)
                .addDate(LocalDate.of(2023, 11, 20)).build());
        products.add(Product.builder("Book", 430).id(9).isDiscount(true)
                .addDate(LocalDate.of(2023, 12, 30)).build());

        ProductExecutor processedProducts = new ProductExecutor(products);

        System.out.println("Books that are more expensive than 250 USD:");
        processedProducts.getProductsByTypeAndPrice().forEach(Product::printTypeAndPrice);

        System.out.println("\nBooks with discount 10%:");
        processedProducts.getProductsWithDiscount().forEach(Product::printTypePriceDiscount);

        System.out.println("\nCheapest product:");
        processedProducts.getCheapestProduct().printTypePriceDiscount();

        System.out.println("\nLatest products:");
        processedProducts.getLastAddedProducts().forEach(Product::printTypePriceDiscountData);

        System.out.println("\nGeneral price for Books in this year:");
        System.out.println(processedProducts.getGeneralPriceForBookInThisYear());

        System.out.println("\nGrouped products:");
        processedProducts.groupByType().forEach((k,v) -> {
            System.out.print(k + ":\n");
            v.forEach(System.out::println);
        });
    }
}