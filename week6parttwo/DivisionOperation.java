/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6parttwo;

import java.util.Scanner;

/**
 *
 * @author Pam
 */
public class DivisionOperation extends MathOperation{
    
    public DivisionOperation(Scanner input)
    {
        super(input);
        setOperation('/');
    }
    
    public DivisionOperation(int num1,int num2)
    {
        super(num1,num2);
        setOperation('/');
    }
    
    public String toString()
    {
        return(String.format("%d / %d", this.getNum1(),this.getNum2()));
    }

    
    public double getResult()
    {
        return((double)this.getNum1() / this.getNum2());
    }
}