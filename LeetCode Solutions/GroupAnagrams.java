
/*  Given an array of strings, group anagrams together.

    For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Return:

    [
      ["ate", "eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    Idea 1: Iterate through array, create a HashMap for current word and
            store that hashmap into a hashmap of hashmaps (avoid duplicate anagram hashmaps by not adding them).
            if that hashmap for the current word matches another hashmap in the anagram hashmaps,
            then add that word to it's corresponding group.

            Worked but was too slow

    Idea 2: Iterate through array and sort each string, if a mapping to a list exists for that key, add it to the list
            else, create a mapping for it and add it to the list.
*/

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMaps = new HashMap<String, List<String>>();

        for (String s : strs) {
            String orig = s;
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            s = String.valueOf(arr);

            if (!anagramMaps.containsKey(s)) {
                anagramMaps.put(s, new ArrayList<String>());
            }
            anagramMaps.get(s).add(orig);
        }

        return new ArrayList<List<String>>(anagramMaps.values());
    }

}
