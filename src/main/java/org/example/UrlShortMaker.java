package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class UrlShortMaker {


    public String generateUniqueUrl(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(longUrl.getBytes());
            String hash = Base64.getUrlEncoder().encodeToString(hashInBytes);

            return hash.substring(0, 5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
