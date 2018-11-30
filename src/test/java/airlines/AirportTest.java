package airlines;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * This are the scenarios to add and remove passengers in different types
 * The Add passenger policy is
 *  1. For economic flight-> Any passengers can be added(vip or usual passengers)
 *  2. For business flight->only vip passengers has to be added.
 *  The Remove passenger policy is
 *  1. For economic flight->possible to remove any passengers type
 *  2.For business flight->Reject remove passenger if it's vip.
 */
class AirportTest {
    //Flight
    private Flight economyFlight;
    private Flight businessFlight;
    //Passenger
    //passenger
    private Passenger joel;
    private Passenger meli;

    @BeforeEach
    void setUp() {
        //Flight object
        economyFlight=new Flight("1","Ecnomy");
        businessFlight=new Flight("2","Business");
        joel=new Passenger("Joel",false);
        meli=new Passenger("Meli", true);

    }
    @DisplayName("Test flight based on policy:Economic flight-> Ordinary or vip passengers can be added to economic flight. It's possible to remove economic flight\n" +
            "Business flight-> only vip can be added and not possible to remove vip")
    @Test
    void testEconomyFlightUsualPassenger(){

        assertAll("Verify all conditions for economic and business flight",
                () -> assertEquals("1", economyFlight.getId()),
                //Any passengers can be added to economic flight
                () -> assertEquals(true, economyFlight.addPasseneger(joel)),
                //possible to add vip passenger to economy flight
                () -> assertEquals(true, economyFlight.addPasseneger(meli)),
                () -> assertEquals(2, economyFlight.getPassengerList().size()),
                () -> assertEquals("Joel", economyFlight.getPassengerList().get(0).getName()),
                () -> assertEquals("Meli", economyFlight.getPassengerList().get(1).getName()),
                () -> assertEquals(true, economyFlight.removePasseneger(joel)),
                () -> assertEquals(1, economyFlight.getPassengerList().size()),
                () -> assertEquals("2", businessFlight.getId()),
                //VIP passengers can be added to business flight
                () -> assertEquals(true, economyFlight.addPasseneger(meli)),
                () -> assertEquals(1, businessFlight.getPassengerList().size()),
                () -> assertEquals("Meli", businessFlight.getPassengerList().get(0).getName()),
                /* reject to remove business class passengers */
                () -> assertEquals(false, businessFlight.removePasseneger(meli)),
                () -> assertEquals(1, businessFlight.getPassengerList().size())
           );
    }

}
