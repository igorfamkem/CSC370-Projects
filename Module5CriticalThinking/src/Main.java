
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        int[] numberArray = new int [5];


        System.out.println("Enter five numbers: ");

        for (int i = 0; i < 5; i++) {

            System.out.print("Number " + (i + 1) + ": ");
            numberArray[i] = kb.nextInt();

        }

        int product = calculateProduct(numberArray , 5);

        System.out.println("The product of the five numbers is: "+ product);

    }

    public static int calculateProduct(int[] numberArray, int n) {
        if (n <= 0) {
            return 1;
        }
        return numberArray[n - 1] * calculateProduct(numberArray, n - 1);
    }



}