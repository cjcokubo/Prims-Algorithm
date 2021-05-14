package question3;

public class demoTree{
	
	public static void main(String[] args){
		
		PrimsAlgorithm prims = new PrimsAlgorithm(50, 50);
		Boolean start = prims.getArr()[0][0];
		Boolean end = prims.getArr()[prims.getRow()-1][prims.getCol()-1];
		
		MySimpleBinaryTree<Boolean> myBT = new MySimpleBinaryTree<>();
	
		// Binary Tree
		Boolean element = start;
		
		Position<Boolean> node = myBT.addStart(element);
		Position<Boolean> top_node = null;
		Position<Boolean> bottom_node = myBT.addBottom(node, prims.getArr()[1][0]);
		Position<Boolean> left_node = null;
		Position<Boolean> right_node = myBT.addRight(node, prims.getArr()[0][1]);
		
		//System.out.println(myBT.children(node));
		System.out.println(myBT.returnNodeValue(bottom_node));
		System.out.println(myBT.returnNodeValue(right_node));

	}


}