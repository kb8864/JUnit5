package exercises.sec3;

public interface UserRepository {
    User findById(String userId);
}