package org.selenoid.ui;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
public class TodoMvcPage {
    public SelenideElement newtodoInput=$("input.new-todo");
    public SelenideElement showItem=$(byText("Show Selenide"));

    void addItme(String text){
        newtodoInput.sendKeys(text);
        newtodoInput.pressEnter();
    }
    void shouldHaveShowItem(){
        showItem.shouldBe(Condition.visible);
    }
    void clickShowItem(){
        showItem.click();
    }
}
