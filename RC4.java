import java.util.Scanner;

public class RC4 {
    public static String encrypt(String key, String data) {
        // Initialize state array
        int[] state = new int[256];
        for (int i = 0; i < 256; i++) {
            state[i] = i;
        }
        
        // Key scheduling
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + state[i] + key.charAt(i % key.length())) % 256;
            swap(state, i, j);
        }
        
        // Generate output
        StringBuilder output = new StringBuilder();
        int i = 0;
        j = 0;
        
        for (char c : data.toCharArray()) {
            i = (i + 1) % 256;
            j = (j + state[i]) % 256;
            swap(state, i, j);
            int keystream = state[(state[i] + state[j]) % 256];
            output.append((char)(c ^ keystream));
        }
        
        return output.toString();
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String encrypted = encrypt(key, text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + encrypt(key, encrypted));
        
        scanner.close();
    }
}