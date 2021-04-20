/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6parttwo;

public class FakeOperation extends MathOperation {
    
    public FakeOperation(int a, int b)
    {
        super(a,b);
    }
    
    public String printResult()
    {
        return(String.format("%d <> %d = %f", this.getNum1(), this.getNum2(), getResult()));
    }
    
    public double getResult()
    {
        return((getNum1() % getNum2()) * 2 - 10);
    }
    
    public String toString()
    {
        return(printResult());
    }
}

