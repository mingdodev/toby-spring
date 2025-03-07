package tobyspring.hellospring.payment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.TestPaymentConfig;

import java.math.BigDecimal;
import java.time.Clock;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

    @Autowired PaymentService paymentService;
    @Autowired Clock clock;
    @Autowired ExRateProviderStub exRateProviderStub;

    @Test
    void convertedAmount() {
        // exRate: 1000
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));

//        // exRate: 500
//        exRateProviderStub.setExRate(valueOf(500));
//        Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);
//
//        assertThat(payment2.getExRate()).isEqualByComparingTo(valueOf(500));
//        assertThat(payment2.getConvertedAmount()).isEqualByComparingTo(valueOf(5_000));
    }

    // 스프링에서 자동으로 clock을 주입받으면 고정된 시각이 아니므로 테스트 실행 시점의 시간 기준이 되어 실패함
//    @Test
//    void validUntil() {
//        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
//
//        // valid until이 prepare() 30분 뒤로 설정이 됐는가
//        LocalDateTime now = LocalDateTime.now(this.clock);
//        LocalDateTime expectedValidUntil = now.plusMinutes(30);
//
//       Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
//    }
}