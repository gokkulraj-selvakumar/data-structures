public class Solution {
    public int solve(ArrayList<Integer> A) {
        //Initialize variable to store max and min
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //determine array length
        int length = A.size();

        //find the maximum and minimum
        for(int i=0; i<A.size(); i++) {
            //get the element
            int element = A.get(i);

            if(max < element) {
                //element is larger, update max
                max = element;
            }

            if(min > element) {
                //minimum element found, update min
                min = element;
            }
        }

        //check if max and min are same, then return 1
        if(max == min) {
            return 1;
        }

        //create variable to store max and min index, and smallest length
        int last_max_index = -1;
        int last_min_index = -1;
        int smallest_length = Integer.MAX_VALUE;

        //loop through the array
        for(int i=0; i<length; i++) {
            //get element
            int element = A.get(i);

            if(element == max) {
                //max element found
                if(last_min_index != -1) {
                    //already found minimum element, calculate sub array length
                    int sub_length = i - last_min_index + 1;

                    //update minimum value to the smallest_length
                    smallest_length = Math.min(sub_length, smallest_length);
                }

                //update the max element index
                last_max_index = i;
            }
            else if(element == min) {
                //min element found
                if(last_max_index != -1) {
                    //already found max element, calculate sub array length
                    int sub_length = i - last_max_index + 1;

                    //update minimum value to smallest length
                    smallest_length = Math.min(sub_length, smallest_length);
                }

                //update the min element index
                last_min_index = i;
            }
        }

        return smallest_length;
    }
}
