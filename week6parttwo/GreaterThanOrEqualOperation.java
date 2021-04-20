
package week6parttwo;

import java.util.Scanner;

public class GreaterThanOrEqualOperation extends GreaterThanOperation{
    
    
    public GreaterThanOrEqualOperation(Scanner input) {
        
        super(input);
        setOperation(">=");
    } 
    public GreaterThanOrEqualOperation(int a, int b) {
        super(a,b);
        setOperation(">=");
    }     
    
}
