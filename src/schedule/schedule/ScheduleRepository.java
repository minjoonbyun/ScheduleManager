package schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

//데이버베이스와 직접 연결하여 데이터를 CRUD(생성,조회,수정,삭제)
//따로 분리해서 관리(데이터베이스와 직접 소통)

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
    private static final Map<Long, Schedule> scheduleList = new HashMap<>();
    private static long sequence = 0L;

    // schedule 저장
    public void save(Schedule schedule) {
        schedule.setId(++sequence);
        scheduleList.put(schedule.getId(), schedule);
    }

    // schedule ID로 찾기
    public Schedule findById(Long id) {
        return scheduleList.get(id); // 해당 id의 일정이 있으면 반환, 없으면 null
    }

    public List<Schedule> findAll(){
        return new ArrayList<>(scheduleList.values());
    }

    // 일정 삭제
    public void delete(Schedule schedule) {
        scheduleList.remove(schedule.getId());
    }
}
