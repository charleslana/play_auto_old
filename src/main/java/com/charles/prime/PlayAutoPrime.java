package com.charles.prime;

import com.charles.prime.autocomplete.PlayAutocomplete;
import com.microsoft.playwright.Page;

public record PlayAutoPrime(Page page) {

    public PlayAutocomplete autocomplete() {
        return new PlayAutocomplete(page);
    }
}
