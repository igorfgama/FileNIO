package main;

import enums.Category;
import enums.Plan;
import model.Product;
import model.User;
import repository.BuyRepository;
import service.BuyService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // Usuário tem nome, login, senha
        // Produto tem nome, código, quantidade, categoria, preço
        // Compra tem código, login, quantidade, data
        // Planos têm diferentes tipos de compra e descontos

        loadData();
    }

    private static void loadData() throws IOException {
        Product product = new Product("123", "Notebook", new BigDecimal("3999.90"), Category.NOTEBOOK, 10);
        Product product2 = new Product("789", "iPhone", new BigDecimal("4289.90"), Category.PHONE, 20);
        Product product3 = new Product("963", "Cadeira Gamer", new BigDecimal("1212.90"), Category.HOME, 15);
        User user = new User("456789", "456789", "Jão", Plan.BASIC, LocalDate.now().plusDays(30));
        User user2 = new User("987654", "456789", "Zézin", Plan.PREMIUM, LocalDate.now().plusDays(30));

        BuyService buyService = new BuyService();
        buyService.buy(user, product, 1);
        buyService.buy(user, product2, 2);
        buyService.buy(user, product3, 2);
        buyService.buy(user2, product3, 1);

        //System.out.println(new BuyRepository().read());

        buyService.listBuys(user.id());
    }
}
