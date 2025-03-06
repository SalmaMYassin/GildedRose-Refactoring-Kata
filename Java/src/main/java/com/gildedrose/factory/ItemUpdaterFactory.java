package com.gildedrose.factory;

import java.util.HashMap;
import java.util.Map;

import com.gildedrose.model.ItemType;
import com.gildedrose.updater.AgedBrieUpdater;
import com.gildedrose.updater.BackstagePassUpdater;
import com.gildedrose.updater.ConjuredItemUpdater;
import com.gildedrose.updater.ItemUpdater;
import com.gildedrose.updater.NormalItemUpdater;
import com.gildedrose.updater.SulfurasUpdater;

public class ItemUpdaterFactory {

    private static final Map<ItemType, ItemUpdater> UPDATERS = new HashMap<>();

    static {
        UPDATERS.put(ItemType.AGED_BRIE, new AgedBrieUpdater());
        UPDATERS.put(ItemType.BACKSTAGE_PASSES, new BackstagePassUpdater());
        UPDATERS.put(ItemType.SULFURAS, new SulfurasUpdater());
        UPDATERS.put(ItemType.CONJURED, new ConjuredItemUpdater());
    }

    public static ItemUpdater getUpdater(ItemType type) {
        return UPDATERS.getOrDefault(type, new NormalItemUpdater());
    }
}
