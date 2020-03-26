package com.company;

public class Item {
    String name;
    int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int add) {
        this.amount += add;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }
}
