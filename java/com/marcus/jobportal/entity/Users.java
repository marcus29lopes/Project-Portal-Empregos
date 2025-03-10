
package com.marcus.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
        name = "users"
)
public class Users {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int userId;
    @Column(
            unique = true
    )
    private String email;
    private @NotEmpty String password;
    private boolean isActive;
    @DateTimeFormat(
            pattern = "dd-MM-yyyy"
    )
    private Date registrationDate;
    @ManyToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "userTypeId",
            referencedColumnName = "userTypeId"
    )
    private UsersType userTypeId;

    public Users() {
    }

    public Users(int userId, String email, String password, Date registrationDate, boolean isActive, UsersType usersTypeId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
        this.userTypeId = usersTypeId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersType getUserTypeId() {
        return this.userTypeId;
    }

    public void setUserTypeId(UsersType userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String toString() {
        int var10000 = this.userId;
        return "Users{userId=" + var10000 + ", email='" + this.email + "', password='" + this.password + "', isActive=" + this.isActive + ", registrationDate=" + String.valueOf(this.registrationDate) + ", usersTypeId=" + String.valueOf(this.userTypeId) + "}";
    }
}