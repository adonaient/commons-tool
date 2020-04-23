package com.adonai.tool.string;

import java.util.StringTokenizer;

public class StringHandler {
	public static String get1stTokenList(String word, String idx) {
		return word.substring(0, word.indexOf(idx, 0));
	}

	public static <T> String getStringFormat(String format, T i) {
		return String.format(format, new Object[] { i });
	}

	public static String[] getTokenAry(String word, String delim) {
		StringTokenizer st = new StringTokenizer(word, delim);
		int countTokens = st.countTokens();
		String[] rtval = new String[countTokens];
		for (int i = 0; i < countTokens; i++) {
			rtval[i] = st.nextToken();
		}

		// 남아 있는 토큰를 확인하고 while문으로 루핑
		// st = new StringTokenizer(word, "/");
		// while (st.hasMoreTokens()) {
		// String token = st.nextToken();
		// System.out.println(token);
		// }
		return rtval;
	}

	public static String getLPAD(int many, int cnt) {
		return String.format("%0" + many + "d", cnt);
	}
}
