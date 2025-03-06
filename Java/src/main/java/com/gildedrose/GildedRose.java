package com.gildedrose;

import com.gildedrose.factory.ItemUpdaterFactory;
import com.gildedrose.model.GildedRoseItem;
import com.gildedrose.model.Item;
import com.gildedrose.model.ItemType;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            GildedRoseItem gildedRoseItem = new GildedRoseItem(item);
            ItemType type = ItemType.fromName(gildedRoseItem.getName());
            ItemUpdaterFactory.getUpdater(type).update(gildedRoseItem);
        }
    }

}
