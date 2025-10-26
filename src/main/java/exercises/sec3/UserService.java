package exercises.sec3;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(String userId) {
        User user = userRepository.findById(userId);
        return user != null ? user.getName() : null;
    }
}
