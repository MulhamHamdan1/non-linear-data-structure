public class Main {
    public static void main(String[] args) {

        BST bst = new BST();
        bst.normalInsert(5);
        bst.normalInsert(7);
        bst.normalInsert(6);
        bst.insert(10);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(11);
        System.out.println("height = " +bst.heightOfTree());
        System.out.println("is 12 exist: "+bst.normalSearch(12));
        System.out.println("pre order travers: ");
        bst.preOrder();
        System.out.println("in order travers: ");
        bst.inOrder();
        System.out.println("post order travers: ");
        bst.postOrder();
        bst.delete(5 );
        System.out.println("the in order after deleting 5 element: ");
        bst.inOrder();

        System.out.println("max = " +bst.max().value);

        System.out.println("min =  "+ bst.min().value);
        System.out.println("is equal itself: "+ bst.checkEquality(bst));
        System.out.println("is valid BST: "+BST.validating(bst));
        System.out.print("the element its distance 2: ");
        bst.printDistanceAway(2);
        System.out.println();
        System.out.println("Breadth \'level order\' traverse: ");
        bst.printInLevelOrder();
        bst.printInLevelOrderWithDistance();
    }





}