package be.wihtow.utils.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author X-L
 */
public enum Password {

    INSTANCE;

    public String encode(String password) {
        String saltedPass = "YouRSaltToAnnoyPeople!:)" + password;
        byte[] uniqueKey = saltedPass.getBytes();
        byte[] hash;

        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        return hashString.toString();
    }
}
