package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;
import org.hibernate.validator.constraints.Length;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Transient
    private String salt=BCrypt.gensalt();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
//    @Size(min = 3,max=4)
    private String password;
    @Transient
    private String password2;
    @AssertTrue(message = "Passwords should be same")
    public boolean isPasswordSame() {
        return password.equals(password2);
    }
    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, salt);
    }
    public void setPassword2(String password) {
        this.password2 = BCrypt.hashpw(password, salt);
    }

    public boolean isPasswordCorrect(String password) {
        return BCrypt.checkpw(password, getPassword());
    }
}
