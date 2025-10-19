
package com.mycompany.concavemirrorverifier;
import java.util.Scanner;
/**
 *
 * @author MUSH
 */
public class ConcaveMirrorVerifier {

     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
   
        // Accept object distance u from user
        System.out.print("\nEnter object distance u (in cm): ");
        double u = input.nextDouble();
        
        // Make sure u is negative for concave mirror
        if (u > 0) {
            u = -u; // Convert to negative for concave mirror
            System.out.println("Note: Object distance converted to negative for concave mirror: " + u + " cm");
        }
        
        // Accept image distance v from user
        System.out.print("Enter image distance v (in cm): ");
        double v = input.nextDouble();
        
        // Calculate focal length using mirror formula: 1/f = 1/v + 1/u
        double focalLength = calculateFocalLength(u, v);
        
        // Display results
        System.out.println("\n==================================================");
        System.out.println("               CALCULATION RESULTS");
        System.out.println("==================================================");
        System.out.printf("Object distance (u): %.2f cm%n", u);
        System.out.printf("Image distance (v): %.2f cm%n", v);
        System.out.printf("Calculated focal length (f): %.2f cm%n", focalLength);
        
        // Check if mirror is acceptable (focal length between 21.0cm and 25.0cm inclusive)
        boolean isAcceptable = isFocalLengthAcceptable(focalLength);
        
        System.out.println("\n==================================================");
        System.out.println("               VERIFICATION RESULT");
        System.out.println("==================================================");
        if (isAcceptable) {
            System.out.println("ACCEPTABLE: Focal length lies between 21.0cm and 25.0cm");
            System.out.println("   The concave mirror meets WAKISHA MOCK EXAM standards!");
        } else {
            System.out.println("NOT ACCEPTABLE: Focal length is outside required range");
            System.out.println("   The concave mirror does NOT meet WAKISHA MOCK EXAM standards!");
        }
        System.out.println("==================================================");
        
        input.close();
    }
    

    public static double calculateFocalLength(double u, double v) {
        // Mirror formula: 1/f = 1/v + 1/u
        double reciprocalF = (1.0 / v) + (1.0 / u);
        
        // f = 1 / (1/v + 1/u)
        double focalLength = 1.0 / reciprocalF;
        
        return focalLength;
    }
    
    /**
     * Checks if focal length is within acceptable range for WAKISHA MOCK Exams
     * @param focalLength
     * @return 
    **/
    public static boolean isFocalLengthAcceptable(double focalLength) {
        // Check if focal length lies between 21.0cm and 25.0cm inclusive
        return (focalLength >= 21.0 && focalLength <= 25.0);
    }
}