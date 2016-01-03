package java_basis_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTraverse {
	
	private HashMap< String, Integer > map = null;
	
	public MapTraverse(){
		this.map = new HashMap< String, Integer >();
	}
	
	public MapTraverse( HashMap< String, Integer > map ){
		this.map = map;
	}
	
	
	public void Traverse_1(){
		for( String key : map.keySet() ){
			System.out.println( "key = " + key + " value = " + map.get( key ) );
		}
	}
	
	
	public void Traverse_2(){
		Iterator iter = this.map.entrySet().iterator();
		while( iter.hasNext() ){
			Map.Entry< String, Integer > entry = ( Entry< String, Integer > ) iter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println( "key = " + key + " value = " + value );
		}
	}
	
	public void Traverse_3(){
		for( Map.Entry< String, Integer > entry : map.entrySet() ){
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println( "key = " + key + " value = " + value );
		}
	}
	
	public void Traverse_4(){
		for( Integer value : map.values() ){
			System.out.println( "value = " + value );
		}
	}
	
	public static void main(String[] args) {
		HashMap< String, Integer > map = new HashMap< String, Integer >();
		map.put( "A", 5 );
		map.put( "B", 6 );
		map.put( "C", 7 );
		map.put( "D", 9 );
		map.put( "E", 2 );
		MapTraverse mapTra = new MapTraverse( map );
		
		Long t1 = System.currentTimeMillis();
		mapTra.Traverse_1();
		Long t2 = System.currentTimeMillis();
		System.out.println("traverse_1 cost " + ( t2 - t1 ) + "ms" );
		
		t1 = System.currentTimeMillis();
		mapTra.Traverse_2();
		t2 = System.currentTimeMillis();
		System.out.println("traverse_2 cost "+ ( t2 - t1 ) + "ms" );
		
		t1 = System.currentTimeMillis();
		mapTra.Traverse_3();
		t2 = System.currentTimeMillis();
		System.out.println("traverse_3 cost "+ ( t2 - t1 ) + "ms" );
		t1 = System.currentTimeMillis();
		mapTra.Traverse_4();
		t2 = System.currentTimeMillis();
		System.out.println("traverse_4 cost "+ ( t2 - t1 ) + "ms" );
		
		
	}
	

}
