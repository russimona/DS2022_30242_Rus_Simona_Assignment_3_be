package ro.tuc.ds2020.dtos;


import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class UserDetailsDTO {

    private UUID id;
    @NotNull
    private String name;

    @NotNull
    private String surname;
    private String role_user;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(String name, String surname, String role_user, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.role_user = role_user;
        this.email = email;
        this.password = password;
    }

    public UserDetailsDTO(UUID id, String name, String surname, String role_user, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role_user = role_user;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsDTO that = (UserDetailsDTO) o;
        return email == that.email &&
                Objects.equals(name, that.name) &&
                Objects.equals(role_user, that.role_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role_user, email);
    }

}
