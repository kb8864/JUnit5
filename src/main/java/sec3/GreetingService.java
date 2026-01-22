package sec3;

import java.time.LocalTime;

// 挨拶を返すサービス。時間に依存しているが、TimeProviderを通じて注入可能
public class GreetingService {

    private final TimeProvider timeProvider;

    public GreetingService(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String getGreeting() {
        LocalTime now = timeProvider.getCurrentTime();
        int hour = now.getHour();

        if (hour < 12) {
            return "おはようございます";
        } else if (hour < 18) {
            return "こんにちは";
        } else {
            return "こんばんは";
        }
    }
}
