package test;


public class Student {
    public String id,name,pack,gender,birthday,price,phone,email;
    
    public Student(String id,String name,String price,String pack){
        this.id=id;
        this.name=name;
        this.price=price;
        this.pack=pack;
    }
    public Student(String id,String name,String price,String gender,String email,String phone,String pack,String birth){
        this.id=id;
        this.name=name;
        this.price=price;
        this.gender=gender;
        this.email=email;
        this.phone=phone;
        this.pack=pack;
        this.birthday=birth;
    }
    public Student(String id,String name,String price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    
    public String getName(){
        return name;
    }
    public String getPrice(){
        return this.price;
    }
    public String getPack(){
        return this.pack;
    }
    public String getID(){
        return this.id;
    }
    public String getGender(){
        return this.gender;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getBirth(){
        return this.birthday;
    }
}
