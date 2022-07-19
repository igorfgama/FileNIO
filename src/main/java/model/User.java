package model;

import enums.Plan;

import java.time.LocalDate;

public record User(String id, String password, String name, Plan plan, LocalDate validate) {
    @Override
    public String toString() {
        return this.id + "," + this.password + "," + this.name + "," + this.plan + "," + this.validate;
    }
}
