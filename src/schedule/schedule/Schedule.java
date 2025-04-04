package schedule;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity// 테이블이랑 매핑
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long id;

    private String name;
    private String password;
    private String todo;

    @CreatedDate// JPA가 자동관리하도록 수정
    @Column(updatable=false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Schedule(String name, String password, String todo) // 수정시 사용
    {
        this.name = name;
        this.password = password;
        this.todo = todo;
    }

    public void update(String todo){
        this.todo = todo;
    }
}

