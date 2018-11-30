package airlines_modifed;
import  airlines.Passenger;
public class EconomyFlight extends Flight {

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengersSet.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVIP()) {
            return passengersSet.remove(passenger);
        }
        return false;
    }

}
