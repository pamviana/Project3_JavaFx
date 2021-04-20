
package week6parttwo;

import java.util.Scanner;

public class SubtractionOperation extends MathOperation{
    
    public SubtractionOperation(int num1,int num2)
    {
        super(num1,num2);
        setOperation('-');
    }
    
    public SubtractionOperation(Scanner input)
    {
        super(input);
        setOperation('-');
    }
    
        public String toString()
    {
        return(String.format("%d - %d", this.getNum1(),this.getNum2()));
    }

    
    public double getResult()
    {
        return(this.getNum1() - this.getNum2());
    }
}
