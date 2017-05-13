package com.njust.servlet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getMD5 {
//	private static String password;
//	private static String name;
//	private static String id;
//	private static String md5;
	public static String makeMD5(String password) {
		MessageDigest md;
		   try {
		    // ����һ��MD5���ܼ���ժҪ
		    md = MessageDigest.getInstance("MD5");
		    // ����md5����
		    md.update(password.getBytes());
		    // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
		    // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
		    String pwd = new BigInteger(1, md.digest()).toString(16);
//		    System.err.println(pwd);
		    return pwd;
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   return password;
		}
}
