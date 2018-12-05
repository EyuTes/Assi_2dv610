package contacts;

public class Address {

    /*-----------------properties--------------*/
    private String city;
    private Countries country = Countries.Sverige;
    private String street ;
    private String zipCode ;

    /*-----------------Constructors--------------*/
    //default constructor, needed when Address is a member in another class
    public Address()
    {
        this("", "Stcokholm", "");
    }

    //Constructor with parameters
    public Address(String street, String city, String zipCode)
    {
     this(street, city, zipCode, Countries.Sverige);
    }
    /* Copy Constructor - clone the other Address
     * this Address is created with the same values from another Address object
     */
    public Address(Address address)
    {
        this(address.street, address.city, address.zipCode, address.country);
    }

    public Address(String street, String city, String zipCode, Countries country)
    {
        if (validate(street.trim()) && validate(city.trim()) && validate(country.toString()))
        {
            this.country = country;
            this.street = street;
            this.city = city;
            this.zipCode = zipCode;
        }
    }
    /*-----------------Getters and setters--------------*/
    //read access
    public String getStreetAddress(){
        return street;
    }
    //write access
    public void setStreetAddress(String street){
        if(validate(street)){
            this.street=street;
        }
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        if(validate(city)){
            this.city=city;
        }
    }
    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String zipCode){
        if(validate(zipCode)){
            this.zipCode=zipCode;
        }
    }
    public void setCountry(Countries country){
        if(validate(country.toString())){
            this.country=country;
        }
     }

    /*-----------------Methods--------------*/
    public String getAddress()
    {
        Address copyAddres = new Address(street, city, zipCode, country);
        return copyAddres.toString();
    }
    public String getCountry()
    {
        String strCountry = country.toString();
        strCountry = strCountry.replace("_", " ");
        return strCountry;
    }
    private boolean validate(Object input)
    {
        if (input=="" || input==null)
            throw new NullPointerException(" Null or Empty is not allowed");
        return true;
    }
    @Override
    public String toString() {
        String strOut = String.format("{0, -25} {1,-15} {2,-12} {3,-8} ", street, city, zipCode, getCountry());
        return strOut;
    }
}
