/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class FlowChart {
    private int equip_id;
    private String equip_name;
    private String equip_desc;
    private int available;
    private int unavailable;
    private int missing;
    private int return_to_main;
    private int defective;
    private String name;
    private int equip_number;
    private int id;
    private String first_date;

    public int getEquip_id() {
        return equip_id;
    }
    
    public String getEquip_name() {
        return equip_name;
    }

    public int getAvailable() {
        return available;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public int getMissing() {
        return missing;
    }

    public int getReturn_to_main() {
        return return_to_main;
    }

    public int getDefective() {
        return defective;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getEquip_number() {
        return equip_number;
    }
    
    public String getEquip_desc() {
        return equip_desc;
    }
    
    public String getFirst_date() {
        return first_date;
    }
    
    
    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }
    
    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setUnavailable(int unavailable) {
        this.unavailable = unavailable;
    }

    public void setMissing(int missing) {
        this.missing = missing;
    }

    public void setReturn_to_main(int return_to_main) {
        this.return_to_main = return_to_main;
    }

    public void setDefective(int defective) {
        this.defective = defective;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquip_number(int equip_number) {
        this.equip_number = equip_number;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setEquip_desc(String equip_desc) {
        this.equip_desc = equip_desc;
    }
    
    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }
    
    
    public FlowChart(String equip_name, int available, int unavailable, int missing, int return_to_main, int defective) {
        this.equip_name = equip_name;
        this.available = available;
        this.unavailable = unavailable;
        this.missing = missing;
        this.return_to_main = return_to_main;
        this.defective = defective;
    }
    
    public FlowChart(int equip_id, String equip_name, String equip_desc, String first_date) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.equip_desc = equip_desc;
        this.first_date = first_date;
    }
    
     public FlowChart(String name, int equip_number) {
        this.name = name;
        this.equip_number = equip_number;
    
     }
     
     public FlowChart(int id, String name, int equip_number) {
        this.id = id;
        this.name = name;
        this.equip_number = equip_number;
    
     }
}
