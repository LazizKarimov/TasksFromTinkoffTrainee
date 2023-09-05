import java.util.*;

public class Task4 {
    public static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap) {
        return new TreeMap<>(unsortedMap).descendingMap();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] denominations = new int[m];

        for (int i = 0; i < m; i++) {
            denominations[i] = scanner.nextInt();
        }

        Map<Integer, Integer> denominationCounts = new HashMap<>();
        for (int denomination : denominations) {
            denominationCounts.put(denomination, 2);
        }

        denominationCounts = sortByKeys(denominationCounts);

        List<Integer> stolenDenominations = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : denominationCounts.entrySet()) {
            while (entry.getValue() != 0 && n >= entry.getKey()) {
                n -= entry.getKey();
                int oldValue = entry.getValue();
                entry.setValue(oldValue - 1);
                stolenDenominations.add(entry.getKey());
            }

            if (n == 0) break;
        }

        if (n != 0) {
            System.out.println(-1);
        } else {
            System.out.println(stolenDenominations.size());
            stolenDenominations.sort(Comparator.naturalOrder());
            for (int i = 0; i < stolenDenominations.size(); i++) {
                System.out.print(stolenDenominations.get(i));
                if (i != stolenDenominations.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}

