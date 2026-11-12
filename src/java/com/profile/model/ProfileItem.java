package com.profile.model;

public class ProfileItem implements java.io.Serializable {
    private String name;
    private String id;
    private String programme;
    private String email;
    private String hobbies;
    private String selfintro;
    
    
    //constructor
    public ProfileItem()
    {
        name = "";
        id = "";
        programme = "";
        email = "";
        hobbies = "";
        selfintro = "";
    }
    
    public ProfileItem(String name, String id, String programme, String email, String hobbies, String selfintro)
    {
        this.name = name;
        this.id = id;
        this.programme = programme;
        this.email = email;
        this.hobbies = hobbies;
        this.selfintro = selfintro;
    }
    
    //getter
    public String getName()
    {
        return name;
    }
    
    public String getId ()
    {
        return id;
    }
    
    public String getProgramme ()
    {
        return programme;
    }
    
    public String getEmail ()
    {
        return email;
    }
    
    public String getHobbies ()
    {
        return hobbies;
    }
    
    public String getSelfintro ()
    {
        return selfintro;
    }
    
    
    
    //setter
    public void setName (String name){
        this.name = name;
    }
    
    public void setId (String id){
        this.id = id;
    }
    
    public void setProgramme (String programme){
        this.programme = programme;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    
    public void setHobbies (String hobbies){
        this.hobbies = hobbies;
    }
    
    public void setSelfintro(String selfintro){
        this.selfintro = selfintro;
    }
    
    
   
}
