package com.demo.sortedmap;

import java.util.Comparator;
import java.util.Map.Entry;

public class EmpEntryComparator implements Comparator<Entry<Object, Employee>> {
	boolean keepDuplicate;

	/**
	 * By default duplicacy is allowed while sorting. Use parameterized contractor
	 * to control over duplicacy.
	 */
	public EmpEntryComparator() {
		this(true);
	}

	/**
	 * @param keepDuplicate
	 *            is to indicate if need to keep the duplicate values in sorted set
	 *            because that value is not duplicate in @Map as @HashMap compares
	 *            Keys to check duplicacy.
	 */
	public EmpEntryComparator(boolean keepDuplicate) {
		this.keepDuplicate = keepDuplicate;
	}

	/**
	 * This method compares two Entry's objects.
	 * 
	 * @param arg0
	 *            is the first argument to compare
	 * @param arg1
	 *            is the second argument to compare
	 * @return int value: if arg0 < arg1 then -1, if arg0 == arg1 then 0 and if arg0
	 *         > arg1 then 1.
	 */
	@Override
	public int compare(Entry<Object, Employee> arg0, Entry<Object, Employee> arg1) {
		int retVal;
		if (arg0 == arg1) {
			retVal = 0;
		} else if (arg0 == null) {
			retVal = -1;
		} else if (arg1 == null) {
			retVal = 1;
		} else {
			Employee emp0 = (Employee) arg0.getValue();
			Employee emp1 = (Employee) arg1.getValue();
			if (emp0 == emp1) {
				retVal = 0;
			} else if (emp0 == null) {
				retVal = -1;
			} else if (emp1 == null) {
				retVal = 1;
			} else {
				String name0 = emp0.getName();
				String name1 = emp1.getName();
				if (name0 == name1) {
					retVal = 0;
				} else if (name0 == null) {
					retVal = -1;
				} else if (name1 == null) {
					retVal = 1;
				} else {
					retVal = name0.compareTo(name1);
				}
			}
		}
		return keepDuplicate ? (retVal == 0 ? -1 : retVal) : retVal;
	}
}
