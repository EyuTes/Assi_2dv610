package contacts;

public class Contact {
    /*-----------------properties--------------*/
    private String firstName;
    private String lastName ;
    //Aggregation-"has a" relation: Contact has an address
    private Address address;
    /*-----------------Constructor--------------*/
    //Empty constructor
    public Contact() {
        address = new Address();
    }
    //Parameterized constructor with constructor chaining
    public Contact(Contact contact)
    {
    this(contact.firstName, contact.lastName, contact.address);
    }
    public Contact(String firstName, String lastName, Address addr )
    {
        if (validate(firstName.trim()) && validate(lastName.trim()) && validate(addr))
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = addr;
        }
    }
    /*-----------------getters and setters--------------*/
    public Address getAddressData() {
        return address;
    }
    public void setAddress(Address address){
        if(validate(address)){
            this.address=address;
        }
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        if(validate(firstName)){
            this.firstName=firstName;
        }
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        if(validate(lastName)){
            this.lastName=lastName;
        }
    }
    public String getFullName() {
        return getFirstName()+ " , " + getLastName();
    }
    /*-----------------Methods--------------*/
    public boolean validate(Object input)
    {
        if (input=="" || input==null)
            throw new NullPointerException(" Null or Empty is not allowed");
        return true;
    }
    @Override
    public String toString() {
        String strOut = String.format("{0,-20} {1}",getFullName(),address.toString());
        return strOut;
    }
}
