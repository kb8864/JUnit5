package sec3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceSystemTest {

    @Test
    void 朝の挨拶を返す() {
        TimeProvider morning = new SystemTimeProvider();
        GreetingService service = new GreetingService(morning);
        assertEquals("おはようございます", service.getGreeting());
    }

    @Test
    void 昼の挨拶を返す() {
        TimeProvider noon = new SystemTimeProvider();
        GreetingService service = new GreetingService(noon);
        assertEquals("こんにちは", service.getGreeting());
    }

    @Test
    void 夜の挨拶を返す() {
        TimeProvider night = new SystemTimeProvider();
        GreetingService service = new GreetingService(night);
        assertEquals("こんばんは", service.getGreeting());
    }
}
