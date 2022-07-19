package validation;

import model.Buy;

import java.util.Objects;

public class BuyValidation implements Validation<Buy> {
    @Override
    public void validate(Buy buy) {
        if(Objects.isNull(buy))
            throw new RuntimeException("Compra inválida.");
    }
}
