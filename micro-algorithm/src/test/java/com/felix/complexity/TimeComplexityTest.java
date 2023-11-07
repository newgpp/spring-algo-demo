package com.felix.complexity;

import org.junit.Test;

/**
 * @author felix
 */
public class TimeComplexityTest {

    /**
     * for 循环是最常见的迭代形式之一，适合预先知道迭代次数时使用。
     * 此求和函数的操作数量与输入数据大小成正比，或者说成“线性关系”。实际上，时间复杂度描述的就是这个“线性关系”。
     */
    int forLoop(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }

    /**
     * while 循环比 for 循环的自由度更高。在 while 循环中，我们可以自由设计条件变量的初始化和更新步骤。
     */
    int whileLoop(int n) {
        int res = 0;
        int i = 1;
        while (i <= n) {
            res += i;
            i++;
        }
        return res;
    }

    /**
     * 双层for循环
     * 这种情况下，函数的操作数量与n的平方成正比，或者说算法运行时间和输入数据大小成“平方关系”。
     */
    String nestLoop(int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                res.append(String.format("(%s + %s), ", i, j));
            }
        }
        return res.toString();
    }

    @Test
    public void loop_should_success() {
        int forLoopR = forLoop(5);
        int whileLoopR = whileLoop(5);
        String s = nestLoop(5);

        System.out.println(forLoopR);
        System.out.println(whileLoopR);
        System.out.println(s);
    }

    /**
     * 递归
     * 普通递归：当函数返回到上一层级的函数后，需要继续执行代码，因此系统需要保存上一层调用的上下文
     */
    int recur(int n) {
        if (n == 1) {
            return 1;
        }
        return n + recur(n - 1);
    }

    /**
     * 尾递归
     * 尾递归：递归调用是函数返回前的最后一个操作，这意味着函数返回到上一层级后，无需继续执行其他操作，因此系统无需保存上一层函数的上下文
     */
    int tailRecur(int n, int res) {
        if (n == 1) {
            return res + n;
        }
        return tailRecur(n - 1, res + n);
    }

    /**
     * 递归树
     * 给定一个斐波那契数列 0 1 1 2 3 5 8 13 ... 求该数列的第n个数字
     */
    int treeRecur(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        return treeRecur(n - 1) + treeRecur(n - 2);
    }


    @Test
    public void recursion_should_success() {
        System.out.println(recur(5));
        System.out.println(tailRecur(5, 0));
        System.out.println(treeRecur(8));
    }

    /**
     * 时间复杂度：常数阶
     */
    void algo_a(int n) {
        System.out.println(n);
    }

    /**
     * 时间复杂度：线性阶
     */
    void algo_b(int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(i);
        }
    }

    /**
     * 时间复杂度：常数阶
     */
    void algo_c(int n) {
        for (int i = 1; i < 1000000; i++) {
            System.out.println(i);
        }
    }

    /**
     * 对数阶
     */
    int logarithmic(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }

    /**
     * 平方阶
     */
    int quadratic(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    /**
     * 平方阶
     */
    int bubbleSort(int[] nums) {
        int count = 0;
        int n = nums.length;
        //未排序区间为 [i, n]
        for (int i = 0; i < n; i++) {
            //将未排序区间 [i, n]最小的元素移动到最左侧
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    count += 3;
                }
            }
        }
//        for (int num : nums) {
//            System.out.println(num);
//        }
        return count;
    }

    /**
     * 线性对数阶
     */
    int linearLog(int n) {
        int count = 0;
        for (int i = n; i > 0; i--) {
            int j = i;
            while (j > 1) {
                j = j / 2;
                count++;
            }
        }
        return count;
    }

    /**
     * 指数阶
     * 生物学细胞分裂：1->2, 2->4, 4->8 ...
     */
    int exponential(int n) {
        int count = 0;
        int base = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }
            base = base * 2;
        }
        return count;
    }

    /**
     * 阶乘阶
     */
    int factorialRecur(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += factorialRecur(n - 1);
        }
        return count;
    }


    /**
     * ### 理解
     * 1. 时间复杂度分析统计的不是算法运行时间，而是算法运行时间随着数据量变大时的增长趋势。
     * 2. 在时间复杂度分析中，我们可以简单地将所有计算操作的执行时间视为相同的“单位时间”，从而将“计算操作的运行时间的统计”简化为“计算操作的数量的统计”
     * <p>
     * 以上三个算法的时间复杂度
     * https://www.hello-algo.com/chapter_computational_complexity/time_complexity.assets/time_complexity_simple_example.png
     * <p>
     * ### 常见类型
     * O(1) 常数阶-常数阶的操作数量与输入数据大小无关，即不随着n的变化而变化。
     * O(log n) 对数阶-与指数阶相反，对数阶反映了“每轮缩减到一半”的情况。设输入数据大小为，由于每轮缩减到一半，因此循环次数是log2^n，即2^n的反函数。
     * O(n) 线性阶-线性阶的操作数量相对于输入数据大小n以线性级别增长。线性阶通常出现在单层循环中
     * O(nlog n) 线性对数阶-线性对数阶常出现于嵌套循环中，两层循环的时间复杂度分别为O(n)和O(log n)
     * O(n^2) 平方阶-平方阶的操作数量相对于输入数据大小以平方级别增长。平方阶通常出现在嵌套循环中，外层循环和内层循环都为O(n)，因此总体为O(n^2)
     * O(2^n) 指数阶-生物学细胞分裂：1->2, 2->4, 4->8 ...
     * O(n!) 阶乘阶-排列组合方案 n个元素 所有的排列组合方案为 n!
     */
    @Test
    public void time_count_should_success() {
        int i = bubbleSort(new int[]{7, 9, 3, 6, 1, 0, 11});

        System.out.println(factorialRecur(4));
    }


}
