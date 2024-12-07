package org.example;

import java.util.Random;

public class UrlShortMaker {

    private Random random = new Random();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public String linkShortMaker(String longUrl) {
        long id = generateUniqueId(longUrl);

        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(ALPHABET.charAt((int)(id % BASE)));
            id /= BASE;
        }

        return sb.reverse().toString();
    }

    private long generateUniqueId(String url) {
        long id = random.nextLong();
        // Здесь можно добавить проверку на уникальность id в базе данных
        return id;
    }

}
