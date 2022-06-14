package fr.m2i.crm.model;

import fr.m2i.crm.state.CustomerState;
import fr.m2i.crm.state.OrderState;
import javafx.beans.DefaultProperty;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation", length = 100)
    private String designation;

    @Column(name = "nb_days")
    private Integer nbDays;

    @Column(name = "total_exclude_taxe", precision = 9, scale = 2)
    private Double totalExcludeTaxe;

    @Column(name = "total_with_taxe", precision = 9, scale = 2)
    private Double totalWithTaxe;

    @Column(name = "type_presta", length = 100)
    private String typePresta;

    @Column(name = "unit_price", precision = 9, scale = 2)
    private Double unitPrice;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    public OrderState orderState;

    @JoinColumn(name = "customer_id", nullable = false)
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
