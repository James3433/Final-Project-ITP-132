/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Equipment {       
    private int equip_id;
    private String equip_name;
    private String room;
    private String equip_used;
    private String Equip_user;
    private String category;
    private String emp_in_charge;
    private String status;
    private String property_num;
    private String pir_num;
    private String equip_desc;
    private String amount;
    private String first_date;
    private String last_date;



    public int getEquip_id() {
        return equip_id;
    }
    
    public String getRoom(){
        return room;
        
    }
    public String getEquip_name() {
        return equip_name;
    }

    public String getEquip_used() {
        return equip_used;
    }

    public String getEquip_user() {
        return Equip_user;
    }

    public String getCategory() {
        return category;
    }

    public String getEmp_in_charge() {
        return emp_in_charge;
    }

    public String getStatus() {
        return status;
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
    
    public String getAmount() {
        return amount;
    }

    public String getFirst_date() {
        return first_date;
    }

    public String getLast_date() {
        return last_date;
    }
    
    
    
    
    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setEquip_used(String equip_used) {
        this.equip_used = equip_used;
    }

    public void setEquip_user(String Equip_user) {
        this.Equip_user = Equip_user;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setEmp_in_charge(String emp_in_charge) {
        this.emp_in_charge = emp_in_charge;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }
    
    
    
    
    public Equipment(int equip_id, String equip_name, String room, String equip_used, String Equip_user, String category, String emp_in_charge, String status, String property_num, String pir_num, String equip_desc, String amount) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.room = room;
        this.equip_used = equip_used;
        this.Equip_user = Equip_user;
        this.category = category;
        this.emp_in_charge = emp_in_charge;
        this.status = status;
        this.property_num = property_num;
        this.pir_num = pir_num;
        this.equip_desc = equip_desc;
        this.amount = amount;
        
        if(this.status.equals("5") || this.status.equals("6")){
        this.status = "1";
        }
        
        if(this.status.equals("3")){
        this.equip_id = equip_id;
        this.equip_name = "------------";
        this.room = "------------";
        this.equip_used = "------------";
        this.Equip_user = "------------";
        this.category = "------------";
        this.emp_in_charge = "------------";
        this.property_num = "------------";
        this.pir_num = "------------";
        this.status = status;
        this.equip_desc = "-------------";
        this.amount = "------------";
        }
        
    }

    public Equipment(int equip_id, String equip_name, String equip_desc) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.equip_desc = equip_desc;
    }
    
    public Equipment(int equip_id, String equip_name, String equip_desc, String status) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.equip_desc = equip_desc;
        this.status = status;
    }

    public Equipment(int equip_id, String equip_name, String room, String equip_used, String equip_user, String category, String emp_in_charge, String status, String property_num, String pir_num, String equip_desc, String amount, String first_date, String last_date) {
        
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.room = room;
        this.equip_used = equip_used;
        this.Equip_user = equip_user;
        this.category = category;
        this.emp_in_charge = emp_in_charge;
        this.status = status;
        this.property_num = property_num;
        this.pir_num = pir_num;
        this.equip_desc = equip_desc;
        this.amount = amount;
        this.first_date = first_date;
        this.last_date = last_date;
    }
   
    
    
}
