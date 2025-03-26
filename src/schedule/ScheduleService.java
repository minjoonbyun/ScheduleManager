package schedule;

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
    }

    //일정 조회
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id);
        return new ScheduleResponseDto(schedule);
}
