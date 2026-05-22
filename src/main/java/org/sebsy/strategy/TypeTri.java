package org.sebsy.strategy;

public enum TypeTri {
    BUBBLE_SORT(1),
    INSERTION_SORT(2),
    SELECTION_SORT(3);

    private final int value;

    TypeTri(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TypeTri fromValue(int value) {
        for (TypeTri type : TypeTri.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid typeTri value: " + value);
    }
}
