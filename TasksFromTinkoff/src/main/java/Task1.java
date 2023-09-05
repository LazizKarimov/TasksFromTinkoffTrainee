import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long s = scanner.nextLong();

        ArrayList<Long> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            prices.add(scanner.nextLong());
        }

        Collections.sort(prices, Collections.reverseOrder());

        long maxAffordablePrice = 0;

        for (Long price : prices) {
            if (price <= s) {
                maxAffordablePrice = price;
                break;
            }
        }

        System.out.println(maxAffordablePrice);
    }
}
