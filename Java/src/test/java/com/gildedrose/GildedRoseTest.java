package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    // Normal Item
    @Test
    void normalItem_qualityDecreasesSellinDecreases() {
        Item[] items = { new Item("Normal Item", 11, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(10, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void normalItem_qualityDecreasesTwiceAsFastAfterSellIn() {
        Item[] items = { new Item("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality); // Decreases by 2
    }

    @Test
    void normalItem_qualityNeverGoesBelowZero() {
        Item[] items = { new Item("Normal Item", 5, 0) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}
