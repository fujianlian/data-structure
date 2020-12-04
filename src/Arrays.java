import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 数组相关算法案例
 */
public class Arrays {

    public static void main(String[] args) {
        System.out.println(majorityElement2(new int[]{1, 2, 2, 3, 2, 1, 1, 3}).toString());
    }

    /**
     * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     */
    static int majorityElement(int[] nums) {
        // 此种算法非常容易忽略掉只有一个元素的时候
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        int main = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int frequency = map.get(num) + 1;
                map.put(num, frequency);
                if (total < frequency) {
                    total = frequency;
                    main = num;
                }
            } else {
                map.put(num, 1);
                if (total == 0) {
                    total = 1;
                    main = num;
                }
            }
        }
        return total > nums.length / 2 ? main : -1;
    }

    // 摩尔投票算法
    static int majorityElement1(int[] nums) {
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
        if (count <= 0) {
            return -1;
        } else {
            for (int num : nums) {
                if (num == majority) counter++;
            }
        }
        if (counter > nums.length / 2) {
            return majority;
        }
        return -1;
    }

    // 摩尔投票算法变型 找出数组中所有大于1/3长度的元素
    static List<Integer> majorityElement2(int[] nums) {
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
        if (count1 > l) {
            a.add(main1);
        }
        if (count2 > l && main1 != main2) {
            a.add(main2);
        }
        return a;
    }
}

