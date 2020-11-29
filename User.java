package pdf;

public class User {
    private String first_name;
    private String last_name;
    private String email;
    private String dob;
    private String tel_num;
    private int id_num;
    private String password;
    
    public User(String fname, String lname, String email, String dob, String telnum, int id, String password){
        this.first_name=fname;
        this.last_name=lname;
        this.email=email;
        this.dob=dob;
        this.id_num=id;
        this.tel_num=telnum;
        this.password=password;
    }

    public String getFirstName(){
        return this.first_name;
    }

    public String getLastName(){
        return this.last_name;
    }

    public String getEmailAddress(){
        return this.email;
    }

    public int getID(){
        return this.id_num;
    }

    public String getPassword(){
        return this.password;
    }

    public void setEmail(String newemail){
        this.email= newemail;
    }

    public void setLastName(String newlstname){
        this.last_name= newlstname;
    }

    public void setFirstName(String newfname){
        this.first_name=newfname;
    }

    public void setPassword(String newpass){
        this.password=newpass;
    }

    public void setDOB(String newdob){
        this.dob=newdob;
    }

    public void setTelephoneNumber(String newtel){
        this.tel_num=newtel;
    }
}
