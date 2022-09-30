package page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;

public class PrimePage {

    public PrimePage(Page page) {
        this.page = page;
    }

    public final String url = "https://www.primefaces.org/primevue/autocomplete";

    private final Page page;

    public void goToMain() {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }
}
