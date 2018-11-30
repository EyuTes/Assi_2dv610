package airlines_modifed;
import  airlines.Passenger;
public class PremiumFlight extends Flight {

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVIP()) {
            return passengersSet.add(passenger);
        }
        return false;
    }
    @Override
    public boolean removePassenger(Passenger passenger) {
        if (passenger.isVIP()) {
            return passengersSet.remove(passenger);
        }
        return false;
    }
}
