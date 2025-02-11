class Solution {
public:
    int findKthLargest(vector<int>& arr, int k) {
           priority_queue<int, vector<int>, greater<int>> pq;
        int n = arr.size()  ;
        for(int i=0;i<n;i++)
        {
            pq.push(arr[i]);
          

            if(pq.size()>k)
            {
                pq.pop();
            }
        }
         return pq.top();
    }
};
