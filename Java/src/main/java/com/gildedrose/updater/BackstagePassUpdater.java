package com.gildedrose.updater;

import com.gildedrose.model.Item;

public class BackstagePassUpdater implements ItemUpdater{

    @Override
    public void update(Item item) {
        item.sellIn--;
        if ((item.sellIn < 0)) {
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
