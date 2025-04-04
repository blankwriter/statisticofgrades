import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
        int noOfStudent;
        int maximumGrade, minimumGrade;
        double averageGrade;
        int sumOfGrades = 0;
        int[] stats = new int[5];

        System.out.println("Enter the number of students: ");
        noOfStudent = scanner.nextInt();

        int[] scores = new int[noOfStudent];

        System.out.println("Enter the scores of all the students: ");
        for (int i = 0; i < noOfStudent; i++) {
            scores[i] = scanner.nextInt();
        }

        maximumGrade = Arrays.stream(scores).max().getAsInt();
        minimumGrade = Arrays.stream(scores).min().getAsInt();

        for (int score : scores) {
            sumOfGrades += score;

        if (score > 80) {
            stats[4]++;
        } else if (score >= 61) {
            stats[3]++;
        } else if (score >= 41) {
            stats[2]++;
        } else if (score >= 21) {
            stats[1]++;
        } else {
            stats[0]++;
        }
    }

        averageGrade = (double) sumOfGrades / noOfStudent;
            System.out.println("Values:\n");
            System.out.println("The maximum grade is " + maximumGrade);
            System.out.println("The minimum grade is " + minimumGrade);
            System.out.println("The average grade is " + averageGrade);

        System.out.println("\nGraph:\n");
        int maxHeight = getMax(stats);
        for (int i = maxHeight; i > 0; i--){
            System.out.printf("%3d >", i);
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("  #######");
                } else {
                    System.out.print("         ");
                }
            }

            System.out.println();
        }
        System.out.println("    +-----------+---------+---------+---------+---------+");
        System.out.println("     I    0-20   I  21-40  I   41-60  I  61-80  I  81-100 I");
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array){
            if (value > max){
                max = value;
            }
        }
        return max;


    }
}
