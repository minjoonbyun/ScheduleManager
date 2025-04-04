@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원가입
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        // 중복
        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 유저 저장
        User user = new User(
                userRequestDto.getUsername(),
                userRequestDto.getEmail(),
                userRequestDto.getPassword() //
        );

        userRepository.save(user);
        return new UserResponseDto(user);
    }
}
