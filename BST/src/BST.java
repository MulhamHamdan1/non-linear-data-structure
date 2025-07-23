import java.util.ArrayList;

public class BST {

    Node root;

    // ✅---------------- INSERTION ----------------

    Node insert(int value) {
        root = insertRec(root, value);
        return root;
    }

    private Node insertRec(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        return root;
    }

    void normalInsert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Node curRoot = root;
        while (curRoot != null) {
            if (value < curRoot.value) {
                if (curRoot.left == null) {
                    curRoot.left = newNode;
                    return;
                } else {
                    curRoot = curRoot.left;
                }
            } else if (value > curRoot.value) {
                if (curRoot.right == null) {
                    curRoot.right = newNode;
                    return;
                } else {
                    curRoot = curRoot.right;
                }
            } else {
                break;
            }
        }
    }

    // ✅---------------- SEARCH ----------------

    boolean search(int value) {
        return searchRec(value, root);
    }

    private boolean searchRec(int value, Node root) {
        if (root == null)
            return false;
        if (value == root.value)
            return true;
        if (value < root.value)
            return searchRec(value, root.left);
        else
            return searchRec(value, root.right);
    }

    boolean normalSearch(int value) {
        Node cur = root;
        while (cur != null) {
            if (value < cur.value)
                cur = cur.left;
            else if (value > cur.value)
                cur = cur.right;
            else
                return true;
        }
        return false;
    }

    // ✅---------------- TRAVERSALS ----------------

    void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root == null)
            return;
        inOrderRec(root.left);
        System.out.print(root.value + " ---> ");
        inOrderRec(root.right);
    }

    void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    void preOrderRec(Node root) {
        if (root == null)
            return;
        System.out.print(root.value + " ---> ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    void postOrderRec(Node root) {
        if (root == null)
            return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.value + " ---> ");
    }

    // ✅---------------- DELETE ----------------

    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
        if (root == null)
            return null;

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Leaf
            if (root.left == null && root.right == null)
                return null;

                // One child
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

                // Two children
            else {
                Node cur = maxRec(root.left);
                root.value = cur.value;
                root.left = deleteRec(root.left, cur.value);
            }
        }
        return root;
    }

    // ✅---------------- HEIGHT ----------------

    int heightOfTree() {
        return height(root);
    }

    int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // ✅---------------- MAX & MIN VALUE ----------------

    Node max() {
        return maxRec(root);
    }

    Node maxRec(Node root) {
        if (root.right == null)
            return root;
        return maxRec(root.right);
    }

    Node min(){
        return minRec(root);
    }

    Node minRec(Node root){
        if (root.left==null)
            return root;
        return minRec(root.left);
    }
    // ✅---------------- CHECK EQUALITY ----------------
    boolean checkEquality(BST tree){

        return checkEqualityRec(tree.root, root);
    }
    boolean checkEqualityRec(Node node1, Node node2){
        if (node1==null &&node2==null)
            return true;
        if (node1==null || node2==null)
            return false;
        if (node2.value != node1.value)
            return false;

        return checkEqualityRec(node1.left, node2.left) && checkEqualityRec(node1.right,node2.right);
    }

    // ✅---------------- VALIDATING BST ----------------


    static boolean validating(BST tree){
        return validatingRec(tree.root, -999999, 999999);
    }

   private static boolean validatingRec(Node root, int l, int r){
        if (root==null)
            return true;
        if (root.value<=l||root.value>=r)
            return false;

        return validatingRec(root.left,l,root.value) && validatingRec(root.right, root.value,r);

    }

    // ✅---------------- PRINT IN DISTANCE K ----------------

    void printDistanceAway(int distance){
        var list = new ArrayList<Integer>();
        DistanceRec(root,distance,0, list );
        for (var x: list)
            System.out.print(x + " ");
       // System.out.println();
    }

    void DistanceRec(Node root, int distance,int curDistance,  ArrayList<Integer> list){
        if(root==null)
            return;
        if (curDistance==distance){
            list.add(root.value);
        }
        DistanceRec(root.left, distance, curDistance+1, list);
        DistanceRec(root.right, distance, curDistance+1, list);
    }
    // ✅---------------- PRINT IN LEVEL ORDER TRAVERSAL ----------------

    void printInLevelOrder(){
        var list = new ArrayList<Integer>();
        inOrderLevelRec(root, list);
        for (var x : list)
            System.out.print(x +  " ");
        System.out.println();
    }

    void inOrderLevelRec(Node root , ArrayList<Integer> list){
        if (root == null)
            return;
        list.add(root.value);
        inOrderLevelRec(root.left, list);
        inOrderLevelRec(root.right, list);
    }

    void printInLevelOrderWithDistance(){
        for (int i=0; i<=heightOfTree(); i++){
            printDistanceAway(i);
        }
    }

}
