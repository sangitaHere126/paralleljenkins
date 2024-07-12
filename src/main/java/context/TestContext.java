package context;

import managers.PageObjectManager;

import java.sql.SQLOutput;

public class TestContext {
    private PageObjectManager pageObjectManager;

    public TestContext(){
        System.out.println("Constructor TestContext");
        this.pageObjectManager =new PageObjectManager();
    }

    public PageObjectManager getPageObjectManager(){return pageObjectManager;}

    public void createScenario(String name) {
        System.out.println("scenario started");
    }

    public void endScenario(){
        this.pageObjectManager.getWebDriverManager().quit();
    }

    public void entersText(String textData, String oRKey){
        this.pageObjectManager.getWebDriverManager().entersText(textData, oRKey);
    }

}
