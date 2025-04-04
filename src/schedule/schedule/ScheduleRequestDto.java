package schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

//데이터를 주고받을 때 필요한 정보단 담아서 전달하는 객체
@Getter
@NoArgsConstructor
public class ScheduleRequestDto {
    @NotBlank(message = "제목은 필수입니다")
    private Long userId; // name을 UserId로 바꿨음
    private String todo;
    private String date;
}
