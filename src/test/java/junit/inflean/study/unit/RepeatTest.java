package junit.inflean.study.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("반복 테스트")
public class RepeatTest {

    @DisplayName("반복 - 인자X")
    @RepeatedTest(10)
    void repeated_test() {
        System.out.println("반복");
    }

    @DisplayName("반복 - RepetitionInfo 인자 추가")
    @RepeatedTest(10)
    void repeated_test_add_repetition(RepetitionInfo info) {
        System.out.println("RepetitionInfo 파라메터 반복" + info);
    }

    @DisplayName("반복 - display명 노출")
    @RepeatedTest(value = 10, name = "{displayName}, " + RepeatedTest.CURRENT_REPETITION_PLACEHOLDER + " - " + RepeatedTest.TOTAL_REPETITIONS_PLACEHOLDER)
    void repeated_test_add_display_name() {
        System.out.println("RepetitionInfo 파라메터 반복");
    }
}
