package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Aged Brie": updateAgedBrie(item); break;
                case "Backstage passes to a TAFKAL80ETC concert": updateBackstagePasses(item); break;
                case "Conjured Item": updateConjured(item); break;
                case "Sulfuras, Hand of Ragnaros": break;
                default: updateNormalItem(item); break;
            }
        }
    }

       public void updateNormalItem(Item item){
        item.sellIn--;
        item.quality -= isExpired(item.sellIn) ? 2:1; 
        item.quality = Math.max(item.quality, MIN_QUALITY);
    }

    public void updateAgedBrie(Item item){
        item.sellIn--;
        item.quality += isExpired(item.sellIn) ? 2:1;
        item.quality = Math.min(item.quality, MAX_QUALITY);
    }

    public void updateBackstagePasses(Item item){
        item.sellIn--;
        if (isExpired(item.sellIn)) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality += 3;
        } else if (item.sellIn < 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
        item.quality = Math.min(item.quality, MAX_QUALITY);
    }

    public void updateConjured(Item item){
        item.sellIn--;
        item.quality -= isExpired(item.sellIn) ? 4:2; 
        item.quality = Math.max(item.quality, MIN_QUALITY);
    }

    public Boolean isExpired(int sellIn){
        return (sellIn < 0);
    }
}
