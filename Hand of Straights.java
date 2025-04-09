class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // TreeMap to store card values and their frequency in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // If total cards can't be evenly divided into groupSize, return false
        if (hand.length % groupSize != 0) return false;

        // Count the frequency of each card in the hand
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        // Try to create groups while there are still cards left
        while (map.size() > 0) {
            // Get the smallest card value (start of a potential group)
            int currentCard = map.firstKey();

            // Try to form a group of size 'groupSize' starting from currentCard
            for (int i = 0; i < groupSize; i++) {
                int card = currentCard + i;

                // If the required card is not present, we can't form a valid group
                if (!map.containsKey(card)) return false;

                // Decrease the frequency of the card
                map.put(card, map.get(card) - 1);

                // If frequency becomes 0, remove the card from the map
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        // All cards successfully grouped into consecutive sequences
        return true;
    }
}

