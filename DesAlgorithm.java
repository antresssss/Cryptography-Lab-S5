
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

class DesAlgorithm{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a message: ");
        String message = sc.nextLine();

        try {
            // Convert message to bytes
            byte[] myMessage = message.getBytes();

            // Generate a DES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keyGenerator.generateKey();

            // Initialize the Cipher for encryption
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            // Encrypt the message
            byte[] encryptedBytes = cipher.doFinal(myMessage);

            // Initialize the Cipher for decryption
            cipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the message
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convert encrypted and decrypted bytes back to Strings
            String encryptedData = new String(encryptedBytes);
            String decryptedData = new String(decryptedBytes);

            // Output results
            System.out.println("Original Message: " + message);
            System.out.println("Encrypted: " + encryptedData);
            System.out.println("Decrypted: " + decryptedData);

        } catch (Exception e) {
            System.out.println("An error occurred during encryption/decryption");
        }

        sc.close();
    }
}
