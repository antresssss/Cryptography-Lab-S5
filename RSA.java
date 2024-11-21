import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    private static BigInteger n, e, d;  
    // Generate keys
    public static void generateKeys() {
        BigInteger p = BigInteger.valueOf(61), q = BigInteger.valueOf(53);
        n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(17);
        d = e.modInverse(phi);
    }
    
    // Encrypt a message
    public static BigInteger encrypt(int message) {
        return BigInteger.valueOf(message).modPow(e, n);
    }
    
    // Decrypt a message
    public static int decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n).intValue();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        generateKeys();
        
        System.out.print("Enter a number to encrypt (less than 3233): ");
        int message = scanner.nextInt();
        
        BigInteger ciphertext = encrypt(message);
        System.out.println("Encrypted: " + ciphertext);
        
        System.out.println("Decrypted: " + decrypt(ciphertext));
        
        scanner.close();
    }
}
