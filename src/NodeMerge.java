import java.util.HashMap;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class NodeMerge {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        while (l1 != null && l2 != null) {
            ListNode sumNode;
            if (l1.val <= l2.val) {
                sumNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                sumNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            cursor.next = sumNode;
            cursor = sumNode;
        }
        cursor.next = l1 == null ? l2 : l1;
        return root.next;
    }
}

