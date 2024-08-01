package tobyspring.hellospring.learningtest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {
    // clock을 이용하여 LocalDateTime.now
    @Test
    void clock() {
        Clock clock = Clock.systemDefaultZone();

        // 이 시계를 이용하여 시간을 가져와봐
        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        Assertions.assertThat(dt2).isAfter(dt1);
    }
    // clock을 테스트에서 사용할 때 내가 원하는 시간을 지정해서 현재 시간을 가져오게 할 수 있는가?
    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime dt1 = LocalDateTime.now(clock);
        LocalDateTime dt2 = LocalDateTime.now(clock);

        // 시간을 언제 불러오든 똑같다.
        Assertions.assertThat(dt2).isEqualTo(dt1);

    }
}
