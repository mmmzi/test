package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode//用于去重使用
public class Book {

    private Long id;

    private String name;

    private String category;

    private Integer score;

    private String intro;
}
