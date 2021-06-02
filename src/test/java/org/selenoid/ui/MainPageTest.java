package org.selenoid.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private MainPage page=new MainPage();
    @BeforeAll
    public static void setUpAllure(){
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
    @BeforeEach
    public void setUp(){
        Configuration.startMaximized=true;
        open("https://www.jetbrains.com/");
    }

    @Test
    public void search(){
        page.searchButton.click();
       // $(byId("header-search")).sendKeys("Selenium");
        $("[data-test=search-input]").sendKeys("Selenium");
        $(byXpath("//button[@type='submit' and text()='Search']")).click();

        $(byClassName("js-search-input")).shouldHave(Condition.attribute("value","Selenium"));

    }
    @Test
    public void toolsMenu() {
        page.toolsMenu.hover();
        $(byClassName("menu-mail_popup-wrapper")).shouldBe(Condition.visible);
    }
    @Test
    public void navigationToAllTools(){
        page.seeAllToolsButton.click();
        $(byClassName("products-list")).shouldBe(Condition.visible);
        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
}