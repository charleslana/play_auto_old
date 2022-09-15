package test;

import base.BaseTestClass;
import com.charles.PlayAuto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import page.PrimePage;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PrimeTest extends BaseTestClass {

    PrimePage primePage;

    @BeforeEach
    public void setUp() {
        page.setDefaultTimeout(60000);
        primePage = new PrimePage(page);
    }

    @Order(1)
    @Test
    @DisplayName("Should autocomplete basic")
    void shouldAutocompleteBasic() {
        primePage.goToMain();
        PlayAuto.getInstance(page).prime().autocomplete().selectBasic(1, "Brazil");
    }

    @Order(2)
    @Test
    @DisplayName("Should autocomplete multiple")
    void shouldAutocompleteMultiple() {
        primePage.goToMain();
        page.mouse().wheel(0, 300);
        PlayAuto.getInstance(page).prime().autocomplete().selectMultiple(5, List.of("Brazil", "United States"));
    }
}
