package com.gildedrose.updater;

import com.gildedrose.model.GildedRoseItem;

public class BackstagePassUpdater implements ItemUpdater{

    @Override
    public void update(GildedRoseItem item) {
        item.decreaseSellIn();
        int sellIn = item.getSellIn();

        if (item.isExpired()) {
            item.setQualityToZero();
        } else if (sellIn < 5) {
            item.increaseQuality(3);
        } else if (sellIn < 10) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality(1);
        }
    }
    
}
