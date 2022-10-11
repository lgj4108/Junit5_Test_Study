package junit.inflean.study.unit;


import org.junit.jupiter.api.*;

@DisplayName("테스트 케이스별 인스턴스 생성")
public class InstanceTest {

    @DisplayName("테스트 케이스별 인스턴스 생성")
    static class CreateOtherInstanceTest {

        int value = 1;

        @BeforeAll
        static void beforeAll() {
            System.out.println("before All Start");
        }

        @AfterAll
        static void afterAll() {
            System.out.println("after all Start");
        }

        @Test
        void instanceTest1() {
            System.out.println(value++);
            System.out.println(this);
        }

        @Test
        void instanceTest2() {
            System.out.println(value++);
            System.out.println(this);
        }


    }

    @DisplayName("하나의 클래스의 인스턴스 생성")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static class CreateOneInstanceTest {

        int value = 1;

        @BeforeAll
        void beforeAll() {
            System.out.println("before All Start" + this);
        }

        @AfterAll
        void afterAll() {
            System.out.println("after all Start" + this);
        }

        @Test
        void instanceTest1() {
            System.out.println(value++);
            System.out.println(this);
        }

        @Test
        void instanceTest2() {
            System.out.println(value++);
            System.out.println(this);
        }

    }
}
