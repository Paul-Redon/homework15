package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product bread = new SimpleProduct("Хлеб", 50);
        Product milk = new SimpleProduct("Молоко", 80);
        Product cheese = new DiscountedProduct("Сыр", 200, 20);
        Product meat = new FixPriceProduct("Мясо");
        Product fish = new DiscountedProduct("Рыба", 250, 10);
        Product eggs = new SimpleProduct("Яйца", 90);

        ProductBasket basket = new ProductBasket();

        System.out.println("~ 1. Добавление продуктов ~");
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(meat);
        basket.addProduct(fish);
        System.out.println("Продукты добавлены");

        System.out.println("~ 2. Добавление в заполненную корзину ~");
        basket.addProduct(eggs);

        System.out.println("~ 3. Содержимое корзины ~");
        basket.printBasket();

        System.out.println("~ 4. Стоимость корзины ~");
        System.out.println("Общая стоимость: " + basket.getTotalCost());

        System.out.println("~ 5. Поиск существующего товара ~");
        System.out.println("Хлеб в корзине: " + basket.containsProductByName("Хлеб"));

        System.out.println("~ 6. Поиск отсутствующего товара ~");
        System.out.println("Шоколад в корзине: " + basket.containsProductByName("Шоколад"));

        System.out.println("~ 7. Очистка корзины ~");
        basket.clearBasket();
        System.out.println("Корзина очищена");

        System.out.println("~ 8. Содержимое пустой корзины ~");
        basket.printBasket();

        System.out.println("~ 9. Стоимость пустой корзины ~");
        System.out.println("Общая стоимость: " + basket.getTotalCost());

        System.out.println("~ 10. Поиск в пустой корзине ~");
        System.out.println("Хлеб в корзине: " + basket.containsProductByName("Хлеб"));
    }
}