package junit.inflean.study.unit;

import junit.inflean.study.annotation.FastTest;
import junit.inflean.study.annotation.SlowTest;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Composed Annotation Test")
public class ComposedAnnotationTest {

    @FastTest
    void use_composed_annotation_with_fast_tag() {
        System.out.println("use composed annotation fast");
    }

    @SlowTest
    void use_composed_annotation_with_slow_tag() {
        System.out.println("use composed annotation slow");
    }
}
