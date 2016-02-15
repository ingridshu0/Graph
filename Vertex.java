package Graph;

import java.util.ArrayList;

/**
 * Representation of vertices that contain a generic object
 * Representation of edges between vertices that have a cost associated with them 
 * Edges can be 1-directional
 * Vertices know whether or not they have been visited
 * Way to traverse from 1 vertex to others
 * @author ingrid
 *
 * @param <E>
 */
public class Vertex<E> {
	
	public ArrayList<Vertex<E>> pointers = new ArrayList<Vertex<E>>();
	public ArrayList<Integer> values = new ArrayList<Integer>();
	private E obj;
	private boolean visited;
	
	/**
	 * Constructor
	 */
	public Vertex(E o)
	{
		obj = o;
		visited = false;
	}
	
	
	/**
	 * Adds the given vertex and value to corresponding indices
	 * Creates a pointer to this Vertex from v also
	 * Returns false if v is already in values
	 * 
	 * @param v
	 * @param distance
	 * @return if v and distance were successfully added to their own ArrayLists
	 */
	public boolean addPointer(Vertex<E> v, int distance)
	{
		if(pointers.contains(v))
		{
			return false;
		}
		
		pointers.add(v);
		values.add(distance);
		v.addPointer(this, distance);
		return true;
	}
	
	
	/**
	 * Finds distance from this to v
	 * Returns -1 if this does not contain a pointer to v
	 * 
	 * @param v
	 * @return distance from this to v
	 */
	public Integer visitOther(Vertex<E> v)
	{
		if(pointers.contains(v) != true)
		{
			return -1;
		}
		
		// find index of v in pointers
		Integer index = findIndex(v);
		// return corresponding distance from this to v
		return values.get(index);
	}
	
	
	/**
	 * @precondition pointers contains vertex
	 * @param vertex
	 * @return 
	 */
	private Integer findIndex(Vertex<E> vertex)
	{
		Integer index = 0;
		for(Vertex<E> v : pointers)
		{
			if(v.getValue().equals(vertex.getValue()))
			{
				return index;
			}
			index++;
		}
		
		return index;
	}
	
	
	/**
	 * Returns object contained in given vertex
	 * @return object contained in given vertex
	 */
	public E getValue()
	{
		return obj;
	}
	
	
	/**
	 * Returns whether the current vertex has been visited
	 * @return whether the current vertex has been visited
	 */
	public boolean getVisited()
	{
		return visited;
	}
	
	
	/**
	 * Accessor
	 * If the Vertex has been visited
	 */
	public void setVisited()
	{
		visited = true;
	}
	
	
}
