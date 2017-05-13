package com.njust.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getProperDate {
	public static String makeProperDate(String date) {
		//�ȼ���Ƿ������ĸ���ǵĻ����ش�����Ϣ
		String regex=".*[a-zA-Z]+.*";
		
		
		String birthday = date;
		Calendar time = Calendar.getInstance();
//		try{
//			double tempdate = Double.parseDouble(date);
//			if(tempdate<100){
//				birthday = Math.floor(tempdate)+"";
//			}
//		}
//		catch(Exception e){
//			System.out.println("�û������޷�ת��double�ͣ�");
//		}
		
		try{

			Matcher m=Pattern.compile(regex).matcher(date);
			if(m.matches()){			//case0�����հ�����ĸ
				date="/";
				return date;
			}
			
			if(birthday.length()<=3 && birthday.length()>0 ){		//case1�����ճ���С�ڵ���3
				if(birthday.contains("/")){							//case1.1�������к���/����
					date="/";
					System.out.println("�û��������/����ѧ���������");
				}
				else if (Integer.parseInt(birthday)<150 && Integer.parseInt(birthday)>=0 ){		//case1.2�������������ͣ�0~150��������24��ת���ɵ����1992-01-01
						int tempage = time.get(Calendar.YEAR) - Integer.parseInt(birthday);
						date = tempage+"-01-01";
					}
				else{												//case1.3�������������Ϊ��/��
					date="/";
				}
			}
			else if(birthday.length()<=5){							//case2�����ճ��ȵ���4��5���������룬��92-5��92-05������19925
				if(birthday.contains("/") || birthday.contains("-") || birthday.contains(".")){		//case2.1���������룬92-5��92/5��92.05��������05-5��ȫ��ת��Ϊ��-������
					birthday=birthday.replace("/", "-");
					birthday=birthday.replace(".", "-");
					if( !birthday.endsWith("-") && !birthday.startsWith("-")){
						String[] temparray = birthday.split("-");
						if(temparray.length==2 && temparray[0].length()==2 && temparray[1].length()<=2){	//ֻ�������92-1��92-01��92-10��09-10��09-01��������ʽ��������9-12
							int birthyear = Integer.parseInt(temparray[0]);
							int birthmon = Integer.parseInt(temparray[1]);
							if(birthmon>=1 && birthmon<=12){	//�·�����Ϸ�
								if(birthyear<=time.get(Calendar.YEAR)-2000 && birthyear>=0){			//case2.2������0~16��Ĭ��Ϊ������
									if(birthyear<10 && birthyear>=0 ){								//С��10��һλ��
										if(birthmon<10){
											date = "200"+birthyear+"-0"+birthmon+"-01";
										}
										else{
											date = "200"+birthyear+"-"+birthmon+"-01";
										}
									}
									else{ //if(birthyear>=10){		//���ڵ���10����λ��
										if(birthmon<10){
											date = "20"+birthyear+"-0"+birthmon+"-01";
										}
										else{
											date = "20"+birthyear+"-"+birthmon+"-01";
										}
									}
								}
								else if(birthyear>time.get(Calendar.YEAR)-2000 && birthyear<=99){		//case2.3������16~99��Ĭ��Ϊ������
									//date = "19"+birthyear+"-0"+birthmon+"-01";
									if(birthmon<10){
										date = "19"+birthyear+"-0"+birthmon+"-01";
									}
									else{
										date = "19"+birthyear+"-"+birthmon+"-01";
									}
								}
								else{		//case2.4����ݲ��Ϸ������ָ���
									date="/";
								}
							}
							else{													//case2.5���·����벻�Ϸ�
								date="/";
							}
						}
						else{						//case2.6�������ӷ���4��5λ�����Ϸ�
							date="/";
						}
					}
					else{		//case2.7�����ӷ�λ�ò��Ϸ�
						date="/";
					}
				}
				else if(birthday.length()==4){
					if( Integer.parseInt(birthday)>=1900 && Integer.parseInt(birthday)<=time.get(Calendar.YEAR) ){//case2.8������4λ���Ϸ�������
						date = birthday+"-01-01";
					}
					else{ 
						date = "/";		//case2.9������4λ�����Ϸ�����
					}
				}
				else{// if(birthday.length()==5){		//����5λ������
					if( Integer.parseInt(birthday.substring(0, 4))>=1900 && Integer.parseInt(birthday.substring(0, 4))<=time.get(Calendar.YEAR) 
							&& Integer.parseInt(birthday.substring(4))>=0 && Integer.parseInt(birthday.substring(4))<10 ){//case2.10������5λ�����֣���20051
						date = birthday.substring(0, 4)+"-0"+birthday.substring(4)+"-01";
					}
					else{ 
						date = "/";		//case2.11������5λ�����Ϸ�����
					}
				}
			}
			else if(birthday.length()<=8){	//case3�����ճ��ȵ���6��7��8���������룬��1992-5��1992-05������1992-1-1����92-10-10��92-1-1������19920101����199201����920101
				if(birthday.contains("/") || birthday.contains("-") || birthday.contains(".")){		//case3.1���������룬��1992-5��1992-05������1992-1-1����92-10-10��92-1-1��ȫ��ת��Ϊ��-������
					birthday=birthday.replace("/", "-");
					birthday=birthday.replace(".", "-");
					if( !birthday.endsWith("-") && !birthday.startsWith("-")){
						String[] temparray = birthday.split("-");
						if(temparray.length==2 && temparray[0].length()==4 && temparray[1].length()<=2){	//����٣�ֻ�������1992-1��1992-01��1992-10��2009-10,2009-1��������ʽ��������992-10
							int birthyear = Integer.parseInt(temparray[0]);
							int birthmon = Integer.parseInt(temparray[1]);
							if(birthmon>=1 && birthmon<=12){	//�·�����Ϸ�
								if(birthyear<=time.get(Calendar.YEAR) && birthyear>=1900){			//case3.2������1900~2016
									if(birthmon<10){
										date = birthyear+"-0"+birthmon+"-01";
									}
									else{
										date = birthyear+"-"+birthmon+"-01";
									}
								}
								else{		//case3.4����ݲ��Ϸ���С��1900�����2016
									date="/";
								}
							}
							else{													//case3��4���·����벻�Ϸ�
								date="/";
							}
						}
						else if(temparray.length==3){	//����ڡ��ۣ�ֻ�������1992-1-1����92-01-01��92-1-1��������ʽ
							if(temparray[0].length()==4  && temparray[1].length()==1 && temparray[2].length()==1){	//case3.5�������1992-1-1
								int birthyear = Integer.parseInt(temparray[0]);
								int birthmon = Integer.parseInt(temparray[1]);
								int birth_d = Integer.parseInt(temparray[2]);
								if( birthyear<=time.get(Calendar.YEAR) && birthyear>=1900 && 
										birthmon>=1 && birthmon<10 && birth_d>=1 && birth_d<10 ){	//case3.6������������Ϸ�������1900~2016
									date = birthyear+"-0"+birthmon+"-0"+birth_d;
								}
								else{		//case3.7�����������벻�Ϸ�
									date="/";
								}
							}
							else if(temparray[0].length()==2  && temparray[1].length()<=2 && temparray[2].length()<=2){		//case3��8�������92-10-10��92-1-1��
								int birthyear = Integer.parseInt(temparray[0]);
								int birthmon = Integer.parseInt(temparray[1]);
								int birth_d = Integer.parseInt(temparray[2]);
								if(birthyear>time.get(Calendar.YEAR)-2000 && birthyear<=99){		//case3.9������16~99��Ĭ��Ϊ������
									//�ж������Ƿ�Ϸ�
									if( ((birthmon==1 || birthmon==3 || birthmon==5 || birthmon==7 || birthmon==8 || birthmon==10 || birthmon==12)	//����
											&& birth_d>0 && birth_d<=31)
											||
										((birthmon==4 || birthmon==6 || birthmon==9 || birthmon==11)	//С��
											&& birth_d>0 && birth_d<=30 )
											||
										(((1900+birthyear)%100==0 && (1900+birthyear)%400==0) || ((1900+birthyear)%100!=0 && (1900+birthyear)%4==0)	//ƽ��
											&& (birthmon==2 && birth_d>0 && birth_d<=28 ))
									){	//�жϴ�С��ƽ��
										if(birthmon<10){
											if(birth_d<10){
												date = "19"+birthyear+"-0"+birthmon+"-0"+birth_d;
											}
											else{
												date = "19"+birthyear+"-0"+birthmon+"-"+birth_d;
											}
										}
										else{
											if(birth_d<10){
												date = "19"+birthyear+"-"+birthmon+"-0"+birth_d;
											}
											else{
												date = "19"+birthyear+"-"+birthmon+"-"+birth_d;
											}
										}
									}
									else{		//case3��10���������벻�Ϸ�
										date="/";
									}
								}
								else if(birthyear<=time.get(Calendar.YEAR)-2000 && birthyear>=0){		//case3.11������0~16��Ĭ��Ϊ������
									//�ж������Ƿ�Ϸ�
									if( ((birthmon==1 || birthmon==3 || birthmon==5 || birthmon==7 || birthmon==8 || birthmon==10 || birthmon==12)	//����
											&& birth_d>0 && birth_d<=31)
											||
										((birthmon==4 || birthmon==6 || birthmon==9 || birthmon==11)	//С��
											&& birth_d>0 && birth_d<=30 )
											||
										(((2000+birthyear)%100==0 && (2000+birthyear)%400==0) || ((2000+birthyear)%100!=0 && (2000+birthyear)%4==0)	//ƽ��
											&& (birthmon==2 && birth_d>0 && birth_d<=28 ))
									){	//�жϴ�С��ƽ��
										int temp_bd = birthyear+2000;
										if(birthmon<10){
											if(birth_d<10){
												date = temp_bd+"-0"+birthmon+"-0"+birth_d;
											}
											else{
												date = temp_bd+"-0"+birthmon+"-"+birth_d;
											}
										}
										else{
											if(birth_d<10){
												date = temp_bd+"-"+birthmon+"-0"+birth_d;
											}
											else{
												date = temp_bd+"-"+birthmon+"-"+birth_d;
											}
										}
									}
									else{		//case3��12���������벻�Ϸ�
										date="/";
									}
								
								}
								else{													//case3��13���·����벻�Ϸ�
									date="/";
								}
									
							}
							else{				//case3.14���������벻�Ϸ�����992-1-1
								date="/";
							}
						}
						else{						//case3.15�����λ�����Ϸ�����92-1-1-1
							date="/";
						}
					}
					else{		//case3.16�����ӷ�λ�ò��Ϸ�
						date="/";
					}
				}
				//case3.17�������19920101����199201���ں��油��8λ����920101
				else if(birthday.matches("^\\d+$")){	//����ƥ�䴿����
					if(birthday.length()==6 && Integer.parseInt(birthday.substring(0, 4))>=1900 && Integer.parseInt(birthday.substring(0, 4))<=time.get(Calendar.YEAR) 
							&& Integer.parseInt(birthday.substring(4))>0 && Integer.parseInt(birthday.substring(4))<=12){	//case3.18�������199201���ں��油��8λ
						birthday+="01";
					}
					else if(birthday.length()==6 && Integer.parseInt(birthday.substring(0, 2))>0 && Integer.parseInt(birthday.substring(0, 2))<=time.get(Calendar.YEAR)-2000 ){
						//case3.19����050101
						birthday="20"+birthday;
					}
					else if(birthday.length()==6 && Integer.parseInt(birthday.substring(0, 2))>time.get(Calendar.YEAR)-2000 && Integer.parseInt(birthday.substring(0, 2))<99 ){
						//case3.20����920101
						birthday="19"+birthday;
					}
					if(birthday.length()==8){
						String temp_birthday = birthday.substring(0, 4)+"-"+birthday.substring(4, 6)+"-"+birthday.substring(6, 8);
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						Date dt = df.parse(temp_birthday);
						date = df.format(dt).toString();
					}
					else{
						date="/";			//case3.21�����Ȳ���8λ������1992011
					}
				}
				else{
					date="/";			//case3.22�������Ĳ��Ϸ����룬����1992@1-1
				}
			}
			else if(birthday.length()<=10){	//case4�����ճ��ȵ���9��10���������룬��1992-01-01��1992-01-1��1992-1-01������1992-0101
				if(birthday.contains("/") || birthday.contains("-") || birthday.contains(".")){		//case4.1�����������1992-01-01��1992-01-1��1992-1-01����ȫ��ת��Ϊ��-������
					birthday=birthday.replace("/", "-");
					birthday=birthday.replace(".", "-");
					String[] temparray = birthday.split("-");
					if(birthday.length()==9 && temparray.length==2 ){				//case4.2�������1992-0101
						birthday=birthday.substring(0, 7)+"-"+birthday.substring(7);
					}
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");		//ת����׼��ʽ����
					Date dt = df.parse(birthday);
					Date dt_start = df.parse("1900-01-01");
					if(dt.before(new Date()) && dt.after(dt_start)){		//���ڷ�Χ1900~��ǰ����
						date = df.format(dt).toString();
					}
					else{
						date="/";
					}
				}
				else{
					date="/";			//case4.2��û�����ӷ��������Ϲ淶
				}
			}
			else{
				date="/";				//case5�����ȴ���10�Ĳ��Ϸ�����
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("����ѧ���������");
			date="/";					//case6���������Ϸ�����
		}
		return date;
	}
}
