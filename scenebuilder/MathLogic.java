
package scenebuilder;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import week6parttwo.MathOperation;

public class MathLogic {
    private ArrayList<MathOperation> data = new ArrayList<>();
    
    public void addOperation(MathOperation value)
    {
        data.add(value);
    }
    
    
    public String calculateData()
    {
        StringBuilder result = new StringBuilder();
        for (MathOperation curOp : data)
        {
             result.append(curOp.printResult());
             result.append('\n');
        }
        return(result.toString());
    }
}
