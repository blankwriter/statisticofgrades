import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         Scanner scanner = new Scanner(System.in);
        int noOfStudent;
        int maximumGrade, minimumGrade;
        double averageGrade;
        int sumOfGrades = 0;
        int[] stats = new int[5];
 // Get number of students with error handling
        while (true) {
            try {
                System.out.println("Enter the number of students: ");
                noOfStudent = scanner.nextInt();
                if (noOfStudent <= 0) {
                    System.err.println("Error: The number of students must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }

        int[] scores = new int[noOfStudent];

        // Get student grades with error handling
        System.out.println("Enter the scores of all the students: ");
        for (int i = 0; i < noOfStudent; i++) {
            while (true) {
                try {
                    int score = scanner.nextInt();
                    if (score < 0 || score > 100) {
                        System.out.println("Error: Grades must be between 0 and 100.");
                        continue;
                    }
                    scores[i] = score;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid integer.");
                    scanner.next(); // Clear invalid input
                }
            }
        }
        // Get the maximum and minumum grade 
        maximumGrade = Arrays.stream(scores).max().getAsInt();
        minimumGrade = Arrays.stream(scores).min().getAsInt();
       
        // Get the total sum of grades 
        for (int score : scores) {
            sumOfGrades += score; // sumofGrades = sumofGrades + scores

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
       //Get the average grade
        averageGrade = (double) sumOfGrades / noOfStudent;
            System.out.println("Values:\n");
            System.out.println("The maximum grade is " + maximumGrade); //Print out the maximum grade 
            System.out.println("The minimum grade is " + minimumGrade); //Print out the minimum grade
            System.out.println("The average grade is " + averageGrade);  //Print out the average grade

        System.out.println("\nGraph:\n");
        int maxHeight = getMax(stats); //Handle the height of the Histogram
        for (int i = maxHeight; i > 0; i--){    //
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
        scanner.close();
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
