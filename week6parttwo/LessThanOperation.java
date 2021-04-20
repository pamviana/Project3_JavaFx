
package week6parttwo;

import java.util.Scanner;

public class LessThanOperation extends GreaterThanOperation{
    public LessThanOperation(Scanner input)
    {
        super(input);
        setOperation("<");
    }
    
    public LessThanOperation(int a, int b)
    {
        super(a,b);
        setOperation("<");
    }
    public double getResult()
    {   double result=0;
        if(getOperation() == "<") {
            if(getNum1() < getNum2()) {
                result = 1;
            }
            else {
                result= 0;
            }
        }
        
        else if(getOperation() == "<=") {
            if(getNum1() <= getNum2()) {
                result = 1;
            }
            else {
                result= 0;
            }
        }
        return result;
    }
    
    
}
