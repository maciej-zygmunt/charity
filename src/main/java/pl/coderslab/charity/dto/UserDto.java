package pl.coderslab.charity.dto;

import lombok.experimental.Delegate;
import pl.coderslab.charity.model.IUser;
import pl.coderslab.charity.model.User;

import javax.validation.constraints.AssertTrue;

public class UserDto {

    private final @Delegate
    IUser user;

    private String password2;

    public UserDto() {
        this.user = new User();
    }


    public User getUser() {
        return (User) this.user;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @AssertTrue(message = "Passwords should be same")
    public boolean isPasswordSame() {
        return getPassword().equals(password2);
    }
}
