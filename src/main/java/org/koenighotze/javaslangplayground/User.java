package org.koenighotze.javaslangplayground;

/**
 * @author David Schmitz
 */
public class User {
    private Address address = new Address();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean validateAddress() {
        if (getAddress().getStreet().matches("^\\w+$")) {
            throw new IllegalStateException("Invalid street " + getAddress().getStreet());
        }

        return true;
    }
}