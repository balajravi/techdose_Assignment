class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null|| head.next==null)
            return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode itr=dummy;
        while(itr.next!=null && itr.next.next!=null)
        {
            if(itr.next.val==itr.next.next.val)
            {
                itr.next=itr.next.next;
            }
            else
            {
                itr=itr.next;
            }
        }
        return dummy.next;
        
    }
}
/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
Return the linked list sorted as well.


Example 1:

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:

Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
    */
