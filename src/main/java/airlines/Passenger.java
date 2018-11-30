package airlines;

public class Passenger {
    private String name;
    private boolean vip;
    public Passenger(String name, boolean vip){
        this.name=name;
        this.vip=vip;
    }
    public boolean isVIP(){
        return vip;
    }
    public String getName(){
        return name;
    }
}
