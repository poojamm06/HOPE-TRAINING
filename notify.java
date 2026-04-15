class notification{
    String name;
    String message;
    public notification(String name, String message){
        this.name = name;
        this.message = message;
    }
    void send(){
        System.out.println("Notification sent to " + name + ": " + message);    
        System.out.println("notification sent successfully from parent class");
    }
}
class EmailNotification extends notification{
    public EmailNotification(String name, String message) {
        super(name, message);
    }
    @Override
    void send() {
        System.out.println("Email notification sent to " + name + ": " + message);
        System.out.println("notification sent successfully from child class");
    }
}
class SMSNotification extends notification{
    public SMSNotification(String name,String message){
        super(name,message);
    }
    void send(){
        System.out.println("Email notification sen to "+ name + ":" + message);
        System.out.println("notification sen sucessfully from child class");
    }
}
public class notify{
    public static void main(String[] args){
        notification n;
        n= new EmailNotification("Pooja","internship attendance mandatory");
        n.send();
        n= new SMSNotification("Ruth","how do u do?");
        n.send();
        
    }
}
