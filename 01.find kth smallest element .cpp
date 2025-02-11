class Solution {
  public:
    // arr : given array
    // k : find kth smallest element and return using this function
    int kthSmallest(vector<int> &arr, int k) {
        // code here
        int N=arr.size();
        priority_queue<int>pq;
        for(int i=0;i<N;i++)
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
