import java.util.*;

public class Main {
    public static void main(String[] args) {
            System.out.println(replaceVowels("apple"));
            System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));

            System.out.println(stringTransform("hello"));
            System.out.println(stringTransform("bookkeeper"));

            System.out.println(doesBlockFit(1, 3, 5, 4, 5));
            System.out.println(doesBlockFit(1, 8, 1, 1, 1));
            System.out.println( doesBlockFit(1, 2, 2, 1, 1));

            System.out.println(numCheck(243));
            System.out.println(numCheck(52));

            System.out.println(countRoots(new int[]{1, -3, 2}));
            System.out.println(countRoots(new int[]{2, 5, 2}));
            System.out.println(countRoots(new int[]{1, -6, 9}));

            String[][] salesData1 = {
                    {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                    {"Banana", "Shop2", "Shop3", "Shop4"},
                    {"Orange", "Shop1", "Shop3", "Shop4"},
                    {"Pear", "Shop2", "Shop4"}
            };
            System.out.println(salesData(salesData1));

            String[][] salesData2 = {
                    {"Fridge", "Shop2", "Shop3"},
                    {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                    {"Laptop", "Shop3", "Shop4"},
                    {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
            };
            System.out.println(salesData(salesData2));

            System.out.println(validSplit("apple eagle egg goat"));
            System.out.println(validSplit("cat dog goose fish"));

            System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
            System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
            System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));

            System.out.println(commonVowel("Hello world"));
            System.out.println(commonVowel("Actions speak louder than words."));

            int[][] data1 = {
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {5, 5, 5, 5, 5},
                    {7, 4, 3, 14, 2},
                    {1, 0, 11, 10, 1}
            };
            System.out.println(Arrays.deepToString(dataScience(data1)));

            int[][] data2 = {
                    {6, 4, 19, 0, 0},
                    {81, 25, 3, 1, 17},
                    {48, 12, 60, 32, 14},
                    {91, 47, 16, 65, 217},
                    {5, 73, 0, 4, 21}
            };
            System.out.println(Arrays.deepToString(dataScience(data2)));
        }
    public static String replaceVowels(String str) {
        return str.replaceAll("[AEIOUaeiou]", "*");
    }

    public static String stringTransform(String str) {
        return str.replaceAll("(.)\\1", "Double$1");
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int[] dims = {a, b, c};
        Arrays.sort(dims);
        return dims[0] <= w && dims[1] <= h;
    }

    public static boolean numCheck(int num) {
        int sum = 0;
        int originalNum = num;
        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum % 2 == originalNum % 2;
    }

    public static int countRoots(int[] coeffs) {
        int a = coeffs[0], b = coeffs[1], c = coeffs[2];
        int discriminant = b * b - 4 * a * c;
        return discriminant > 0 ? 2 : (discriminant == 0 ? 1 : 0);
    }

    public static List<String> salesData(String[][] data) {
        Map<String, Set<String>> salesMap = new HashMap<>();
        for (String[] row : data) {
            for (int i = 1; i < row.length; i++) {
                salesMap.computeIfAbsent(row[i], k -> new HashSet<>()).add(row[0]);
            }
        }
        Set<String> result = new HashSet<>(salesMap.get(data[0][1]));
        for (String shop : salesMap.keySet()) {
            result.retainAll(salesMap.get(shop));
        }
        return new ArrayList<>(result);
    }

    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) * (i % 2 == 0 ? -1 : 1) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String str) {
        str = str.toLowerCase();
        Map<Character, Integer> vowelCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            }
        }
        return Collections.max(vowelCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int[][] dataScience(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    sum += arr[j][i];
                }
            }
            arr[i][i] = sum / (arr.length - 1);
        }
        return arr;
    }
}