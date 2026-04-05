
import java.util.Scanner;
import java.util.Arrays;

public class Cupcake {

    // Task: Determine the minimum miles Marc must walk
    public long calculateMinimumMiles(int[] calories, int n) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(calories);
        
        long totalMiles = 0;
        
        // Step 2: Iterate backward to simulate descending order
        // This ensures the largest calories get the smallest multiplier (j=0)
        for (int i = 0; i < n; i++) {
            // 'i' represents our 'j' from the formula (0, 1, 2...)
            // 'calories[n - 1 - i]' gets the largest remaining calorie count
            int currentCalories = calories[n - 1 - i];
            
            // Calculate distance: c * 2^j
            // We use a long to prevent integer overflow for large numbers
            long distance = currentCalories * (long)Math.pow(2, i);
            
            totalMiles += distance;
        }
        
        return totalMiles;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of cupcakes
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] calories = new int[n];
            
            // Read calorie counts
            for (int i = 0; i < n; i++) {
                calories[i] = sc.nextInt();
            }
            
            Cupcake solver = new Cupcake();
            System.out.println(solver.calculateMinimumMiles(calories, n));
        }
        
        sc.close();
    }
}
