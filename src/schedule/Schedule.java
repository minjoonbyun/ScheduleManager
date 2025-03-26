package schedule;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Schedule {
    private Long id;
    private String name;
    private String password;
    private String todo;
    private String date;
    private String updated_at;

    public Schedule(ScheduleRequestDto scheduleRequestDto) // 등록 시 사용
    {
        this.name = scheduleRequestDto.getName();
        this.password = scheduleRequestDto.getPassword();
        this.todo = scheduleRequestDto.getTodo();
        this.date = scheduleRequestDto.getDate();
    }

    public Schedule(String name, String password, String todo, String date) // 수정시 사용
    {
        this.name = name;
        this.password = password;
        this.todo = todo;
        this.updated_at = date;
    }
}

