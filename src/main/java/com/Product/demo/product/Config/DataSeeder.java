
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
                            .productStock(15L)
                            .productPrice(new BigDecimal("150000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("Dell XPS 15")
                            .productDescription("Dell XPS high performance laptop")
                            .productStock(20L)
                            .productPrice(new BigDecimal("135000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("iPhone 16")
                            .productDescription("Apple iPhone 16 smartphone")
                            .productStock(30L)
                            .productPrice(new BigDecimal("79999.00"))
                            .category("Mobiles")
                            .build(),

                    Products.builder()
                            .productName("Samsung Galaxy S25")
                            .productDescription("Samsung flagship Android smartphone")
                            .productStock(25L)
                            .productPrice(new BigDecimal("84999.00"))
                            .category("Mobiles")
                            .build(),

                    Products.builder()
                            .productName("Sony Headphones")
                            .productDescription("Sony wireless noise cancelling headphones")
                            .productStock(40L)
                            .productPrice(new BigDecimal("9999.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Logitech Mouse")
                            .productDescription("Logitech wireless optical mouse")
                            .productStock(50L)
                            .productPrice(new BigDecimal("1499.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Mechanical Keyboard")
                            .productDescription("RGB mechanical gaming keyboard")
                            .productStock(35L)
                            .productPrice(new BigDecimal("3999.00"))
                            .category("Accessories")
                            .build(),

                    Products.builder()
                            .productName("Samsung 4K TV")
                            .productDescription("55 inch Samsung 4K UHD Smart TV")
                            .productStock(12L)
                            .productPrice(new BigDecimal("65000.00"))
                            .category("Electronics")
                            .build(),

                    Products.builder()
                            .productName("Apple iPad Air")
                            .productDescription("Apple iPad Air tablet")
                            .productStock(18L)
                            .productPrice(new BigDecimal("59999.00"))
                            .category("Tablets")
                            .build(),

                    Products.builder()
                            .productName("HP Laser Printer")
                            .productDescription("HP wireless laser printer")
                            .productStock(10L)
                            .productPrice(new BigDecimal("18000.00"))
                            .category("Office Equipment")
                            .build(),

                    Products.builder()
                            .productName("Canon DSLR Camera")
                            .productDescription("Canon professional DSLR camera")
                            .productStock(8L)
                            .productPrice(new BigDecimal("55000.00"))
                            .category("Cameras")
                            .build(),

                    Products.builder()
                            .productName("Nike Running Shoes")
                            .productDescription("Nike comfortable running shoes")
                            .productStock(45L)
                            .productPrice(new BigDecimal("4999.00"))
                            .category("Fashion")
                            .build(),

                    Products.builder()
                            .productName("Adidas Backpack")
                            .productDescription("Adidas durable travel backpack")
                            .productStock(30L)
                            .productPrice(new BigDecimal("2499.00"))
                            .category("Fashion")
                            .build(),

                    Products.builder()
                            .productName("LG Washing Machine")
                            .productDescription("LG fully automatic front load washing machine")
                            .productStock(7L)
                            .productPrice(new BigDecimal("32000.00"))
                            .category("Home Appliances")
                            .build(),

                    Products.builder()
                            .productName("Boat Bluetooth Speaker")
                            .productDescription("Boat portable wireless Bluetooth speaker")
                            .productStock(55L)
                            .productPrice(new BigDecimal("2999.00"))
                            .category("Electronics")
                            .build()

            ));

            log.info("15 products inserted successfully!");
        } else {
            log.info("Products already exist. Skipping data seeding.");
        }
    }
}
