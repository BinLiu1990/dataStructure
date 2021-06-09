package bin.liu.arrayQueue;

/**
 * @author: super_bin
 * @date: 2021/5/17 9:26
 * @description: 数组队列  先进先出！！！！！
 */
public class ArrayQueue {
    private int maxSize;
    private int front = -1;
    private int rear = -1;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean full() {
        return rear == maxSize - 1;
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
        arr[++rear] = num;
    }

    public void get() {
        if (empty()) {
            System.out.println("队列已空");
            return;
        }
        System.out.println("取到的数据：" + arr[++front]);
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
