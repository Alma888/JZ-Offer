//单例模式实现：

//实现方式1——懒汉式(双重锁机制)
public class Solution1 {
    private static Solution1 instance=null; //静态的类型引用
    private Solution1(){
    }
    public static Solution1 getInstance(){ //获取实例的方法，保证同步
        if(instance==null){                  //第一次判断
            synchronized (Solution1.class){
                if(instance==null){          //第二次判断
                    instance=new Solution1();//创建新的实例
                }
            }
        }
        return instance;
    }
}

//实现方式2——懒汉式(使用同步方法)
/*
public class Solution1 {
    private Solution1(){}
    private static Solution1 instance=null;   //静态的类型引用
    public static synchronized Solution1 getInstance(){   //获取实例的方法，保证同步
        if(instance==null){
            instance=new Solution1();    //创建新的
        }
        return instance;
    }
}
*/

//实现方式3——饿汉式(不使用同步锁)
/*
public class Solution1 {
    private Solution1(){}//private类型的构造函数，保证其他类对象不能直接new一个该对象的实例
    private static Solution1 instance=new Solution1();//直接初始化一个实例对象
    public static Solution1 getInstance(){  //该类唯一的一个public方法
        return instance;
    }
}

Solution1 s=new Solution1 ();  //编译出错
Solution1 s=Solution1 .getInstance(); //保证用的是用一个实例
 */