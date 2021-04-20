
package week6parttwo;

import java.util.Scanner;

public class ThreeValueSumOperation extends MathOperation{
    private int num3;
    
    public ThreeValueSumOperation(Scanner input){
        super(input);
        num3=input.nextInt();
    }    
    public ThreeValueSumOperation(int num1,int num2, int num3) {
        super(num1,num2);
        this.num3=num3;
        
    }
    
    public int getNum3()
    {
        return num3;
    }
    
    public double getResult()
    {
        return(getNum1() + getNum2() + getNum3());
    }
    
    public String toString()
    {
        return(String.format("%d + %d + %d", this.getNum1(),this.getNum2(),this.getNum3()));
    }

    public String printResult()
    {
        return(String.format("%d + %d + %d = %f", this.getNum1(), this.getNum2(), this.getNum3(), getResult()));
    }
    
}
