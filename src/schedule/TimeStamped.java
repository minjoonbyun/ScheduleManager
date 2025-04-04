import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public abstract class TimeStamped {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType,TIMESTAMP)
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType,TIMESTAMP)
    LocalDateTime updatedAt;
}
