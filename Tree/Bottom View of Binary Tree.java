class Solution
{
    static ArrayList <Integer> bottomView(Node root)
    {
      Queue<Pair> q=new ArrayDeque<>();
      Map<Integer,Integer> map= new TreeMap<>();
      q.add(new Pair(0,root));
      while(!q.isEmpty()){
          Pair cur=q.poll();
          map.put(cur.hd,cur.node.data);
          if(cur.node.left!=null)
                q.add(new Pair(cur.hd-1,cur.node.left));
          if(cur.node.right!=null)
                q.add(new Pair(cur.hd+1,cur.node.right));
      }
      ArrayList<Integer> ans=new ArrayList<>();
      for(Map.Entry<Integer,Integer>entry:map.entrySet())
      ans.add(entry.getValue());
      return ans;
      
    }
    static class Pair{
        int hd;
        Node node;
        public Pair(int hd,Node node){
            this.hd=hd;
            this.node=node;
        }
    }
}
/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. 
For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
 

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

Thus nodes of the binary tree will be
printed as such 3 1 2.
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
