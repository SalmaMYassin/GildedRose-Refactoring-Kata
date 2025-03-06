package com.gildedrose.updater;

import com.gildedrose.model.GildedRoseItem;

public class AgedBrieUpdater implements ItemUpdater{

    @Override
    public void update(GildedRoseItem item) {
        item.decreaseSellIn();
        item.increaseQuality(item.isExpired() ? 2 : 1);
    }
}
