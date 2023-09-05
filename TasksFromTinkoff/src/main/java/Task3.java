import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] sequenceJoe = new int[n];
        int[] sequenceWin = new int[n];

        for (int i = 0; i < n; i++) {
            sequenceJoe[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sequenceWin[i] = scanner.nextInt();
        }

        boolean canGetWinningSequence = canGetWinningSequence(sequenceJoe, sequenceWin);

        if (canGetWinningSequence) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean canGetWinningSequence(int[] sequenceJoe, int[] sequenceWin) {
        int n = sequenceJoe.length;
        int left = 0, right = n - 1;

        while (left < n && sequenceJoe[left] == sequenceWin[left]) {
            left++;
        }

        while (right >= 0 && sequenceJoe[right] == sequenceWin[right]) {
            right--;
        }

        if (left > right) {
            return true;
        }

        Arrays.sort(sequenceJoe, left, right + 1);

        for (int i = left; i <= right; i++) {
            if (sequenceJoe[i] != sequenceWin[i]) {
                return false;
            }
        }

        return true;
    }
}
