package com.example.books.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PublisherHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name,  name_director;
    private  Double share_price;
    private int opening_year;
    private boolean open_now;
    private int views;
    public PublisherHouse(String name, Integer opening_year, String name_director, Boolean open_now, Double share_price) {
        this.name = name;
        this.opening_year = opening_year;
        this.name_director = name_director;
        this.open_now = open_now;
        this.share_price = share_price;
    }

    public PublisherHouse() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_director() {
        return name_director;
    }

    public void setName_director(String name_director) {
        this.name_director = name_director;
    }

    public Double getShare_price() {
        return share_price;
    }

    public void setShare_price(Double share_price) {
        this.share_price = share_price;
    }

    public int getOpening_year() {
        return opening_year;
    }

    public void setOpening_year(int opening_year) {
        this.opening_year = opening_year;
    }

    public boolean isOpen_now() {
        return open_now;
    }

    public void setOpen_now(boolean open_now) {
        this.open_now = open_now;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
