package org.example;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UrlShortMaker {

    private Date dateCreation;
    private String shortUrlValue;

    private final Map<String, Map<String, ShortUrl>> history = new HashMap<>();

    public String genеrateShortUrl(String uuid, int maxClicks, String longUrl) {
        dateCreation = new Date();
        shortUrlValue = generateUniqueHash(longUrl + maxClicks + dateCreation + uuid);
        ShortUrl shortUrl = new ShortUrl(longUrl, maxClicks, shortUrlValue, dateCreation);
        saveShortUrl(uuid, shortUrl);
        return shortUrl.getShortUrl();
    }

    public ShortUrl getLongUrl(String uuid, String shortUrl) {
        Map<String,ShortUrl> map;
        ShortUrl longUrl = null;

        try {
            map = history.get(uuid);
            longUrl = map.get(shortUrl);

        } catch (Exception e) {
            System.out.println("Короткая ссылка не существует!");
        }
        return longUrl;
    }

    public String generateUniqueHash(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(value.getBytes());
            String hash = Base64.getUrlEncoder().encodeToString(hashInBytes);

            return hash.substring(0, 5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    private void saveShortUrl(String uuid, ShortUrl shortUrl) {
        Map<String, ShortUrl> map = history.get(uuid);
        if (map != null) {
            map.put(shortUrl.getShortUrl(), shortUrl);
            history.put(uuid, map);
        } else {
            Map<String, ShortUrl> mapNew = new HashMap<>();
            mapNew.put(shortUrl.getShortUrl(), shortUrl);
            history.put(uuid, mapNew);
        }
    }

    public void printHistory() {
        for (Map.Entry<String, Map<String, ShortUrl>> entry : history.entrySet()) {
            System.out.println("UUID: " + entry.getKey());

            for (Map.Entry<String, ShortUrl> urlEntry : entry.getValue().entrySet()) {
                ShortUrl shortUrl = urlEntry.getValue();
                System.out.printf("\tShort URL: %s\n\tLong URL: %s\n\tMax Clicks: %d\n\tDate Creation: %s\n",
                        shortUrl.getShortUrl(),
                        shortUrl.getLongUrl(),
                        shortUrl.getClickTLimit(),
                        shortUrl.getDateCreation()
                );
            }
        }
    }
}
