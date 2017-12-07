package com.demo.sortedmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	/**
	 * Demo of sorting @HashMap values based on values's one property. Ex: The
	 * entries in map with Key as Object and Value as @Employee. The sorting of
	 * entries will be based on name of @Employee
	 */

	public static void main(String[] args) {

		Map<Object, Employee> map = new HashMap<Object, Employee>();

		map.put(1, new Employee(1, "A"));
		map.put('2', new Employee(2, "Y"));
		map.put("3", new Employee(3, "X"));
		map.put(true, new Employee(4, "B"));
		map.put(null, new Employee(5, "C"));
		map.put(4.5, new Employee(6, null));
		map.put(false, new Employee(null, "S"));
		map.put(6, new Employee());
		map.put(-10, new Employee(7, "C"));

		System.out.println("Before sort");
		System.out.println(map);

		Set<Entry<Object, Employee>> values = map.entrySet();
		
		EmpEntryComparator myComparator = new EmpEntryComparator(true, true);
		
		SortedSet<Entry<Object, Employee>> treeSet = new TreeSet<Entry<Object, Employee>>(myComparator);

		treeSet.addAll(values);

		System.out.println("After sort");
		System.out.println(treeSet);
	}
}
