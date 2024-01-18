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
    public  static void main(String[] args){
        Level level;

        Scanner scanner=new Scanner(System.in);

        System.out.println("What Level would you like: Easy, Medium, Hard");
        String input=scanner.nextLine();
        input=input.toLowerCase();

        if(input.charAt(0)==('e')){
            level=new Easy();
        }else if(input.charAt(0)==('m')){
            level=new Medium();
        }else{
            level=new Hard();
        }

        int num1=level.generateRandomNumber();

        int num2=level.generateRandomNumber();

        while(num2>num1){
            num2=level.generateRandomNumber();
        }

        System.out.println("What arithmetic would you like: Addition, Subtraction, Multiplication, Division");
        input=scanner.nextLine();
        input=input.toLowerCase();
        
        Operator operator;
        if(input.charAt(0)==('a')){
            operator=new Addition(num1,num2);
        }else if(input.charAt(0)==('s')){
            operator=new Subtraction(num1,num2);
        }else if(input.charAt(0)==('m')){
            operator=new Multiplication(num1,num2);
        }else{
            operator=new Division(num1,num2);
        }

        int answer=operator.answer();

        if(operator instanceof Division){
            answer=num1;
            num1=num1*num2;
        }

        System.out.println("What is "+num1+" "+operator.toString()+" "+num2+"?");

        int answerInput=scanner.nextInt();

        if(answerInput==answer){
            System.out.println("Correct!");
        }else{
            System.out.println("Incorect!");
            System.out.println("Answer is "+answer);
        }

        scanner.close();
    }
}
