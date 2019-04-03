package com.project.airport.model;

public class Flight {
    String id;
    String city;
    String time;
    String date;
    String numberOfSeats;

    public Flight() {
    }

    public Flight(String id, String city, String time, String date, String numberOfSeats) {
        this.id = id;
        this.city = city;
        this.time = time;
        this.date = date;
        this.numberOfSeats = numberOfSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}

