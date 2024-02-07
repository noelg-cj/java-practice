import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string: ");
        String s = sc.next();
        int len = s.length();
        boolean flag = true;
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len-i-1)) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("It is a palindrome");
        }
        else {
            System.out.println("It is not a palindrome.");
        }
    }
}