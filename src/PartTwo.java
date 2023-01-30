import java.util.*;

public class PartTwo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = sc.nextLine();
        wordCount(text);

    }

    public static void wordCount(String text) {
        Map<String, Integer> words = new HashMap<>();
        int value = 0;
        for (String word : text.split(" ")) {
            if (!words.containsKey(word)) {
                words.put(word, 1);
                if (value <= 1) {
                    value = 1;
                }
            } else {
                words.put(word, words.get(word) + 1);
                value = words.get(word);
            }
        }
        System.out.println("В тексте " + words.size() + " слов");

        Set<String> sort = new TreeSet<>(words.keySet());
        while (value > 0) {
            for (String word : sort) {
                if (words.get(word) == value) {
                    System.out.println(word + "—" + words.get(word));
                }
            }
            value--;
        }
    }
}
