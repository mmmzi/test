package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode//用于去重使用
public class Author {

    private Long id;

    private String name;

    private Integer age;

    private String intro;

    private List<Book> books;
}
