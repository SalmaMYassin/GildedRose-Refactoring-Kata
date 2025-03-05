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

    // Aged Brie  
    @Test
    void agedBrie_qualityIncreasesSellinDecreases() {
        Item[] items = { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(4, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    void agedBrie_qualityIncreasesTwiceAsFastAfterSellIn() {
        Item[] items = { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(-1, items[0].sellIn);
        assertEquals(12, items[0].quality); // Increases by 2
    }

    @Test
    void agedBrie_qualityNeverExceeds50() {
        Item[] items = { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

}
