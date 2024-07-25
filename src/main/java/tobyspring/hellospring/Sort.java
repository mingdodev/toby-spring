package tobyspring.hellospring;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        // 전략 패턴이 적용되어진 메서드
        List<String> scores = Arrays.asList("a","z","java","spring");
        // 전략 오브젝트에 따라 자신의 알고리즘에 적용해 사용함
        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length());

        scores.forEach(System.out::println);
    }
}
