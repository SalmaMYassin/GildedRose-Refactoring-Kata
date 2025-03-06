package com.gildedrose.factory;

import java.util.HashMap;
import java.util.Map;

import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassUpdater;
import com.gildedrose.updater.ConjuredItemUpdater;
import com.gildedrose.updater.ItemUpdater;
import com.gildedrose.updater.NormalItemUpdater;
import com.gildedrose.updater.SulfurasUpdater;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdater> UPDATERS = new HashMap<>();
    
    static {
        UPDATERS.put("Aged Brie", new AgedBrieUpdater());
        UPDATERS.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        UPDATERS.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        UPDATERS.put("Conjured Item", new ConjuredItemUpdater());
    }

    public static ItemUpdater getUpdater(String type) {
        return UPDATERS.getOrDefault(type, new NormalItemUpdater());
    }
}

