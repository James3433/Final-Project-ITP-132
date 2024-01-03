
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Admin
 */
public class SQLconnector {
    private static final String DB_URL = "jdbc:mysql://localhost/inventory_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    Connection conn = getConnection();
    PreparedStatement ps;
    
    
    public Connection getConnection(){
    try{
        conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        System.out.println("Connected to the database");
        return conn;
    } catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection failed");
        return null;
      }
   }
    public ObservableList<Equipment> getEquipmentData() {
        ObservableList<Equipment> data = FXCollections.observableArrayList();
        conn = getConnection();
            try {
        ps = conn.prepareStatement(
           "SELECT * FROM equipment_details; "
        );
        ResultSet rs = ps.executeQuery();
        
        // Rest of the code remains the same
        while (rs.next()) {
            data.add(new Equipment(
                rs.getInt("equip_id"),
        rs.getString("equip_name"),
        rs.getString("room_name"),
        rs.getString("equip_used"),
        rs.getString("equip_user"),
        rs.getString("cat_name"),
        rs.getString("emp_in_charge_name"),
        rs.getString("equip_status"),
        rs.getString("property_num"),
        rs.getString("PIR_num"),
        rs.getString("equip_description"),  
        rs.getString("amount")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

        return data;
    }
    
    public ObservableList<Status> getCombinedData() {
    ObservableList<Status> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM equipment_status_history"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new Status(
                rs.getInt("status_id"),
                rs.getInt("equip_id"),
                rs.getString("equip_name"),
                rs.getString("equip_status"),
                rs.getString("physical_date"),
                rs.getString("user_name"),
                rs.getString("room_name"),
                rs.getString("emp_in_charge_name"),
                rs.getString("property_num"),
                rs.getString("PIR_num"),
                rs.getString("equip_description")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
        return data;
    }  
    
    public ObservableList<Employee> getEmployeeData() {
    ObservableList<Employee> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM employee_details"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new Employee(
                rs.getInt("emp_id"),
                rs.getString("emp_name"),
                    rs.getInt("emp_age"),
                rs.getString("emp_gender"),
                    rs.getString("emp_type"),
                rs.getInt("emp_guard"),
                rs.getString("emp_status")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<Employee> getRoomData() {
    ObservableList<Employee> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM room_details"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new Employee(
                rs.getInt("room_id"),
                rs.getString("room_name"),
                    rs.getString("room_type"),
                rs.getInt("room_guard"),
                rs.getString("room_status")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<XYChart.Series<String, Number>> getEquipmentStatusChartData() {
        ObservableList<XYChart.Series<String, Number>> barChartData = FXCollections.observableArrayList();
        Connection connection = getConnection();
        // Your database connection and query
        try {
            ps = connection.prepareStatement( "SELECT * FROM equip_status_count" );
             ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(resultSet.getString("equip_name"));

                series.getData().add(new XYChart.Data<>("Available", resultSet.getInt("available")));
                series.getData().add(new XYChart.Data<>("Unavailable", resultSet.getInt("unavailable")));
                series.getData().add(new XYChart.Data<>("Missing", resultSet.getInt("missing")));
                series.getData().add(new XYChart.Data<>("Return to Main", resultSet.getInt("return_to_main")));
                series.getData().add(new XYChart.Data<>("Defective", resultSet.getInt("defective")));

                barChartData.add(series);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barChartData;
    }
    
    
    
    public ObservableList<PieChart.Data> getEquipmentCountByRoom() {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM room_equip_count";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String roomName = resultSet.getString("room_name");
                int count = resultSet.getInt("equip_number");
                data.add(new PieChart.Data(roomName, count));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        return data;
    }
    
     public ObservableList<PieChart.Data> getEquipmentCountByCat() {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        String query = "SELECT * FROM category_equip_count";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String roomName = resultSet.getString("cat_name");
                int count = resultSet.getInt("equip_number");
                data.add(new PieChart.Data(roomName, count));
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        return data;
    }
    
    public ObservableList<FlowChart> getEquipmentDate() {
    ObservableList<FlowChart> equipmentList = FXCollections.observableArrayList();
    conn = getConnection();
    try {
    ps = conn.prepareStatement(
          "SELECT * FROM equip_inventory_date");
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                FlowChart equip = new FlowChart(
                    rs.getInt("equip_id"),
                    rs.getString("equip_name"),
                    rs.getString("equip_description"),
                    rs.getString("first_date")
                );
                equipmentList.add(equip);
                }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return equipmentList;
}
    
    public ObservableList<FlowChart> getEquipCount() {
    ObservableList<FlowChart> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM equipment_count" 
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new FlowChart(
                rs.getString("equip_name"),
                    rs.getInt("equip_number")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<FlowChart> getRoomEquipCount() {
    ObservableList<FlowChart> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM room_equip_count"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new FlowChart(
                rs.getString("room_name"),
                rs.getInt("equip_number")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<FlowChart> getCatEquipCount() {
    ObservableList<FlowChart> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM category_equip_count"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new FlowChart(
                rs.getString("cat_name"),
                rs.getInt("equip_number")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<FlowChart> getEmpEquipCount() {
    ObservableList<FlowChart> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT * FROM employee_equip_count"
        );
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new FlowChart(
                    rs.getInt("emp_id"),
                rs.getString("emp_name"),
                rs.getInt("equip_number")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 
    
    public ObservableList<String> getRoomNames() {
    ObservableList<String> roomNames = FXCollections.observableArrayList();
    conn = getConnection();

    try {
        ps = conn.prepareStatement("SELECT room_name FROM room WHERE room_id != 404 AND room_status != 0");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            roomNames.add(rs.getString("room_name"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return roomNames;
}

    public ObservableList<String> getEmployeeNames() {
        ObservableList<String> empNamesList = FXCollections.observableArrayList();
        conn = getConnection();

        try {
            ps = conn.prepareStatement("SELECT CONCAT(emp_fname, ' ', UPPER(SUBSTRING(emp_mname, 1, 1)), IF(emp_mname != '' ,'. ', ' '), emp_lname, ' ',emp_suffix) AS emp_name FROM employee WHERE emp_status != 0;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                empNamesList.add(rs.getString("emp_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empNamesList;
    }
    
    public ObservableList<String> getCategoryNames() {
        ObservableList<String> categoryNames = FXCollections.observableArrayList();
        conn = getConnection();
        try {
            ps = conn.prepareStatement("SELECT cat_name FROM category");
                ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                categoryNames.add(rs.getString("cat_name"));
                    }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        return categoryNames;
    }
    
    public int getRoomIdByName(String roomName) {
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT room_id FROM room WHERE room_name = ?");
            ps.setString(1, roomName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("room_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        // Return a default or error value, depending on your requirements
        return -1;
    }
    
    public int getEmpIdByName(String empName) {
        conn = getConnection();
        try {
            ps = conn.prepareStatement("SELECT emp_id FROM employee WHERE CONCAT(emp_fname, ' ', UPPER(SUBSTRING(emp_mname, 1, 1)), IF(emp_mname != '' ,'. ', ' '), emp_lname, ' ',emp_suffix) = ?");
            ps.setString(1, empName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("emp_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        // Return a default or error value, depending on your requirements
        return -1;
    }

    public int getCategoryIdByName(String categoryName) {
    conn = getConnection();
    try {
        ps = conn.prepareStatement("SELECT category_id FROM category WHERE cat_name = ?");
        ps.setString(1, categoryName);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("category_id");
        } else {
            // Handle the case where no matching category name was found
            return -1; // or throw an exception or log a message
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception
        return -1; // or throw an exception or log a message
    }
}
  
 public ObservableList<Equipment> getEquipmentForEmployee(int employeeId) {
    ObservableList<Equipment> equipmentList = FXCollections.observableArrayList();
    conn = getConnection();

    try {
        CallableStatement cs = conn.prepareCall("{CALL GetLatestEmpEquipment(?)}");
        cs.setInt(1, employeeId);
        boolean hasResults = cs.execute();
       
        while (hasResults) {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equip_id"),
                        rs.getString("equip_name"),
                        rs.getString("equip_description")
                );
                equipmentList.add(equip);
            }
            hasResults = cs.getMoreResults();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return equipmentList;
}

public ObservableList<Equipment> getEquipmentByName1(String equipName) {
    ObservableList<Equipment> equipmentList = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        CallableStatement cs = conn.prepareCall("{CALL GetLatestEquipmentStatus(?)}");
        cs.setString(1, equipName);
        boolean hasResults = cs.execute();

        while (hasResults) {
            ResultSet rs = cs.getResultSet();
            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equip_id"),
                        rs.getString("equip_name"),
                        rs.getString("equip_description"),
                        rs.getString("equip_status")
                );
                equipmentList.add(equip);
            }
            hasResults = cs.getMoreResults();
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }

    return equipmentList;
}
 
   public ObservableList<Equipment> getEquipmentByName2(String equipName, int roomId) {
    ObservableList<Equipment> equipmentList = FXCollections.observableArrayList();
    conn = getConnection();
    try {
       ps = conn.prepareStatement(
         "SELECT DISTINCT se.equip_id, se.equip_name, se.equip_description, eis.equip_status " +
         "FROM school_equipment se " +
         "JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id " +
         "JOIN (SELECT equip_id, MAX(physical_date) AS latest_date FROM equipment_inventory_status GROUP BY equip_id) " +
         "latest_status ON eis.equip_id = latest_status.equip_id AND eis.physical_date = latest_status.latest_date " +
         "WHERE se.equip_name = ? AND eis.room_id = ? " +
         "GROUP BY se.equip_id;");
        ps.setString(1, equipName);
        ps.setInt(2, roomId);
        boolean hasResults = ps.execute();

        while (hasResults) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Equipment equip = new Equipment(
                        rs.getInt("equip_id"),
                        rs.getString("equip_name"),
                        rs.getString("equip_description"),
                        rs.getString("equip_status")
                );
                equipmentList.add(equip);
            }
            hasResults = ps.getMoreResults();
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
    return equipmentList;
}

   public ObservableList<FlowChart> getEquipCountFromRoom(int roomId) {
    ObservableList<FlowChart> data = FXCollections.observableArrayList();
    conn = getConnection();
    try {
        ps = conn.prepareStatement(
            "SELECT se.equip_name, COUNT(DISTINCT CASE WHEN eis.physical_date = latest_status.latest_date THEN se.equip_id END) AS equip_number " +
            "FROM school_equipment se " +
            "JOIN equipment_inventory_status eis ON se.equip_id = eis.equip_id " +
            "LEFT JOIN (SELECT equip_id, MAX(physical_date) AS latest_date FROM equipment_inventory_status GROUP BY equip_id) " +
            "latest_status ON eis.equip_id = latest_status.equip_id " +
            "JOIN room r ON eis.room_id = r.room_id " +
            "WHERE r.room_id = ? " +
            "GROUP BY se.equip_name " +
            "HAVING MAX(eis.physical_date) = MAX(latest_status.latest_date)" +
            "ORDER BY se.equip_name ASC;" 
        );
        ps.setInt(1, roomId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            data.add(new FlowChart(
                rs.getString("equip_name"),
                    rs.getInt("equip_number")
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return data;
    } 

 public List<List<String>> getEquipmentNamesById(int equipId) {
    List<List<String>> equipmentList = new ArrayList<>();
    conn = getConnection();
    try {
        // Call the stored procedure
        CallableStatement cs = conn.prepareCall("{CALL GetEquipmentDetails(?)}");
        cs.setInt(1, equipId);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
            List<String> equip = new ArrayList<>();
            equip.add(rs.getString("equip_id"));
            equip.add(rs.getString("property_num"));
            equip.add(rs.getString("PIR_num"));
            equip.add(rs.getString("equip_name"));
            equip.add(rs.getString("equip_description"));
            equip.add(rs.getString("equip_used"));
            equip.add(rs.getString("equip_user"));
            equip.add(rs.getString("amount"));
            equip.add(rs.getString("cat_name"));
            equip.add(rs.getString("room_name"));
            equip.add(rs.getString("equip_status"));
            equip.add(rs.getString("emp_in_charge_name"));
            equip.add(rs.getString("first_date"));
            equip.add(rs.getString("latest_date"));
            equipmentList.add(equip);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }
    return equipmentList;
}
 
public List<List<String>> getEquipmentByRoom(String roomName) {
    List<List<String>> equipmentList = new ArrayList<>();
    Connection conn = getConnection();

    try {
        // Call the stored procedure
        CallableStatement cs = conn.prepareCall("{CALL GetEquipmentByRoom(?)}");
        cs.setString(1, roomName);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
                    List<String> equipment = new ArrayList<>();
                    equipment.add(rs.getString("equip_id"));
                    equipment.add(rs.getString("equip_name"));
                    equipment.add(rs.getString("equip_description"));
                    equipmentList.add(equipment);
                }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

    return equipmentList;
}

public List<List<String>> getEquipmentByCat(String catName) {
    List<List<String>> equipmentList = new ArrayList<>();
    Connection conn = getConnection();

    try {
        // Call the stored procedure
        CallableStatement cs = conn.prepareCall("{CALL GetEquipmentByCategory(?)}");
        cs.setString(1, catName);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
                    List<String> equipment = new ArrayList<>();
                    equipment.add(rs.getString("equip_id"));
                    equipment.add(rs.getString("equip_name"));
                    equipment.add(rs.getString("equip_description"));
                    equipmentList.add(equipment);
                }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

    return equipmentList;
}

public List<List<String>> getEquipmentByEmp(int empId) {
    List<List<String>> equipmentList = new ArrayList<>();
    Connection conn = getConnection();

    try {
        // Call the stored procedure
        CallableStatement cs = conn.prepareCall("{CALL GetEquipmentByEmployee(?)}");
        cs.setInt(1, empId);
        ResultSet rs = cs.executeQuery();

        while (rs.next()) {
                    List<String> equipment = new ArrayList<>();
                    equipment.add(rs.getString("equip_id"));
                    equipment.add(rs.getString("equip_name"));
                    equipment.add(rs.getString("equip_description"));
                    equipmentList.add(equipment);
                }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception according to your needs
    }

    return equipmentList;
}

    public void addEquipment(int equipId, String propertyNum, String pirNum, String equipName, String equipDesc,String equipUsed, String equipUser, String amount,int categoryId, int roomId, int empInCharge, int status, String physicalDate, int userId) {
    conn = getConnection();

    try {
        // Insert a new record into the school_equipment table
        ps = conn.prepareStatement(
                "INSERT INTO school_equipment (equip_id, property_num, pir_num, equip_name, equip_description,equip_used, equip_user, amount,category_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, equipId);
        ps.setString(2, propertyNum);
        ps.setString(3, pirNum);
        ps.setString(4, equipName);
        ps.setString(5, equipDesc);
        ps.setString(6, equipUsed);
        ps.setString(7, equipUser);
        ps.setString(8, amount);
        ps.setInt(9, categoryId);

        ps.executeUpdate();

        // After adding the equipment, update the equipment status in equipment_inventory_status table

        addEquipmentStatus(equipId, physicalDate, roomId, status, empInCharge, userId);

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception according to your needs
    }
}
    
    public void addEmployee(int empId, String empFname, String empMname, String empLname, String empSuffix, int empAge, String empType, String empGender, int empStatus) {
    conn = getConnection();

    try {
        // Insert a new record into the employee table
        ps = conn.prepareStatement(
                "INSERT INTO employee (emp_id, emp_fname, emp_mname, emp_lname, emp_suffix, emp_age, emp_gender, emp_type, emp_status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, empId);
        ps.setString(2, empFname);
        ps.setString(3, empMname);
        ps.setString(4, empLname);
        if (empSuffix != null && !empSuffix.isEmpty()) {
            ps.setString(5, empSuffix);
        } else {
            // Set NULL explicitly for the emp_suffix column
            ps.setString(5, " ");
        }
        ps.setInt(6, empAge);
        ps.setString(7, empGender);
        ps.setString(8, empType);
        ps.setInt(9, empStatus);

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception according to your needs
    }
}
    
    public void addRoom(int roomId, String roomName, String roomType, int roomStatus) {
    conn = getConnection();

    try {
        // Insert a new record into the employee table
        ps = conn.prepareStatement(
                "INSERT INTO room (room_id, room_name, room_type, room_status) " +
                        "VALUES (?, ?, ?, ?)"
        );
        ps.setInt(1, roomId);
        ps.setString(2, roomName);
        ps.setString(3, roomType);
        ps.setInt(4, roomStatus);

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception according to your needs
    }
}
    
    public void addEquipmentStatus(int equipId, String physicalDate, int roomId, int status, int empInCharge, int userId) {
    Connection conn = getConnection();

    try {
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO equipment_inventory_status (equip_id, physical_date, room_id, equip_status, emp_in_charge, user_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, equipId);
        ps.setString(2, physicalDate);
        ps.setInt(3, roomId);
        ps.setInt(4, status);
        ps.setInt(5, empInCharge);
        ps.setInt(6, userId);

        ps.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("equipId: "+equipId);
        System.out.println("physicalDate: "+physicalDate);
        System.out.println("roomId: "+roomId);
        System.out.println("status: "+status);
        System.out.println("empInCharge: "+empInCharge);
        System.out.println("userId: "+userId);
    }
} 
    
    public void updateEmployee(int empId, String empFname, String empMname, String empLname, String empSuffix, int empAge, String empType, String empGender, String empStatus) {
        Connection conn = getConnection();

        try {
            // Update the record in the employee table
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE employee " +
                            "SET emp_fname = ?, emp_mname = ?, emp_lname = ?, emp_suffix = ?, emp_age = ?, emp_gender = ?, emp_type = ?, emp_status = ?" +
                            "WHERE emp_id = ?"
            );
            ps.setString(1, empFname);
            ps.setString(2, empMname);
            ps.setString(3, empLname);
            ps.setString(4, empSuffix);
            ps.setInt(5, empAge);
            ps.setString(6, empGender);
            ps.setString(7, empType);
            ps.setString(8, empStatus);
            ps.setInt(9, empId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
        }
    }
   
    public void editRoom(int roomId, String roomName, String roomType, int roomStatus) {
    conn = getConnection();

    try {
        // Insert a new record into the employee table
        ps = conn.prepareStatement(
                "UPDATE room SET room_name = ?, room_type = ?, room_status = ? WHERE room_id = ?;"
        );
        ps.setString(1, roomName);
        ps.setString(2, roomType);
        ps.setInt(3, roomStatus);
        ps.setInt(4, roomId);

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception according to your needs
    }
}
    
   public void updateEquipmentName(int equipId, String propertyNum, String pirNum, String equipName, String equipDesc,String equipUsed, String equipUser, String amount, int categoryId) {
    Connection conn = getConnection();
    try {
        // Define your SQL update query
        PreparedStatement preparedStatement = conn.prepareStatement(
                "UPDATE school_equipment SET property_num = ?, pir_num = ?, equip_name = ?, equip_description = ?,equip_used = ?, equip_user = ?, amount = ?, category_id = ? WHERE equip_id = ?");

        // Set the parameters for the prepared statement
        preparedStatement.setString(1, propertyNum);
        preparedStatement.setString(2, pirNum);
        preparedStatement.setString(3, equipName);
        preparedStatement.setString(4, equipDesc);
        preparedStatement.setString(5, equipUsed);
        preparedStatement.setString(6, equipUser);
        preparedStatement.setString(7, amount);
        preparedStatement.setInt(8, categoryId);
        preparedStatement.setInt(9, equipId);

        // Execute the update
        preparedStatement.executeUpdate();
             
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
        }
    }
    
    public boolean isEmployeeAlreadyExists( int empId, String fname, String mname, String lname) {
    boolean exists = false;
    String query = "SELECT emp_id FROM employee WHERE emp_id != ? AND (emp_fname = ? AND emp_lname = ? AND (emp_mname = ? OR emp_mname IS NULL))";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, empId);
        preparedStatement.setString(2, fname);
        preparedStatement.setString(3, lname);
        preparedStatement.setString(4, mname);
        ResultSet resultSet = preparedStatement.executeQuery();
        exists = resultSet.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
}
    
    public boolean isRoomExists( int roomId, String roomName) {
    boolean exists = false;
    String query = "SELECT room_id FROM room WHERE room_id != ? AND room_name = ?";
    try (Connection connection = getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, roomId);
        preparedStatement.setString(2, roomName);
        ResultSet resultSet = preparedStatement.executeQuery();
        exists = resultSet.next();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
}
    
    public boolean isPropertyOrPirNumExists(String propertyNum, String pirNum) {
        String query = "SELECT COUNT(*) AS count FROM school_equipment WHERE property_num = ? OR pir_num = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, propertyNum);
            preparedStatement.setString(2, pirNum);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return false; 
    }
}
