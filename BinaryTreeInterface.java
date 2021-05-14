package question3;

public interface BinaryTreeInterface<E>{
	
	// original model for binary


	Position<E> start();

	int size();
	boolean isEmpty();

	Position<E> parent(Position<E> p);
	boolean isStart(Position<E> p);

	Position<E> left(Position<E> p);
	Position<E> right(Position<E> p);

	Position<E> sibling(Position<E> p); 


	} 