package service;

import model.User;
import repository.UserRepository;

import java.io.IOException;
import java.util.List;

public class UserService {
    public boolean containsUser(String id) throws IOException {
        List<User> users = new UserRepository().read();

        return users.stream()
                .anyMatch(u -> u.id().equals(id));
    }
}
