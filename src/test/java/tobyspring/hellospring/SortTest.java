package tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        // 모든 테스트는 다른 테스트와 독립적으로 실행이 되어야 한다.
        // 테스트마다 새로운 인스턴스가 만들어진다.
        System.out.println(sort);
    }

    @Test
    void sort(){
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        Assertions.assertThat(list).isEqualTo(List.of("b","aa"));
    }

    @Test
    void sort3Items(){
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }

    @Test
    void sortAlreadySorted(){
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));

        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }
}