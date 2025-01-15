package tobyspring.hellospring.exrate;

import api.*;
import tobyspring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;

public class WebApiExRateProvider implements ExRateProvider {
//    매번 객체를 생성하는 것은 성능에 영향을 줌 -> 스프링 컨테이너에 싱글톤 빈으로 올리자.
    private final ApiTemplate apiTemplate;

    public WebApiExRateProvider(ApiTemplate apiTemplate) {
        this.apiTemplate = apiTemplate;
    }

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getForExRate(url); // callback
    }
}
