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


    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //일정생성
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule (
                scheduleRequestDto.getName(),
                scheduleRequestDto.getPassword(),
                scheduleRequestDto.getTodo(),
                scheduleRequestDto.getDate()
        );

        // DB에 일정 저장
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

    public List<ScheduleResponseDto> getAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
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
        schedule.setName(scheduleRequestDto.getName());
        schedule.setUpdated_at(LocalDateTime.now().toString());  // 수정일 업데이트

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
