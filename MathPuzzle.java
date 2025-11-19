import java.io.*;
import java.util.*;

public class MathPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter difficulty level (easy/medium/hard): ");
            String level = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
            String line;
            int score = 0;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int a = Integer.parseInt(parts[0]);
                String op = parts[1];
                int b = Integer.parseInt(parts[2]);

                int correct = 0;
                switch (op) {
                    case "+":
                        correct = a + b;
                        break;
                    case "-":
                        correct = a - b;
                        break;
                    case "*":
                        correct = a * b;
                        break;
                    case "/":
                        correct = a / b;
                        break;
                }

                System.out.print(a + " " + op + " " + b + " = ");
                int ans = sc.nextInt();

                if (ans == correct) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer: " + correct);
                }
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("score.txt", true));
            bw.write(name + " (" + level + ") - Score: " + score);
            bw.newLine();
            bw.close();

            System.out.println("Score saved to file!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
