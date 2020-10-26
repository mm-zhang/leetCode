// reference： https://leetcode.com/problems/split-array-with-same-average/discuss/120667/C%2B%2B-Solution-with-explanation-early-termination-(Updated-for-new-test-case)
// https://leetcode.com/problems/split-array-with-same-average/discuss/728030/Java-Combinations-vs-DFS

/*
*   [A] --> [B, C]  array A split to two parts, sub-Array B and sub-Array C
*   Based on simple math formula induction
*   average = total_sum(A) / N, ===> the average of B and the average of C would be the same as the average
*   assume length (B) = k  ===>  k  = N / 2 && length(B) = length(c) = k  ===> average  = sum(B) / k = sum(C) / k
*   ===> average = sum(B) / k = Sum(c) / (n - k)
*   ===> total_sum(A) / N = sum(B) / k
*   ===> sum(B) = total_sum(A) / N * k
*   ===> since sum(A), N, and sum(B) are all integers
*   ===> total_sum(A) * k % N == 0, otherwise, sum(B) can not be integer
*   ====> if find the above conditon, then there exists at least one k match the requirement, can break the loop
*   ===> if can not find any conditon matches the requirement, return false
*/

class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int N = A.length;
        int totalSum = 0;
        for(int num: A){
            totalSum += num;
        }
       Arrays.sort(A);
        int k = N / 2;
        for(int i = 1; i <= k; ++i){
            if(totalSum * i % N == 0){
                if(combinationOfSum(A, totalSum * i / N, i, 0)){
                    return true;
                }
                
            }
        }
        
      return false;
        
    }
    
    private boolean combinationOfSum(int[] A, int sum, int k, int index){
        if (k == 0) return sum == 0;
        if(sum < 0 || index >= A.length){
            return false;
        }
        if(A[index] * k > sum){
            return false;
        }
        if(k == 0){
            return sum == 0;
        }
        for(int i = index; i <= A.length - k; ++i){
            if (i > index && A[i] == A[i - 1]) continue;
            if(A[i] <= sum && combinationOfSum(A, sum - A[i], k - 1, i + 1)){
                return true;
            }
        }
        return false;
    }  
}