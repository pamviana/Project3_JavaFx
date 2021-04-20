
package week6parttwo;

import java.util.Scanner;

public class LessThanOrEqualOperation extends LessThanOperation{
    
    public LessThanOrEqualOperation(Scanner input) {
        
        super(input);
        setOperation("<=");
    } 
    public LessThanOrEqualOperation(int a, int b) {
        super(a,b);
        setOperation("<=");
    }  
}
