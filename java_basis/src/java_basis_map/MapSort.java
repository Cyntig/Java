package java_basis_map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapSort{
	
	public static class Point{
		private int x;
		private int y;
		
		public Point( int x, int y ){
			this.x = x;
			this.y = y;
		}
	}
	
	private LinkedHashMap< String, Point > map = null;
	
	public MapSort( ) {
		this.map = new LinkedHashMap< String, Point >();
	}
	public MapSort( LinkedHashMap< String, Point > map ){
		this.map = map;
	}
	public void  printMap( LinkedHashMap< String, Point > map ){
		Iterator< Map.Entry< String, Point > > iter = map.entrySet().iterator(); 
		while( iter.hasNext() ){
			Map.Entry< String, Point > entry = iter.next();
			String key = entry.getKey();
			System.out.println( key + ": x = " + entry.getValue().x + " y = " + entry.getValue().y );
		}
	}
	
	
	public void sortByKey( ){
		
		ArrayList< Map.Entry< String, Point > > list_data = 
								new ArrayList< Map.Entry< String, Point > >( this.map.entrySet() );
		Collections.sort( list_data, new Comparator< Map.Entry< String, Point > >(){

			@Override
			public int compare( Entry< String, Point > o1, Entry< String, Point > o2 ) {
				// TODO Auto-generated method stub
				if( o2.getKey().compareTo( o1.getKey() ) >= 0 ){
					return 1;
				}
				else{
					return -1;
				}
			}
		} );
		
		LinkedHashMap< String, Point > sorted_map = new LinkedHashMap< String, Point >();
		
		for( int i = 0; i < list_data.size(); i++ ){
			sorted_map.put( list_data.get( i ).getKey(), list_data.get( i ).getValue()  );
		}
		this.map = sorted_map;
		
	}
	
	
	public void sortByValue(  ){
		
		ArrayList< Map.Entry< String, Point > > list_data = 
							new ArrayList< Map.Entry< String, Point > >( this.map.entrySet() );
		
		Collections.sort( list_data, new Comparator< Map.Entry< String, Point > >(){

			@Override
			public int compare(Entry<String, Point> o1, Entry<String, Point> o2) {
				// TODO Auto-generated method stub
				if( Integer.valueOf( o2.getValue().x ).compareTo( Integer.valueOf( o1.getValue().x ) ) > 0 ){
					return 1;
				}
				else if( Integer.valueOf( o2.getValue().x ).compareTo( Integer.valueOf( o1.getValue().x ) ) < 0 ){
					return -1;
				}
				else{
					if( Integer.valueOf( o2.getValue().y ).compareTo( Integer.valueOf( o1.getValue().y ) ) > 0 ){
						return 1;
					}
					else{
						return -1;
					}
				}
			}
			
		} );
		
		LinkedHashMap< String, Point > sorted_map = new LinkedHashMap< String, Point >();
		
		for( int i = 0; i < list_data.size(); i++ ){
			sorted_map.put( list_data.get( i ).getKey(), list_data.get( i ).getValue() );
		}
		this.map = sorted_map;
	}
	
	
	public static void main(String[] args) {
		
		LinkedHashMap< String, Point > map = new LinkedHashMap< String, Point >();
		map.put( "A", new Point( 3, 6 ) );
		map.put( "B", new Point( 2, 8 ) );
		map.put( "C", new Point( 4, 5 ) );
		map.put( "D", new Point( 3, 7 ) );
		
		MapSort testSort = new MapSort( map );
		
		System.out.println("---------Original map-------");
		testSort.printMap( testSort.map );
		System.out.println("---------Sort by Key-------");
		testSort.sortByKey();
		testSort.printMap( testSort.map );
		System.out.println("---------Sort by value-------");
		testSort.sortByValue();
		testSort.printMap( testSort.map );
		
	
		
		return;
		
	}

	
}
