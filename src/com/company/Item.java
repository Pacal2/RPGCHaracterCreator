package com.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    String name;
    int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void addAmount(int add) {
        this.amount += add;
    }


}
