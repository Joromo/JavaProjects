import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;//array list of contact method

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList< Contacts>();
    }

    public boolean addNewContact(Contacts contacts){
        if (findContacts(contacts.getName()) >=0 ){
            System.out.println("Contact is already saved");
            return false;
        }
        myContacts.add(contacts);
        return true;
    }

    public boolean UpdateContact(Contacts oldcontact, Contacts newcontact){
        int position = findContacts(oldcontact);
        if (position>=0){
            this.myContacts.set(position,newcontact);
            System.out.println(oldcontact.getName()+" was replaced by "+newcontact.getName());
            return true;
        }else if ( findContacts(newcontact.getName())!= -1) {
            System.out.println(" Contatc with Name "+newcontact.getName()+"  Found: Update Unsuccessfull");
            return false;
        }else{
            System.out.println(oldcontact.getName()+"wa not found");
            return false;
        }
    }
    public boolean removeContact(Contacts contacts){
        int position = findContacts(contacts);
        if (position>=0){
            this.myContacts.remove(position);
            System.out.println(contacts.getName() +"was Deleted");

            return true;
        }else{
            System.out.println(contacts.getName()+"wa not found");
            return false;
        }
    }

    private int findContacts(Contacts contacts){
        return myContacts.indexOf(contacts);
    }
    private int findContacts(String findContacts){
        //loop through all record to find a name then do the comparison and return index position
        for (int i=0;i<this.myContacts.size();i++){
            Contacts contacts=this.myContacts.get(i);
            if (contacts.getName().equals(findContacts)){
                return i;//index number of found objects
            }
        }
        return -1;
    }
    public String Querrycontact(Contacts contacts){
        if(findContacts(contacts)>=0){
            return contacts.getName();
        }
        return null;
    }

    public void printListOfContacts(){
        System.out.println("You have "+myContacts.size()+" Contacts in your List");
        for (int i=0;i<myContacts.size();i++){
            System.out.println((i+1)+""+myContacts.get(i).getName()+"=>"+myContacts.get(i).getPhoneNumber());
        }
    }
    public Contacts queryContatc(String name){
        int position=findContacts(name);
        if (position>=0)
            return myContacts.get(position);
        return null;
    }
}
