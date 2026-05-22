package org.sebsy.strategy;

public class Tri {

    public void exec(int typeTri, Integer[] arr) {
        TypeTri type = TypeTri.fromValue(typeTri);
        Strategy strategy = StrategyFactory.getStrategy(type);
        strategy.trier(arr);
    }
}
