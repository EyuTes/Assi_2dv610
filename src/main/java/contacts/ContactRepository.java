package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    /*-----------------properties--------------*/
    private List<Contact> contactRegistry;
    /*-----------------Constructor--------------*/
    public ContactRepository() {
        contactRegistry = new ArrayList<>();
    }
    /*-----------------getter to count number of items--------------*/
    public int Count(){
        return contactRegistry.size();
    }
   /*-----------------Methods--------------*/
   public boolean addContact(String firstName, String lastName, Address addr)
   {
       if (validate(firstName) && validate(lastName) && validate(addr))
       {
        Contact contact = new Contact(firstName,lastName,addr);
        addContact(contact);
        return true;
       }
       return false;
   }
    public boolean addContact(Contact contactIn)
    {
        if (validate(contactIn)) {
          Contact otherContact = new Contact(contactIn.getFirstName(),contactIn.getLastName(),contactIn.getAddressData());
          contactRegistry.add(otherContact);
          return true;
        }
        return false;
    }
    //Change the values of the object at the position=index in the list
    public boolean changeContact(Contact contact, int index)
    {
       if ((contact != null) && checkIndex(index))
        {
         contactRegistry.set(index,contact);
         return true;
        }
        return false;
    }
    //Remove the object at position= index from the list
    public boolean deleteContact(int index)
    {
        if (checkIndex(index))
        {
           contactRegistry.remove(index);
           return true;
        }
        return false;
    }
    public Contact GetContactCopy(int index)
    {
        if (checkIndex(index))
        {
           Contact copyObj = new Contact(contactRegistry.get(index));  //copying is done in the Contact class
           return copyObj;
        }
        return null;
    }
    /*
     * The method returns the array of string of contacts
     */
    public String[] getContactInfo()
    {
        String[] strInfo = new String[contactRegistry.size()];
        int i = 0;
        for (Contact contactObj : contactRegistry) {
        strInfo[i++] = contactObj.toString();
        }
        return strInfo;
    }
    //The helper method checks if index is valid .
    public boolean checkIndex(int index)
    {
        return (index >= 0) && (index < contactRegistry.size());
    }
    //The helper method that validates Object.
    /*-----------------Methods--------------*/
    private boolean validate(Object input)
    {
        if (input=="" || input==null)
            throw new NullPointerException(" Null or Empty is not allowed");
        return true;
    }
}
