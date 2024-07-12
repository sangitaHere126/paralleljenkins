package managers;

import pages.HomePage;

public class PageObjectManager {
    HomePage homePage;
    WebDriverManager app;

    public PageObjectManager(){
        this.app= new WebDriverManager();
    }

    public WebDriverManager getWebDriverManager() {
        return app;
    }

    public HomePage getHomePage(){
        if(homePage==null) {
            homePage = new HomePage(app);
        }
        return homePage;

    }
}
