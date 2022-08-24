/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.models;

/**
 *
 * @author andx
 */
public class Student {

    private int id;
    private String name;
    private String lang;

    public int getId() {
        return id;
    }

    public void setId(int stdid) {
        this.id = stdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String stdname) {
        this.name = stdname;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String stdlang) {
        this.lang = stdlang;
    }

    public Student(int stdId, String stdName, String stdLang) {
        this.id = stdId;
        this.name = stdName;
        this.lang = stdLang;
    }

}


/*

https://blog.csdn.net/liu_yuan_kai/article/details/80268323?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control

javaWEB使用El表达式报错问题，属性未找到javax.el.PropertyNotFoundException

------------------------------描述-------------------------------------

今天在做web练习的时候，在用el取值的时候报错，用${A.Manufacturer}后台报错，

A:一个类的对象名字
Manufacture：类的一个属性名

编译器没有报错，而且确定自己也咩有什么逻辑错误（毕竟小题目没什么逻辑可言），但是运行就是报错------javax.el.PropertyNotFoundException

--------------------------------解决措施------------------------------------

首先我们需要了解的El表达式的运行机制：

    el表达式在你获取对象时，自动把你的属性名转换成字符串，并把首字母大写，进行拼接（"get"+属性名），然后通过反射的方式获取到get方法，返回属性值。实际上就是调用了一遍JavaBean里面的某属性的get函数。

    但是这儿比较鸡肋是，即使你的类属性 首字母是大写，你在调用的时候还是要写成小写格式。

也就是我今天遇到的问题所在：

        我的bean的一个属性叫做“Manufacture”，但是我在使用EL表达式还是得写成${A.manufacturer}才能调用成功！

-----------------------------------------------------------------------------------------------

*/