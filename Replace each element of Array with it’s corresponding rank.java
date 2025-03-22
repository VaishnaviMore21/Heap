class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
        HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();
        int temp=1;
        int n=arr.length;
        int brr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            brr[i]=arr[i];
        }
        Arrays.sort(brr);
        // Assign ranks to unique elements
        for (int i = 0; i < n; i++) {
            if (!mp.containsKey(brr[i])) { // Assign rank only if not already assigned
                mp.put(brr[i], temp);
                temp++; // Only increment if it's a new number
            }
        }
         int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = mp.get(arr[i]);
        }

        return res;
     

  }
}
