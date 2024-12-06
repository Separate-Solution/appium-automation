package com.stampfree.utils;

import org.openqa.selenium.WebElement;

public class AppInteractions {
    protected static void fixedWait() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException iex) {
            System.out.println(iex.getMessage());
        }
    }
    protected void clearTextfield(WebElement textfield){
        textfield.clear();
    }
    protected void clickButton(WebElement button){
        button.click();
    }
    protected void inputText(WebElement textfield, String text){
        textfield.sendKeys(text);
    }
}
