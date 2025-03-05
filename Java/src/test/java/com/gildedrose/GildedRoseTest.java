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

    // Sulfuras
    @Test
    void sulfuras_neverChanges() {
        Item[] items = { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    // Backstage Passes

    @Test
    void backstagePasses_increaseBy1WhenSellInAbove10Days() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void backstagePasses_increaseBy2WhenSellIn10DaysOrLess() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void backstagePasses_increaseBy3WhenSellIn5DaysOrLess() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void backstagePasses_qualityDropsToZeroAfterConcert() {
        Item[] items = { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }
}
