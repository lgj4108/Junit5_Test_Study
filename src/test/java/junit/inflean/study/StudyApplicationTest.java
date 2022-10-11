package junit.inflean.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyApplicationTest {

    @Test
    void test() {
        System.out.println("test");
    }

    @Test
    @DisplayName("테스트")
    void underscore_test() {
        System.out.println("underscore");
    }


}