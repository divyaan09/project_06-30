
# 🛡️ Image Encryption & Decryption in Java

This is a beginner-friendly Java project that demonstrates how to **encrypt and decrypt image files using AES (Advanced Encryption Standard)**. It is useful for understanding cryptography and data security concepts in the context of cybersecurity.

## 📌 Features

- Encrypts image files using AES 128-bit encryption.
- Decrypts the encrypted files back to the original image.
- Demonstrates key generation, saving, and loading.
- No third-party libraries required – uses only core Java.

## 📁 Files Included

- `ImageEncryptor.java` - The main program.
- `sample.jpg` - Sample image to be encrypted.
- `secret.key` - AES key file (generated during runtime).
- `encrypted.img` - Encrypted binary file.
- `decrypted.jpg` - Decrypted output image.
- `README.md` - This documentation.

## ▶️ How to Run

1. **Compile the program**:
    ```bash
    javac ImageEncryptor.java
    ```

2. **Place an image named `sample.jpg` in the same folder.**

3. **Run the program**:
    ```bash
    java ImageEncryptor
    ```

4. **Outputs**:
   - `encrypted.img`: Encrypted data.
   - `secret.key`: AES key used.
   - `decrypted.jpg`: Decrypted image (should match original).

## 🔐 AES Overview

- AES is a symmetric encryption algorithm.
- 128-bit key used for encrypting and decrypting files.
- Suitable for securing sensitive data like images, documents, etc.

## 📘 Learnings

- File handling in Java.
- Using `javax.crypto` package.
- Working with byte arrays.
- Real-world encryption workflows.

## 📌 Notes

- Do not delete `secret.key` file if you want to decrypt later.
- This project is for educational/demo purposes only.

---
Made for learning cryptography and cybersecurity basics!
# project_06-30
# project_06-30
