package pages;

import managers.WebDriverManager;

public class HomePage {
    WebDriverManager app;

    public HomePage( WebDriverManager app){
        this.app=app;
    }

    public void load_url(String browserName){
        try{
            app.launchApp(browserName);

        } catch(Exception ex){
            System.out.println("not able to launch");
        }
    }

    public void navigate(String url){
        try{
            app.navigate(url);

        } catch(Exception ex){
            System.out.println("not able to launch");
        }
    }
}
