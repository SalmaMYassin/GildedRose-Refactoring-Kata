package com.gildedrose.model;

public enum ItemType {
    NORMAL("Normal"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Item");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public static ItemType fromName(String name) {
        for (ItemType type : values()) {
            if (type.name.equalsIgnoreCase(name)) {
                return type;
            }
        }
        return NORMAL; // Default to NORMAL if no match
    }
}
