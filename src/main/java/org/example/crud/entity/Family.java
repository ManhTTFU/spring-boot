package org.example.crud.entity;

public class Family {

    private String lastName;
    private String firstName;

    public Family() {
    }

    public Family(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Family{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
