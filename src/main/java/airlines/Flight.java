package airlines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This are the scenarios to add and remove passengers in different types
 * The Add passenger policy is
 *  1. For economic flight-> Any passengers can be added(vip or usual passengers)
 *  2. For business flight->only vip passengers has to be added.
 *  The Remove passenger policy is
 *  1. For economic flight->except vip remove any passenger
 *  2.For business flight->Reject remove passenger if it's vip.
 */
public class Flight {
    private String id;
    private List<Passenger> passengerList;
    private String flightType;
    public Flight(String id, String flightType){
        this.id=id;
        this.flightType=flightType;
        passengerList=new ArrayList<>();
    }
    public String getId(){
        return id;
    }
    public String getFlightType(){
        return flightType;
    }
    public List<Passenger> getPassengerList(){

        return Collections.unmodifiableList(passengerList);
    }
    public boolean addPasseneger(Passenger passenger) {
        //Any type of flight can be added
        switch (flightType) {
            case "Ecnomy":
                return passengerList.add(passenger);
            case "Business":
                if (passenger.isVIP()) {
                    return passengerList.add(passenger);
                }
                return false;
            default:
                throw new RuntimeException("unknown type" + flightType);
        }
    }
    public boolean removePasseneger(Passenger passenger){
        //Non vip passengers can be removed
        switch (flightType) {
            case "Ecnomy":
                if (!passenger.isVIP()) {
                    //passenger can be removed if not vip
                    return passengerList.remove(passenger);
                }
                return false;
            case "Business":
                return false;
            default:
                throw new RuntimeException("un known type" + flightType);
        }
    }
}
