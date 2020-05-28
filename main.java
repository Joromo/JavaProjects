import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilephone =new MobilePhone("0728175825");

    public static void main(String[] args) {
        boolean quit = false;
        startphone();
        printAction();
        while (!quit){
            System.out.println("\nEnter Action:( 6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("......\n.....\n.. Shuting Down .....");
                    quit=true;
                    break;
                case 1:
                    mobilephone.printListOfContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    UpdateConatct();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContatc();
                    break;
                case 6:
                    printAction();
                    break;
            }
        }
    }
    private static void startphone(){
        System.out.println("........Starting Phone......");
    }
    private static void printAction(){
        System.out.println("\n Available action :\n Press..");
        System.out.println( "\n 0 : - to Shutdown "+
                            "\n 1 : -to Print Contact "+
                            "\n 2 : - to add a new Contatc  "+
                            "\n 3 : - to Update an Existing contatc "+
                            "\n 4 : - to removean existing contact "+
                            "\n 5 : - to Query a contact "+
                            "\n 6 : - to Print LIst of available conatcts ");
        System.out.println("\n\n\n\n Please choose your Actions \n");
    }
    private static void addNewContact(){
        System.out.println("Enter New Conact Name");
        String name =scanner.nextLine();
        System.out.println("Enter Phone NUmber");
        String phoneNumber= scanner.nextLine();

        Contacts newContatc = Contacts.creatContact(name,phoneNumber);
        if (mobilephone.addNewContact(newContatc)){
            System.out.println("New Added Contact: Name: "+ name+" Phone NUmber "+phoneNumber);
            }else{
            System.out.println("Cannoty add, "+name+"already Exist");
        }
    }
    private static void UpdateConatct(){
        System.out.println("Enter Name of Contatc toupdayte");
        String name = scanner.nextLine();
        Contacts existingContatc = mobilephone.queryContatc(name);
        if (existingContatc==null){
            System.out.println("Contatc not found");
            return;
        }
        System.out.println("Enter a new Conact Name: ");
        String newname = scanner.nextLine();
        System.out.println("Enter a new Phone NUmber");
        String Number = scanner.nextLine();

        Contacts newContacts = Contacts.creatContact(newname,Number);

        if (mobilephone.UpdateContact(existingContatc,newContacts)){
            System.out.println("Successfully Updated Records");
        }else{
            System.out.println("Error Updating Records");
        }
    }
    private static void removeContact(){
        System.out.println("Enter Name of Contatc to Remove");
        String name = scanner.nextLine();
        Contacts existingContatc = mobilephone.queryContatc(name);
        if (existingContatc==null){
            System.out.println("Contatc not found");
            return;
        }
        if (mobilephone.removeContact(existingContatc)){
            System.out.println("Successfully Updated Records");
        }else{
            System.out.println("Error Updating Records");
        }
    }
    private static void queryContatc(){
        System.out.println("Enter Name of Contatc to Remove");
        String name = scanner.nextLine();
        Contacts existingContatc = mobilephone.queryContatc(name);
        if (existingContatc==null){
            System.out.println("Contatc not found");
            return;
        }
        System.out.println("Name : "+existingContatc.getName()+" Phone Number is "+existingContatc.getPhoneNumber());
    }

}
