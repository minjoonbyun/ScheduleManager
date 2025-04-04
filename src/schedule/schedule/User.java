package schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.setPassword(password); // 암호화 저장
    }

    public void update(String email, String password) {
        this.email = email;
        this.setPassword(password);
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
