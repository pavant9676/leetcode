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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode();
        ListNode finalans = dummy;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
            
        }
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            dummy.next = minNode;
            dummy = minNode;
            if(minNode.next!=null){
                pq.add(minNode.next);
            }
        }
        return finalans.next;
        
        
        
        
        //ListNode newNode = new ListNode(pq.remove());



    }
}