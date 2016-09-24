public class BinarySearchTree implements TreeInterface
{
	TreeNode root;
	TreeNode current;
	TreeNode temp;

	boolean wentLeft;
	boolean wentRight;

	/**
	 * default constructor
	 */
	public BinarySearchTree()
	{
		root = null;
		temp = root;
		current = null;
		wentLeft = false;
		wentRight = false;
	}

	/**
	 * inserts the specified value into the
	 * binary search tree
	 */
	public void insert(int num) 
	{
		if (root == null)
		{
			root = new TreeNode(num);
			current = root;
		}
		else if (current.value == num)
		{
			System.out.println("This element already exists.");
		}
		else
		{
			if (num > current.value)
			{
				if (current.right == null)
				{
					current.right = new TreeNode(num);
					current = root;
				}
				else
				{
					current = current.right;
					insert(num);
				}
			}
			else if (num < current.value)
			{
				if (current.left == null)
				{
					current.left = new TreeNode(num);
					current = root;
				}
				else
				{
					current = current.left;
					insert(num);
				}
			}
		}
	}

	/**
	 * the user speceifies a value to be removed
	 * and the method finds and removes the node
	 * with that value
	 * 
	 */
	public void delete(int num) 
	{
		// if the root is the value we want to delete
		if (root.value == num)
		{
			temp = root.right;
			root = root.left;
			root.right = temp;
			
			// reset current back to the root for the next 
			// insert or delete
			current = root;
		}
		else if(num < current.value && current.left != null) // move down the left
		{
			wentLeft = true;
			wentRight = false;

			temp = current;
			current = current.left;
			delete(num);
		}
		else if (num > current.value && current.right != null) // move down the right
		{
			wentLeft = false;
			wentRight = true;

			temp = current;
			current = current.right;
			delete(num);
		}
		else if (num == current.value)
		{
			// if the node we want to delete is a leaf node
			if (current.left == null && current.right == null)
			{
				// up to this point, temp is used to track the parent
				// of current so that it is easier to remove the parent's
				// reference
				if (wentLeft)
				{
					temp.left = null;
					current = root;
				}
				else if (wentRight)
				{
					temp.right = null;
					current = root;
				}
			}
			else
			{
				if (current.left != null)
				{
					temp = current.left;
					while (temp.right != null)
					{
						temp = temp.right;
					}
					temp.right = current.right;
					current = root;
				}
				else if (current.right != null)
				{
					temp = current.right;
					while (temp.left != null)
					{
						temp = temp.left;
					}
					temp.left = current.left;
					current = root;
				}
			}
		}
		else // didn't find the value anywhere
		{
			System.out.print("A node with value " + num + " does not exist.");
		}
	}

	/**
	 * displays the values of the various nodes
	 * in the tree
	 */
	public void dumpTree() 
	{
		
		System.out.println("Dumping tree:");
		System.out.print("\n");
		printTree(this.root, 0);
		System.out.print("\n");
	}

	/**
	 * count the number of levels as you recursively call
	 * the method while going down the tree. Handle 
	 * everything right of the root first, then print
	 * the root value, then display the rest of the
	 * elements to the left.
	 * 
	 * @param root
	 * @param level
	 */
	public static void printTree(TreeNode node, int level)
	{
		if(node == null)
		{
			return;
		}
		
		printTree(node.right, level+1);

		if (level != 0)
		{
			for (int i = 0; i < level - 1; i ++)
			{
				System.out.print("|\t");
			}
			System.out.println("|-------" + node.value);
		}
		else
		{
			System.out.println(node.value);
		}

		printTree(node.left, level+1);
	}
}
