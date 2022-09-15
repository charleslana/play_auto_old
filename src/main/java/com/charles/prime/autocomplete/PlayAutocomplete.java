package com.charles.prime.autocomplete;

import com.charles.prime.page.PlayAutoPage;
import com.microsoft.playwright.Page;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlayAutocomplete extends PlayAutoPage {

    public PlayAutocomplete(Page page) {
        this.page = page;
    }

    private final Page page;

    public void selectBasic(Integer autocompleteIndex, String text) {
        page.locator(AUTOCOMPLETE_INPUT).nth(autocompleteIndex).fill(text);
        assertThat(page.locator(AUTOCOMPLETE_ITEMS).nth(0)).hasText(text);
        page.locator(AUTOCOMPLETE_ITEMS).nth(0).click();
    }

    public void selectMultiple(Integer autocompleteIndex, List<String> texts) {
        texts.forEach(text -> {
            page.locator(AUTOCOMPLETE_INPUT).nth(autocompleteIndex).fill(text);
            assertThat(page.locator(AUTOCOMPLETE_ITEMS).nth(0)).hasText(text);
            page.locator(AUTOCOMPLETE_ITEMS).nth(0).click();
        });
    }
}
