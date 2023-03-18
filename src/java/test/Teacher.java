/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author HP
 */
public class Teacher {
    public String id,name,pack,fillier;
    
    public Teacher(String id, String name ,String fillier ,String pack){
        this.id=id;
        this.name=name;
        this.fillier=fillier;
        this.pack=pack;
    }
    public String GetID(){
        return id;
    }
    public String GetName(){
        return name;
    }
    public String GetPack(){
        return pack;
    }
    public String GetFillier(){
        return fillier;
    }
}
