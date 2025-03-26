package schedule;
import lombok.Getter;

//데이터를 주고받을 때 필요한 정보단 담아서 전달하는 객체
@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String todo;
    private String date;
}
