package schedule;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청한 데이터를 받아서 Service에 전달
//Service에서 처리된 데이터를 사용자에게 반환

@RestController
public class ScheduleController {

    private  final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일정 생성(POST)
    public ScheduleResponseDto createSchedule (ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto);
        return scheduleResponseDto;
    }


    // 선택 일정 조회(GET)
    public ScheduleResponseDto getSchedule(Long id) {
        return scheduleService.getSchedule(id);
    }

    // 전체 일정 조회(GET)
    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
}
