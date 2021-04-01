package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FindSelenideGitHubTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

        @Test
        void findSelenideInGitHub() {
            open("https://github.com/");
            $("[name=q]").setValue("selenide").pressEnter();
            $$("ul.repo-list li").first().$("a").click();
            $("h1").shouldHave(Condition.text("selenide / selenide"));
            $(byText("Wiki")).click();
            $("#wiki-pages-box").$(byText("SoftAssertions")).click();
            $("#wiki-wrapper").shouldHave(Condition.text("SoftAssertions"));
            $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));
        }
    }

