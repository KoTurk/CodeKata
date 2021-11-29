package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("foo", 0, 0));

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items.get(0).name);
    }

    @Test
    void fooExtracted() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("foo", 0, 0));

        GildedRose app = new GildedRose(items);
        app.extracted();
        assertEquals("foo", app.items.get(0).name);
    }

    @Test
    void testAgedBrie() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Aged Brie", 0, 0));

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items.get(0).name);
        assertEquals(2, app.items.get(0).quality);
    }

    @Test
    void testAgedBrieExtracted() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Aged Brie", 0, 0));

        GildedRose app = new GildedRose(items);
        app.extracted();
        assertEquals("Aged Brie", app.items.get(0).name);
        assertEquals(2, app.items.get(0).quality);
    }

    @Test
    void testBoyZone() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("BoyZone", -1, 10));

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("BoyZone", app.items.get(0).name);
        assertEquals(8, app.items.get(0).quality);
    }

    @Test
    void testBoyZoneExtracted() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("BoyZone", -1, 10));

        GildedRose app = new GildedRose(items);
        app.extracted();
        assertEquals("BoyZone", app.items.get(0).name);
        assertEquals(8, app.items.get(0).quality);
    }

    @Test
    void testAgedBrieQualityLesThanFifty() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Aged Brie", -2, 20));

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items.get(0).name);
        assertEquals(22, app.items.get(0).quality);
    }

    @Test
    void testAgedBrieQualityLesThanFiftyExtracted() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Aged Brie", -2, 20));

        GildedRose app = new GildedRose(items);
        app.extracted();
        assertEquals("Aged Brie", app.items.get(0).name);
        assertEquals(22, app.items.get(0).quality);
    }

    @Test
    void testBackStagePasses() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -2, 20));

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items.get(0).name);
        assertEquals(0, app.items.get(0).quality);
    }

    @Test
    void testBackStagePassesExtracted() {
        List<Item> items = new ArrayList<>(1);
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -2, 20));

        GildedRose app = new GildedRose(items);
        app.extracted();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items.get(0).name);
        assertEquals(0, app.items.get(0).quality);
    }
}
