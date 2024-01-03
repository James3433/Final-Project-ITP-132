/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

public class SystemController {

    @FXML
    private TableColumn<Equipment, Integer> equip_id_view;
    
    @FXML
    private TableColumn<Equipment, String> equip_name_view;
    
    @FXML
    private TableColumn<Equipment, String> equip_desc_view;
    
    @FXML
    private TableColumn<Equipment, String> property_num_view;
    
    @FXML
    private TableColumn<Equipment, String> par_num_view;
    
    @FXML
    private TableColumn<Equipment, String> amount_view;

    @FXML
    private TableColumn<Equipment, String> equip_used_view;

    @FXML
    private TableColumn<Equipment, String> equip_user_view;

    @FXML
    private TableColumn<Equipment, String> room_view;

    @FXML
    private TableColumn<Equipment, String> category_view;

    @FXML
    private TableColumn<Equipment, String> emp_in_charge_view;

    @FXML
    private TableColumn<Equipment, String> status_view;

    @FXML
    private TableView<Equipment> invent_table_view;
    
    @FXML
    private TableColumn<Status, String> date_view;

    @FXML
    private ToggleButton equip_button;
    

    @FXML
    private TableColumn<Status, Integer> equip_id_view1;

    @FXML
    private TableColumn<Status, String> equip_name_view1;
    
    @FXML
    private TableColumn<Status, String>  emp_in_charge_view2;
    
    @FXML
    private TableColumn<Status, String> room_view1;
    
    @FXML
    private TableColumn<Status, Integer> status_id_view;

    @FXML
    private AnchorPane equipments;

     @FXML
    private TextField search;

    @FXML
    private ChoiceBox<String> search_status;
    
    @FXML
    private Button log_out;

    @FXML
    private AnchorPane status;

    @FXML
    private ToggleButton status_button;

    @FXML
    private TableView<Status> status_table_view;

    @FXML
    private TableColumn<Status, String> status_view1;

    @FXML
    private Text user;

    @FXML
    private TableColumn<Status, String> user_view;
    
    @FXML
    private TableColumn<Status, String> property_num_view1;
    
    @FXML
    private TableColumn<Status, String> par_num_view1;
    
    @FXML
    private TableColumn<Status, String> equip_desc_view1;
   
    
    
    @FXML
    private Button edit;
    
    @FXML
    private Button edit_name;
    
    @FXML
    private Button add;
    
    @FXML
    private TextField search1;
    
    @FXML
    private TextField input_date_and_time;

    @FXML
    private ChoiceBox<String> input_emp_in_charge;

    @FXML
    private TextField input_equip_id;

    @FXML
    private TextField input_equip_name;
    
    @FXML
    private TextField input_equip_desc;
    
    @FXML
    private TextField input_property_num;
    
    @FXML
    private TextField input_par_num;
    
    @FXML
    private TextField input_amount;

    @FXML
    private TextField input_equip_used;

    @FXML
    private TextField input_equip_user;

    @FXML
    private ChoiceBox<String> input_room;
    
    @FXML
    private ChoiceBox<String> input_category;
    
    
    @FXML
    private AnchorPane employee;
    
     @FXML
    private ToggleButton emp_button;
    
    @FXML
    private TextField input_emp_age;

    @FXML
    private TextField input_emp_fname;

    @FXML
    private ChoiceBox<String> input_emp_gender;

    @FXML
    private TextField input_emp_id;

     @FXML
    private TextField input_emp_lname;

    @FXML
    private TextField input_emp_mname;

    @FXML
    private ChoiceBox<String> input_emp_sufix;
    
    @FXML
    private ChoiceBox<String> input_emp_status;

    @FXML
    private ChoiceBox<String> input_emp_type;
    
    @FXML
    private Button show_details;
    
    @FXML
    private Button edit_emp;
    
    
    
    
    @FXML
    private TextField search2;
    
    @FXML
    private TableColumn<Employee, Integer> emp_age_view;
    
    @FXML
    private TableColumn<Employee, String> emp_gender_view;
    
    @FXML
    private TableColumn<Employee, Integer> emp_equip_guard_view;
    
    @FXML
    private TableColumn<Employee, Integer> emp_id_view;

    @FXML
    private TableColumn<Employee, String> emp_name_view;

    @FXML
    private TableColumn<Employee, String> emp_status_view;

    @FXML
    private TableView<Employee> emp_table_view;

    @FXML
    private TableColumn<Employee, String> emp_type_view;
    
    
    @FXML
    private TableView<Equipment> equip_table_showm;
    
    @FXML
    private TableColumn<Equipment, Integer> equip_id_shown;
    
    @FXML
    private TableColumn<Equipment, String> equip_name_shown;
    
    @FXML
    private TableColumn<Equipment, String> equip_desc_shown;
    
    
    @FXML
    private TextField search3;
    
    @FXML
    private AnchorPane flowchart;
    
    @FXML
    private ToggleButton flowchart_button;
    
    
    @FXML
    private BarChart<String, Number> equip_status_table;
    
    
    
    @FXML
    private PieChart room_pie_chart;
    
    @FXML
    private PieChart cat_pie_chart;
    
    
    @FXML
    private TableView<Equipment> equip_table_shown1;
    
    @FXML
    private TableColumn<Equipment, Integer> equip_id_shown1;
    
    @FXML
    private TableColumn<Equipment, String> equip_name_shown1;
    
    @FXML
    private TableColumn<Equipment, String> equip_desc_shown1;
    
    @FXML
    private TableColumn<Equipment, String> equip_status_shown1;
    
    @FXML
    private Button show_details1;
    
    
    @FXML
    private TextField search5;
    
    @FXML
    private TableView<FlowChart> equip_date_shown;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_id_shown2;
    
    @FXML
    private TableColumn<FlowChart, String> equip_name_shown2;
    
    @FXML
    private TableColumn<FlowChart, String> equip_desc_shown2;
    
    @FXML
    private TableColumn<FlowChart, String> invent_date_shown;
    
    
    @FXML
    private TableView<FlowChart> equip_num_table;
    
    @FXML
    private TableColumn<FlowChart, String> equip_name_view3;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view;
    
    
    
    @FXML
    private TableView<FlowChart> equip_room_table;
    
    @FXML
    private TableColumn<FlowChart, String> room_view2;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view1;
    
    @FXML
    private TextArea equip_room_show;
    
    
    @FXML
    private TableView<FlowChart> category_table_view;
    
    @FXML
    private TableColumn<FlowChart, String> category_view1;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view2;
    
    @FXML
    private TextArea equip_cat_show;
    
    
    @FXML
    private TextField search4;
    
    @FXML
    private TableView<FlowChart> emp_guard_table_view;
    
    @FXML
    private TableColumn<FlowChart, Integer> emp_id_shown;
    
    @FXML
    private TableColumn<FlowChart, String> emp_guard_view;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view3;
    
    @FXML
    private TextArea equip_emp_shown;
    
    
    @FXML
    private ToggleButton room_button;
    
    @FXML
    private AnchorPane room_pane;
    
    @FXML
    private TableView<Employee> room_table_view;
    
    @FXML
    private TableColumn<Employee, Integer> room_id_view1;
    
    @FXML
    private TableColumn<Employee, String> room_name_view1;
    
    @FXML
    private TableColumn<Employee, String> room_type_view1;
    
    @FXML
    private TableColumn<Employee, Integer> equip_num_view6;
    
    @FXML
    private TableColumn<Employee, String> room_status_view1;
    
    @FXML
    private TextField input_room_id;

    @FXML
    private TextField input_room_name;

    @FXML
    private ChoiceBox<String> input_room_type;
    
    @FXML
    private ChoiceBox<String> input_room_status;
    
    @FXML
    private Button show_details3;
    
    @FXML
    private Button edit_room;
    
    @FXML
    private TextField search6;
    
    
    @FXML
    private TableView<FlowChart> equip_num_table1;
    
    @FXML
    private TableColumn<FlowChart, String> equip_name_view4;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view7;
    
    
    @FXML
    private TableView<Equipment> equip_table_shown2;
    
    @FXML
    private TableColumn<Equipment, Integer> equip_id_shown3;
    
    @FXML
    private TableColumn<Equipment, String> equip_name_shown3;
    
    @FXML
    private TableColumn<Equipment, String> equip_desc_shown3;
    
    @FXML
    private TableColumn<Equipment, String> equip_status_shown3;
    
    
    @FXML
    private TableView<FlowChart> category_table_view1;
    
    @FXML
    private TableColumn<FlowChart, String> category_view2;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view4;
    
    @FXML
    private TextArea equip_cat_show1;
    
    
    @FXML
    private TableView<FlowChart> emp_guard_table_view1;
    
    @FXML
    private TableColumn<FlowChart, Integer> emp_id_shown1;
    
    @FXML
    private TableColumn<FlowChart, String> emp_guard_view1;
    
    @FXML
    private TableColumn<FlowChart, Integer> equip_num_view5;
    
    @FXML
    private TextArea equip_emp_shown1;
    
    @FXML
    private TextField search7;
    
    
    
    
    private SQLconnector sqlConnector = new SQLconnector();
    private Timeline timeline;
    ObservableList<XYChart.Series<String, Number>> barChartData;
    ObservableList<PieChart.Data> pieChartRoom;
    ObservableList<PieChart.Data> pieChartCat;
    private ObservableList<FlowChart> countData;
    private ObservableList<FlowChart> equipDate;
    private ObservableList<FlowChart> roomCountData;
    private ObservableList<FlowChart> catCountData;
    private ObservableList<FlowChart> empCountData;
    private ObservableList<Equipment> equipmentData;
    private ObservableList<Status> statusData;
    private ObservableList<Employee> empData;
    private ObservableList<String> empInChargeList;
    private ObservableList<Employee> roomData;
    private int equipmentCount;
    private int employeeCount;
    private int roomCount;
    private String[] statusBox = {"All","Available","Unavailable","Missing","Return to Main","Defective","Emp Transfered","Room Transfered"};
    private String[] statusBox1 = {"All","Available","Unavailable","Missing","Return to Main","Defective"};
    private String[] statusBox2 = {"Active","Inactive","Retired"};
    private String[] statusBox3 = {"Available","Unavailable"};
    private String[] roomTypeBox = {"Classroom","Laboratory","Storage","Faculty"};
    private String[] empTypeBox = {"Admin Staff","Utility","Watchmen","Faculty"};
    private String [] genderBox = {"Male","Female"};
    private String [] suffixBox = {" ","Jr.","Sr."};
    Scene scene;
    private Equipment selectedEquipment;
    private FlowChart selectedFlowChart;
    private SystemController systemController;
    private Text roomText;
    private int userId;
    private int roomId = 0;

    public int getUserId() {
    return userId;
    }
    
    public void setUserText(String userName, int userId) {
    user.setText("Welcome, " + userName);
    this.userId = userId;
    }   
    
    
    public void initialize() {
    // Set the initial visibility of AnchorPanes here
    equipments.setVisible(false);
    status.setVisible(false);
    edit.setVisible(false);
    edit_name.setVisible(false);
    edit_emp.setVisible(false);
    edit_room.setVisible(false);
    show_details.setVisible(false);
    show_details1.setVisible(false);
    show_details3.setVisible(false);
    input_emp_status.setVisible(false);
    input_room_status.setVisible(false);
    employee.setVisible(false);
    room_pane.setVisible(false);
    flowchart.setVisible(true);
    
    // Initialize the timeline to update the date and time every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateDateTime();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
      
        
    search1.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEquipTable(newValue);
         });
    search2.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEmpTable(newValue);
         });
    search3.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEquipStatusCountTable(newValue);
         }); 
    
    search4.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEmpCountTable(newValue);
  
         });
    search5.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEquipDateTable(newValue);
  
         });
    search6.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterRoomTable(newValue);
  
         });
    search7.textProperty().addListener((observable, oldValue, newValue) -> {
       
       filterEmpCountTable(newValue);
      
         });
    search.textProperty().addListener((observable, oldValue, newValue) -> {
        String selectedStatus = search_status.getValue();
       filterStatusTable(newValue, selectedStatus);
       System.out.println("Status picked: " + selectedStatus);
         });
    
    search_status.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
       if(search.getText().equals("")){
         String selectedText = "defaultText";
         filterStatusTable(selectedText,newValue);
       }else{
         System.out.println("Status picked: "+newValue);
         filterStatusTable(search.getText(), newValue);
        }
     });
        
        ObservableList<String> roomNames = sqlConnector.getRoomNames();
        input_room.setItems(roomNames);
        
        empInChargeList = sqlConnector.getEmployeeNames();
        input_emp_in_charge.setItems(empInChargeList);
        
        ObservableList<String> categoryNames = sqlConnector.getCategoryNames();
        input_category.setItems(categoryNames);
        
        input_emp_type.getItems().addAll(empTypeBox);
        input_emp_gender.getItems().addAll(genderBox);
        input_emp_sufix.getItems().addAll(suffixBox);
        search_status.getItems().addAll(statusBox);
        input_emp_status.getItems().addAll(statusBox2);
        input_room_status.getItems().addAll(statusBox3);
        input_room_type.getItems().addAll(roomTypeBox);
        
        user.setStyle("-fx-text-fill: white;");
        user.setStyle("-fx-background-color:  #62a1f5;");
        
    initialize_equipment();
    initialize_status();
    initialize_employee();
    initialize_room();
    initialize_equipment_count();
    initialize_equipment_count1();
    initialize_room_equipment_count();
    initialize_category_equipment_count();
    initialize_employee_equipment_count();
    initialize_equipment_date();
    loadEquipStatusChart();
    loadEquipRoomChart();
    loadEquipCatChart();
    
    refreshTables();
    clearInputFields();
    
    invent_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            System.out.println("----------one");
            System.out.println(userId);
            selectedEquipment = newSelection;
            if(selectedEquipment.getStatus().equals("3")){
                edit.setVisible(false);
                 edit_name.setVisible(false);
            }else{
                edit.setVisible(true);
                edit_name.setVisible(true);
            }
        } else {
            // No row is selected, hide the edit button
            edit.setVisible(false);
            edit_name.setVisible(false);
        }
    });
 
    emp_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            clearInputFields();
            
            Employee selectedEmployee = newSelection;

                // Fetch related equipment information
                equipmentData = sqlConnector.getEquipmentForEmployee(selectedEmployee.getEmp_id());

                // Update equip_table_showm with the fetched equipment information
                equip_table_showm.setItems(equipmentData);

                // Set up cell value factories for equip_table_showm
                equip_id_shown.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("equip_id"));
                equip_name_shown.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_name"));
                equip_desc_shown.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_desc"));
                   
            // A row is selected, update the input fields with the selected employee's data
            
            input_emp_id.setText(String.valueOf(newSelection.getEmp_id()));

            // Assuming getEmp_name() returns the full name
            String fullName = newSelection.getEmp_name();
            

            // Split the full name into first, middle, and last names if needed
            String[] names = fullName.split("\\s+");
            if (names.length > 0) {
                String lastName = names[0].replaceAll(",", ""); // Remove the comma
                input_emp_lname.setText(lastName); // First name
            }
            if (names.length > 1) {
                input_emp_fname.setText(names[1]); // Middle name
            }
            if (names.length > 2) {
                if(names[2].equals("Jr.") || names[2].equals("Sr.")){
                   input_emp_sufix.setValue(names[2]);
                }else{
                   input_emp_mname.setText(names[2]); // Last name 
                }
            }
            if (names.length > 3) {
                 input_emp_sufix.setValue(names[3]);
             }
            input_emp_age.setText(String.valueOf(newSelection.getEmp_age()));
            input_emp_type.setValue(newSelection.getEmp_type());
            input_emp_gender.setValue(newSelection.getEmp_gender());
            
            input_emp_status.setVisible(true);
            input_emp_status.setValue(mapEmpStatus(newSelection.getEmp_status()));
            // Show the edit_emp button
            edit_emp.setVisible(true);
            input_emp_status.setVisible(true);
        }else {
            // No row is selected, clear the input fields and hide the edit_emp button
            clearInputFields();
            edit_emp.setVisible(false);
            input_emp_status.setVisible(false);
            equip_table_showm.setItems(null);
        }
    });
    
    room_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        System.out.println("Clicked");
        if (newSelection != null) { 
              
              Employee selectedEmployee = newSelection;
              roomId = selectedEmployee.getRoom_id();
              countData = sqlConnector.getEquipCountFromRoom(selectedEmployee.getRoom_id());       
        
              // Setting up the cell value factories for each column
              equip_name_view4.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
              equip_num_view7.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

              equip_num_table1.setItems(countData);
              
               input_room_id.setText(String.valueOf(selectedEmployee.getRoom_id()));
               input_room_name.setText(selectedEmployee.getRoom_name());
               input_room_type.setValue(selectedEmployee.getRoom_type());
               input_room_status.setValue(mapStatus(selectedEmployee.getRoom_status()));
              
              edit_room.setVisible(true);
              input_room_status.setVisible(true);
        }
       });
    equip_table_showm.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            selectedEquipment = newSelection;
            show_details.setVisible(true);
        }
       });
    equip_table_shown1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            selectedFlowChart = null;
            selectedEquipment = newSelection;
            show_details1.setVisible(true);
        }
       });
    equip_table_shown2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            selectedFlowChart = null;
            selectedEquipment = newSelection;
            show_details3.setVisible(true);
        }
       });
    equip_date_shown.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            selectedEquipment = null;
            selectedFlowChart = newSelection;
            show_details1.setVisible(true);
        }
       });
    equip_room_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            String roomName = newSelection.getName();
     
                updateRoomEquipmentTextArea(roomName);
        }else{
            equip_room_show.clear();
        }
       });
    
    category_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            String catName = newSelection.getName();
     
                updateCatEquipmentTextArea(catName);
        }else{
            equip_cat_show.clear();
        }
       });
    
    category_table_view1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            String catName = newSelection.getName();
     
                updateCatEquipmentTextArea(catName);
        }else{
            equip_cat_show1.clear();
        }
       });
    
    emp_guard_table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            int empId = newSelection.getId();
     
                updateEmpEquipmentTextArea(empId);
        }else{
            equip_emp_shown.clear();
        }
       });
    
    emp_guard_table_view1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            int empId = newSelection.getId();
                
                updateEmpEquipmentTextArea(empId);
        }else{
            equip_emp_shown1.clear();
        }
       });
    
    equip_num_table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            
        equipmentData = sqlConnector.getEquipmentByName1(newSelection.getName());
                // Update equip_table_showm with the fetched equipment information
        equip_table_shown1.setItems(equipmentData);
        
                // Set up cell value factories for equip_table_showm
        equip_id_shown1.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("equip_id"));
        equip_name_shown1.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_name"));
        equip_desc_shown1.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_desc"));
        equip_status_shown1.setCellValueFactory(new PropertyValueFactory<Equipment, String>("status"));
        equip_status_shown1.setCellFactory(column -> {
        return new TableCell<Equipment, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1") || item.equals("5") || item.equals("6")) {
                        setText("Available");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Unavailable");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("2")) {
                        setText("Missing");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("3")) {
                        setText("Returned");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("4")) {
                        setText("Defective");
                        setStyle("-fx-text-fill: red;");
                    }
                }
            }
        };
    });
        }else{
            equip_table_shown1.setItems(null);
        }
       });  
    
    equip_num_table1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            System.out.println("Count Clicked: "+roomId);
            if(roomId != 0){
        equipmentData = sqlConnector.getEquipmentByName2(newSelection.getName(), roomId);
                    System.out.println("With Room");

            }else{
        equipmentData = sqlConnector.getEquipmentByName1(newSelection.getName());
                    System.out.println("Without Room");

            }
            
        equip_table_shown2.setItems(equipmentData);
        
                // Set up cell value factories for equip_table_showm
        equip_id_shown3.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("equip_id"));
        equip_name_shown3.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_name"));
        equip_desc_shown3.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equip_desc"));
        equip_status_shown3.setCellValueFactory(new PropertyValueFactory<Equipment, String>("status"));
        equip_status_shown3.setCellFactory(column -> {
        return new TableCell<Equipment, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1") || item.equals("5") || item.equals("6")) {
                        setText("Available");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Unavailable");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("2")) {
                        setText("Missing");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("3")) {
                        setText("Returned");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("4")) {
                        setText("Defective");
                        setStyle("-fx-text-fill: red;");
                    }
                }
            }
        };
    });    
        }else{
            equip_table_shown2.setItems(null);
        }
       });  
    
  }
    
    private void updateDateTime() {
        // Update the date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        input_date_and_time.setText(formattedDateTime);
    }

private void updateRoomEquipmentTextArea(String roomName) {
    List<List<String>> equipmentList = sqlConnector.getEquipmentByRoom(roomName);
   
    StringBuilder equipmentTextBuilder = new StringBuilder("Equipment Names:\n");

    for (List<String> equipment : equipmentList) {
        String equipId = equipment.get(0);
        String equipName = equipment.get(1);
        String equipDesc = equipment.get(2);
        equipmentTextBuilder.append(equipId).append(": ").append(equipName).append(" | ").append(equipDesc).append("\n");
    }
    
    equip_room_show.setText(equipmentTextBuilder.toString());
}

private void updateCatEquipmentTextArea(String catName) {
    List<List<String>> equipmentList = sqlConnector.getEquipmentByCat(catName);
   
    StringBuilder equipmentTextBuilder = new StringBuilder("Equipment Names:\n");

    for (List<String> equipment : equipmentList) {
        String equipId = equipment.get(0);
        String equipName = equipment.get(1);
        String equipDesc = equipment.get(2);
        equipmentTextBuilder.append(equipId).append(": ").append(equipName).append(" | ").append(equipDesc).append("\n");
    }
    
    equip_cat_show.setText(equipmentTextBuilder.toString());
    equip_cat_show1.setText(equipmentTextBuilder.toString());
}

private void updateEmpEquipmentTextArea(int empId) {
    List<List<String>> equipmentList = sqlConnector.getEquipmentByEmp(empId);
   
    StringBuilder equipmentTextBuilder = new StringBuilder("Equipment Names:\n");

    for (List<String> equipment : equipmentList) {
        String equipId = equipment.get(0);
        String equipName = equipment.get(1);
        String equipDesc = equipment.get(2);
        equipmentTextBuilder.append(equipId).append(": ").append(equipName).append(" | ").append(equipDesc).append("\n");
    }
    
    equip_emp_shown.setText(equipmentTextBuilder.toString());
    equip_emp_shown1.setText(equipmentTextBuilder.toString());
}

    @FXML
    public void addEquipment(ActionEvent event) {
        int equipCount = 2021100 + equipmentCount;
    if (input_equip_id.getText().isEmpty() || input_par_num.getText().isEmpty()|| input_property_num.getText().isEmpty() || input_equip_name.getText().isEmpty() || input_equip_desc.getText().isEmpty() || input_equip_used.getText().isEmpty() || input_equip_user.getText().isEmpty()|| input_amount.getText().isEmpty() || input_category.getValue() == null || input_room.getValue() == null || input_emp_in_charge.getValue() == null || input_date_and_time.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Must Input all needed data");
    } else {
    // Get values from input fields
    int equipId = Integer.parseInt(input_equip_id.getText());
    String equipName = input_equip_name.getText();
    String equipUsed = input_equip_used.getText();
    String equipUser = input_equip_user.getText();
    String equipDesc = input_equip_desc.getText();
    String propertyNum = input_property_num.getText();
    String pirNum = input_par_num.getText();
    String amount = input_amount.getText();
    String selectedCategory = input_category.getValue(); // Assumes input_category is a ChoiceBox<String>
    String selectedRoom = input_room.getValue(); // Assumes input_room is a ChoiceBox<String>
    String selectedEmpInCharge = input_emp_in_charge.getValue(); // Assumes input_emp_in_charge is a ChoiceBox<String>
    String physicalDate = input_date_and_time.getText();
    
    if(equipId <= equipCount){
            JOptionPane.showMessageDialog(null, "Equipment ID exist. Try Again");
            return;
        }
    if (!amount.matches("\\d*")) {
            JOptionPane.showMessageDialog(null, "Invalid input for amount. Please enter a valid number.");
            return; // Exit the method without adding the equipment
        }
    
    if (sqlConnector.isPropertyOrPirNumExists(propertyNum, pirNum)) {
            JOptionPane.showMessageDialog(null, "Property No# or PAR No# already exists");
            return; // Exit the method without adding the equipment
        }
    // Get the category_id based on the selected category name
    int categoryId = sqlConnector.getCategoryIdByName(selectedCategory);

    // Get the room_id based on the selected room name
    int roomId = sqlConnector.getRoomIdByName(selectedRoom);

    // Get the emp_id based on the selected employee name
    int empId = sqlConnector.getEmpIdByName(selectedEmpInCharge);

    // Add the equipment to the database
    sqlConnector.addEquipment(equipId, propertyNum, pirNum, equipName, equipDesc,equipUsed, equipUser, amount, categoryId, roomId, empId, 1, physicalDate, userId);
    System.out.println(""+userId);
            // Clear input fields
            clearInputFields();
            // Refresh the TableView after adding data   
            refreshTables();
    }
}
    @FXML
    public void addEmployee(ActionEvent event){
        int empCount = 2021010 + employeeCount;
    if (input_emp_id.getText().isEmpty() || input_emp_fname.getText().isEmpty() || input_emp_lname.getText().isEmpty() || input_emp_age.getText().isEmpty() || input_emp_type.getValue() == null ||input_emp_gender.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Must Input all needed data");
    } else {
        int empId = Integer.parseInt(input_emp_id.getText());
            String empFname = input_emp_fname.getText();
            String empMname = input_emp_mname.getText();
            String empLname = input_emp_lname.getText();
            String empSuffix = input_emp_sufix.getValue(); 
            String Age = input_emp_age.getText();
            String empType = input_emp_type.getValue();
            String empGender = input_emp_gender.getValue(); 
            
        if(empId <= empCount){
            JOptionPane.showMessageDialog(null, "Employee ID exist. Try Again");
            return;
        }
        if (!(Age.matches("\\d*"))) {
            JOptionPane.showMessageDialog(null, "Invalid input for amount. Please enter a valid number.");
            return; // Exit the method without adding the equipment
        }
        int empAge = Integer.parseInt(input_emp_age.getText());
        if (sqlConnector.isEmployeeAlreadyExists(empId, empFname,empMname, empLname)) {
            JOptionPane.showMessageDialog(null, "First name, Middle Name and Last name already exists.");
        } else {
            
            
            sqlConnector.addEmployee(empId, empFname, empMname, empLname, empSuffix, empAge, empType, empGender, 1);

            // Clear input fields
            clearInputFields();
            // Refresh the TableView after adding data   
            refreshTables();
            
             }
        }
    }
    
    @FXML
    public void editEmployee(ActionEvent event) {
        // Assuming you have input fields in your UI for editing employee details
    Employee selectedEmployee = emp_table_view.getSelectionModel().getSelectedItem();
    int empCount = 2021010 + employeeCount;
    if (selectedEmployee != null) {
        int empId = selectedEmployee.getEmp_id();
        String empSuffix;
        String empFname = input_emp_fname.getText();
        String empMname = input_emp_mname.getText();
        String empLname = input_emp_lname.getText();
       if(input_emp_sufix.getValue() == null){
        empSuffix = " ";
           }else{
        empSuffix = input_emp_sufix.getValue();
             }
        String Age = input_emp_age.getText();
        String empType = input_emp_type.getValue();
        String empGender = input_emp_gender.getValue();
        String empStatus = mapEmpStatusToInt(input_emp_status.getValue());
        
        if(empId <= empCount){
            JOptionPane.showMessageDialog(null, "Employee ID exist. Try Again");
            return;
        }
        if (!(Age.matches("\\d*"))) {
            JOptionPane.showMessageDialog(null, "Invalid input for amount. Please enter a valid number.");
            return; // Exit the method without adding the equipment
        }
        int empAge = Integer.parseInt(input_emp_age.getText());
    if (sqlConnector.isEmployeeAlreadyExists(empId, empFname, empMname, empLname)) {
            JOptionPane.showMessageDialog(null, "First name, Middle Name and Last name already exists.");
        } else { 
        // Call the updateEmployee method from SQLconnector
        sqlConnector.updateEmployee(empId, empFname, empMname, empLname, empSuffix, empAge, empType, empGender, empStatus);
        
            // Clear input fields
            clearInputFields();
            // Refresh the TableView after adding data   
            refreshTables();
         }
         }else {
             // Handle the case where no employee is selected
       }
    }
    
    @FXML
    public void addRoom(ActionEvent event){
        if (input_room_id.getText().isEmpty()  || input_room_name.getText().isEmpty() || input_room_type.getValue() == null ) {
        JOptionPane.showMessageDialog(null, "Must Input all needed data");
    } else { 
        int roomId = Integer.parseInt(input_room_id.getText());
            String roomName = input_room_name.getText();
            String roomType = input_room_type.getValue();
        // Check if the employee already exists in the database based on both id and fname/lname
        if(roomId <= roomCount){
            JOptionPane.showMessageDialog(null, "Room ID exist. Try Again");
            return;
        }
        if (sqlConnector.isRoomExists( roomId, roomName)) {
            JOptionPane.showMessageDialog(null, "Room Name exist. Try Again");
            return;
        } 
            sqlConnector.addRoom(roomId, roomName, roomType, 1);

            // Clear input fields
            clearInputFields();
            // Refresh the TableView after adding data   
            refreshTables();
            
        }
    }
    
    @FXML
    public void editRoom(ActionEvent event){
        if (input_room_id.getText().isEmpty()  || input_room_name.getText().isEmpty() || input_room_type.getValue() == null ) {
        JOptionPane.showMessageDialog(null, "Must Input all needed data");
    } else {
        int roomId = Integer.parseInt(input_room_id.getText());
            String roomName = input_room_name.getText();
            String roomType = input_room_type.getValue();
            int roomStatus = Integer.parseInt(mapStatusToInt(input_room_status.getValue()));
        // Check if the employee already exists in the database based on both id and fname/lname
        if (sqlConnector.isRoomExists( roomId, roomName)) {
            JOptionPane.showMessageDialog(null, "Room Name exist. Try Again");
            return;
        }
            sqlConnector.editRoom(roomId, roomName, roomType, roomStatus);

            // Clear input fields
            clearInputFields();
            // Refresh the TableView after adding data   
            refreshTables();
        }
    }
    
    @FXML
    public void showDetails(ActionEvent event) throws IOException {
    System.out.println("Equipment: "+selectedEquipment);
    System.out.println("FlowChart: "+selectedFlowChart);
    if (selectedEquipment != null ) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("EquipDetails.fxml"));
       Parent root = loader.load();
       
       EquipDetailsController edc = loader.getController();
       edc.setValues(selectedEquipment, selectedFlowChart);

       Stage dialogStage = new Stage();
       dialogStage.initModality(Modality.WINDOW_MODAL);
       dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       Scene scene = new Scene(root);
       dialogStage.setScene(scene);

       dialogStage.showAndWait();
    }else if (selectedFlowChart != null) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("EquipDetails.fxml"));
       Parent root = loader.load();
       
       EquipDetailsController edc = loader.getController();
       edc.setValues(selectedEquipment, selectedFlowChart);

       Stage dialogStage = new Stage();
       dialogStage.initModality(Modality.WINDOW_MODAL);
       dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       Scene scene = new Scene(root);
       dialogStage.setScene(scene);

       dialogStage.showAndWait();
               }
     }
    
    @FXML
    public void editEquipment(ActionEvent event) throws IOException {
    if (selectedEquipment != null) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Changer.fxml"));
       Parent root = loader.load();
       
       // Get the controller from the loader
       ChangerController cc = loader.getController();
       cc.setUserId(userId);
       cc.initialize();
       cc.setSystemController(this);
       cc.setValues(selectedEquipment);
       // Set the stage in ChangerController

        // Create a new scene and show the Changer.fxml content as a modal dialog
       Stage dialogStage = new Stage();
       dialogStage.initModality(Modality.WINDOW_MODAL);
       dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       Scene scene = new Scene(root);
       dialogStage.setScene(scene);

       // Set the title of the dialog stage (you can customize this)
       dialogStage.setTitle("Edit Equipment");

       // Show the dialog and wait for the user to close it before returning to the main application
       dialogStage.showAndWait();
         }
     }
    
    @FXML
    public void editEquipmentName(ActionEvent event) throws IOException {
    if (selectedEquipment != null) {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangerName.fxml"));
       Parent root = loader.load();
       
       // Get the controller from the loader
       NameChangerController ncc = loader.getController();
       ncc.setValues(selectedEquipment);
       ncc.setSystemController(this);
       // Set the stage in ChangerController

        // Create a new scene and show the Changer.fxml content as a modal dialog
       Stage dialogStage = new Stage();
       dialogStage.initModality(Modality.WINDOW_MODAL);
       dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
       Scene scene = new Scene(root);
       dialogStage.setScene(scene);

       // Set the title of the dialog stage (you can customize this)
       dialogStage.setTitle("Edit Equipment Name");

       // Show the dialog and wait for the user to close it before returning to the main application
       dialogStage.showAndWait();
         }
     }
    
    
    public void initialize_equipment() {
       SQLconnector sqlConnector = new SQLconnector();
        equipmentData = sqlConnector.getEquipmentData();

        // Setting up the cell value factories for each column
       
        //equip_id_view
        equip_id_view.setCellValueFactory(new PropertyValueFactory <Equipment, Integer> ("equip_id"));
        property_num_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("property_num"));
        par_num_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("pir_num"));
        equip_name_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("equip_name"));
        equip_desc_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("equip_desc"));
        amount_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("amount"));
        equip_used_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("equip_used"));
        equip_user_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("equip_user"));
        room_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("room"));
        category_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("category"));
        emp_in_charge_view.setCellValueFactory(new PropertyValueFactory <Equipment, String> ("emp_in_charge"));

        // Setting the data to the table
        
        invent_table_view.setItems(equipmentData);
        
    status_view.setCellValueFactory(new PropertyValueFactory<>("status"));
    status_view.setCellFactory(column -> {
        return new TableCell<Equipment, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1")) {
                        setText("Available");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Unavailable");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("2")) {
                        setText("Missing");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("3")) {  
                        setText("Returned");
                        //diri
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("4")) {
                        setText("Defective");
                        setStyle("-fx-text-fill: red;");
                    }
                }
            }
        };
    });
    equipmentCount = equipmentData.size();
    }

    public void initialize_status() {
    SQLconnector sqlConnector = new SQLconnector();
    statusData = sqlConnector.getCombinedData();

    // Setting up the cell value factories for each column
    status_id_view.setCellValueFactory(new PropertyValueFactory<Status, Integer>("status_id"));
    equip_id_view1.setCellValueFactory(new PropertyValueFactory<Status, Integer>("equip_id"));
    property_num_view1.setCellValueFactory(new PropertyValueFactory<Status, String>("property_num"));
    par_num_view1.setCellValueFactory(new PropertyValueFactory<Status, String>("pir_num"));
    equip_name_view1.setCellValueFactory(new PropertyValueFactory<Status, String>("equip_name"));
    equip_desc_view1.setCellValueFactory(new PropertyValueFactory<Status, String>("equip_desc"));
    room_view1.setCellValueFactory(new PropertyValueFactory<Status, String>("room"));
    
    status_view1.setCellValueFactory(new PropertyValueFactory<>("status"));
    status_view1.setCellFactory(column -> {
        return new TableCell<Status, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1")) {
                        setText("Available");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Unavailable");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("2")) {
                        setText("Missing");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("3")) {
                        setText("Returned");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("4")) {
                        setText("Defective");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("5")) {
                        setText("Emp Transfered");
                        setStyle("-fx-text-fill: orange;");
                    } else if (item.equals("6")) {
                        setText("Room Transfered");
                        setStyle("-fx-text-fill: orange;");
                    }
                }
            }
        };
    });
    emp_in_charge_view2.setCellValueFactory(new PropertyValueFactory<Status, String>("emp_in_charge"));
    date_view.setCellValueFactory(new PropertyValueFactory<Status, String>("physical_date"));
    user_view.setCellValueFactory(new PropertyValueFactory<Status, String>("user_name"));

    // Setting the data to the table
    status_table_view.setItems(statusData);
    
    }
    
    private void loadEquipStatusChart() {
        barChartData = sqlConnector.getEquipmentStatusChartData();
        equip_status_table.getData().addAll(barChartData);
    }
    
    private void loadEquipRoomChart() {
    pieChartRoom = sqlConnector.getEquipmentCountByRoom();
    room_pie_chart.setData(pieChartRoom);
    }
    
    private void loadEquipCatChart() {
    pieChartCat = sqlConnector.getEquipmentCountByCat();
    cat_pie_chart.setData(pieChartCat);
    }
    
     public void initialize_employee() {
        empData = sqlConnector.getEmployeeData();       
        
        // Setting up the cell value factories for each column
        emp_id_view.setCellValueFactory(new PropertyValueFactory <Employee, Integer> ("emp_id"));
        emp_name_view.setCellValueFactory(new PropertyValueFactory <Employee, String> ("emp_name"));
        emp_age_view.setCellValueFactory(new PropertyValueFactory <Employee, Integer> ("emp_age"));
        emp_gender_view.setCellValueFactory(new PropertyValueFactory <Employee, String> ("emp_gender"));
        emp_type_view.setCellValueFactory(new PropertyValueFactory <Employee, String> ("emp_type"));
        emp_equip_guard_view.setCellValueFactory(new PropertyValueFactory <Employee, Integer> ("emp_guard"));

        emp_table_view.setItems(empData);
        
    emp_status_view.setCellValueFactory(new PropertyValueFactory<>("emp_status"));
    emp_status_view.setCellFactory(column -> {
        return new TableCell<Employee, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1")) {
                        setText("Active");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Retired");
                        setStyle("-fx-text-fill: red;");
                    } else if (item.equals("2")) {
                        setText("Inactive");
                        setStyle("-fx-text-fill: red;");
                    }
                }
            }
        };
    });
    employeeCount = empData.size();
   }
     
    public void initialize_room() {
        roomData = sqlConnector.getRoomData();       
        
        // Setting up the cell value factories for each column
        room_id_view1.setCellValueFactory(new PropertyValueFactory <Employee, Integer> ("room_id"));
        room_name_view1.setCellValueFactory(new PropertyValueFactory <Employee, String> ("room_name"));
        room_type_view1.setCellValueFactory(new PropertyValueFactory <Employee, String> ("room_type"));
        equip_num_view6.setCellValueFactory(new PropertyValueFactory <Employee, Integer> ("equip_stored"));

        room_table_view.setItems(roomData);
        
    room_status_view1.setCellValueFactory(new PropertyValueFactory<>("room_status"));
    room_status_view1.setCellFactory(column -> {
        return new TableCell<Employee, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals("1")) {
                        setText("Available");
                        setStyle("-fx-text-fill: green;");
                    } else if (item.equals("0")) {
                        setText("Unavaialble");
                        setStyle("-fx-text-fill: red;");
                    }
                }
            }
        };
    });
    roomCount = roomData.size();
   }
     
      public void initialize_equipment_count() {
        countData = sqlConnector.getEquipCount();       
        
        // Setting up the cell value factories for each column
        equip_name_view4.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view7.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

        equip_num_table1.setItems(countData);
        
   } 
      
      public void initialize_equipment_count1() {
        countData = sqlConnector.getEquipCount();       
        
        // Setting up the cell value factories for each column
        equip_name_view3.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

        equip_num_table.setItems(countData);
        
   }
      
      public void initialize_equipment_date() {
        equipDate = sqlConnector.getEquipmentDate();

                // Set up cell value factories for equip_table_showm
                equip_id_shown2.setCellValueFactory(new PropertyValueFactory<FlowChart, Integer>("equip_id"));
                equip_name_shown2.setCellValueFactory(new PropertyValueFactory<FlowChart, String>("equip_name"));
                equip_desc_shown2.setCellValueFactory(new PropertyValueFactory<FlowChart, String>("equip_desc"));
                invent_date_shown.setCellValueFactory(new PropertyValueFactory<FlowChart, String>("first_date"));
                
                equip_date_shown.setItems(equipDate);
   }
      
      public void initialize_room_equipment_count() {
        roomCountData = sqlConnector.getRoomEquipCount();       
        
        // Setting up the cell value factories for each column
        room_view2.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view1.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));
        
        equip_room_table.setItems(roomCountData);
        
   }
      public void initialize_category_equipment_count() {
        catCountData = sqlConnector.getCatEquipCount();       
        
        // Setting up the cell value factories for each column
        category_view1.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view2.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

        category_table_view.setItems(catCountData);
        
        category_view2.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view4.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));
        
        category_table_view1.setItems(catCountData);
        
   }
      
   public void initialize_employee_equipment_count() {
        empCountData = sqlConnector.getEmpEquipCount();       
        
        // Setting up the cell value factories for each column
        emp_id_shown.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("id"));
        emp_guard_view.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view3.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

        emp_guard_table_view.setItems(empCountData);
        
        emp_id_shown1.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("id"));
        emp_guard_view1.setCellValueFactory(new PropertyValueFactory <FlowChart, String> ("name"));
        equip_num_view5.setCellValueFactory(new PropertyValueFactory <FlowChart, Integer> ("equip_number"));

        emp_guard_table_view1.setItems(empCountData);
        
   }
      
    @FXML
    public void switch_mode(ActionEvent e) {
    if (e.getSource() == status_button) {
        // Show the "status" pane
        status.setVisible(true);
        equipments.setVisible(false);
        employee.setVisible(false);
        flowchart.setVisible(false);
        room_pane.setVisible(false);
        clearInputFields();
        refreshTables();
    } else if (e.getSource() == equip_button) {
        // Show the "equipment" pane
        status.setVisible(false);
        equipments.setVisible(true);
        employee.setVisible(false);
        flowchart.setVisible(false);
        room_pane.setVisible(false);
        clearInputFields();
        refreshTables();
    }else if (e.getSource() == emp_button) {
        // Show the "equipment" pane
        status.setVisible(false);
        equipments.setVisible(false);
        employee.setVisible(true);
        flowchart.setVisible(false);
        room_pane.setVisible(false);
        clearInputFields();
        refreshTables();
    }else if (e.getSource() == flowchart_button) {
        // Show the "equipment" pane
        status.setVisible(false);
        equipments.setVisible(false);
        employee.setVisible(false);
        flowchart.setVisible(true);
        room_pane.setVisible(false);
        clearInputFields();
        refreshTables();
    }else if (e.getSource() == room_button) {
        // Show the "equipment" pane
        status.setVisible(false);
        equipments.setVisible(false);
        employee.setVisible(false);
        flowchart.setVisible(false);
        room_pane.setVisible(true);
        clearInputFields();
        refreshTables();
    }
  } 
    
   private void filterEquipTable(String searchText) {
    ObservableList<Equipment> filteredList = FXCollections.observableArrayList();

    // Convert the search text to lowercase for case-insensitive search
    String searchTextLower = searchText.toLowerCase();
    // Filter the statusData based on the search text and selectedStatus
    for (Equipment equip : equipmentData) {
        String statusName = mapStatus(equip.getStatus());
        
    if (String.valueOf(equip.getEquip_id()).contains(searchTextLower) ||
                equip.getEquip_name().toLowerCase().contains(searchTextLower) ||
                equip.getRoom().toLowerCase().contains(searchTextLower) ||
                equip.getEquip_used().toLowerCase().contains(searchTextLower) ||
                equip.getEquip_user().toLowerCase().contains(searchTextLower) ||
                equip.getCategory().toLowerCase().contains(searchTextLower) ||
                equip.getEmp_in_charge().toLowerCase().contains(searchTextLower) ||
                statusName.toLowerCase().equals(searchTextLower) ||
                equip.getProperty_num().toLowerCase().contains(searchTextLower) ||
                equip.getPir_num().toLowerCase().contains(searchTextLower) ||
                equip.getEquip_desc().toLowerCase().contains(searchTextLower) ||
                equip.getAmount().toLowerCase().contains(searchTextLower)) {
    
                filteredList.add(equip);
            }
        }
        invent_table_view.setItems(filteredList);
    }
    
   private void filterEmpTable(String searchText) {
    ObservableList<Employee> filteredList = FXCollections.observableArrayList();

    // Convert the search text to lowercase for case-insensitive search
    String searchTextLower = searchText.toLowerCase();
    // Filter the statusData based on the search text and selectedStatus
    for (Employee emp : empData) {
        String statusName = mapStatus(emp.getEmp_status());
    if (String.valueOf(emp.getEmp_id()).contains(searchTextLower) ||
                emp.getEmp_name().toLowerCase().contains(searchTextLower) ||
        String.valueOf(emp.getEmp_age()).contains(searchTextLower) ||
                emp.getEmp_gender().toLowerCase().contains(searchTextLower) ||
                emp.getEmp_type().toLowerCase().contains(searchTextLower) ||
        String.valueOf(emp.getEmp_guard()).contains(searchTextLower) ||
                statusName.toLowerCase().equals(searchTextLower))

                filteredList.add(emp);
            }
        emp_table_view.setItems(filteredList);
    }
   
   private void filterEquipStatusCountTable(String searchText) {
    ObservableList<FlowChart> filteredList = FXCollections.observableArrayList();
    
    String searchTextLower = searchText.toLowerCase();
    
    for (FlowChart equip : countData) {
        if (equip.getName().toLowerCase().contains(searchTextLower)) {
            filteredList.add(equip);
        }
    }
    equip_num_table.setItems(filteredList);
}
   
    private void filterEmpCountTable(String searchText) {
    ObservableList<FlowChart> filteredList = FXCollections.observableArrayList();

    String searchTextLower = searchText.toLowerCase();
    for (FlowChart emp : empCountData) {
    if ( String.valueOf(emp.getId()).contains(searchTextLower) ||
            emp.getName().toLowerCase().contains(searchTextLower))
                filteredList.add(emp);
            }
        emp_guard_table_view.setItems(filteredList);
        emp_guard_table_view1.setItems(filteredList);
    }
    
     private void filterEquipDateTable(String searchText) {
    ObservableList<FlowChart> filteredList = FXCollections.observableArrayList();

    String searchTextLower = searchText.toLowerCase();
    for (FlowChart equip : equipDate) {
    if ( String.valueOf(equip.getEquip_id()).contains(searchTextLower) ||
            equip.getEquip_name().toLowerCase().contains(searchTextLower) ||
            equip.getEquip_desc().toLowerCase().contains(searchTextLower) ||
            equip.getFirst_date().toLowerCase().contains(searchTextLower))
                filteredList.add(equip);
            }
        equip_date_shown.setItems(filteredList);
    }
    
    private void filterRoomTable(String searchText) {
    ObservableList<Employee> filteredList = FXCollections.observableArrayList();

    String searchTextLower = searchText.toLowerCase();
    for (Employee emp : roomData) {
         String statusName = mapStatus(emp.getRoom_status());
    if ( String.valueOf(emp.getRoom_id()).contains(searchTextLower) ||
            emp.getRoom_name().toLowerCase().contains(searchTextLower) ||
            emp.getRoom_type().toLowerCase().contains(searchTextLower) ||
            statusName.toLowerCase().equals(searchTextLower))
                filteredList.add(emp);
            }
        room_table_view.setItems(filteredList);
    }
     
  private void filterStatusTable(String searchText, String selectedStatus) {
    ObservableList<Status> filteredList = FXCollections.observableArrayList();

    // Convert the search text to lowercase for case-insensitive search
    String searchTextLower = searchText.toLowerCase();
    System.out.println("SearchText: " + searchText);
    System.out.println("SlectedStatus: " + selectedStatus);
    // Filter the statusData based on the search text and selectedStatus
    for (Status status : statusData) {
        String mappedStatus = mapStatusToInt(selectedStatus);

        boolean searchTextMatch = searchText.equals("defaultText") || searchText.trim().isEmpty() ||
                (String.valueOf(status.getEquip_id()).contains(searchTextLower) ||
                 status.getEquip_name().toLowerCase().contains(searchTextLower) ||
                 status.getPhysical_date().toLowerCase().contains(searchTextLower) ||
                 status.getRoom().toLowerCase().contains(searchTextLower) ||
                 status.getEmp_in_charge().toLowerCase().contains(searchTextLower));
                 
        System.out.println("---Search---");
        System.out.println("Search: " + searchTextMatch);
        
        boolean statusMatch = selectedStatus.equals("All") ||
                status.getStatus().equals(mappedStatus);
        System.out.println("---Status---");
        System.out.println("Status: " + statusMatch);
       
        if (searchTextMatch && statusMatch) {
            filteredList.add(status);
        }
    }
         // Set the filtered list to the status table
         status_table_view.setItems(filteredList);
    }



   
   private String  mapStatusToInt(String status) {
        if (status == null) {
        return "5"; // or handle the null case based on your requirements
       }
    switch (status) {
        case "Available":
            return "1";
        case "Unavailable":
            return "0";
        case "Missing":
            return "2";
        case "Return to Main":
            return "3";
        case "Defective":
            return "4";
        case "Emp Transfered":
            return "5";
        case "Room Transfered":
            return "6";
        default:
            return "5"; // Indicate an invalid status
    }
}
   private String  mapEmpStatusToInt(String status) {
        if (status == null) {
        return "5"; // or handle the null case based on your requirements
       }
    switch (status) {
        case "Active":
            return "1";
        case "Retired":
            return "0";
        case "Inactive":
            return "2";
        default:
            return "5"; // Indicate an invalid status
    }
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
                return "Emp Transfered";
            case "6":
                return "Room Transfered";
            default:
                return null;
        }
}
   
   private String mapEmpStatus(String status) {
        // Map the integer status to a user-friendly string
        switch (status) {
            case "1":
                return "Active";
            case "0":
                return "Retired";
            case "2":
                return "Inactive";
            default:
                return null;
        }
}
   
    public void refreshTables() {
        
    input_equip_id.setText(String.valueOf(2021100 + equipmentCount + 1));
    
    input_emp_id.setText(String.valueOf(2021010 + employeeCount + 1));
        
    input_room_id.setText(String.valueOf(roomCount + 1));
    
    search.clear();
    search1.clear();
    search2.clear();
    search3.clear();
    search4.clear();
    search5.clear();
    search_status.setValue("All");
    input_emp_in_charge.getItems().clear();
    roomId = 0;
        
    equip_status_table.getData().clear();
    equipmentData = sqlConnector.getEquipmentData();
    statusData = sqlConnector.getCombinedData();
    empData = sqlConnector.getEmployeeData();
    countData = sqlConnector.getEquipCount();
    equipDate = sqlConnector.getEquipmentDate();
    barChartData = sqlConnector.getEquipmentStatusChartData();
    roomData = sqlConnector.getRoomData();
    roomCountData = sqlConnector.getRoomEquipCount();
    catCountData = sqlConnector.getCatEquipCount();
    empCountData = sqlConnector.getEmpEquipCount();
    pieChartRoom = sqlConnector.getEquipmentCountByRoom();
    pieChartCat = sqlConnector.getEquipmentCountByCat();
    empInChargeList = sqlConnector.getEmployeeNames();
    
    equip_num_table.setItems(countData);
    equip_num_table1.setItems(countData);
    invent_table_view.setItems(equipmentData);
    status_table_view.setItems(statusData);
    emp_table_view.setItems(empData);
    room_table_view.setItems(roomData);
    equip_num_table.setItems(countData);
    equip_date_shown.setItems(equipDate);
    equip_status_table.getData().addAll(barChartData);
    equip_room_table.setItems(roomCountData);
    category_table_view.setItems(catCountData);
    category_table_view1.setItems(catCountData);
    emp_guard_table_view.setItems(empCountData);
    emp_guard_table_view1.setItems(empCountData);
    room_pie_chart.setData(pieChartRoom);
    cat_pie_chart.setData(pieChartCat);
    input_emp_in_charge.getItems().addAll(empInChargeList);
}

    private void clearInputFields() {
    
    input_equip_id.clear();
    input_property_num.clear();
    input_par_num.clear();
    input_equip_name.clear();
    input_equip_desc.clear();
    input_equip_used.clear();
    input_equip_user.clear();
    input_amount.clear();
    input_category.setValue(null);
    input_room.setValue(null);
    input_emp_in_charge.setValue(null);
        
    input_emp_id.clear();
    input_emp_fname.clear();
    input_emp_mname.clear();
    input_emp_lname.clear();
    input_emp_age.clear();
    input_emp_type.setValue(null);
    input_emp_sufix.setValue(null);
    input_emp_gender.setValue(null);
    
    input_room_id.clear();
    input_room_name.clear();
    input_room_type.setValue(null);
    input_room_status.setValue(null);
      }
    
    
    @FXML
    public void logOut(ActionEvent event) throws IOException {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                // Get the Stage from the current ActionEvent
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
    } else {
    // User clicked "No" or closed the dialog - do nothing or handle it accordingly
          }
    }
    
    public void stopTimeline() {
    timeline.stop();
    }
}

