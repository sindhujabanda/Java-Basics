package LeetCode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode currentNode = head;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }

        head = preNode;

        return head;
    }

    public static void main(String[] args){
        ListNode list = new ListNode(1, new ListNode(4, new ListNode(8, new ListNode(12))));
        ListNode result = reverseList(list);
        while (result != null){
            System.out.println(result.value + " ");
            result = result.next;
        }
    }
}
