package ru.zavrichko;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("selenide/selenide");
        $(".header-search-input").submit();

        $(linkText("selenide/selenide")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#16900")).should(Condition.visible);

    }
}
