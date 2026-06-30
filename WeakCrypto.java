package com.example.security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Random;

public class WeakCrypto {

    // Weak cryptographic algorithm - MD5
    public String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Weak encryption - DES
    public byte[] encryptData(String data) throws Exception {
        String key = "weakkey1";
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        return cipher.doFinal(data.getBytes());
    }

    // Insecure random number generation
    public String generateToken() {
        Random random = new Random();
        return String.valueOf(random.nextInt(999999));
    }
}
