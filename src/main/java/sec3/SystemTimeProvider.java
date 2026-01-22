package sec3;

import java.time.LocalTime;

// 実行時の現在時刻を提供する実装
public class SystemTimeProvider implements TimeProvider {
    @Override
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    @Override
    public String getTimeLabelForName(String name) {
        return "";
    }

    @Override
    public void notifyUser(String name) {

    }
}
