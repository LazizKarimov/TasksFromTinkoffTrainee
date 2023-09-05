import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {

    public static Map<Character, Integer> lettersMap;

    public static void createOccurrencesMap(String letters) {
        for (char c : letters.toCharArray()) {
            if (lettersMap.containsKey(c)) {
                int oldOccurrenceValue = lettersMap.get(c);
                lettersMap.replace(c, oldOccurrenceValue, oldOccurrenceValue + 1);
            } else {
                lettersMap.put(c, 1);
            }
        }
    }

    public static int sheriffsCount() {
        Map<Character, Integer> sheriffMap = new HashMap<>();
        sheriffMap.put('s', 0);
        sheriffMap.put('h', 0);
        sheriffMap.put('e', 0);
        sheriffMap.put('r', 0);
        sheriffMap.put('i', 0);
        sheriffMap.put('f', 0);
        Map.Entry<Character, Integer> minEntry = null;
        for (Map.Entry<Character, Integer> entry : sheriffMap.entrySet()) {
            if (lettersMap.containsKey(entry.getKey())) {
                if (entry.getKey() == 'f') {
                    entry.setValue(lettersMap.get(entry.getKey()) / 2);
                } else {
                    entry.setValue(lettersMap.get(entry.getKey()));
                }
            }

            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }

        return minEntry.getValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = scanner.nextLine();
        lettersMap = new HashMap<>();
        createOccurrencesMap(letters);
        System.out.println(sheriffsCount());
    }
}
