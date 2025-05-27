package com.app.shared.util;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class EncryptionUtils {
    private static final String PASSWORD = "secret-key";
    private static final String SALT = "deadbeef";

    private static final TextEncryptor encryptor = Encryptors.text(PASSWORD, SALT);

    public static String encrypt(String data) {
        return encryptor.encrypt(data);
    }

    public static String decrypt(String encrypted) {
        return encryptor.decrypt(encrypted);
    }
}
