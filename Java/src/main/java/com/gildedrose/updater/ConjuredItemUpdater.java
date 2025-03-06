package com.gildedrose.updater;

import com.gildedrose.model.GildedRoseItem;

public class ConjuredItemUpdater implements ItemUpdater{

    @Override
    public void update(GildedRoseItem item) {
        item.decreaseSellIn();
        item.decreaseQuality(item.isExpired() ? 4 : 2);
    } 
}
