package question3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MySimpleBinaryTree<E> implements BinaryTreeInterface<E>, Iterable<E>{
	PrimsAlgorithm prims = new PrimsAlgorithm(50, 50);

	private int size = 0;
	private Node<E> start = null;
	//private Node<E> end = null;
		
	private static class Node<E> implements Position<E>{
		private E element;
		private Node<E> parent;
		private Node<E> bottom;
		private Node<E> left ;
		private Node<E> right;

		public Node(E e, Node<E> above, Node<E> below, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			bottom = below;
			left = leftChild;
			right = rightChild;
		}

		public Node<E> getParent(){ return parent; }
		public Node<E> getBottom(){ return bottom; }
		public Node<E> getLeftChild(){ return left; }
		public Node<E> getRightChild(){ return right;} 

		public void setBottom(Node<E> bottomNode){ bottom  = bottomNode; }
		public void setLeft(Node<E> leftNode){ left  = leftNode; }
		public void setRight(Node<E> rightNode){ right = rightNode; }


		public E getElement(){ return element;}
		public void setElement(E newElement){ element=newElement; }

		} // end of Node class 

	public MySimpleBinaryTree(){}

	public Position<E> start(){ return start; }

	public int size(){return size; }
	public boolean isEmpty(){ return size == 0 ; }

	private Node<E> validate(Position<E> p){
		// assume that the position is a valid node 
		Node<E> mynode = (Node<E>) p;

		return mynode;
	}

	public Position<E> parent(Position<E> p){
		Node<E> myNode = validate(p);

		return myNode.getParent();
	}
	
	public boolean isStart(Position<E> p){
		Node<E> myNode = validate(p);
		return (start == myNode);
	}
	
	public Position<E> bottom(Position<E> p){
		Node<E> myNode = validate(p);
		return myNode.getBottom();
	}
	public Position<E> left(Position<E> p){
		Node<E> myNode = validate(p);
		return myNode.getLeftChild();
	}
	public Position<E> right(Position<E> p){
		Node<E> myNode = validate(p);
		return myNode.getRightChild();
	}

	public Position<E> sibling(Position<E> p){
		Node<E> myNode = validate(p);
		Node<E> myNodeParent = myNode.getParent();

		if (myNode == myNodeParent.getLeftChild()) return myNodeParent.getRightChild();
		else return myNodeParent.getLeftChild();

	}


	public Position<E> addStart(E rootElement){
		Node<E> myNewRootNode = new Node(rootElement, null, null, null, null);
		start = myNewRootNode;

		return start;
	}
	
	public Position<E> addBottom(Position<E> p, E myvalue){
		Node<E> parentNode = validate(p);
		Node<E> myNewNode = new Node(myvalue, parentNode, null, null, null);

		myNewNode.setBottom(null);
		
		parentNode.setBottom(myNewNode);

		return myNewNode;
	}

	public Position<E> addLeft(Position<E> p, E myvalue){
		Node<E> parentNode = validate(p);
		Node<E> myNewNode = new Node(myvalue, null, null, null, parentNode);

		myNewNode.setLeft(null);
		
		parentNode.setLeft(myNewNode);

		return myNewNode;
	}

	public Position<E> addRight(Position<E> p, E myvalue){
		Node<E> parentNode = validate(p);
		Node<E> myNewNode = new Node(myvalue, null, null, parentNode, null);

		myNewNode.setRight(null);
		parentNode.setRight(myNewNode);

		return myNewNode;
	}


	public void set(Position<E> p, E myNewElement){
		Node<E> myNode = validate(p);

		myNode.setElement(myNewElement);
	}


	public E returnNodeValue(Position<E> p){
		Node<E> myNode = validate(p);

		return myNode.getElement(); 
	} 


	public List<Position<E>> children(Position<E> p){
		List<Position<E>> childrenList = new ArrayList<>(2);

		Node<E> my_current_node = validate(p);

		if (my_current_node.getBottom() !=null){
			childrenList.add(my_current_node.getBottom());
		}
		if (my_current_node.getLeftChild() !=null) {
		childrenList.add(my_current_node.getLeftChild());
		}
		if (my_current_node.getLeftChild() !=null){
		childrenList.add(my_current_node.getRightChild());
		}

		return childrenList;
	}

	private class TreeElementIterator implements Iterator<E>{
		// Iterator on elements
		Iterator<Position<E>> myPositionIterator; 

		public TreeElementIterator(){
			myPositionIterator = position().iterator();
		}

		public boolean hasNext(){
			// return next element 
			return myPositionIterator.hasNext();
		}

		public E next(){
			// return element of next node
			Position<E> myNextPosition = myPositionIterator.next();


			Node<E> myNextNode = validate(myNextPosition);
			return myNextNode.getElement();
		}


		public void remove(){
			// remove last element returned by next
		}

	}

	// ITERATOR ON ELEMENTS
	public Iterator<E> iterator(){ 
		
		Iterator<E> myIterator_on_Elements = new TreeElementIterator();

		return myIterator_on_Elements;
	 }

	// ITERATOR ON POSITIONS
	 public Iterable<Position<E>> position(){
	 	List<Position<E>> myPreorderList = new ArrayList<>();

	 	Position<E> p = start();

	 	preorder(myPreorderList,p);

	 	return myPreorderList;
	 }

	 private void preorder(List<Position<E>> mycurrentList, Position<E> p){
	 	mycurrentList.add(p);

	 	if(p!=null){
	 	for(Position<E> c : children(p)) preorder(mycurrentList, c);

	 	}
	 }
}
