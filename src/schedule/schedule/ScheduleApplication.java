package schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing
public class ScheduleApplication {

    public static void main(String[] args) {
        // Spring Boot 애플리케이션을 실행
        SpringApplication.run(ScheduleApplication.class, args);
    }
}
