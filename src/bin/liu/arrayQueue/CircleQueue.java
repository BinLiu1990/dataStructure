package bin.liu.arrayQueue;

/**
 * @author: super_bin
 * @date: 2021/5/17 9:26
 * @description: 环形队列  先进先出！！！！！
 * 已经使用过的数组的位置可以重复使用
 */
public class CircleQueue {
    private int maxSize;
    private int front = 0;
    private int rear = 0;
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean full() {
        //TODO 重点 取模的原因是 环形！！！！有循环的概念； +1：一位预留位置
        return (rear + 1) % maxSize == front;
    }

    public boolean empty() {
        return front == rear;
    }

    public void add(int num) {
        if (full()) {
            System.out.printf("添加%d时，队列已满", num);
            System.out.println();
            return;
        }
        //TODO 重点
        arr[rear] = num;
        //maxSize = 4,实际数组长度是3，一位是空位
        //rear = （2 + 1）% 4
        //rear = 3
        //下次 add ，使用空位 arr[3] = ? -> rear  = 0
        rear = (rear + 1) % maxSize;
    }

    public void get() {
        if (empty()) {
            System.out.println("队列已空");
            return;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        System.out.println("取到的数据：" + value);
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public static void main(String[] args) {
        //数据组长度为3，一位 预留位置
        CircleQueue arrayQueue = new CircleQueue(4);
        System.out.println("-----------------添加数据----------------------");
        arrayQueue.add(10);
        arrayQueue.add(20);
        arrayQueue.add(30);
        //队列满了
        arrayQueue.add(40);
        System.out.println("-----------------获取数据----------------------");
        //获取头部元素
        arrayQueue.get();
        arrayQueue.get();
        arrayQueue.get();
        //队列空了
        arrayQueue.get();

    }
}
