package validation;

import model.User;

public class UserValidation implements Validation<User> {
    @Override
    public void validate(User user) {
        if(user.name().length() < 3)
            throw new RuntimeException("Nome inválido.");
        if(user.id().length() < 4)
            throw new RuntimeException("Login inválido.");
        if(user.password().length() < 6)
            throw new RuntimeException("Senha inválida.");
    }
}
