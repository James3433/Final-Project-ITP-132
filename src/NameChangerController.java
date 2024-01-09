/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */


import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class NameChangerController {
    
    @FXML
    private AnchorPane changer_pane;
    
    @FXML
    private Button cancel;

    @FXML
    private TextField input_equip_id;

    @FXML
    private TextField input_equip_name;
    
    @FXML
    private TextField input_equip_asc;

    @FXML
    private TextField input_equip_used;

    @FXML
    private TextField input_equip_user;
    
    @FXML
    private TextField input_property_num;
    
    @FXML
    private TextField input_pir_num;
    
    @FXML
    private TextField input_amount;
    
    @FXML
    private ChoiceBox<String> input_category;
    
    @FXML
    private Button ok;

    Stage stage;
    private Equipment equipment;
    private SystemController systemController;
    private SQLconnector sqlConnector = new SQLconnector();
        
    public void setSystemController(SystemController systemController) {
    this.systemController = systemController;
     }
    public void initialize(){
        
        ObservableList<String> categoryNames = sqlConnector.getCategoryNames();
        input_category.setItems(categoryNames);
    }
    public void setValues(Equipment equipment) {
        // Set values based on the selected equipment
        this.equipment = equipment;
        input_equip_id.setText(String.valueOf(equipment.getEquip_id()));
        input_property_num.setText(equipment.getProperty_num());
        input_pir_num.setText(equipment.getPir_num());
        input_equip_name.setText(equipment.getEquip_name());
        input_equip_asc.setText(equipment.getEquip_desc());
        input_equip_used.setText(equipment.getEquip_used());
        input_equip_user.setText(equipment.getEquip_user());
        input_amount.setText(equipment.getAmount());
        input_category.setValue(equipment.getCategory());
    }
    
    @FXML
    public void handleOkButton(ActionEvent eve) {
        System.out.println("button Clicked");
        if (equipment != null) {
            if (input_equip_id.getText().isEmpty() || input_pir_num.getText().isEmpty()|| input_property_num.getText().isEmpty() || input_equip_name.getText().isEmpty() || input_equip_asc.getText().isEmpty() || input_equip_used.getText().isEmpty() || input_equip_user.getText().isEmpty()|| input_amount.getText().isEmpty() || input_category.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Must Input all needed data");
            } else {
            try {
                // Retrieve values from UI components
                int equipId = Integer.parseInt(input_equip_id.getText());
                String propertyNum = input_property_num.getText();
                String pirNum = input_pir_num.getText();
                String equipName = input_equip_name.getText();
                String equipAsc = input_equip_asc.getText();
                String equipUsed = input_equip_used.getText();
                String equipUser = input_equip_user.getText();
                String amount = input_amount.getText();
                String selectedCategory = input_category.getValue();
                
                int categoryId = sqlConnector.getCategoryIdByName(selectedCategory);
                // Call the update method in SystemController or another data management class
                 sqlConnector.updateEquipmentName(equipId, propertyNum, pirNum, equipName, equipAsc,equipUsed, equipUser, amount,categoryId);

            systemController.refreshTables();
            // Close the stage
            stage = (Stage) changer_pane.getScene().getWindow();
            stage.close();
            
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            }
            }
        }
    }
    
    @FXML
    public void handleCancelButton(ActionEvent event) throws IOException {
      int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to Cancel the edit?", "Confirmation", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {
           stage = (Stage) changer_pane.getScene().getWindow();
           stage.close();
    } else {
    // User clicked "No" or closed the dialog - do nothing or handle it accordingly
          }
    }
    
} 
