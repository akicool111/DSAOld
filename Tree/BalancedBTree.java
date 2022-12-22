package binarytree;

public class BalancedBTree {

    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {

        }
        TreeNode(int val)
        {
            this.val=val;
            this.left=null;
            this.right=null;
        }
        TreeNode(int val,TreeNode left,TreeNode right)
        {
            this.val=val;
            this.left=left;
            this.right=right;
        }

    }
    class TreeData{
        private int ht;
        private boolean flg;

        TreeData()
        {

        }
        TreeData(int ht,boolean flg)
        {
            this.ht=ht;
            this.flg=flg;
        }
    }
    public static void main(String[] args) {

    }
    public TreeData dfs(TreeNode root)
    {
        if(root==null)
        {
            return new TreeData(0,true);
        }
        TreeData left=dfs(root.left);
        TreeData right=dfs(root.right);

       //boolean ans=false;
        /*if(Math.abs(left.ht-right.ht)<=1 && left.flg && right.flg)
        {
            ans=true;
        }*/
        boolean balance=Math.abs(right.ht-left.ht)<=1 && right.flg && left.flg;
        return new TreeData(Math.max(left.ht,right.ht)+1,balance);

    }
    public boolean isBalanced(TreeNode root)
    {
          return dfs(root).flg;
    }
}
