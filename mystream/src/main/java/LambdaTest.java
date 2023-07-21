import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class LambdaTest {
    public static void main(String[] args) {

        /**
         * 创建线程并启动时使用匿名内部类的写法
         */
//        new Thread(new Runnable() {
//            public void run() {
//                System.out.println("新线程中的run方法被执行了");
//            }
//        }).start();

        /**
         * 使用Lambda的格式对上面代码进行修改
         */
//        new Thread(() -> {
//            System.out.println("新线程中的run方法被执行了");
//        }).start();

        /**
         * 匿名内部类写法
         */
//        int x = calculateNum(new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int left, int right) {
//                return left + right;
//            }
//        });

        /**
         * lambda写法
         */
        int x = calculateNum((int left, int right) -> {
            return left + right;
        });
        System.out.println(x);

        printNum(value -> {
            return value % 2 == 0;
        });

        /**
         * 匿名内部类写法
         */
//        int y=typeConver(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.valueOf(s);
//            }
//        });
        /**
         * lambda写法
         */
        int y = typeConver(s -> {
            return Integer.valueOf(s);
        });
        System.out.println(y);

        /**
         * lambda写法
         */
        foreachArr(value -> {
            System.out.println(value);
        });
    }

    /**
     * 自定义方法
     */
    public static int calculateNum(IntBinaryOperator operator) {
        int a = 10;
        int b = 10;
        return operator.applyAsInt(a, b);
    }

    /**
     * 自定义方法
     */
    public static void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 自定义方法
     */
    public static <R> R typeConver(Function<String, R> function) {
        String str = "1235";
        R result = function.apply(str);
        return result;
    }

    /**
     * 自定义方法
     */
    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }
}
