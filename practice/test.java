import java.util.*;

public class test {
    public static void convertToBinary(int n) {
        int[] binary = new int[1000];

        int i = 0;
        while (n > 0) {
            binary[i] = n%2;
            n = n/2;
            i++;
        }

        for (int j = i-1; j >= 0; j--) {
            System.out.print(binary[j]);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        convertToBinary(n);
    }
}