package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptWorker {

    public CryptWorker() { }

    public String Crypt(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes){
            stringBuilder.append(String.format("%02X ", b));
        }
        return stringBuilder.toString().replaceAll(" ", "");
    }
}
