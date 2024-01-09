import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println(differenceEvenOdd(new int[]{44, 32, 86, 19}));
        System.out.println(differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 5}));
        System.out.println(equalToAvg(new int[]{1, 2, 3, 4, 6}));
        System.out.println(Arrays.toString(indexMult(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(indexMult(new int[]{3, 3, -2, 408, 3, 31})));
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }
    public static boolean duplicateChars(String str) {
        Set<Character> chars = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!chars.add(c)) {
                return true;
            }
        }
        return false;
    }

    public static String getInitials(String name) {
        String[] parts = name.split(" ");
        return "" + parts[0].charAt(0) + parts[1].charAt(0);
    }

    public static int differenceEvenOdd(int[] arr) {
        int evenSum = 0, oddSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        return Math.abs(evenSum - oddSum);
    }

    public static boolean equalToAvg(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        double avg = (double) sum / arr.length;
        for (int num : arr) {
            if (num == avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= i;
        }
        return arr;
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int Tribonacci(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;

        int a = 0, b = 0, c = 1, d;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static String pseudoHash(int length) {
        Random rnd = new Random();
        String characters = "abcdef0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rnd.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public static String botHelper(String transcript) {
        return transcript.toLowerCase().contains("help") ? "Calling for a staff member" : "Keep waiting";
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);
        return Arrays.equals(str1Arr, str2Arr);
    }

}