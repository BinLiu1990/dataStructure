package bin.liu.sparseArray;

/**
 * @author: super_bin
 * @date: 2021/5/14 10:36
 * @description: 二维数据与稀疏数组间的相互转化
 */
public class SparseArray {
    public static void main(String[] args) {
        System.out.println("-------------------------原始二维数组----------------------------------");
        //模拟五子棋  棋盘 11 * 11
        int chessRow = 11;
        int chessCol = 11;
        int[][] chess = new int[chessRow][chessCol];
        //初始化棋盘 1：黑子  2：蓝子  0：无用数据
        chess[1][2] = 1;
        chess[2][3] = 2;
        for (int[] ints : chess) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("-------------------------稀疏数组----------------------------------");
        //二维数组转为稀疏数组
        //关键点：确定行和列的个数，也就是二维数据的 2个下标的大小
        //稀疏数组 行：有效数据的个数，列：固定值 3（row col value）
        int row = 0;
        int col = 3;
        for (int[] ints : chess) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    row++;
                }
            }
        }
        int[][] sparseArray = new int[row + 1][col];
        //第一行
        sparseArray[0][0] = chessRow;
        //有效数据的个数
        int effectiveCount = row;
        sparseArray[0][1] = chessCol;
        sparseArray[0][2] = effectiveCount;
        //非第一行
        int index = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                int value = chess[i][j];
                if (value != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = value;
                }
            }
        }
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        System.out.println("-------------------------稀疏数组转二维数组----------------------------------");
        //创建二维数组 第一行
        int[] sparse = sparseArray[0];
        int[][] dataArray = new int[sparse[0]][sparse[1]];
        //第二行以后的数据
        for (int i = 1; i < sparseArray.length; i++) {
            int col0Val = sparseArray[i][0];
            int col1Val = sparseArray[i][1];
            int col2Val = sparseArray[i][2];
            dataArray[col0Val][col1Val] = col2Val;
        }
        for (int[] ints : dataArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }
}
