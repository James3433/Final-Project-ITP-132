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
    private String equip_asc;

    public int getEquip_id() {
        return equip_id;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public String getEquip_asc() {
        return equip_asc;
    }

    public void setEquip_id(int equip_id) {
        this.equip_id = equip_id;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public void setEquip_asc(String equip_asc) {
        this.equip_asc = equip_asc;
    }

    public ReadEquip(int equip_id, String equip_name, String equip_asc) {
        this.equip_id = equip_id;
        this.equip_name = equip_name;
        this.equip_asc = equip_asc;
    }

}
