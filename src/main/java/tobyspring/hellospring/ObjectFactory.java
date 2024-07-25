package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    // 클래스의 오브젝트를 만듦 = 하나의 빈을 만듦

    // 이렇게 분리하면 메소드 이름이 분명하다. 변경이 필요할 때 찾아가기 편해짐.
    public ExRateProvider exRateProvider() {
        return new SimpleExRateProvider();
    }
}
