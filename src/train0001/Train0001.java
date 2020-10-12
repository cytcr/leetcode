package train0001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 *
 * @author TCR 670830864@qq.com
 * @date 2020/10/12 14:39
 */
public class Train0001 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例：
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
    */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] sum = Train0001.better_sum(nums,target);
        System.out.println("["+sum[0]+","+sum[1]+"]");
    }

    /**
     * 我的思路：先把数组转换成list列表，然后用target - nums[i]去list中匹配
    */
    public static int[] sum(int[] nums,int target){
        int[] resultNum = new int[2];
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i = 0;i < nums.length;i++){
            if(list.contains(target - nums[i])){
                return new int[]{list.indexOf(target - nums[i]),i};
            }
            list.add(i,nums[i]);
        }
        return resultNum;
    }

    /**
     * 更优思路:
     * 创建一个哈希表，对于每一个 nums[i]，我们首先查询哈希表中是否存在 target - nums[i]，
     * 然后将 nums[i] 插入到哈希表中，即可保证不会让 nums[i] 和自己匹配
     */
    public static int[] better_sum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
