import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Task6 {

    public static ArrayList<Ghost> allGhosts;

    public static ArrayList<String> questions;

    public static void initializeAllGhosts(int n) {
        allGhosts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            allGhosts.add(new Ghost(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGhosts = scanner.nextInt();
        int numberOfQuestions = scanner.nextInt();

        // Прочистить символ новой строки
        scanner.nextLine();

        questions = new ArrayList<>();
        for (int i = 0; i < numberOfQuestions; i++) {
            questions.add(scanner.nextLine());
        }

        initializeAllGhosts(numberOfGhosts);

        processQuestions();

    }

    private static void processQuestions() {
        for (String question : questions) {
            String[] arrayOfValues = question.split(" ");

            switch (arrayOfValues[0]) {
                case "1" -> {
                    Ghost ghost1 = allGhosts.get(Integer.parseInt(arrayOfValues[1]) - 1);
                    Ghost ghost2 = allGhosts.get(Integer.parseInt(arrayOfValues[2]) - 1);
                    ghost1.addBandMember(ghost2);
                }
                case "2" -> {
                    Ghost ghost1 = allGhosts.get(Integer.parseInt(arrayOfValues[1]) - 1);
                    Ghost ghost2 = allGhosts.get(Integer.parseInt(arrayOfValues[2]) - 1);
                    System.out.println(ghost1.checkIfInSameBand(ghost2));
                }
                case "3" -> System.out.println(
                        allGhosts.get(Integer.parseInt(arrayOfValues[1]) - 1)
                                .getAmountOfBands());
                default -> System.out.println("wrong format");
            }
        }
    }


}

class Ghost {
    private final int serialNumber;

    private int bandsTookPartIn;

    private LinkedList<Ghost> band;

    public Ghost(int serialNumber) {
        this.serialNumber = serialNumber;
        this.bandsTookPartIn = 1;

        band = new LinkedList<>();
        band.add(this);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getAmountOfBands() {
        return bandsTookPartIn;
    }

    private void incrementBandsNumber() {
        bandsTookPartIn++;
    }

    public void addBandMember(Ghost bandMember) {
        if (!band.contains(bandMember)) {
            if (band.size() < bandMember.band.size()) {
                bandMember.band.add(this);

                band = bandMember.band;
            } else {
                band.add(bandMember);

                bandMember.band = band;
            }
            for (Ghost ghost:
                    band) {
                ghost.incrementBandsNumber();
            }
        }
    }

    public String checkIfInSameBand(Ghost otherGhost) {
        return band.contains(otherGhost) ? "YES" : "NO";
    }
}