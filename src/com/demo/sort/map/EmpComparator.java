package com.demo.sort.map;

import java.util.Comparator;

public class EmpComparator implements Comparator<Employee> {

	private boolean keepDuplicate;
	private boolean reverse;

	/**
	 * By default duplicacy is allowed while sorting. Use parameterized constructors
	 * to control over duplicacy and sorting order.
	 */
	public EmpComparator() {
		this(true);
	}

	/**
	 * @param keepDuplicate
	 *            is to indicate if need to keep the duplicate values in sorted set
	 *            because that value is not duplicate in {@code}Map as
	 *            {@code}HashMap compares Keys to check duplicacy.
	 */
	public EmpComparator(boolean keepDuplicate) {
		this(keepDuplicate, false);
	}

	/**
	 * @param keepDuplicate
	 *            is to indicate if need to keep the duplicate values in sorted set
	 *            because that value is not duplicate in {@code}Map as
	 *            {@code}HashMap compares Keys to check duplicacy.
	 * @param reverse
	 *            is the indicator which can set set to {@literal}true if sorting is
	 *            to be done in descending order.
	 */
	public EmpComparator(boolean keepDuplicate, boolean reverse) {
		this.keepDuplicate = keepDuplicate;
		this.reverse = reverse;
	}

	@Override
	public int compare(Employee arg0, Employee arg1) {
		int retVal;
		if (arg0 == arg1) {
			retVal = 0;
		} else if (arg0 == null) {
			retVal = -1;
		} else if (arg1 == null) {
			retVal = 1;
		} else {
			String name0 = arg0.getName();
			String name1 = arg1.getName();
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
		retVal = this.reverse ? -retVal : retVal;
		return this.keepDuplicate ? (retVal == 0 ? -1 : retVal) : retVal;
	}

}
