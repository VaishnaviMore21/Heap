class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer>map=new TreeMap<>();
          if (hand.length % groupSize != 0) return false;
        for(int i=0;i<hand.length;i++)
        {
            map.put(hand[i],map.getOrDefault(hand[i], 0) + 1);
        }
        while(map.size()>0)
        {
            int currentCard=map.entrySet().iterator().next().getKey();
            for(int i=0;i<groupSize;i++)
            {
                int card=currentCard+i;
                if(!map.containsKey(card))return false;
                map.put(card,map.get(card)-1);
                if(map.get(card)==0)
                {
                    map.remove(card);
                }
            }
        }  
        return true;

    }
}
