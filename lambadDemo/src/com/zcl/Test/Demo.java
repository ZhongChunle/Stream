package com.zcl.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 要求
 * 找出集合中哪些是上海的
 * 找出集合中最大的年龄和最小的年龄是多少
 * 统计年龄总和
 * 按年龄倒序排序取出前3名
 * 统计集合中出现的城市，要求不能重复
 * 判断集合中是否有姓王的人
 * 找出集合中第一个姓郑的人
 */
public class Demo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三", "北京", 22));
        personList.add(new Person("李四", "长沙", 28));
        personList.add(new Person("王五", "郑州", 17));
        personList.add(new Person("赵六", "南京", 33));
        personList.add(new Person("郑七", "深圳", 40));
        personList.add(new Person("李八", "上海", 36));
        personList.add(new Person("陈十", "上海", 24));
        personList.add(new Person("郑十", "上海", 24));

        // 1、找出集合中哪些是上海的
        personList.stream().filter(person -> person.getCity() == "上海").forEach(person -> System.out.println("找出集合中哪些是上海的："+person.toString()));

        // 2、找出集合中最大的年龄和最小的年龄是多少
        Optional<Integer> max = personList.stream().map(person -> person.getAge()).reduce(Integer::max);
        System.out.println("最大的年龄是："+max.orElse(0));
        Optional<Integer> min = personList.stream().map(person -> person.getAge()).reduce(Integer::min);
        System.out.println("最小的年龄是："+min.orElse(0));

        // 统计年龄总和
        Integer sum = personList.stream().map(person -> person.getAge()).reduce(0, (a, b) -> a + b);
        System.out.println("年龄的总和是："+sum);

        // 按年龄倒序排序取出前3名[年龄由大到小]
        // Integer.compare(x,y)比较两个数值
        Stream<Person> limit = personList.stream().sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge())).limit(3);
        limit.forEach(person -> System.out.println("按年龄倒序排序取出前3名[年龄由大到小]："+person.toString()));

        // 统计集合中出现的城市，要求不能重复[上海]
        List<String> collect = personList.stream().map(person -> person.getCity()).sorted().distinct().collect(Collectors.toList());
        collect.forEach(c-> System.out.println("不重复上海："+c.toString()));

        // 判断集合中是否有姓王的人
        personList.stream().filter(person -> person.getName().startsWith("王")).forEach(person -> System.out.println("性王的人士："+person.toString()));

        // 找出集合中第一个姓郑的人
        personList.stream().filter(person -> person.getName().startsWith("郑")).limit(1).forEach(person -> System.out.println("第一个性郑的人："+person.toString()));
        Scanner sc = new Scanner(System.in);
        System.out.println("请问是否推出程序：Y");
        String s = sc.nextLine();
        switch (s){
            case "Y":
                System.exit(0);
        }

        System.out.println("这是一个修改的项目");
    }
}
