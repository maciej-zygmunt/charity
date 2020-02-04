package pl.coderslab.charity.model;

public interface IUser {
    String getEmail();

    String getPassword();

    java.util.Set<Role> getRoles();

    void setEmail(String email);

    void setPassword(String password);

    void setRoles(java.util.Set<Role> roles);
}
