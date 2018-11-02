package guru.springframework.sfgpetclinic.model;

public class Person {

    private String firstName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

}
