package service;

import model.Buy;
import model.Product;
import model.User;
import repository.BuyRepository;
import validation.BuyValidation;
import validation.QuantityValidation;
import validation.UserValidation;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class BuyService {
    public void buy(User user, Product product, Integer quantity) throws IOException {
        new QuantityValidation().validate(quantity, product);
        new UserValidation().validate(user);
        Buy buy = new Buy(product.code(), user.id(), quantity, LocalDateTime.now());
        new BuyValidation().validate(buy);

        new BuyRepository().write(Collections.singletonList(buy));
        System.out.println("Compra realizada de " + buy.quantity()
                + " " + product.name() + " no valor de R$ "
                + (product.price().multiply(new BigDecimal(String.valueOf(buy.quantity())))));
    }

    public void listBuys(String id) throws IOException {
        List<Buy> buys = new BuyRepository().read();
        buys.stream()
                .filter(c -> c.id().equals(id))
                .forEach(u -> System.out.println("[" + u.id() + "," +
                        u.date().getDayOfMonth() + "/" +
                        u.date().getMonth().getValue() + "/" +
                        u.date().getDayOfMonth() + " " +
                        u.date().getHour() + ":" +
                        u.date().getMinute() +
                        "]"));
    }
}
