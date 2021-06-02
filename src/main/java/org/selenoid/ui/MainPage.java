package org.selenoid.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
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
    @Test
    void todoMvc(){
        open("https://todomvc.com/examples/angularjs/");
        todoMvcPage.addItme("Show Selenide");
        todoMvcPage.shouldHaveShowItem();
        todoMvcPage.clickShowItem();

    }
}