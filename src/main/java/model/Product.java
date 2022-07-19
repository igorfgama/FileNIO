package model;

import enums.Category;

import java.math.BigDecimal;

public record Product(String code, String name, BigDecimal price, Category category, Integer inventory) {

    @Override
    public String toString() {
        return this.code + "," + this.name + "," + this.price + "," + this.category + "," + this.inventory;
    }
}
