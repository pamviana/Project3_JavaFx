
package week6parttwo;

import java.util.ArrayList;
import java.util.Scanner;

public class Week6PartTwo {
    
    public static void printResult(MathOperation problem) {
        System.out.print(problem + " = ");
        System.out.println(problem.getResult());
    }

    public static void main(String[] args) {
        MathOperation problem = new MultiplicationOperation(3,4);
        printResult(problem);
        
        int sel;
        int num1,num2;
        ArrayList<MathOperation> operations = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("1)Add Addition\n2)Add Subtraction\n3)Add Multiplication\n4)Add Division\n5)Exit");
            sel=input.nextInt();
            
            if(sel==1) {
                
                operations.add(new AdditionOperation(input));
            }
        }
    }
    
}
