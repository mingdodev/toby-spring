package tobyspring.hellospring.exrate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(String result, Map<String, BigDecimal> rates) {
    // 데이터 전달을 위한 데이터 타입
    // DTO에서 생성자를 만들고 getter 만들었던 것처럼
    // 저렇게 생성자를 만든다 특이하죠?
    // 한번 값을 저장하면 수정 불가, 그를 계속 이용
    // @JsonIgnoreProperties(ignoreUnknown = true) 매핑하지 않는 변수는 무시해준다!
}
