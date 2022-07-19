package repository;

import model.Buy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyRepository implements Repository<List<Buy>> {
    static final List<String> buyList = new ArrayList<>();
    @Override
    public void write(List<Buy> buys) throws IOException {
        final Path path = validatePath();
        buyList.addAll(parseBuy(buys));
        Files.write(path, buyList);
    }

    @Override
    public List<Buy> read() throws IOException {
        final Path path = validatePath();
        List<Buy> buys = Files.lines(path, StandardCharsets.UTF_8)
                .map(c -> c.split(","))
                .map(s -> new Buy(s[0], s[1], Integer.parseInt(s[2]), LocalDateTime.parse(s[3])))
                .toList();
        buyList.addAll(parseBuy(buys));
        return buys;
    }

    private List<String> parseBuy(List<Buy> buys) {
        List<String> buysAsString = Collections.singletonList(buys.toString());
        buysAsString = buysAsString.stream()
                .map(c -> c.replace("[", ""))
                .map(c -> c.replace("]", ""))
                .toList();
        System.out.println(buysAsString);
        return buysAsString;
    }

    private Path validatePath() throws IOException {
        final Path path = Path.of("data_buy.csv");
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

    public List<String> getBuys(){
        return buyList;
    }
}
