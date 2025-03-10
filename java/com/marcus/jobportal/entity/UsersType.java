
package com.marcus.jobportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(
        name = "users_type"
)
public class UsersType {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int userTypeId;
    private String userTypeName;
    @OneToMany(
            mappedBy = "userTypeId",
            cascade = {CascadeType.ALL}
    )
    private List<Users> users;

    public UsersType() {
    }

    public UsersType(int usersTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = usersTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUserTypeId() {
        return this.userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return this.userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return this.users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public String toString() {
        return "UsersType{userTypeName='" + this.userTypeName + "', usersTypeId=" + this.userTypeId + "}";
    }
}
