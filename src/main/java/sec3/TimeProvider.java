package sec3;

import java.time.LocalTime;

// 現在の時刻を提供するためのインターフェース
public interface TimeProvider {
    LocalTime getCurrentTime();

    // 任意の名前の文字列を渡すと、その時間帯のラベル（朝／昼／夜）を返す
    String getTimeLabelForName(String name);

    // 任意の名前に対して通知を送る（戻り値なし・副作用想定）
    void notifyUser(String name);
}
