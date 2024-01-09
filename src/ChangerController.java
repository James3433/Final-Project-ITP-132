
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class ChangerController {
    
    @FXML
    private ChoiceBox<String> input_emp_in_charge;

    @FXML
    private Button cancel;

    @FXML
    private TextField date_and_time_shown;

    @FXML
    private TextField equip_id_shown;

    @FXML
    private TextField equip_name_shown;
    
    @FXML
    private TextField equip_desc_shown;
    
     @FXML
    private TextField user_id_shown;

    @FXML
    private ChoiceBox<String> input_room;

    @FXML
    private ChoiceBox<String> input_status;
    
    @FXML
    private AnchorPane changer_pane;
    
    @FXML
    private Button ok;
    
    
    private int userId;
    private Timeline timeline;
    Equipment equipment;
    private String[] statusBox = {"Available","Unavaileble","Missing","Return to Main","Defective"};
    private SQLconnector sqlConnector = new SQLconnector();
    Stage stage;
    private SystemController systemController;
    
    
    
    public void setSystemController(SystemController systemController) {
    this.systemController = systemController;
     }
    
     public int getUserId() {
        return userId;
    }
    
    public void setUserId(int user_id) {
        this.userId = user_id;
    }
    
   public void initialize() {
       System.out.println("ChangerController initialized.");
        System.out.println("Initailize UserId: " + getUserId());       
        // Initialize the timeline to update the date and time every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDateTime();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        
        user_id_shown.setText(String.valueOf(getUserId()));
        // Populate the 3 choice box
        ObservableList<String> roomNames = sqlConnector.getRoomNames();
        input_room.setItems(roomNames);
        
        input_status.getItems().clear();
        input_status.getItems().addAll(statusBox);
        System.out.println("StatusBox: "+input_status.getItems());
        
        ObservableList<String> empInChargeList = sqlConnector.getEmployeeNames();
        input_emp_in_charge.setItems(empInChargeList);
        
   }

    private void updateDateTime() {
        // Update the date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        date_and_time_shown.setText(formattedDateTime);
    }

    public void setValues(Equipment equipment) {
         this.equipment = equipment;
        // Set values based on the selected equipment
        equip_id_shown.setText(String.valueOf(equipment.getEquip_id()));
        equip_name_shown.setText(equipment.getEquip_name());
        equip_desc_shown.setText(equipment.getEquip_desc());
        input_status.setValue(mapStatus(equipment.getStatus()));
        input_room.setValue(equipment.getRoom());
        input_emp_in_charge.setValue(equipment.getEmp_in_charge());
        
    }
        
    private String mapStatus(String status) {
        // Map the integer status to a user-friendly string
        switch (status) {
            case "1":
                return "Available";
            case "0":
                return "Unavailable";
            case "2":
                return "Missing";
            case "3":
                return "Return to Main";
            case "4":
                return "Defective";
            case "5":
                return "Transfered to";
            case "6":
                return "Room Transfered";
            default:
                return null;
        }
}
    
    @FXML
    public void handleRoomSelection(ActionEvent event) {
        String room = input_room.getValue();
        if(!(room.equals(equipment.getRoom()) || room.equals("Empty"))){
             input_status.setValue("Room Transfered");
             input_status.setDisable(true);
         }else if(input_status.getValue().equals("Room Transfered")){
             input_status.setValue("Available");
             input_status.setDisable(false);
         }else{
             input_status.setDisable(false);
             }
    }
    
    @FXML
    public void handleStatusSelection(ActionEvent event) {
        String status = input_status.getValue();
     if(!(status.equals("Available") || status.equals("Transfered to") || status.equals("Room Transfered"))){
            input_emp_in_charge.setDisable(true);
        if ("Return to Main".equals(status)) {
            // If "Return to Main" is selected, set room and emp choice boxes to empty
            input_room.setValue("Empty");
            input_emp_in_charge.setValue("Empty");
            input_room.setDisable(true);
        } else {
            input_room.setValue(equipment.getRoom());
            input_emp_in_charge.setValue(equipment.getEmp_in_charge());
            input_room.setDisable(false);
        }
     }else{
         input_emp_in_charge.setDisable(false);
         }
    }
    
    @FXML
    public void handleEmpSelection(ActionEvent event) {
        String emp = input_emp_in_charge.getValue();
         if(!(emp.equals(equipment.getEmp_in_charge()) || emp.equals("Empty"))){
             input_status.setValue("Transfered to");
             input_status.setDisable(true);
         }else if(input_status.getValue().equals("Emp Transfered")){
             input_status.setValue("Available");
             input_status.setDisable(false);
         }else{
             input_status.setDisable(false);
             }
         }
    
    
    @FXML
public void handleOkButton(ActionEvent event) {
    // Retrieve values from UI components
    int equipId = Integer.parseInt(equip_id_shown.getText());
    String physicalDate = date_and_time_shown.getText();
    String selectedRoom = input_room.getValue();
    String selectedStatus = input_status.getValue();
    String selectedEmpInCharge = input_emp_in_charge.getValue();
    
    // Check if the values are the same as the current values of the equipment
    if (selectedRoom.equals(String.valueOf(equipment.getRoom())) &&
        selectedStatus.equals(String.valueOf(mapStatus(equipment.getStatus()))) &&
        selectedEmpInCharge.equals(String.valueOf(equipment.getEmp_in_charge()))) {
        JOptionPane.showMessageDialog(null, "Must change Room, Status, or Employee");
        return; // Exit the method without making changes
    }

    // Continue with the rest of the logic to update the status if there are changes
    try {
        int roomId = 0;
        int status = 0;
        int empInCharge = 0;

        // Update the selected row in invent_table_view
        if (selectedStatus.equals("Return to Main")) {
            roomId = 404;
            status = mapStatusToInt(selectedStatus);
            empInCharge = 404;
        } else {
            roomId = sqlConnector.getRoomIdByName(selectedRoom);
            status = mapStatusToInt(selectedStatus);
            empInCharge = sqlConnector.getEmpIdByName(selectedEmpInCharge);
        }

        // Update equipment_inventory_status table
        sqlConnector.addEquipmentStatus(equipId, physicalDate, roomId, status, empInCharge, userId);

        systemController.refreshTables();

        // Set the data into the TableView
        stage = (Stage) changer_pane.getScene().getWindow();
        stage.close();

    } catch (NumberFormatException e) {
        e.printStackTrace(); // Handle the exception according to your application's error handling strategy
    }

}

private int mapStatusToInt(String status) {
    switch (status) {
        case "Available":
            return 1;
        case "Unavailable":
            return 0;
        case "Missing":
            return 2;
        case "Return to Main":
            return 3;
        case "Defective":
            return 4;
        case "Transfered to":
            return 5;
        case "Room Transfered":
            return 6;
        default:
            return 0; // Indicate an invalid status
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
   
    
    public void stopTimeline() {
    timeline.stop();
}

     public void initializeController() {
    // Your existing initialization logic here
    System.out.println("Explicit initialization called with userId: " + getUserId());
}
}

