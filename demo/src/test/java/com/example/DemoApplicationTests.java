package com.example;


import com.google.common.base.Joiner;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.base.Splitter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

    private Stream<String> mapStream;

    @Test
    public void contextLoads() {
    }

    @Test
    public void filter() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 过滤出偶数
        Stream<Integer> filterStream = stream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        // 简单输出
        filterStream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    @Test
    public void map() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 整数转换为String
        mapStream = stream.map(new Function<Integer, String>(){
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        });
        // 简单输出
        mapStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String integer) {
                System.out.println(integer);
            }
        });
    }

    // 转换
    @Test
    public void flatMap() {
        Stream<String> stream = Stream.of("java:1", "android:2", "ios:3");
        // 整数转换为String
        Stream<String> rerStream = stream.flatMap(
                new Function<String, Stream<String>>() {
                    @Override
                    public Stream<String> apply(String s) {
                        // 分割
                        Iterable<String> iterableList = Splitter.on(':').trimResults() // 移除前面和后面的空白
                                .omitEmptyStrings()
                                .split(s);
                        return Lists.newArrayList(iterableList).parallelStream();
                    }
                });
        // 简单输出
        rerStream.forEach(new Consumer<String>() {
            @Override
            public void accept(String integer) {
                System.out.println(integer);
            }
        });

        String s =  "abc";
    }

    // 去重
    @Test
    public void distinct() {
        Stream<Integer> stream = Stream.of(1,2,3,1,2,3,1,2,3);
        Stream<Integer> rerStream = stream.distinct();
        // 简单输出
        rerStream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    // 自己来组装Collector，返回一个List
    @Test
    public void collectNew() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> intList = stream.collect(
                new Collector<Integer, List<Integer>, List<Integer>>() {
                    // 生成结果容器，容器类型为,我们这里为List<Integer>
                    @Override
                    public Supplier<List<Integer>> supplier() {
                        return new Supplier<List<Integer>>() {

                            @Override
                            public List<Integer> get() {
                                return new ArrayList<>();
                            }
                        };
                    }

                    // 把流里面的结果都放到结果容器里面去
                    @Override
                    public BiConsumer<List<Integer>, Integer> accumulator() {
                        return new BiConsumer<List<Integer>, Integer>() {
                            @Override
                            public void accept(List<Integer> integers, Integer integer) {
                                integers.add(integer);
                            }
                        };
                    }

                    // 两个两个合并并行执行的线程的执行结果，将其合并为一个最终结果A
                    @Override
                    public BinaryOperator<List<Integer>> combiner() {
                        return new BinaryOperator<List<Integer>>() {
                            @Override
                            public List<Integer> apply(List<Integer> left, List<Integer> right) {
                                left.addAll(right);
                                return left;
                            }
                        };
                    }

                    // 可以对最终的结果做一个转换操作
                    @Override
                    public Function<List<Integer>, List<Integer>> finisher() {
                        return new Function<List<Integer>, List<Integer>>() {
                            @Override
                            public List<Integer> apply(List<Integer> integers) {
                                return integers;
                            }
                        };
                    }

                    // 特征值
                    @Override
                    public Set<Characteristics> characteristics() {
                        return EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH);
                    }
                });

        for (Integer item : intList) {
            System.out.println(item);
        }
    }

    @Test
    public void toCollection() {
        List<String> list = Arrays.asList("java", "ios", "c");
        LinkedList<String> retList = list.stream().collect(Collectors.toCollection(
                new Supplier<LinkedList<String>>() {

                    @Override
                    public LinkedList<String> get() {
                        return new LinkedList<>();
                    }
                }));
    }

    @Test
    public void toSet() {
        List<String> list = Arrays.asList("java", "ios", "c");
        Set<String> retList = list.stream().collect(Collectors.toSet());
        System.out.println(retList);
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
    }

    @Test
    public void joining() {
        List<String> list = Arrays.asList("java", "ios", "c");
        String ret = list.stream().collect(Collectors.joining("','", "'", "'"));
        System.out.println(ret);//'java','ios','c'

        //String str = list.stream().collect(Collectors.joining("','","'",","));
    }

    @Test
    public void mapping() {
        List<String> list = Arrays.asList("java", "ios", "c");
        // 先把流里面的每个元素的前后加上[],之后在用:拼接起来
        String ret = list.stream().collect(Collectors.mapping(
                new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return "'" + s + "'";
                    }
                },
                Collectors.joining(",")));
        System.out.println(ret);//'java','ios','c'
    }

    @Test
    public void collectingAndThen() {
        List<String> list = Arrays.asList("java", "ios", "c");
        // Collectors.toList()之后在把List<String>通过Joiner转换String
        String ret = list.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                new Function<List<String>, String>() {
                    @Override
                    public String apply(List<String> strings) {
                        return Joiner.on("; ")
                                .join(strings);
                    }
                }));
        System.out.println(ret);//java; ios; c
    }
}
