package com.project.airport.model;

public class Booking {
    private String id;
    private String passengerId;
    private String bookingId;

    public Booking() {
    }

    public Booking(String id, String passengerId, String bookingId) {
        this.id = id;
        this.passengerId = passengerId;
        this.bookingId = bookingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingDAO{" +
                "id='" + id + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                '}';
    }
}
