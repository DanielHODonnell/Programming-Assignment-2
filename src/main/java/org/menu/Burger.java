package org.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Burger {
    private final List<Double> prices = new ArrayList<>();

    public void addBun(String bun) {
        if ("Sesame".equals(bun)) prices.add(2.00);
        if ("Brioche".equals(bun)) prices.add(2.50);
    }

    public void addCheese(String cheese) {
        switch (cheese) {
            case "Cheddar" -> prices.add(0.50);
            case "American" -> prices.add(0.50);
            case "Swiss" -> prices.add(0.75);
            case "Pepper Jack" -> prices.add(1.00);
        }
    }

    public void addTopping(String topping) {
        switch (topping) {
            case "Lettuce" -> prices.add(0.10);
            case "Onion" -> prices.add(0.15);
            case "Tomato" -> prices.add(0.25);
            case "Bacon" -> prices.add(1.00);
        }
    }

    public void addPatty(String patty) {
        switch (patty) {
            case "Veg" -> prices.add(1.50);
            case "NonVeg" -> prices.add(1.00);
            case "Impossible" -> prices.add(0.75);
            case "Chicken" -> prices.add(1.00);
        }
    }

    public double getPrice() {
        Collections.sort(prices);
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    public List<Double> getSortedPrice() {
        List<Double> sorted = new ArrayList<>(prices);
        Collections.sort(sorted);
        return sorted;
    }
}
