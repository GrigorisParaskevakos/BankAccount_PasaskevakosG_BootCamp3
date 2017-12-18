package mainapplication;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Paraskevakos Grigoris
 */

public class AdvancedEncryptionStandard {

    /*Private Key 16 characters (AES-128bit), 
   *                OR 
   * you can make your own here: String to hex ( https://www.theproblemsite.com/reference/mathematics/codes/hexadecimal-code ) 
   * reverse check here: ( http://string-functions.com/hex-string.aspx )
   * BUT remember: The length must be 16 character, 8bit/character = 128bit
   * */
  private static byte[] key = {0x68, 0x61, 0x70, 0x70, 0x79, 0x6e, 0x65, 0x77, 0x79, 0x65, 0x61, 0x72, 0x68, 0x6f, 0x68, 0x6f }; //happynewyearhoho  in hexcode

    /**
     * Encrypt Text
     */
    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedString = new String(Base64.getEncoder().encode(cipherText), "UTF-8");
            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Decrypt Text
     */
    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] cipherText = Base64.getDecoder().decode(encryptedText.getBytes("UTF8"));
            String decryptedString = new String(cipher.doFinal(cipherText), "UTF-8");
            return decryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
