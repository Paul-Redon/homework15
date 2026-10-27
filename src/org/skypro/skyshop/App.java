package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Хлеб", 50);
        Product product2 = new Product("Молоко", 80);
        Product product3 = new Product("Сыр", 200);
        Product product4 = new Product("Мясо", 350);
        Product product5 = new Product("Рыба", 250);
        Product product6 = new Product("Яйца", 90);

        ProductBasket basket = new ProductBasket();

        System.out.println("~ 1. Добавление продуктов ~");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        System.out.println("Продукты добавлены");

        System.out.println("~ 2. Добавление в заполненную корзину ~");
        basket.addProduct(product6);

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