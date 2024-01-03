/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Status {
    private int status_id;
    private int equip_id;
    private String equip_name;
    private String status;
    private String physical_date;
    private String user_name;
    private String room;
    private String emp_in_charge;
    private String property_num;
    private String pir_num;
    private String equip_desc;

    public int getStatus_id() {
        return status_id;
    }

    public int getEquip_id() {
        return equip_id;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public String getStatus() {
        return status;
    }

    public String getPhysical_date() {
        return physical_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getRoom() {
        return room;
    }

    public String getEmp_in_charge() {
        return emp_in_charge;
    }

    public String getProperty_num() {
        return property_num;
    }

    public String getPir_num() {
        return pir_num;
    }

    public String getEquip_desc() {
        return equip_desc;
    }
    
    
    
    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhysical_date(String physical_date) {
        this.physical_date = physical_date;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setEmp_in_charge(String emp_in_charge) {
        this.emp_in_charge = emp_in_charge;
    }

    public void setProperty_num(String property_num) {
        this.property_num = property_num;
    }

    public void setPir_num(String pir_num) {
        this.pir_num = pir_num;
    }

    public void setEquip_desc(String equip_desc) {
        this.equip_desc = equip_desc;
    }


    public Status(int status_id, int equip_id, String equip_name, String status, String physical_date, String user_name, String room, String emp_in_charge, String property_num, String pir_num, String equip_desc) {
        this.status_id = status_id;
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.status = status;
        this.physical_date = physical_date;
        this.user_name = user_name;
        this.room = room;
        this.emp_in_charge = emp_in_charge;
        this.property_num = property_num;
        this.pir_num = pir_num;
        this.equip_desc = equip_desc;
    }
    
    public Status(int equipId, String status) {
        // Initialize your fields here
    }
    
    
}
