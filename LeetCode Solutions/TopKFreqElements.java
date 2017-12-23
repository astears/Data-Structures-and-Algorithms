/* Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

class TopKFreqElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
            new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        for (Map.Entry e : map.entrySet()) {
            maxHeap.add(e);
        }

        for (int i = 0; i < k; i++) {

            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
