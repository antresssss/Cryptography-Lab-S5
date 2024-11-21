
import java.util.Scanner;   

public class SubstitutionCipher
{   
 public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
   
 public static String encryptData(String inputStr, int shiftKey)   
 {   
     inputStr = inputStr.toLowerCase();   
        
     String encryptStr = "";   
        
     for (int i = 0; i < inputStr.length(); i++)   
     {   
         int pos = ALPHABET.indexOf(inputStr.charAt(i));   
           
         int encryptPos = (shiftKey + pos) % 26;   
         char encryptChar = ALPHABET.charAt(encryptPos);   
  
         encryptStr += encryptChar;   
     }   
     return encryptStr;   
 }   
   
  
 public static String decryptData(String inputStr, int shiftKey)   
 {   
 
     inputStr = inputStr.toLowerCase();   
       
 
     String decryptStr = "";   
       
     for (int i = 0; i < inputStr.length(); i++)   
     {   
           
         int pos = ALPHABET.indexOf(inputStr.charAt(i));   
             
         int decryptPos = (pos - shiftKey) % 26;   
           
         // if decryptPos is negative   
         if (decryptPos < 0){   
             decryptPos = ALPHABET.length() + decryptPos;   
         }   
         char decryptChar = ALPHABET.charAt(decryptPos);   
           
         decryptStr += decryptChar;   
     }   
     return decryptStr;   
 }   
     
 public static void main(String[] args)   
 {    
     Scanner sc = new Scanner(System.in);   
        
     System.out.println("Enter a string for encryption using Caesar Cipher: ");   
     String inputStr = sc.nextLine();  
     String pt=inputStr.replace(" ", "");
          
     System.out.println("Encrypted Data ===> "+encryptData(pt, 3));
     
     System.out.println("Decrypted Data ===> "+decryptData(encryptData(pt, 3), 3).toUpperCase());       
     sc.close();   
 }   
}   

