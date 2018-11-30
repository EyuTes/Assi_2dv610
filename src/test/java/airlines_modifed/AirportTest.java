package airlines_modifed;

import org.junit.jupiter.api.*;
import  airlines.Passenger;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger meli;
        private Passenger joel;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            meli = new Passenger("Meli", true);
            joel = new Passenger("Joel", false);
        }
        @Nested
        @DisplayName("When we have a usual(or ordinary) passenger")
        class UsualPassenger {

            @Test
            @DisplayName("Then can be added or removed from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(meli)),
                        () -> assertEquals(true, economyFlight.addPassenger(joel)),
                        () -> assertEquals(2, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(meli)),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(joel)),
                        () -> assertEquals(true, economyFlight.removePassenger(joel)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals(false, economyFlight.removePassenger(meli)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Then cannot added to an economy flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i=0; i<repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(joel);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(joel)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Joel"))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then can be add to economic flight but cannot be remove from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(meli)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(meli)),
                        () -> assertEquals(false, economyFlight.removePassenger(meli)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size())
                );
            }
            @DisplayName("Then cannot added more than once in economic flight")
            @RepeatedTest(5)
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i=0; i<repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(meli);
                }
                assertAll("Verify a VIP passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(meli)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Meli"))
                );
            }
        }
    }
    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mesi;
        private Passenger jafer;
        private Passenger henok;
        private Passenger beti;

        @BeforeEach
        void setUp() {
            businessFlight = new EconomyFlight("2");
            mesi = new Passenger("Mesi", true);
            jafer = new Passenger("Jafer", false);

        }@Nested
        @DisplayName("When we have a usual(ordinary) passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then cannot add or remove from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                        //() -> assertEquals(false, businessFlight.addPassenger(jafer)),
                        () -> assertFalse(businessFlight.getPassengersSet().contains(jafer)),
                        () -> assertEquals(false, businessFlight.removePassenger(jafer))
                );
            }
        }
        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then you can add  but cannot remove from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(mesi)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(mesi)),
                        () -> assertEquals(1, businessFlight.getPassengersSet().size())
                );
            }
            @DisplayName("Then you cannot add passenger to a business flight more than once")
            @RepeatedTest(5)
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i=0; i<repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(mesi);
                }
                assertAll("Verify a VIP passenger can be added to a business flight only once",
                        () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                        () -> assertTrue(businessFlight.getPassengersSet().contains(mesi)),
                        () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("Mesi"))
                );
             }
         }
     }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger meli;
        private Passenger joel;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            meli = new Passenger("Meli", true);
            joel = new Passenger("Joel", false);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Can't be add or remove him from a premium flight")
            public void testPremiumFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(joel)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(joel)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }
        }
        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("can be added or removed from a premium flight")
            public void testPremiumFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertEquals(true, premiumFlight.addPassenger(meli)),
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(meli)),
                        () -> assertEquals(0, premiumFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Can't not add to a premium flight more than once")
            @RepeatedTest(5)
            public void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i=0; i<repetitionInfo.getCurrentRepetition(); i++) {
                    premiumFlight.addPassenger(meli);
                }
                assertAll("Verify a VIP passenger can be added to a premium flight only once",
                        () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                        () -> assertTrue(premiumFlight.getPassengersSet().contains(meli)),
                        () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("Meli"))
                );
            }
        }
    }
}

