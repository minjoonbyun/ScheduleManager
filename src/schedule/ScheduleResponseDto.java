package schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto
{
    private Long id;
    private String name;
    private String todo;
    private String date;
    private String updated_at;

    public ScheduleResponseDto(Schedule schedule)
    {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.date = schedule.getDate();
    }

    public ScheduleResponseDto(Long id,String name,String todo,String date)
    {
        this.id = id;
        this.name = name;
        this.todo = todo;
        this.updated_at = date;
    }
}
