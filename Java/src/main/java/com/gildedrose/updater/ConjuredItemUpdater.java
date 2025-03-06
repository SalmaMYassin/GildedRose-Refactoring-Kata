package com.gildedrose.updater;

import com.gildedrose.model.Item;

public class ConjuredItemUpdater implements ItemUpdater{

    @Override
    public void update(Item item) {
        item.sellIn--;
        item.quality -= (item.sellIn<0) ? 4:2; 
        item.quality = Math.max(item.quality, 0);
    }
    
}
