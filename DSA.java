
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;
import java.util.Scanner;

public class DSA {

    public static void main(String[] args) {
        try {
            // Generate a KeyPair using DSA (Digital Signature Algorithm)
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
            keyPairGen.initialize(2048);
            KeyPair keyPair = keyPairGen.generateKeyPair();
            
            // Extract the private and public keys
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            // Get user input for the message to sign
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the secret message:");
                String message = sc.nextLine();

                // Initialize the Signature object for signing with SHA256 and DSA
                Signature signature = Signature.getInstance("SHA256withDSA");
                signature.initSign(privateKey);
                signature.update(message.getBytes());

                // Generate the digital signature
                byte[] digitalSignature = signature.sign();
                String signatureBase64 = Base64.getEncoder().encodeToString(digitalSignature);
                System.out.println("Digital Signature: " + signatureBase64);

                // Initialize the Signature object for verification
                signature.initVerify(publicKey);
                signature.update(message.getBytes());

                // Verify the digital signature
                boolean isVerified = signature.verify(digitalSignature);
                System.out.println("Signature verification result: " + isVerified);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
