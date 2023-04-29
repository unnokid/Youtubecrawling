package com.example.youtubepopularityrank.service;

import com.example.youtubepopularityrank.entity.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlingService {

    public List<Video> getInfo() {
        //크롬 설정을 담은 객체
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        //options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://www.youtube.com";
        driver.get(url);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        List<WebElement> el1 = driver.findElements(By.className("title"));
        for (int i = 0; i < el1.size(); i++) {
            if (el1.get(i).getText().equals("인기 급상승")) {
                el1.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }

        List<WebElement> el2 = driver.findElements(By.className("tab-title"));

        for (int i = 0; i < el2.size(); i++) {
            if (el2.get(i).getText().equals("음악")) {
                el2.get(i).click();
                break;
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        List<WebElement> el3 = driver.findElement(By.id("grid-container")).findElements(By.id("dismissible"));

        List<Video> videoList = new ArrayList<>();

        for (int i = 0; i < el3.size(); i++) {
            String thumbnail = el3.get(i).findElement(By.cssSelector("img")).getAttribute("src");
            WebElement element = el3.get(i).findElement(By.id("video-title"));
            String title = element.getAttribute("title");
            String target = element.getAttribute("href");
            String description = element.getAttribute("aria-label");
            videoList.add(new Video(thumbnail, title, target, description));
        }

        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return videoList;
    }
}
