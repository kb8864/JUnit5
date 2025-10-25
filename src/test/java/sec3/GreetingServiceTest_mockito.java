package sec3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

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
}