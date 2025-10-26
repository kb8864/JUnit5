package exercises.sec3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock //Mockito が @Mock を使って偽物の UserRepository を作成
    UserRepository mockUserRepository;

    @InjectMocks //@InjectMocks が UserService の中にその偽物を自動で入れてくれる
    UserService userService;

    @Test
    void ユーザーが存在する場合名前を返す(){
        doReturn(new User("u123", "佐藤"))
                .when(mockUserRepository).findById("u123");

        String name = userService.getUserName("u123");
        assertEquals("佐藤", name);

    }

    @Test
    void  ユーザーが存在しない場合nullを返す(){
        doReturn(null).when(mockUserRepository).findById("unknown");
        String name = userService.getUserName("unknown");

        assertNull(name);
    }

}