package fr.m2i.crm.model;

import fr.m2i.crm.state.CustomerState;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "first_name", length = 100)
    private String firstname;

    @Column(name = "last_name", length = 100)
    private String lastname;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "zip_code", length = 12)
    private String zipCode;

    @Column(name = "state", columnDefinition = "INT(1) DEFAULT 0 NOT NULL")
    @Enumerated(EnumType.ORDINAL)
    public CustomerState customerState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public CustomerState getCustomerState() {
        return customerState;
    }

    public void setCustomerState(CustomerState customerState) {
        this.customerState = customerState;
    }

    public void setNotNullData(Customer newCustomer) {
        if (newCustomer.getAddress() != null) {
            this.setAddress(newCustomer.getAddress());
        }

        if (newCustomer.getCompanyName() != null) {
            this.setCompanyName(newCustomer.getCompanyName());
        }

        if (newCustomer.getCity() != null) {
            this.setCity(newCustomer.getCity());
        }

        if (newCustomer.getZipCode() != null) {
            this.setZipCode(newCustomer.getZipCode());
        }

        // l'avoir pour tous les champs qu'on veut modifier

    }
}
