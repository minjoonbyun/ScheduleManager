package schedule;
import java.util.List;

import org.springframework.web.bind.annotation.*;

//사용자가 요청한 데이터를 받아서 Service에 전달
//Service에서 처리된 데이터를 사용자에게 반환

@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {

    private  final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //일정 생성(POST)
    @PostMapping
    public ScheduleResponseDto createSchedule (@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto);
        return scheduleResponseDto;
    }


    // 선택 일정 조회(GET)
    @GetMapping("/{id}")
    public ScheduleResponseDto getSchedule(Long id) {
        return scheduleService.getSchedule(id);
    }

    // 전체 일정 조회(GET)
    @GetMapping
    public List<ScheduleResponseDto> getAllSchedules(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String updatedAt) {
        return scheduleService.getAllSchedules(name, updatedAt);
    }
}
