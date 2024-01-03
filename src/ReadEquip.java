/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class ReadEquip {
    private int equip_id;
    private String equip_name;
    private String equip_desc;

    public int getEquip_id() {
        return equip_id;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public String getEquip_desc() {
        return equip_desc;
    }

    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public void setEquip_desc(String equip_desc) {
        this.equip_desc = equip_desc;
    }

    public ReadEquip(int equip_id, String equip_name, String equip_desc) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.equip_desc = equip_desc;
    }

}
