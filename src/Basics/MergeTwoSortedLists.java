package Basics;
class ListNode{
    int value;
    ListNode next;

    ListNode(int value){
        this.value = value;
        this.next = null;
    }

    ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }
}

public class MergeTwoSortedLists {

    public static ListNode mergeTwo(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null){
            if(list1.value <= list2.value){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if(list1 != null){
            current.next = list1;
        } else{
            current.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(5)));

        ListNode result = mergeTwo(list1, list2);
        while (result != null){
            System.out.println(result.value + " ");
            result = result.next;
        }
    }
}
