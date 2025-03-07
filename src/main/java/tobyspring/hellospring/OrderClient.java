package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tobyspring.hellospring.order.Order;
import tobyspring.hellospring.order.OrderService;
import tobyspring.hellospring.order.OrderServiceImpl;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderService orderServiceImpl =  beanFactory.getBean(OrderServiceImpl.class);

        Order order = orderServiceImpl.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);
    }
}
