package demoqa.TextBox;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue("Mikhail Kocherginsky");
        $("#userEmail").setValue("Koche@mail.ru");
        $("#currentAddress").setValue("city: Kostroma street:Testovaya  building:1  ");
        $("#permanentAddress").setValue("city: Kostroma street:Testovaya  building:2  ");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text("Mikhail Kocherginsky")));
        $("#output #email").shouldHave((text("Koche@mail.ru")));


    }
}
