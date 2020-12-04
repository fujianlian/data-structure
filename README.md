# 算法基础

## 摩尔投票法

在任何数组中，出现次数大于该数组长度一半的值只能有一个。

通过数学知识，我们可以证明它的正确性，但是这并不在我们这篇博客里涉及。

摩尔投票法的基本思想很简单，在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。如果只存在一种元素，那么这个元素则可能为目标元素。

那么有没有可能出现最后有两种或两种以上元素呢？根据定义，这是不可能的，因为如果出现这种情况，则代表我们可以继续一轮投票。因此，最终只能是剩下零个或一个元素。

在算法执行过程中，我们使用常量空间实时记录一个候选元素c以及其出现次数f(c)，c即为当前阶段出现次数超过半数的元素。根据这样的定义，我们也可以将摩尔投票法看作是一种动态规划算法。

~~~java
/**
 * 找出超过一半的元素，没有返回-1
 */
public int majorityElement(int[] nums) {
    int majority = -1;
    int count = 0;     
    for (int num : nums) {
        if (count == 0) {
            majority = num;
            count++;
        } else {
            if (majority == num) {
                count++;
            } else {
                count--;
            }
        }
    }
    int counter = 0;
    // count>0表示有存在一个超过一半的元素
    if (count <= 0) {
        return -1;
    } else {
        for (int num : nums) {
            if (num == majority) counter ++;
        }
    }
    if (counter > nums.length / 2) {
        return majority;
    }
    return -1;
}
~~~

题目变型

~~~java
/**
 * 找出数组超过1/3长度的元素
 */
public int majorityElement(int[] nums) {
    int main1 = -1;
    int count1 = 0;
    int main2 = -1;
    int count2 = 0;   
    for (int num : nums) {
         if (main1 == num) {
              count1++;
         } else if (main2 == num) {
              count2++;
         } else if (count1 == 0) {
              main1 = num;
              count1++;
         } else if (count2 == 0) {
              main2 = num;
              count2++;
         } else {
              count1--;
              count2--;
         }
    }
    List<Integer> a = new ArrayList<>();
    int l = nums.length / 3;
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
        if (num == main1) count1++;
        if (num == main2) count2++;
    }
    if (count1 > l) a.add(main1);
    if (count2 > l && main1 != main2) a.add(main2);
    return a;
}
~~~

