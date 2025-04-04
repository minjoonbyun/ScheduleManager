package schedule.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email); // 중복 체크
    Optional<User> findByEmail(String email); //유저 찾기
}

