package scenebuilder;


import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import week6parttwo.AdditionOperation;
import week6parttwo.DivisionOperation;
import week6parttwo.FakeOperation;
import week6parttwo.GreaterThanOperation;
import week6parttwo.GreaterThanOrEqualOperation;
import week6parttwo.LessThanOperation;
import week6parttwo.LessThanOrEqualOperation;
import week6parttwo.MathOperation;
import week6parttwo.ModOperation;
import week6parttwo.MultiplicationOperation;
import week6parttwo.SubtractionOperation;
import week6parttwo.ThreeValueSumOperation;

public class MenusController implements Initializable {

    private MathLogic data = new MathLogic();
    private static Stage stage;
    public static void setStage(Stage val)
    {
        stage = val;
    }
    
    @FXML
    private RadioButton rdAdd;

    @FXML
    private ToggleGroup opSelect;

    @FXML
    private RadioButton rdSub;

    @FXML
    private RadioButton rdMult;

    @FXML
    private RadioButton rdDiv;

    @FXML
    private RadioButton rdMod;
    
    @FXML
    private RadioButton rdFake;
    
    @FXML
    private RadioButton rdGr;

    @FXML
    private RadioButton rdGrOrEq;

    @FXML
    private RadioButton rdLess;

    @FXML
    private RadioButton rdLessOrEq;
    
    @FXML
    private RadioButton rd3Sum;

    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem save;
    
    @FXML
    private TextField txtNum1;

    @FXML
    private TextField txtNum2;
    
    @FXML
    private TextField txtNum3;
    
    @FXML
    private TextArea txtResult;
    
    @FXML
    private Label lblError;
    
    @FXML
    private Label lbDetails;
    
    @FXML
    private Label lblNum3;
    
    @FXML
    private ListView lvList;
    
    
    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void save(ActionEvent event) {
        FileWriter output= null;
        
        try{
            output= new FileWriter("output_math.txt", false);
            output.write(txtResult.getText());
            output.close();
        }
        catch(java.io.IOException e){
            System.out.println("Error writing to file");
            System.exit(2);
        }
    }
    
    @FXML
    private ListView lvActive;
    
    
    @FXML
    void setFull(ActionEvent event) {
        stage.setFullScreen(true);
    }

    @FXML
    void setWindowed(ActionEvent event) {
        stage.setFullScreen(false);
    }

    @FXML
    void handleAdd(ActionEvent event) {
        lblError.setVisible(false);
        lblNum3.setVisible(false);
        txtNum3.setVisible(false);
        String sNum1, sNum2;
        sNum1 = txtNum1.getText();
        sNum2 = txtNum2.getText();
        
        int num1,num2;
        num1 = Integer.parseInt(sNum1);
        num2 = Integer.parseInt(sNum2);
        
        
        RadioButton selected = (RadioButton)opSelect.getSelectedToggle();
        MathOperation newOp = null;
        
        try
        {
            if (num2 == 0)
            {
                throw new Exception("Whoops, num2 is zero");
            }
            Class newType = (Class) selected.getUserData();
            newOp = (MathOperation)newType.getConstructor(int.class,int.class).newInstance(num1,num2);
            data.addOperation(newOp);
            lvList.getItems().add(newOp);
        }
        catch(Exception e)
        {
            lblError.setText(e.getMessage());
            lblError.setVisible(true);
            
        }
        if(rd3Sum.isSelected()) {
            
            lblNum3.setVisible(true);
            txtNum3.setVisible(true);
            String sNum3;
            int num3;
            sNum3 = txtNum3.getText();
            num3 = Integer.parseInt(sNum3);
            try
            {

                Class newType = (Class) selected.getUserData();
                newOp = (MathOperation)newType.getConstructor(int.class,int.class,int.class).newInstance(num1,num2,num3);
                data.addOperation(newOp);
                lvList.getItems().add(newOp);
            }
            catch(Exception e)
            {
                lblError.setText(e.getMessage());
                lblError.setVisible(true);

            }
        }
    }
    
    @FXML
    void calculate(ActionEvent event) {
        txtResult.setEditable(false);
        
        
        ObservableList<MathOperation> items = lvActive.getItems();
        
        StringBuilder result = new StringBuilder();
        for (MathOperation curOp : items)
        {
            String ret = curOp.printResult();
            result.append(ret);
            result.append('\n');
        }
        
        
        txtResult.setText(result.toString());
    }
    
    @FXML
    void btnAddClicked(ActionEvent event)
    {
        ObservableList items = lvList.getSelectionModel().getSelectedItems();
        lvActive.getItems().addAll(items);
        lvList.getItems().removeAll(items);
        
    }
    
    @FXML
    void btnRemoveClicked(ActionEvent event)
    {
        ObservableList items = lvActive.getSelectionModel().getSelectedItems();
        lvList.getItems().addAll(items);
        lvActive.getItems().removeAll(items);
        
    }
    
    @FXML
    void lvListSelectionChanged (MouseEvent event)
    {
        MathOperation selected = (MathOperation)lvList.getSelectionModel().getSelectedItem();
        if (selected != null)
        {
            lbDetails.setText(selected.printResult());
            
        }
    }
    
    @FXML
    void ThreeValueSum(ActionEvent event){
        lblNum3.setVisible(true);
        txtNum3.setVisible(true);
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rdAdd.setUserData(AdditionOperation.class);
        rdSub.setUserData(SubtractionOperation.class);
        rdMult.setUserData(MultiplicationOperation.class);
        rdMod.setUserData(ModOperation.class);
        rdDiv.setUserData(DivisionOperation.class);
        rdFake.setUserData(FakeOperation.class);
        rdGr.setUserData(GreaterThanOperation.class);
        rdGrOrEq.setUserData(GreaterThanOrEqualOperation.class);
        rdLess.setUserData(LessThanOperation.class);
        rdLessOrEq.setUserData(LessThanOrEqualOperation.class);
        rd3Sum.setUserData(ThreeValueSumOperation.class);
        
        lvList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvActive.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
    


