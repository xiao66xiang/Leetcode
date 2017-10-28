/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    set<int> s;
    void search(TreeNode* root) {
            if (root!=NULL) s.insert(root->val);
            if (root->left!=NULL) search(root->left);
            if (root->right!=NULL) search(root->right);
        }
    int findSecondMinimumValue(TreeNode* root) {
        search(root);
        if (s.size()<2) return(-1);
        else {
            int smallest=-1, second=-1;
            for (set<int>::iterator i=s.begin();i!=s.end();i++)
                if (*i<smallest || smallest==-1) smallest=*i;
            for (set<int>::iterator i=s.begin();i!=s.end();i++)
                if (*i>smallest&&(*i<second||second==-1)) second=*i;
            return(second);
        }
        
    }
};