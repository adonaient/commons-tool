package com.adonai.tool.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.adonai.tool.date.DateHandler;
import com.adonai.tool.math.MathHandler;

public class ListHandler {
	public static int getRemoveDuplicatesCnt(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		int trInt;
		for (trInt = 0; trInt < array.length; ++trInt) {
			set.add(Integer.valueOf(array[trInt]));
		}
		trInt = set.size();
		return trInt;
	}

	public static <E> List<E> subList(List<E> aList, int size) {
		int lastIdx = aList.size();
		int startIdx = lastIdx - size;
		if (startIdx < 0) {
			startIdx = 0;
		}
		return aList.subList(startIdx, lastIdx);
	}

	public static <E> List<E> subList(List<E> aList, int cnt, int rm) {
		int lastIdx = aList.size() - rm;
		int startIdx = lastIdx - cnt;
		if (startIdx < 0) {
			startIdx = 0;
		}
		if (lastIdx < 0) {
			lastIdx = 0;
		}
		return aList.subList(startIdx, lastIdx);
	}

	public static <T> void setList(List<T> aList, T addVal, int cnt) {
		if (addVal == null) {
			return;
		}
		aList.add(addVal);

		while (aList.size() > cnt) {
			aList.remove(0);
		}

	}

	public static void setTimeListSec(List<Integer> aList, int time, int sec) {
		aList.add(Integer.valueOf(time));

		while (DateHandler.getTimeGapSec(time, ((Integer) aList.get(aList.size() - 1)).intValue()) > sec) {
			aList.remove(0);
		}

	}

	public static double getIntegerListAvg(List<Integer> aList, int upto) {
		double rtVal = 0.0D;
		int listSize = aList.size();
		if (listSize - upto >= 0) {
			for (int i = listSize - 1; i >= listSize - upto; --i) {
				rtVal += (double) ((Integer) aList.get(i)).intValue();
			}
		}

		return rtVal / (double) upto;
	}

	public static double getDoubleListAvg(List<Double> aList) {
		double rtVal = 0.0D;
		int listSize = aList.size();

		for (int i = 0; i < listSize; ++i) {
			rtVal += ((Double) aList.get(i)).doubleValue();
		}

		return rtVal / (double) listSize;
	}

	public static double getIntegerListAvg(List<Integer> aList) {
		double rtVal = 0.0D;
		int listSize = aList.size();

		for (int i = 0; i < listSize; ++i) {
			rtVal += (double) ((Integer) aList.get(i)).intValue();
		}

		return rtVal / (double) listSize;
	}

	public static double getDoubleListSum(List<Double> aList, int size) {
		double sum = 0.0D;
		int listSize = aList.size();
		if (listSize >= size) {
			for (int i = 0; i < listSize; ++i) {
				sum = MathHandler.getAdd(sum, ((Double) aList.get(i)).doubleValue());
			}
		}

		return sum;
	}

	public static int getIntegerListSum(List<Integer> aList, int size) {
		int sum = 0;
		int listSize = aList.size();
		if (listSize >= size) {
			for (int i = 0; i < listSize; ++i) {
				sum += ((Integer) aList.get(i)).intValue();
			}
		}

		return sum;
	}

	public static int getIntListSumUpto(List<Integer> aList, int upto) {
		int sum = 0;
		int aListSize = aList.size();
		if (aListSize - upto >= 0) {
			for (int i = aListSize - 1; i >= aListSize - upto; --i) {
				sum += ((Integer) aList.get(i)).intValue();
			}
		}

		return sum;
	}
}
