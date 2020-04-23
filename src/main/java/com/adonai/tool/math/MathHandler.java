package com.adonai.tool.math;

public class MathHandler {
	public static void main(String[] args) {
		System.out.println(getPercentage(350.5484D, 356.1613D));
	}

	public static double getGrowRate(double start, double end) {
		return start != 0.0D && end != 0.0D ? (end - start) / Math.abs(start) * 100.0D : 0.0D;
	}

	public static <T extends Number> Double getSubtract(T org, T sub) {
		if (org == null || sub == null) {
			return null;
		}
		return (double) Math.round((org.doubleValue() - sub.doubleValue()) * 100.0D) / 100.0D;
	}

	public static double getAdd(double org, double add) {
		return (double) Math.round((org + add) * 100.0D) / 100.0D;
	}

	public static double getMultiply(double org, double add) {
		return (double) Math.round((org * add) * 100.0D) / 100.0D;
	}

	public static double getPercentage(double numerator, double denominator) {
		return numerator != 0.0D && denominator != 0.0D ? numerator / denominator * 100.0D : 0.0D;
	}

	public static double getFluctuationRate(double start, double end) {
		return (end / start - 1.0D) * 100.0D;
	}

	/**
	 * point 값에 따라서 소수점을 자른다.
	 * 
	 * @param source 변경할 실수
	 * @param point  소수점 자를 자릿수
	 * @return 자른소수점
	 */
	public static double getRound(double source, int point) {
		double pow = Math.pow(10, point);
		return Math.round(source * pow) / pow;
	}
}
