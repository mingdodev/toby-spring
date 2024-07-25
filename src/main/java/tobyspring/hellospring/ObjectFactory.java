package tobyspring.hellospring;

public class ObjectFactory {
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    // 이렇게 분리하면 메소드 이름이 분명하다. 변경이 필요할 때 찾아가기 편해짐.
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
