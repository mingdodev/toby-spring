package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class ObjectFactory {
    // 이게 어떻게 가능해?
    // 의존 관계를 어떻게 알아서 찾는 거야?
    // 스프링이 필요한 것은 빈에 관련된 정보
    // 컴포넌트를 지정하고 그 컴포넌트들을 설정해서 정보를 찾아봐

    // Error creating bean with name 'paymentService' defined in file
    // 아!~! 맞다맞다
    // 컴포넌트 애노테이션을 여러 개에 붙이면 에러가 난다.
    // getBean(PaymentService.class)에서 해당 타입의 빈을 여러 개 찾으면
    // 의존관계 설정에 혼란을 겪겠지
    // 전에 그랬었다 이해 완료 ~!~!!!~!~!~!

    // 컴포넌트 스캔을 많이 사용하지만, 빈 팩토리에 직접 구성 정보를 전달하는 경우도 있다.
}
