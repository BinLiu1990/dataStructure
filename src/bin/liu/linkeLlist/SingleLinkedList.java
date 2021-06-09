package bin.liu.linkeLlist;

/**
 * @author: super_bin
 * @date: 2021/5/18 10:22
 * @description: 单向链表，顺序存储
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println("---------------------无排序链表----------------------------");
       /* Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.list();*/
        System.out.println("---------------------排序链表----------------------------");
        Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        singleLinkedList.addBySorted(node2);
        singleLinkedList.addBySorted(node1);
        singleLinkedList.addBySorted(node3);
        singleLinkedList.list();
    }

    //初始化头节点
    private Node head = new Node(0, "");

    public void add(Node node) {
        Node tmp = this.head;
        while (true) {
            if (tmp.getNext() == null) {
                tmp.setNext(node);
                break;
            }
            //node 后移
            tmp = tmp.getNext();
        }
    }

    /**
     * 规则：升序
     * 1、需要找到 插入的位置
     * 2.把 node 插入链表中
     *
     * @param node
     */
    public void addBySorted(Node node) {
        Node tmp = this.head;
        while (true) {
            if (tmp.getNext() == null) {
                node.setNext(tmp.getNext());
                tmp.setNext(node);
                break;
            } else if (tmp.getNext().getNo() > node.getNo()) { //插入node的位置
                node.setNext(tmp.getNext());
                tmp.setNext(node);
                break;
            } else if (node.getNo() == tmp.getNext().getNo()) {
                System.out.println(node.getNo() + "编号已存在，不能加入");
                break;
            }
            //node 后移
            tmp = tmp.getNext();
        }
    }


    public void list() {
        Node tmp = head;
        while (true) {
            System.out.println(tmp);
            tmp = tmp.getNext();
            if (tmp == null) {
                break;
            }
        }
    }
}
