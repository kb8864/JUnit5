package sec3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest_mockito {

    @Mock
    TimeProvider mockTimeProvider;

    @InjectMocks
//    自動でもきーとがDIしてくれる
    GreetingService greetingService;
    @Test
    void 朝の挨拶を返す(){
    doReturn(LocalTime.of(9,9)).when(mockTimeProvider).getCurrentTime();
    assertEquals("おはようございます", greetingService.getGreeting());
    }

    @Test
    void 山田に対して昼を返す(){
    doReturn("昼").when(mockTimeProvider).getTimeLabelForName("山田");
    //検証
    assertEquals("昼", mockTimeProvider.getTimeLabelForName("山田"));
    //山田以外にはnullが帰ってくる
         assertEquals(null, mockTimeProvider.getTimeLabelForName("田中"));
    }

    @Test
    void 任意の値で昼を返す(){
        doReturn("昼").when(mockTimeProvider).getTimeLabelForName(anyString());
        //検証
        assertEquals("昼", mockTimeProvider.getTimeLabelForName("山田"));
        assertEquals("昼", mockTimeProvider.getTimeLabelForName("田中"));
    }

    @Test
    void 特定の名前を例外でスローする(){
        doThrow(new RuntimeException("通知失敗の例外エラー"))
                .when(mockTimeProvider).notifyUser(anyString());
        assertThrows(RuntimeException.class, ()-> mockTimeProvider.notifyUser("田中"));
    }

}