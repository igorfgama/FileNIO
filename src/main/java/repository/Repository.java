package repository;

import java.io.IOException;

public interface Repository<T> {
    void write(T t) throws IOException;

    T read() throws IOException;
}
