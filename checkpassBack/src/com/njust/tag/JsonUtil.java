package com.njust.tag;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;



public class JsonUtil {
	/**
	 * @param object
	 *            任意对象
	 * @return java.lang.String
	 */
	public static String objectToJson(Object object) {
		StringBuilder json = new StringBuilder();
		if (object == null) {
			json.append("\"\"");
		} else if (object instanceof String ) {
			json.append("\"").append((String) object).append("\"");
		} else if (object instanceof Boolean || object instanceof Integer || object instanceof Float) {
			json.append("\"").append(object.toString()).append("\"");
		} else {
			json.append(beanToJson(object));
		}
		return json.toString();
	}

	/**
	 * 功能描述:传入任意一个 javabean 对象生成一个指定规格的字符串
	 * 
	 * @param bean
	 *            bean对象
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod()
							.invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * 功能描述:通过传入一个列表对象,调用指定方法将列表中的数据生成一个JSON规格指定字符串
	 * 
	 * @param list
	 *            列表对象
	 * @return java.lang.String
	 */
	public static String listToJson(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	//我的自定义object转json工具类
	public static String myListToJson(List<?> list,String[]... propvalues) {
		StringBuilder json = new StringBuilder();
//		String[] props = (String[]) ArrayUtils.addAll(userPropvalues, visionPropvalues, schoolPropvalues);
		ArrayList<String> props = new ArrayList<String>();
		for(int i=0;i<propvalues.length;i++){
			for(int j=0;j<propvalues[i].length;j++){
				props.add(String.valueOf(propvalues[i][j]));
			}
		}
//				ArrayUtils.addAll(
//				new ArrayList<String>(Arrays.asList(userPropvalues)),
//				new ArrayList<String>(Arrays.asList(visionPropvalues)),
//				new ArrayList<String>(Arrays.asList(schoolPropvalues))
//				);
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(myObjectToJson(obj,props));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}
	
	public static String myObjectToJson(Object object,ArrayList<String> props) {
		Object[] obj=(Object[]) object;
//		String[] props = (String[]) ArrayUtils.addAll(userPropvalues, visionPropvalues);
		
		StringBuilder json = new StringBuilder();
		if (object == null || obj.length!=props.size()) {
			json.append("\"\"");
		} else {
			//拼接json
			json.append("{");
			for(int i=0;i<obj.length;i++){  
//		        System.out.println("obj[i]:"+obj[i]);  
				json.append("\"").append(props.get(i)).append("\"");
//		        json.append(props[i]);
				json.append(":");
				json.append("\"").append(obj[i]).append("\"");
//				json.append(obj[i]);
				json.append(",");
		    }
			json.setCharAt(json.length() - 1, '}');
		}
		return json.toString();
	}
	
	public static String msgToJson(String message) {
		StringBuilder json = new StringBuilder();
		if (message == null || message.equals("")) {
			json.append("\"\"");
		} else {
			//拼接json
			json.append("{");
			json.append("msg");
			json.append(":");
			json.append("\"").append(message).append("\"");
			json.append("}");
		}
		return json.toString();
	}
}
