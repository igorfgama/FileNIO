package service;

import enums.Plan;
import model.User;
import repository.UserRepository;
import validation.UserValidation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

public class SignService {
    public void addUser(String id, String password, String name, Plan plan, LocalDate validate) throws IOException {
        if(new UserService().containsUser(id)){
            User user = new User(id, password, name, plan, validate);
            new UserValidation().validate(user);
            new UserRepository().write(Collections.singletonList(user));
        } else {
            System.out.println("Usuário já existente.");
        }
    }
}
