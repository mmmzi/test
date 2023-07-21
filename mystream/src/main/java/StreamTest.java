import dto.Author;
import dto.Book;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
        test21();
    }

    private static void test21() {
        /**
         * 使用reduce来求所有作家的年龄最小值
         */
        List<Author> authors = getAuthors();
        Integer mmin = authors.stream()
                .map(author->author.getAge())
                .reduce(Integer.MAX_VALUE,(i1,i2)->i1>i2?i2:i1);
        System.out.println(mmin);
    }

    private static void test20() {
        /**
         * 使用reduce求所有作家的年龄最大值
         */
        List<Author> authors = getAuthors();
        Integer mmax = authors.stream()
                .map(author->author.getAge())
                .reduce(Integer.MIN_VALUE,(i1,i2)->i1<i2?i2:i1);
        System.out.println(mmax);
    }

    private static void test19() {
        /**
         * 使用reduce求所有作者年龄的和
         */
        List<Author> authors = getAuthors();
        Integer sum = authors.stream()
                .map(author->author.getAge())
                .reduce(0,(i1,i2)->i1+i2);
        System.out.println(sum);
    }

    private static void test18() {
        /**
         * 获取一个年龄最小的作家并输出其信息
         */
        List<Author> authors = getAuthors();
        Optional<Author> oa = authors.stream()
                .sorted((o1, o2) -> o1.getAge()- o2.getAge())
                .findFirst();
        System.out.println(oa);
    }

    private static void test17() {
        /**
         * 获取任意一个年龄大于18的作家，并打印输出其信息
         */
        List<Author> authors = getAuthors();
        Optional<Author> oa= authors.stream()
                .filter(author -> author.getAge()>18)
                .findAny();
        System.out.println(oa);
    }

    private static void test16() {
        /**
         * 判断是否所有作家都没有超过50岁
         */
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .noneMatch(author -> author.getAge()>50);
        System.out.println(flag);
    }

    private static void test15() {
        /**
         * 判断是否所有作家都是成年人
         */
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(flag);
    }

    private static void test14() {
        /**
         * 判断是否有年龄在29岁以上的作家
         */
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(flag);
    }

    private static void test13() {
        /**
         * 获取一个存放所有作者名字的List集合
         */
        List<Author> authors = getAuthors();
        List<String> list = authors.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
//                .collect(Collectors.toSet());
//                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(list);
    }

    private static void test12() {
        /**
         * 分别获取作家所出书籍的最高分和最低分并打印
         */
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((o1, o2) -> o1 - o2);
        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min(((o1, o2) -> o1 - o2));
        System.out.println(max.get());
        System.out.println(min.get());
    }

    private static void test11() {
        /**
         * 打印所有作家总共的书籍数目，包括书籍的去重
         */
        List<Author> authors = getAuthors();

        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println("书籍的数量是： " + count);
    }

    private static void test10() {
        /**
         * 打印所有书籍的分类并去重
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split("，")))
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void test09() {
        /**
         * 打印所有书籍的名字，并去重
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .distinct()
                .forEach(s -> System.out.println(s));
    }

    private static void test08() {
        /**
         * 打印除了年龄最大的作家外的其他作家，不能有重复元素，并且按照年龄降序排序
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getAge() + " " + author.getName()));
    }

    private static void test07() {
        /**
         * 根据作家年龄降序排序，打印前两个作家姓名
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName() + " " + author.getAge()));
    }

    private static void test06() {
        /**
         * 对流中元素按照年龄进行降序排序，并且要求不能有重复元素
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test05() {
        /**
         * 输出所有作家的姓名并去重
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test04() {
        /**
         * 打印所有作家姓名
         */
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .forEach(s -> System.out.println(s));
    }

    private static void test03() {
        /**
         * Map创建stream流
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");
        map.put(2, "bbb");
        map.put(3, "ccc");
        map.put(4, "ddd");
        map.put(5, "eee");

        Stream<Map.Entry<Integer, String>> stream = map.entrySet().stream();


        /**
         * 匿名内部类写法
         */
//        stream.filter(new Predicate<Map.Entry<Integer, String>>() {
//            @Override
//            public boolean test(Map.Entry<Integer, String> entry) {
//                return entry.getKey()>2;
//            }
//    }).forEach(new Consumer<Map.Entry<Integer,String>>(){
//
//            @Override
//            public void accept(Map.Entry<Integer, String> entry) {
//                System.out.println(entry.getKey()+"=="+entry.getValue());
//            }
//        });

        /**
         * lambda写法
         */
        stream.filter(entry -> entry.getKey() > 2).forEach(entry -> System.out.println(entry.getKey() + "==" + entry.getValue()));
    }

    private static void test02() {
        Integer[] arr = {1, 2, 2, 3, 4, 5, 4};
        Stream<Integer> stream = Arrays.stream(arr);
        /**
         *集合对象.stream()
         */
//        stream.distinct().forEach(integer -> {
//            System.out.println(integer);
//        });

        /**
         * Arrays.stream(数组)
         */
        stream.distinct()
                .filter(integer ->
                {
                    return integer % 2 == 0;
                })
                .forEach(integer -> {
                    System.out.println(integer);
                });
    }

    private static void test01() {
        List<Author> authors = getAuthors();
        /**
         * 使用stream流和lambda查询作者年龄小于18的作者名
         */
        authors.stream()//把集合转换成流
                .distinct()
                .filter(author -> {
                    return author.getAge() < 18;
                })
                .forEach(author -> {
                    System.out.println(author.getName());
                });
    }

    public static List<Author> getAuthors() {

        Author author = new Author(1L, "md", 33, "md is a man", null);
        Author author2 = new Author(2L, "yls", 17, "yls is a girl", null);
        Author author3 = new Author(3L, "yi", 19, "yi is a boy", null);
        Author author4 = new Author(3L, "yi", 19, "yi is a boy", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "aaaaaa", "哲学，爱情", 88, "bbbbbb"));
        books1.add(new Book(2L, "cccccc", "个人成长，爱情", 99, "dddddd"));

        books2.add(new Book(3L, "eeeeee", "哲学", 88, "ffffff"));
        books2.add(new Book(3L, "eeeeee", "哲学", 85, "ffffff"));
        books2.add(new Book(4L, "gggggg", "爱情，个人传记", 56, "hhhhhh"));

        books3.add(new Book(5L, "iiiiii", "爱情", 56, "jjjjjj"));
        books3.add(new Book(6L, "kkkkkk", "个人传记", 100, "llllll"));
        books3.add(new Book(6L, "kkkkkk", "个人传记", 100, "llllll"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }
}
