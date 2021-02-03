package com.company;

public class Store {

    private String name, city;

    public Store(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " (" + city +")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Store) {
            Store other = (Store) obj;
            return this.name.equalsIgnoreCase(other.name) &&
                    this.city.equalsIgnoreCase(other.city);
        } else {
            return false;
        }
    }

}
