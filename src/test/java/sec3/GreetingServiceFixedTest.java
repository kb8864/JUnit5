package sec3;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceFixedTest {

    @Test
    void 朝の挨拶を返す() {
        TimeProvider morning = new FixedTimeProvider(LocalTime.of(9, 0));
        GreetingService service = new GreetingService(morning);
        assertEquals("おはようございます", service.getGreeting());
    }

    @Test
    void 昼の挨拶を返す() {
        TimeProvider noon = new FixedTimeProvider(LocalTime.of(14, 0));
        GreetingService service = new GreetingService(noon);
        assertEquals("こんにちは", service.getGreeting());
    }

    @Test
    void 夜の挨拶を返す() {
        TimeProvider night = new FixedTimeProvider(LocalTime.of(20, 0));
        GreetingService service = new GreetingService(night);
        assertEquals("こんばんは", service.getGreeting());
    }
}
