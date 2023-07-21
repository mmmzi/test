import dto.Author;

import java.util.List;
import java.util.stream.Stream;


public class MethodCitationTest {

    /**
     * 自定义的接口
     */
    interface UseString {
        String use(String str, int start, int length);
    }

    /**
     * 自定义方法
     */
    public static String subAuthorName(String str, UseString useString) {
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }

    public static void main(String[] args) {

//        test01();
//        test02();
//        test03();
        test04();
    }

    private static void test04() {
        /**
         * 构造器引用
         */
        List<Author> authors = StreamTest.getAuthors();
        authors.stream()
                .map(author -> author.getName())
//                .map(name->new StringBuilder(name))
                .map(StringBuilder::new)
                .map(sb -> sb.append("-天下").toString())
                .forEach(str -> System.out.println(str));
    }

    private static void test03() {
        /**
         * 引用类的实例方法
         */
//        subAuthorName("天下大事", new UseString(){
//            @Override
//            public String use(String str, int start, int length) {
//                return str.substring(start,length);
//            }
//        });
        subAuthorName("天下大事", String::substring);
    }

    private static void test02() {
        /**
         * 引用对象的实例方法
         */
        List<Author> authors = StreamTest.getAuthors();

        Stream<Author> authorStream = authors.stream();
        StringBuilder sb = new StringBuilder();
        authorStream.map(author -> author.getName())
                /**
                 * 可以修改成方法引用的写法
                 */
//                .forEach(name->sb.append(name));
                .forEach(sb::append);
    }

    private static void test01() {
        /**
         * 引用类的静态方法
         */
        List<Author> authors = StreamTest.getAuthors();

        Stream<Author> authorStream = authors.stream();
        authorStream.map(author -> author.getAge())
                /**
                 * 可以修改成方法引用的写法
                 */
//                .map(age->String.valueOf(age));
                .map(String::valueOf);
    }
}
