package junit.inflean.study.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("파라메터 테스트")
public class ParameterTest {
    @DisplayName("반복 - 파라메터 values")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d"})
    void parameterized_test_with_parameter_values(String alphabet) {
        System.out.println("test - alphabet : " + alphabet);
    }

    @DisplayName("반복 - 파라메터 values and Display명 노출")
    @ParameterizedTest(name = "{displayName} - {index} | {argumentsWithNames}")
    @ValueSource(strings = {"a", "b", "c", "d"})
    void parameterized_test_with_parameter_values_and_show_name(String alphabet) {
        System.out.println("test - alphabet : " + alphabet);
    }

    @DisplayName("ValueSource 객체로 받기")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void parameterized_test_with_object_add_integer(@ConvertWith(StudyLimitConverter.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyLimitConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            Study study = new Study();
            study.setLimit(Integer.parseInt(o.toString()));

            return study;
        }
    }

    @DisplayName("ValueSource 객체로 받기")
    @ParameterizedTest
    @ValueSource(strings = {"이름1", "이름2", "이름3"})
    void parameterized_test_with_object_add_string(@ConvertWith(StudyNameConverter.class) Study study) {
        System.out.println(study.getName());
    }

    static class StudyNameConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            Study study = new Study();
            study.setName(o.toString());

            return study;
        }
    }

    @DisplayName("CsvSource value 받기")
    @ParameterizedTest
    @CsvSource({"1, '이름1'", "2, 이름2", "3, 이름3", "4, "})
//    @CsvSource({"1, '이름1'", "2, 이름2", "3, 이름3", "4, ''"})
    void parameterized_test_csv_source(Integer limit, String name) {
        System.out.println("limit : " + limit + ", name: " + name);
    }

    @DisplayName("CsvSource value 받기")
    @ParameterizedTest
    @CsvSource({"1, '이름1'", "2, 이름2", "3, 이름3"})
    void parameterized_test_csv_source_with_arguments_accessor(ArgumentsAccessor accessor) {
        System.out.println("limit : " + accessor.getInteger(0) + ", name: " + accessor.getString(1));
    }

    @DisplayName("CsvSource value 받기")
    @ParameterizedTest
    @CsvSource({"1, '이름1'", "2, 이름2", "3, 이름3"})
    void parameterized_test_csv_source_with_aggregator(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println("limit : " + study.getLimit() + ", name: " + study.getName());
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}
