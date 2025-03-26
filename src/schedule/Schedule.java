package schedule;

@NoArgsConstructor
@Data
public class Schedule {
    private String name;
    private String password;
    private String todo;
    private String date;

    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.name = scheduleRequestDto.getName();
        this.password = scheduleRequestDto.getPassword();
        this.todo = scheduleRequestDto.getTodo();
        this.date = scheduleRequestDto.getDate();
    }
}

