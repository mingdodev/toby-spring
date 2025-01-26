package tobyspring.hellospring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobyspring.hellospring.OrderConfig;
import tobyspring.hellospring.TestPaymentConfig;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = OrderConfig.class)
public class OrderServiceSpringTest {
    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        var order = orderService.create("0100", BigDecimal.ONE);

        Assertions.assertThat(order.getId()).isGreaterThan(0);
    }

    @Test
    void getOrder() {
        var order = orderService.create("0200", BigDecimal.ONE);

        Assertions.assertThat(order.getNo()).isEqualTo("0200");
    }
}
