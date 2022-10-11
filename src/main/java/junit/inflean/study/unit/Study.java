package junit.inflean.study.unit;

import lombok.Data;

@Data
public class Study {
    public Study() {
    }

    public Study(Integer limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    private Integer limit;
    private String name;

}
