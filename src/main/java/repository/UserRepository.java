package repository;

import enums.Plan;
import model.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository implements Repository<List<User>> {
    static final List<String> usersList = new ArrayList<>();

    @Override
    public void write(List<User> users) throws IOException {
        final Path path = validatePath();
        usersList.addAll(parseUser(users));
        Files.write(path, usersList);
    }

    @Override
    public List<User> read() throws IOException {
//        final Path path = validatePath();
//        List<User> users = Files.lines(path, StandardCharsets.UTF_8)
//                .map(c -> c.split(","))
//                .map(s -> new User(s[0], s[1], s[2], Enum.valueOf(Plan, s[3]), LocalDate.parse(s[4])))
//                .toList();
//        usersList.addAll(parseUser(users));
//
//        return users;
        return null;
    }

    private Path validatePath() throws IOException {
        final Path path = Path.of("data_user.csv");
        try {
            if(Files.exists(path)){
                return path;
            } else {
                return Files.createFile(path);
            }
        } catch (IOException e){
            throw new IOException("Inválido");
        }
    }

    private List<String> parseUser(List<User> users) {
        List<String> usersAsString = Collections.singletonList(users.toString());
        usersAsString = usersAsString.stream()
                .map(c -> c.replace("[", ""))
                .map(c -> c.replace("]", ""))
                .toList();
        System.out.println(usersAsString);
        return usersAsString;
    }

    public List<String> getUsers() { return usersList; }
}
