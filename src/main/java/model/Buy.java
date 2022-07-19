package model;

import java.time.LocalDateTime;

public record Buy(String code, String id, Integer quantity, LocalDateTime date) {
    @Override
    public String toString() {
        return this.code + "," + this.id + "," + this.quantity + "," + this.date;
    }
}
