package org.skypro.skyshop.engine;

import org.skypro.skyshop.search.Searchable;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (count < searchables.length) {
            searchables[count] = searchable;
            count++;
        } else {
            System.out.println("Невозможно добавить: поисковый движок заполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            if (searchable.getSearchTerm().contains(query)) {
                results[found] = searchable;
                found++;
                if (found == 5) break;
            }
        }
        return results;
    }
}