package Graph;

import java.util.ArrayList;

public class TravellingSalesmanRunner {
	
	public static void main(String[] args)
	{
		String[] s = new String[]{"LA", "NYC", "BASKING RIDGE", "MORRISTOWN"};
		Integer rand = (int)(Math.random()*10);
		
		Vertex<String> v1 = new Vertex<String>("LA");
		Vertex<String> v2 = new Vertex<String>("NYC");
		Vertex<String> v3 = new Vertex<String>("BASKING RIDGE");
		Vertex<String> v4 = new Vertex<String>("MORRISTOWN");
		
		v1.addPointer(v2, 1);
		v1.addPointer(v3, 0);
		v1.addPointer(v4, 0);
		v2.addPointer(v1, 0);
		v2.addPointer(v3, 2);
		v2.addPointer(v4, 0);
		v3.addPointer(v1, 0);
		v3.addPointer(v2, 0);
		v3.addPointer(v4, 3);
		v4.addPointer(v1, 4);
		v4.addPointer(v2, 0);
		v4.addPointer(v3, 0);
		
		ArrayList<Vertex> list = new ArrayList<Vertex>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		
		Integer distance = 0;
		Vertex<String> cur;
		for(int i = 0; i < list.size(); i++)
		{
			cur = list.get(i);
			// final index
			if(i == list.size() - 1)
			{
				System.out.println("entered" + distance);
				for(int j = 0; j < cur.pointers.size(); j++)
				{
					System.out.println(cur.getValue());
				}
				System.out.println(cur.values);
				distance += cur.visitOther(list.get(0));
			}
			// other indices
			else
			{
				distance += cur.visitOther(list.get(i+1));
			}
		}
		
		System.out.println(distance);
	}
	

}
