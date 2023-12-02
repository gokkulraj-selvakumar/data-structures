public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        //determine array length
        int arrayLength = A.size();

        //create variable to store suffix sum
        int[] sMax = new int[arrayLength];

        //determine suffix sum
        sMax[arrayLength-1] = A.get(arrayLength-1);

        //loop through the array
        for(int i=arrayLength-2; i>=0; i--) {
            //update the maximum till end in the current suffix position
            sMax[i] = Math.max(sMax[i+1], A.get(i));
        }

        //create variable to store maximum till i position
        int pMax = A.get(0);

        //variable to store water
        int water = 0;

        //loop through the array
        for(int i=1; i<arrayLength-1; i++) {
            //get left and right max
            int leftMax = pMax;
            int rightMax = sMax[i+1];

            //calculate water content
            int tempWater = Math.min(leftMax, rightMax) - A.get(i);

            //update water
            if(tempWater > 0) {
                water += tempWater;
            }

            //update left max for next iteration
            pMax = Math.max(A.get(i), leftMax);
        }

        //return water
        return water;
    }
}
