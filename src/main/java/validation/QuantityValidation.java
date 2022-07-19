package validation;

import model.Product;

public class QuantityValidation {

    public void validate(Integer quantity, Product product) {
        if(quantity < 0)
            throw new RuntimeException("Quantidade inválida.");
        if(quantity > product.inventory())
            throw new RuntimeException("Pedido acima do estoque.");
    }
}
