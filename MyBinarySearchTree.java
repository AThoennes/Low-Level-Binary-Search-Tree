/*
 * Alex Thoennes
 * 
 * Dr. Bishop
 * 
 * Assignment 4
 * 
 */
public class MyBinarySearchTree 
{
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(5);
		bst.insert(7);
		bst.insert(21);
		bst.dumpTree();
		bst.delete(20);
		bst.delete(21);
		bst.dumpTree();
		bst.delete(35);
	}
}
