package tobyspring.hellospring;

import api.ApiTemplate;
import api.ErApiExRateExtractor;
import api.SimpleApiExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobyspring.hellospring.exrate.CachedExRateProvider;
import tobyspring.hellospring.payment.ExRateProvider;
import tobyspring.hellospring.exrate.WebApiExRateProvider;
import tobyspring.hellospring.payment.PaymentService;

import java.time.Clock;

@Configuration
public class PaymentConfig {
    @Bean
    public PaymentService paymentService() { return new PaymentService(exRateProvider(), clock()); };

    @Bean
    public ExRateProvider cachedExRateProvider() { return new CachedExRateProvider(exRateProvider()); }

    @Bean
    public ApiTemplate apiTemplate() { return new ApiTemplate(new SimpleApiExecutor(), new ErApiExRateExtractor()); }

    @Bean
    public ExRateProvider exRateProvider() { return new WebApiExRateProvider(apiTemplate()); }

    @Bean
    public Clock clock() { return Clock.systemDefaultZone(); }
}
