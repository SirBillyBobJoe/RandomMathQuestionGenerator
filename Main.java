import java.util.Scanner;

import Levels.Easy;
import Levels.Hard;
import Levels.Medium;
import Operators.Addition;
import Operators.Division;
import Operators.Multiplication;
import Operators.Operator;
import Operators.Subtraction;
import Levels.Level;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Level level = askForLevel(scanner);

        int num1 = level.generateRandomNumber();
        int num2 = level.generateRandomNumber();
        while (num2 > num1) {
            num2 = level.generateRandomNumber();
        }

        Operator operator = askForOperator(scanner, num1, num2);

        askQuestion(scanner, operator, num1, num2);

        scanner.close();
    }

    public static Level askForLevel(Scanner scanner) {

        System.out.println("What Level would you like: Easy, Medium, Hard");
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Please Input a Level");
            input = scanner.nextLine();
        }

        input = input.toLowerCase();

        if (input.charAt(0) == ('e')) {
            return new Easy();
        } else if (input.charAt(0) == ('m')) {
            return new Medium();
        } else {
            return new Hard();
        }

    }

    public static Operator askForOperator(Scanner scanner, int num1, int num2) {
        System.out.println("What Operator would you like: Addition, Subtraction, Multiplication, Division");
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Please Input a Operator");
            input = scanner.nextLine();
        }
        input = input.toLowerCase();

        if (input.charAt(0) == ('a')) {
            return new Addition(num1, num2);
        } else if (input.charAt(0) == ('s')) {
            return new Subtraction(num1, num2);
        } else if (input.charAt(0) == ('m')) {
            return new Multiplication(num1, num2);
        } else {
            return new Division(num1, num2);
        }

    }

    public static void askQuestion(Scanner scanner, Operator operator, int num1, int num2) {
        int answer = operator.answer();

        if (operator instanceof Division) {
            answer = num1;
            num1 = num1 * num2;
        }

        System.out.println("What is " + num1 + " " + operator.toString() + " " + num2 + "?");

        while (!scanner.hasNextInt()) {
            System.out.println("Please Input a Integer");
            scanner.next();
        }

        int answerInput = scanner.nextInt();

        if (answerInput == answer) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!");
            System.out.println("Answer is " + answer);
        }

    }
}
