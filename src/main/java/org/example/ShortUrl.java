package org.example;

import java.util.Date;

public class ShortUrl {

    private String longUrl;
    private Date dateCreation;
    private int maxClicks;
    private int currentClicks = 0;
    private String shortUrl;

    public ShortUrl(String longUrl, int maxClicks, String shortUrlValue, Date dateCreation) {
        this.longUrl = longUrl;
        this.maxClicks = maxClicks;
        this.dateCreation = dateCreation;
        shortUrl = "https://" + shortUrlValue;
    }

    public int getClickTLimit() {
        return maxClicks;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void updateLeftClicks() {
        currentClicks += 1;
        System.out.println("\nКоличество кликов обновлено. Осталось: " + (maxClicks - currentClicks));
    }

}
