package com.gildedrose.model;

public class GildedRoseItem {

    private final Item item; // Using composition - to wrap the Item object (since we can't change the Item class directly)
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    public void decreaseSellIn() {
        item.sellIn--;
    }

    public void increaseQuality(int amount) {
        item.quality = Math.min(item.quality + amount, MAX_QUALITY);
    }

    public void decreaseQuality(int amount) {
        item.quality = Math.max(item.quality - amount, MIN_QUALITY);
    }

    public void setQualityToZero() {
        item.quality = 0;
    }

    public boolean isExpired() {
        return item.sellIn < 0;
    }
}
