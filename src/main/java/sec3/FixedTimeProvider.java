package sec3;

import java.time.LocalTime;

// テスト用の固定時間を返すモック
public class FixedTimeProvider implements TimeProvider {

    private final LocalTime fixedTime;

    public FixedTimeProvider(LocalTime fixedTime) {
        this.fixedTime = fixedTime;
    }

    @Override
    public LocalTime getCurrentTime() {
        return fixedTime;
    }

    @Override
    public String getTimeLabelForName(String name) {
        return "";
    }

    @Override
    public void notifyUser(String name) {

    }
}
