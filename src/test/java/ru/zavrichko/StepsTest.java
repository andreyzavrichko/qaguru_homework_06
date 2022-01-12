package ru.zavrichko;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsTest {

    private static final String REPOSITORY = "selenide/selenide";
    private static final int NUMBER = 16900;

    @Test
    public void lambdaStepTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Проверяем наличие Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });


    }
}









