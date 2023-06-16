import java.util.Date;

public class User {
    private String SecondName;
    private String FirstName;
    private String LastName;
    private Date birthDate;
    private Long phoneNumber;
    private char gender;

    public User(String SecondName, String FirstName, String LastName, Date birthDate, Long phoneNumber, char gender) {
        this.SecondName = SecondName;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return
                SecondName + ' ' +
                FirstName + ' ' +
                LastName + ' ' +
                birthDate + ' '+
                phoneNumber +' '+
                gender +";"+ "\n";
    }
}



