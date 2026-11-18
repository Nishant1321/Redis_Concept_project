
package com.Product.demo.product.Config;

import com.Product.demo.product.Entity.Products;
import com.Product.demo.product.Repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {

        if (productRepo.count() == 0) {

            log.info("Sending product data...");

            productRepo.saveAll(List.of(

                    Products.builder()
                            .productName("MacBook Pro")
                            .productDescription("Apple MacBook Pro M3 laptop")
                            .ProductStock(15L)
                            .ProductPrice(new BigDecimal("150000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("Dell XPS 15")
                            .productDescription("Dell XPS high performance laptop")
                            .ProductStock(20L)
                            .ProductPrice(new BigDecimal("135000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("iPhone 16")
                            .productDescription("Apple iPhone 16 smartphone")
                            .ProductStock(30L)
                            .ProductPrice(new BigDecimal("79999.00"))
                            .category("Mobiles")
                            .build(),

                    Products.builder()
                            .productName("Samsung Galaxy S25")
                            .productDescription("Samsung flagship Android smartphone")
                            .ProductStock(25L)
                            .ProductPrice(new BigDecimal("84999.00"))
                            .category("Mobiles")
                            .build(),

                    Products.builder()
                            .productName("Sony Headphones")
                            .productDescription("Sony wireless noise cancelling headphones")
                            .ProductStock(40L)
                            .ProductPrice(new BigDecimal("9999.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Logitech Mouse")
                            .productDescription("Logitech wireless optical mouse")
                            .ProductStock(50L)
                            .ProductPrice(new BigDecimal("1499.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Mechanical Keyboard")
                            .productDescription("RGB mechanical gaming keyboard")
                            .ProductStock(35L)
                            .ProductPrice(new BigDecimal("3999.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Samsung 4K TV")
                            .productDescription("55 inch Samsung 4K UHD Smart TV")
                            .ProductStock(12L)
                            .ProductPrice(new BigDecimal("65000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("Apple iPad Air")
                            .productDescription("Apple iPad Air tablet")
                            .ProductStock(18L)
                            .ProductPrice(new BigDecimal("59999.00"))
                            .category("Tablets")
                            .build(),

                    Products.builder()
                            .productName("HP Laser Printer")
                            .productDescription("HP wireless laser printer")
                            .ProductStock(10L)
                            .ProductPrice(new BigDecimal("18000.00"))
                            .category("Office Equipment")
                            .build(),

                    Products.builder()
                            .productName("Canon DSLR Camera")
                            .productDescription("Canon professional DSLR camera")
                            .ProductStock(8L)
                            .ProductPrice(new BigDecimal("55000.00"))
                            .category("Cameras")
                            .build(),

                    Products.builder()
                            .productName("Nike Running Shoes")
                            .productDescription("Nike comfortable running shoes")
                            .ProductStock(45L)
                            .ProductPrice(new BigDecimal("4999.00"))
                            .category("Fashion")
                            .build(),

                    Products.builder()
                            .productName("Adidas Backpack")
                            .productDescription("Adidas durable travel backpack")
                            .ProductStock(30L)
                            .ProductPrice(new BigDecimal("2499.00"))
                            .category("Fashion")
                            .build(),

                    Products.builder()
                            .productName("LG Washing Machine")
                            .productDescription("LG fully automatic front load washing machine")
                            .ProductStock(7L)
                            .ProductPrice(new BigDecimal("32000.00"))
                            .category("Home Appliances")
                            .build(),

                    Products.builder()
                            .productName("Boat Bluetooth Speaker")
                            .productDescription("Boat portable wireless Bluetooth speaker")
                            .ProductStock(55L)
                            .ProductPrice(new BigDecimal("2999.00"))
                            .category("Electronics")
                            .build()

            ));

            log.info("15 products inserted successfully!");
        } else {
            log.info("Products already exist. Skipping data seeding.");
        }
    }
}
