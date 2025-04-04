package schedule;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.List;

//비즈니스 로직 처리(일정 등록, 수정, 삭제 시 규칙 적용)
//Repository에서 데이터를 가져오거나 저장하는 역할
//컨트롤러가 요청을 받으면 서비스가 처리

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;


    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    //일정생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        User user = userRepository.findById(scheduleRequestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        Schedule schedule = new Schedule (user, scheduleRequestDto.getTodo(), scheduleRequestDto.getDate());
        scheduleRepository.save(schedule);
        return new ScheduleResponseDto(schedule);
    }
    
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        if (schedule == null) {
            throw new IllegalArgumentException("일정을 찾을 수 없습니다.");
        }
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> getAllSchedules(String name, String updatedAt) {
        List<Schedule> schedules = scheduleRepository.findAll();

        // '작성자명(name)'으로 필터링
        if (userId != null) {
            schedules = schedules.stream().filter(schedule -> schedule.getName().equals(userId)).collect(Collectors.toList());
        }

        // '수정일(updatedAt)'으로 필터링
        if (updatedAt != null && !updatedAt.isEmpty()) {
            schedules = schedules.stream().filter(schedule -> schedule.getUpdatedAt() != null && schedule.getUpdatedAt().toString().startsWith(updatedAt)).collect(Collectors.toList());
        }

        return schedules.stream().map(ScheduleResponseDto::new).collect(Collectors.toList());
    }

    //일정 조회
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return new ScheduleResponseDto(schedule);
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto, String password) {
        Schedule schedule = scheduleRepository.findById(id);
        if (schedule == null) {
            throw new IllegalArgumentException("일정을 찾을 수 없습니다.");
        }
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 할일, 작성자명만 수정 가능
        schedule.setTodo(scheduleRequestDto.getTodo());
        schedule.setUpdatedAt(LocalDateTime.now());  // 수정일 업데이트

        // DB에 수정된 일정 저장
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule);
    }

    // 일정 삭제
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id);
        if (schedule == null) {
            throw new IllegalArgumentException("일정을 찾을 수 없습니다.");
        }
        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // DB에서 일정 삭제
        scheduleRepository.delete(schedule);
    }
}
