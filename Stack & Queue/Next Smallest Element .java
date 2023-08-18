class Solution {
        public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num)
                map.put(stack.pop(), num);
            stack.push(num);
            // System.out.println(map);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);

        return findNums;
    }
}

nums1 = [4,1,7,9,2]
  
nums2 = [4,1,6,2,9,7,5]
  
Output = [1,-1,5,7,-1]
