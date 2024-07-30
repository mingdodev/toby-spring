package tobyspring.hellospring;

import org.springframework.context.annotation.Bean;
import tobyspring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.payment.ExRateProviderStub;
import tobyspring.hellospring.payment.PaymentService;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class TestObjectFactory {
    @Bean
    public PaymentService paymentService() { return new PaymentService(exRateProvider()); }

    @Bean
    public ExRateProvider exRateProvider() { return new ExRateProviderStub(valueOf(1_000)); }

}
