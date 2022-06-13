package fr.m2i.crm.model;

import fr.m2i.crm.state.OrderState;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_presta", length = 100)
    private String typePresta;

    @Column(name = "designation", length = 100)
    private String designation;

    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne(targetEntity = Customer.class, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Customer customer;

    @Column(name = "nb_days")
    private int nbDays;

    @Column(name = "unit_price", scale = 2, precision = 9)
    private double unitPrice;

    @Column(name = "total_exclude_taxe", scale = 2, precision = 9)
    private double totalExcludeTaxe;

    @Column(name = "total_with_taxe", scale = 2, precision = 9)
    private double totalWithTaxe;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    private OrderState state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
