package LeetCode;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head){

        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast= head;

        while (fast != null){
            if(fast.value != slow.value){
                return false;
            } else{
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode preNode = null, currentNode = head;
        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // Output: true
    }
}
