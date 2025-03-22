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
    public ListNode mergeKLists(ListNode[] listArray) {
          PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Add all non-null nodes to priority queue
        for (ListNode node : listArray) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Merge lists using priority queue
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();

            // Add the next node in the list (if exists) to the priority queue
            if (minNode.next != null) {
                pq.add(minNode.next);
            }

            // Link the extracted node to the merged list
            temp.next = minNode;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
