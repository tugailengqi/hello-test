package com.lengqi.aop.util;

import cn.hutool.core.util.ObjectUtil;
import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<>();
        for (int i = -10; i < 10; i++) {

        }
        System.out.println(test(list));
    }
    public static List<Integer> test(List<Demo> list){
        if (ObjectUtil.isEmpty(list)){
            return null;
        }
        List<Integer> collect = list.stream().filter(v -> v.getAge()>0).map(Demo::getAge).collect(Collectors.toList());

        return collect;
    }
}
class Demo{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
