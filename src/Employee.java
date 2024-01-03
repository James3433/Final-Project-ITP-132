
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Employee {
    private int emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_gender;
    private String emp_type;
    private int emp_guard;
    private String emp_status;
    private int room_id;
    private String room_name;
    private String room_type;
    private int equip_stored;
    private String room_status;
    
    
    @Override
public String toString() {
    return "Employee ID: " + emp_id + ", Name: " + emp_name + ", Age: " + emp_age;
}
    
    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public int getEmp_guard() {
        return emp_guard;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getRoom_type() {
        return room_type;
    }

    public int getEquip_stored() {
        return equip_stored;
    }

    public String getRoom_status() {
        return room_status;
    }

    
    
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public void setEmp_guard(int emp_guard) {
        this.emp_guard = emp_guard;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setEquip_stored(int equip_stored) {
        this.equip_stored = equip_stored;
    }

    public void setRoom_status(String room_status) {
        this.room_status = room_status;
    }

    
    
    public Employee(int emp_id, String emp_name, int emp_age, String emp_gender, String emp_type, int emp_guard, String emp_status) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_gender = emp_gender;
        this.emp_type = emp_type;
        this.emp_guard = emp_guard;
        this.emp_status = emp_status;
    }  

    public Employee(int room_id, String room_name, String room_type, int equip_stored, String room_status) {
        this.room_id = room_id;
        this.room_name = room_name;
        this.room_type = room_type;
        this.equip_stored = equip_stored;
        this.room_status = room_status;
    }
    
    
}
