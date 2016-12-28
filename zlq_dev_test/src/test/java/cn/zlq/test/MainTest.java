package cn.zlq.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangliangqi
 * @Title: MainTest
 * @Package cn.zlq.test
 * @Description
 * @date 2016-06-30
 */
public class MainTest {

    private  ThreadLocal<Lock> local = new ThreadLocal<Lock>(){
        public Lock initialValue(){
            return new Lock();
        }
    };

    private static ThreadLocal<Test1> test = new ThreadLocal<Test1>(){
        public Test1 initialValue(){
            return new Test1();
        }
    };

    public static void main(String[] args) {
        String str="3541068";
        System.out.println(Integer.valueOf(str));



        str= "222"+5+"3333";
        String s = "666"+str+"7777";
        System.out.println(s);

        StringBuffer sb = new StringBuffer();
        sb.append("222"+5).append("3333");
        StringBuffer sbf = new StringBuffer();
        sbf.append("666").append(sb).append("7777");
        System.out.println(sbf.toString());
        MainTest mainTest = new MainTest();
        try {
            mainTest.outer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test1 t = new Test1();
        t.setAge(new AtomicInteger(9));
        t.setStr("main");
        test.set(t);
        OneThread one = new OneThread();
        TwoThread two = new TwoThread();
        one.start();
        two.start();
        System.out.println(test.get().getAge()+";"+test.get().getStr());

    }
    static class OneThread extends Thread{
        @Override
        public void run() {
            test.get().setAge(new AtomicInteger(12));
            test.get().setStr("one thread");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(test.get().getAge()+";"+test.get().getStr());
        }
    }
    static class TwoThread extends Thread{
        @Override
        public void run() {
            test.get().setAge(new AtomicInteger(24));
            test.get().setStr("two thread");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(test.get().getAge()+";"+test.get().getStr());
        }
    }

    static class Test1{
        private AtomicInteger age ;
        private String str ;

        public AtomicInteger getAge() {
            return age;
        }

        public void setAge(AtomicInteger age) {
            this.age = age;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

    public  void outer() throws InterruptedException {
        System.out.println("invoke outer start!");
        local.get().lock();
        inner();
        local.get().unlock();
    }

    public synchronized void inner() throws InterruptedException {
        local.get().lock();
        System.out.println("invoke inner start!");
        local.get().unlock();
    }

    public class Lock{
        private boolean isLocked = false;

        private Thread thread;

        public synchronized void lock() throws InterruptedException {
            Thread curr = Thread.currentThread();
            System.out.println(curr.getId()+",name:"+curr.getName());
            while(isLocked && thread != curr){
                wait();
            }
            isLocked  = true;
            thread = curr;
        }

        public synchronized void unlock(){
            isLocked = false;
            notify();
        }
    }
}
