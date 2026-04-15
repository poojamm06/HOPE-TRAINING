class user{
 String name;
 String location;
 int phone;
 public user(String name,String location,int phone){
    this.name=name;
    this.location=location;
    this.phone=phone;
 }
 void displayInfo(){
    System.out.println("information abt the user:" + name + location + phone);
 }
}
class ridebooking extends user{
    String vehicleType;
    ridebooking(String name,String location,int phone,String vehicleType){
        super(name,location,phone);
        this.vehicleType=vehicleType;
    }
void rideinfo(){
    displayInfo();
    System.out.println("vehicle type:" + vehicleType);}
}
class food extends user{
    String favfood;
    food(String name,String location,int phone,String favfood){
        super(name,location,phone);
        this.favfood=favfood;
    }
    void foodinfo(){
        displayInfo();
        System.out.println("fav food:" + favfood);
    }
}
class parcel extends user{
    String parcelweight;
    parcel(String name,String location,int phone,String parcelweight){
        super(name,location,phone);
        this.parcelweight=parcelweight;
    }
    void parcelinfo(){
        displayInfo();
        System.out.println("Parcel weight:"+ parcelweight);
    }
}
class task{
    public static void main(String[] args){
     
        ridebooking r=new ridebooking("Pooja","Chennai",678,"bike");
        r.rideinfo();
        food f=new food("gara","japan",123,"sushi");
        f.foodinfo();
        parcel p=new parcel("Alice","New York",987,"5kg");
        p.parcelinfo();
    }
}

 
