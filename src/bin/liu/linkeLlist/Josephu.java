package bin.liu.linkeLlist;

/**
 * @author: super_bin
 * @date: 2021/6/7 13:51
 * @description: Josephu 问题为：设编号为 1，2，… n 的 n 个人围坐一圈
 * 约定编号为 k（1<=k<=n）的人从 1 开始报数，
 * 数到 m 个人出列，它的下一位又从 1 开始报数，
 * 数到 m 个人又出列，依次类推，直到所有人出列为止，
 * 由此 产生一个出队编号的序列。
 */
public class Josephu {

    public static void main(String[] args) {
        Josephu josephu = new Josephu();
        josephu.addNodes(5);
        josephu.showNodes();
        //测试一把小孩出圈是否正确
        josephu.countBoy(1, 2, 5); // 2->4->1->5->3
        josephu.showNodes();
    }

    //第一个节点永远不变
    Node first = null;

    public Node addNodes(int nums) {
        //当前节点
        Node curNode = null;
        if (nums < 1) {
            System.out.println("nums 不能小于 1");
            return null;
        }
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                //第一个节点时候
                first = node;
                first.setNext(node);
                curNode = first;
                continue;
            }
            //非第一个节点： 上一个节点（curNode）的next节点指向 node；node节点指向 first 形成环
            curNode.setNext(node);
            node.setNext(first);
            curNode = node;
        }
        return curNode;
    }

    public void showNodes() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何节点~~");
            return;
        }
        // 因为 first 不能动，因此我们仍然使用一个辅助指针完成遍历
        Node curNode = first;
        while (true) {
            System.out.println(curNode);
            curNode = curNode.getNext();
            //说明已经遍历完毕
            if (curNode == first) return;
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        // 创建要给辅助指针,帮助完成小孩出圈
        Node helper = first;
        //需求创建一个辅助指针(变量) helper ,找到最后的节点
        //和 first 配合使用 ，此时 helper 紧随 first 之后
        while (true) {
            if (helper.getNext() == first) {
                // 说明 helper 指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让 first 和 helper 移动 startNo - 1 次 ，
        //即 first 和 helper 移动到 k  的位置
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让 first 和 helper 指针同时 的移动 countNum - 1 次, 然后出圈
        //这里是一个循环操作
        while (true) {
            if (helper == first) {
                //说明圈中只有一个节点
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时 first 指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            //这时将 first 指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}
