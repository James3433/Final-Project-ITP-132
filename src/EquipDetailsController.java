
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */


/**
 *
 * @author Admin
 */
public class EquipDetailsController {
 
    @FXML
    private TextField amount_shown;

    @FXML
    private TextField category_shown;

    @FXML
    private TextField emp_in_charge_shown;

    @FXML
    private TextField equip_id_shown;

    @FXML
    private TextField equip_name_shown;

    @FXML
    private TextField equip_used_shown;

    @FXML
    private TextField equip_user_shown;

    @FXML
    private TextField equip_desc_shown;

    @FXML
    private TextField pir_num_shown;

    @FXML
    private TextField property_num_shown;

    @FXML
    private TextField room_shown;

    @FXML
    private TextField status_shown;
    
    @FXML
    private TextField invent_date_shown;
    
    @FXML
    private TextField last_date_shown;
    
    
    int collector;
    private SQLconnector sqlConnector = new SQLconnector();
    
    public void setValues(Equipment equipment, FlowChart flowChart) {
    if (equipment != null) {
        // Set values based on the selected equipment
        collector = equipment.getEquip_id();
        setEquipmentValues(collector);
    } else if (flowChart != null) {
        // Set values based on the selected flowChart
        collector = flowChart.getEquip_id();
        setEquipmentValues(collector);
    }
}

private void setEquipmentValues(int collector) {
    // Set values based on the selected equipment

    List<List<String>> equipmentList = sqlConnector.getEquipmentNamesById(collector);
    for (List<String> equip : equipmentList) {
        equip_id_shown.setText(String.valueOf(equip.get(0)));
        property_num_shown.setText(String.valueOf(equip.get(1)));
        pir_num_shown.setText(String.valueOf(equip.get(2)));
        equip_name_shown.setText(String.valueOf(equip.get(3)));
        equip_desc_shown.setText(String.valueOf(equip.get(4)));
        equip_used_shown.setText(String.valueOf(equip.get(5)));
        equip_user_shown.setText(String.valueOf(equip.get(6)));
        amount_shown.setText(String.valueOf(equip.get(7)));
        category_shown.setText(String.valueOf(equip.get(8)));
        room_shown.setText(String.valueOf(equip.get(9)));
        status_shown.setText(String.valueOf(mapStatus(equip.get(10))));
        emp_in_charge_shown.setText(String.valueOf(equip.get(11)));
        invent_date_shown.setText(String.valueOf(equip.get(12)));
        last_date_shown.setText(String.valueOf(equip.get(13)));
    }
}
    
    private String mapStatus(String status) {
    // Map the integer status to a user-friendly string
    if (status != null) {
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
            default:
                return null;
        }
    } else {
        return null;
    }
    
    }
}
