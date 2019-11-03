import java.util.*;
public class SymmetricTree {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root = TreeNode.createBinaryTreeByArray(arr,0);
        Solution solution = new Solution();
        solution.isSymmetric(root);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public static TreeNode createBinaryTreeByArray(Integer []array,int index) {
        TreeNode tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> list = new ArrayList();
        traversal(list,root);
        if(list.size()==7){
            return true;
        }
        return false;
    }
    public void traversal(List<Integer> list,TreeNode root){
        if(root==null){
            return;
        }
        traversal(list,root.left);
        traversal(list,root.right);
//        list.add(root.val);
        System.out.print(root.val);
        traversal(list,root.left);
        traversal(list,root.right);
    }



    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}