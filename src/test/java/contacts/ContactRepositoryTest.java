package contacts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
class ContactRepositoryTest {
    private  ContactRepository contactRepository;
    @InjectMocks
    Contact contact;

    @Mock
     Address addr;

    @BeforeEach
    void setUp() {
        addr=new Address("sabiyan123", "dire dawa", "251", Countries.Ethiopia);
        contact=new Contact("Eyuel","Tesfaye",addr);
        contactRepository=new ContactRepository();
       }
    @Test
    void testContactRepository() {
        //when(contactRepository.addContact(contact)).thenReturn(true);
        assertAll("Test all values for the dependecy class",
                ()->assertEquals(1,contactRepository.Count()),
                () -> assertEquals("Eyuel", contact.getFirstName()),
                () -> assertEquals("Tesfaye", contact.getLastName()),
                () ->  assertEquals("Eyuel , Tesfaye", contact.getFullName()),
                () ->assertEquals("dire dawa", addr.getCity()),
                () ->assertEquals("251", addr.getZipCode()),
                () ->assertEquals("sabiyan123", addr.getStreetAddress())
        );
    }
}