package dev.ikhtiyor.springboottesting.payload;

import java.util.Date;

/**
 * @author IkhtiyorDev  <br/>
 * Date 11/04/22
 **/

public class StudentDTO {

    private Integer id;
    private String firstName;
    private String lsatName;
    private String username;
    private Date age;
    private String school;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLsatName() {
        return lsatName;
    }

    public void setLsatName(String lsatName) {
        this.lsatName = lsatName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String firstName, String lsatName, String username, Date age, String school, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lsatName = lsatName;
        this.username = username;
        this.age = age;
        this.school = school;
        this.address = address;
    }
}
