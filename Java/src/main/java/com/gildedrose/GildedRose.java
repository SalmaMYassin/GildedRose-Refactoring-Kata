package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Aged Brie": updateAgedBrie(item); break;
                case "Backstage passes to a TAFKAL80ETC concert": updateBackstagePasses(item); break;
                case "Sulfuras, Hand of Ragnaros": break;
                default: updateNormalItem(item); break;
            }
        }
    }

    public void updateNormalItem(Item item){
        item.sellIn--;
        item.quality -= (item.sellIn < 0) ? 2:1; 
        item.quality = Math.max(item.quality, 0);
    }

    public void updateAgedBrie(Item item){
        item.sellIn--;
        item.quality += (item.sellIn < 0) ? 2:1;
        item.quality = Math.min(item.quality, 50);
    }

    public void updateBackstagePasses(Item item){
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            item.quality += 3;
        } else if (item.sellIn < 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
        item.quality = Math.min(item.quality, 50);
    }
}
