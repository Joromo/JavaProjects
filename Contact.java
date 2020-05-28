import java.util.ArrayList;

public class Contacts {
    private  ArrayList<String> contacts = new ArrayList<>();

    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //to help create new contact method. calls constructor to create contact new
    public static Contacts creatContact(String name, String phoneNumber){
        return  new Contacts(name,phoneNumber);
    }


}
