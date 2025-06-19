import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;

public class ImageEncryptor {

    // Encrypt file
    public static void encrypt(String inputImagePath, String outputEncryptedPath, SecretKey secretKey) throws Exception {
        byte[] imageBytes = Files.readAllBytes(new File(inputImagePath).toPath());

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(imageBytes);

        try (FileOutputStream fos = new FileOutputStream(outputEncryptedPath)) {
            fos.write(encryptedBytes);
        }

        System.out.println("Encryption complete. File saved as: " + outputEncryptedPath);
    }

    // Decrypt file
    public static void decrypt(String encryptedImagePath, String outputImagePath, SecretKey secretKey) throws Exception {
        byte[] encryptedBytes = Files.readAllBytes(new File(encryptedImagePath).toPath());

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        try (FileOutputStream fos = new FileOutputStream(outputImagePath)) {
            fos.write(decryptedBytes);
        }

        System.out.println("Decryption complete. File saved as: " + outputImagePath);
    }

    // Generate AES Key
    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // AES 128-bit key
        return generator.generateKey();
    }

    // Save and load key (for practical use)
    public static void saveKey(SecretKey key, String path) throws IOException {
        byte[] keyBytes = key.getEncoded();
        Files.write(new File(path).toPath(), keyBytes);
    }

    public static SecretKey loadKey(String path) throws IOException {
        byte[] keyBytes = Files.readAllBytes(new File(path).toPath());
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static void main(String[] args) throws Exception {
        String inputImage = "sample.jpg";
        String encryptedFile = "encrypted.img";
        String decryptedImage = "decrypted.jpg";
        String keyFile = "secret.key";

        // Generate and save key
        SecretKey key = generateAESKey();
        saveKey(key, keyFile);

        // Encrypt image
        encrypt(inputImage, encryptedFile, key);

        // Load the key and decrypt
        SecretKey loadedKey = loadKey(keyFile);
        decrypt(encryptedFile, decryptedImage, loadedKey);
    }
}
