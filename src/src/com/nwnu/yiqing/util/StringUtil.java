package com.nwnu.yiqing.util;
/**
 * �ַ������ò���
 *
 */
public class StringUtil {
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param college
	 * @return
	 */
	public static boolean isEmpty(String college){
		if(college == null)return true;
		if("".equals(college))return true;
		return false;
	}
	
	/**
	 * ���ɱ��
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String generateSn(String prefix,String suffix){
		String sn = prefix + System.currentTimeMillis() + suffix;
		return sn;
	}
	
	public static String convertToUnderLine(String str){
		String newStr = "";
		if(isEmpty(str))return "";
		for(int i=0;i<str.length(); i++){
			char c = str.charAt(i);
			if(Character.isUpperCase(c)){
				if(i == 0){
					newStr += Character.toLowerCase(c);
					continue;
				}
				newStr += "_" + Character.toLowerCase(c);
				continue;
			}
			newStr += c;
		}
		return newStr;
	}
}
