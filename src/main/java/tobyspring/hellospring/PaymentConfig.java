package tobyspring.hellospring;

import api.ApiTemplate;
import api.ErApiExRateExtractor;
import api.SimpleApiExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tobyspring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.exrate.RestTemplateExRateProvider;
import tobyspring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() { return new PaymentService(exRateProvider(), clock()); };

    @Bean
    public RestTemplate restTemplate() { return new RestTemplate(); }

    @Bean
    public ExRateProvider exRateProvider() { return new RestTemplateExRateProvider(restTemplate()); }

    @Bean
    public Clock clock() { return Clock.systemDefaultZone(); }
}
