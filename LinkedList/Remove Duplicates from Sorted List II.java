/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp = new ListNode();
        temp.next = head;

        ListNode ptr=temp;
    
        while(ptr.next!=null && ptr.next.next!=null){

            if(ptr.next.val == ptr.next.next.val){
                int value=ptr.next.val;
                while(ptr.next!=null && ptr.next.val==value){
                    ptr.next=ptr.next.next;
                }
            }else{
                ptr=ptr.next;
            }
        }
        return temp.next;
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
