
package week6parttwo;

import java.util.Scanner;

public class GreaterThanOperation extends MathOperation {
    private String op;
    public GreaterThanOperation(Scanner input)
    {
        super(input);
        setOperation(">");
    }
    
    public GreaterThanOperation(int a, int b)
    {
        super(a,b);
        setOperation(">");
    }
    
    public void setOperation(String op) {
        this.op = op;       
        
    }
    
    public String getOperation() {
        return(op);
    }
    
    public double getResult()
    {   double result=0;
        if(op == ">") {
            if(getNum1() > getNum2()) {
                result = 1;
            }
            else {
                result= 0;
            }
        }
        
        else if( op == ">=") {
            if(getNum1() >= getNum2()) {
                result = 1;
            }
            else {
                result= 0;
            }
        }
        return result;
    }
    
    public String toString()
    {
        return(String.format("%d %s %d", this.getNum1(),getOperation(),this.getNum2()));
    }
    
    public String printResult() {
        
        return(String.format("%d %s %d = %f", getNum1(), getOperation(),getNum2(), getResult()));
        }
}
    
    
