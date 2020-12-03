package beerbellybar.data.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    private Integer numPeople;
    private String reservationTime;
    @ManyToOne
    @JsonIgnore
    private Customer customer;
    @ManyToOne
    @JsonIgnore
    private BarTable barTable;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Integer getNumPeople() {return numPeople;}

    public void setNumPeople(Integer numPeople) {this.numPeople = numPeople;}

    public String getReservationTime() {return reservationTime;}

    public void setReservationTime(String reservationTime) {this.reservationTime = reservationTime;}

    public Customer getCustomer() {return customer;}

    public void setCustomer(Customer customer) {this.customer = customer;}

    public BarTable getBarTable() {return barTable;}

    public void setBarTable(BarTable barTable) {this.barTable = barTable;}
}
