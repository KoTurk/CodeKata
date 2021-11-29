package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
  List<Item> items;

  public GildedRose(List<Item> items) {
    this.items = items;
  }

  public void updateQuality() {
    filterByName(items);
    filterByName(filterBySellIn());
    agedBrieOrBackstage(items);
    ifNotSulfurasLowerSellIn();
    agedBrieOrBackstage(filterBySellIn());
    ifBackStagePasses();
  }

  private void ifNotSulfurasLowerSellIn() {
    items.stream().filter(this::ifNotSulfuras).forEach(item -> item.sellIn -= 1);
  }

  private void ifBackStagePasses() {
    items.stream()
        .filter(item -> item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
        .forEach(item -> item.quality -= item.quality);
  }

  private List<Item> filterBySellIn() {
    return items.stream().filter(item -> item.sellIn < 0).collect(Collectors.toList());
  }

  private void filterByName(List<Item> items) {
    items.stream()
        .filter(this::IfNotAgedBrieAndNotBackstagePasses)
        .filter(item -> item.quality > 0)
        .filter(this::ifNotSulfuras)
        .forEach(item -> item.quality -= 1);
  }

  private void agedBrieOrBackstage(List<Item> items) {
    items.stream()
        .filter(
            item ->
                item.name.equals("Aged Brie")
                    || item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
        .filter(item -> item.quality < 50)
        .forEach(item -> item.quality += 1);
  }

  private boolean IfNotAgedBrieAndNotBackstagePasses(Item item) {
    return !item.name.equals("Aged Brie")
        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private boolean ifNotSulfuras(Item item) {
    return !item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  public void extracted() {
    for (Item item : items) {
      if (!item.name.equals("Aged Brie")
          && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (item.quality > 0) {
          if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
          }
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;

          if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < 50) {
                item.quality = item.quality + 1;
              }
            }
          }
        }
      }

      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (!item.name.equals("Aged Brie")) {
          if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.quality > 0) {
              if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
              }
            }
          } else {
            item.quality = item.quality - item.quality;
          }
        } else {
          if (item.quality < 50) {
            item.quality = item.quality + 1;
          }
        }
      }
    }
  }
}
