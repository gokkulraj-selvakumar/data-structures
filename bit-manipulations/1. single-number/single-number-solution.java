public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = 0;

        //perform XOR to get once appearing element
        for(int i=0; i<A.size(); i++) {
            result ^= A.get(i);
        }

        return result;
    }
}