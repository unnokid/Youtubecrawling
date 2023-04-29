package com.example.youtubepopularityrank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoutubepopularityRankApplication {

    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:\\Users\\kihyun2\\Desktop\\chromedriver_win32\\chromedriver.exe";

    public static void main(String[] args) {

        try {
            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(YoutubepopularityRankApplication.class, args);
    }

}
