package com.adonai.tool.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
//	public static void main(String[] args) {
//		System.out.println(getNoExtension("abdasdgagif"));
//	}
	public static <T> boolean creatDir(T fileInfo) {
		if (fileInfo == null) {
			return false;
		}
		File file = fileConverter(fileInfo);
		File fileDir = fileConverter(file.getPath());
		return !fileDir.isDirectory() ? fileDir.mkdirs() : false;
	}

	public static <T> File fileConverter(T para) {
		return para instanceof String ? new File((String) para) : (para instanceof File ? (File) para : null);
	}

	/**
	 * 확장자 출력
	 * @param filename 파일명
	 * @return 확장자만 출력한다.
	 */
	public static String getExtension(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1);
	}

	/**
	 * 파일명만 받아야한다.
	 * @param filename 파일명
	 * @return 파일명 출력
	 */
	public static String getNoExtension(String filename) {
		int lastIdx = filename.lastIndexOf(".");
		if (lastIdx != -1) {
			return filename.substring(0, lastIdx);
		}
		return filename;
	}

	/**
	 * 파일명만 받아야한다.
	 * @param filename 파일명
	 * @return 파일명, 확장자 배열출력
	 */
	public static String[] getFilenameAry(String filename) {
		String[] strAry = { getNoExtension(filename), getExtension(filename) };
		return strAry;
	}

	private static List<String> extList = new ArrayList<String>();

	/**
	 * 폴더내 확장자 종류별로 뽑아내기
	 * @return 
	 */
	/**
	 * 폴더내 확장자 종류별로 뽑아내기
	 * @param folder 폴더정보를 파일에넣어서 입력
	 * @return 확장자들
	 */
	public static List<String> getAllExtensionList(final File folder) {
		boolean existExt = false;
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				getAllExtensionList(fileEntry);
			} else {
				existExt = false;
				System.out.println(fileEntry);
				String extname = FileHandler.getExtension(fileEntry.getName()).toLowerCase();
				for (String ext : extList) {
					if (extname.equals(ext)) {
						existExt = true;
						break;
					}
				}
				if (!existExt) {
					extList.add(extname);
					System.out.println(extname);
				}
			}
		}
		return extList;
	}
	
	public static void copyFile(File file, File mfile){
		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			inStream = new FileInputStream(file); // 원본파일
			outStream = new FileOutputStream(mfile); // 이동시킬 위치

			byte[] buffer = new byte[1024];

			int length;

			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				outStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
