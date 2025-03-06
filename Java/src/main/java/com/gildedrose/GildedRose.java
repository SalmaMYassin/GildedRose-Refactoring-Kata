package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;
import com.gildedrose.model.GildedRoseItem;
import com.gildedrose.model.Item;

class GildedRose {
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            GildedRoseItem gildedRoseItem = new GildedRoseItem(item);
            ItemUpdaterFactory.getUpdater(gildedRoseItem.getName()).update(gildedRoseItem);
        }
    }

}
