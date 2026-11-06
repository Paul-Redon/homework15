package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.engine.SearchEngine;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Хлеб", 50);
        Product milk = new SimpleProduct("Молоко", 80);
        Product cheese = new DiscountedProduct("Сыр", 200, 20);
        Product meat = new FixPriceProduct("Мясо");
        Product fish = new DiscountedProduct("Рыба", 250, 10);
        Product eggs = new SimpleProduct("Яйца", 90);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(meat);
        basket.addProduct(fish);

        System.out.println("~ Содержимое корзины ~");
        basket.printBasket();

        Article article1 = new Article("Польза хлеба",
                "Хлеб — источник углеводов и витаминов группы B.");
        Article article2 = new Article("Молочные продукты",
                "Молоко и сыр содержат кальций, необходимый для костей.");
        Article article3 = new Article("Рыба и омега-3",
                "Рыба богата омега-3 жирными кислотами, полезными для сердца.");

        SearchEngine engine = new SearchEngine(20);
        engine.add(bread);
        engine.add(milk);
        engine.add(cheese);
        engine.add(meat);
        engine.add(fish);
        engine.add(eggs);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        System.out.println("~ Поиск: 'Хлеб' ~");
        printResults(engine.search("Хлеб"));

        System.out.println("~ Поиск: 'Рыба' ~");
        printResults(engine.search("Рыба"));

        System.out.println("~ Поиск: 'кальций' ~");
        printResults(engine.search("кальций"));

        System.out.println("~ Поиск: 'полезн' ~");
        printResults(engine.search("полезн"));

        System.out.println("~ Поиск: 'омега' ~");
        printResults(engine.search("омега"));

        System.out.println("~ Поиск: 'несуществующий' ~");
        printResults(engine.search("несуществующий"));
    }

    private static void printResults(Searchable[] results) {
        boolean found = false;
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено");
        }
    }
}