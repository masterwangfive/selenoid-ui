package org.selenoid.ui;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement toolsMenu = $x("//div[contains(@class, 'menu-main_item') and text() = 'Tools']");
    public SelenideElement searchButton = $("[data-test=menu-main-icon-search]");

    private TodoMvcPage todoMvcPage=new TodoMvcPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.browser="chrome";
    }

  /*  @Test
    void todo(){
        open("https://todomvc.com/examples/angularjs/");
        $("input.new-todo").sendKeys("Show Selenide");
        $("input.new-todo").pressEnter();
        $(withText("Show Selenide"))
                .shouldBe(Condition.visible).click();
    }*/
   /* @Test
    void todoMvc(){
        open("https://todomvc.com/examples/angularjs/");
        todoMvcPage.addItme("Show Selenide");
        todoMvcPage.shouldHaveShowItem();
        todoMvcPage.clickShowItem();

    }*/

}