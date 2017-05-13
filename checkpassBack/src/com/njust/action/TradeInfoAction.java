package com.njust.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.njust.domain.Tradeinfo;
import com.njust.service.TradeinfoService;
import com.njust.service.UserinfoService;
import com.njust.servlet.getMD5;
import com.njust.tag.JsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TradeInfoAction extends ActionSupport{
	private HttpServletRequest req;
	
	private List list;
	private TradeinfoService tradeinfoService;
	
	private int traderecordid;
	private String username;
	private String tradename;
	private float tradeamount;
	private String tradetime;
	
	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public int getTraderecordid() {
		return traderecordid;
	}


	public void setTraderecordid(int traderecordid) {
		this.traderecordid = traderecordid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getTradename() {
		return tradename;
	}


	public void setTradename(String tradename) {
		this.tradename = tradename;
	}


	public float getTradeamount() {
		return tradeamount;
	}


	public void setTradeamount(float tradeamount) {
		this.tradeamount = tradeamount;
	}


	public String getTradetime() {
		return tradetime;
	}


	public void setTradetime(String tradetime) {
		this.tradetime = tradetime;
	}
	
	public void setTradeinfoService(TradeinfoService tradeinfoService) {
		this.tradeinfoService = tradeinfoService;
	}
	
	
	public void createTradeinfo(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is createTradeinfo() of TradeInfoAction!");
		String message=null;
		try {
			Tradeinfo tradeinfo = new Tradeinfo();
			tradeinfo.setUsername(username);
			tradeinfo.setTradename(tradename);
			tradeinfo.setTradeamount(tradeamount);
//			Timestamp ts = new Timestamp(tradetime);
			tradeinfo.setTradetime(tradetime);
			tradeinfoService.save(tradeinfo);
			message="��ӽ��׼�¼�ɹ���";
		} catch (Exception e) {
			e.printStackTrace();
			message="��ӽ��׼�¼�쳣��";
		}finally{
			try {
				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("�������쳣��");
//				message="�������쳣��";
			}
		}
	}
	
	public void getTradeInfo(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is getTradeInfo() of TradeInfoAction! id is:"+traderecordid);
		String hql="from Tradeinfo t where t.traderecordid=?";
		Integer[] values = new Integer[] { traderecordid };
		list = tradeinfoService.findInfo(hql,values);
		String listjson = JsonUtil.listToJson(list);
		try {
			ServletActionContext.getResponse().getWriter().write(listjson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getAllTradesInfo(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is getAllTradesInfo() of TradeInfoAction!");
		String hql="from Tradeinfo t where t.traderecordid>0";
		list = tradeinfoService.findAll(hql);
		String listjson = JsonUtil.listToJson(list);
		try {
			String jsonstring="{\"data\":"+listjson+",\"draw\":\"1\",\"recordsTotal\":"+list.size()+",\"recordsFiltered\":"+list.size()+"}";
			
			ServletActionContext.getResponse().getWriter().write(jsonstring);  //�����ַ�ʽ��ֵjson
//			ServletActionContext.getResponse().getWriter().write(listjson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����Զ������תjson����
	}
	
	//���׼�¼����ɾ��
//	public void delUser() {
//		System.out.println("This is delUser() of PersonInfoAction!");
//		System.out.println("Ҫɾ������idΪ"+id);
//		String message=null;
//		try {
//			req = ServletActionContext.getRequest();
//			if(id==-1||req==null || req.getSession()==null){
//				System.out.println("reqΪ�գ���req.getSession()Ϊ�գ�");
////				message="reqΪ�գ���req.getSession()Ϊ�գ�";
//				message="�����쳣�������ԣ�";
//				return;
//			}
//			String queryhql = "from Userinfo u where u.id=?";
//			Integer[] val = new Integer[] { id };
//			try{
//				list = userinfoService.findInfo(queryhql, val);
//				if(list.size()!=1){							//�ҵ�Ҫɾ�����û�
//					message="��ɾ���û��쳣��";
//					return;
//				}
//				System.out.println("�ҵ����û���");
//				Userinfo temp = (Userinfo) list.get(0);
////				temp.setIsDeleted(1);						//���ɾ��
////				userinfoService.update(temp);
//				userinfoService.delete(temp);
//				System.out.println("��ɾ�����û���");
//				message="��ɾ�����û���";
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("ɾ���쳣��");
//				message="�û�ɾ���쳣��";
//				return;
//			}
//			System.out.println("�û�ɾ���ɹ���");
//			message="�û�ɾ���ɹ���";
//		}finally{
//			try {
//				id=-1;	//id��Ϊ��
//				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("�������쳣��");
////				message="�������쳣��";
//			}
//		}
////		return SUCCESS;
//	}
	
	//���׼�¼�����޸�
//	public void updateUserInfo() {
//		System.out.println("This is updateUserInfo() of PersonInfoAction! id is:"+id);
//		String message=null;
//		String hql = "from Userinfo u where u.id=?";
//		Integer[] values = new Integer[] { id };
//		try {
//			list = userinfoService.findInfo(hql, values);
//			if(list.size()==1){
//				Userinfo userinfo = (Userinfo) list.get(0);
//				userinfo.setUsername(username);
//				userinfo.setPassword(password);
//				userinfo.setLevel(level);
//				userinfo.setRealname(realname);
//				userinfo.setGender(gender);
//				userinfo.setAge(age);
//				userinfo.setAddress(address);
//				userinfo.setPhone(phone);
//				userinfo.setEmail(email);
//				userinfo.setGuardianName(guardianName);
//				userinfo.setSchool(school);
//				userinfo.setGrade(grade);
//				userinfo.setStuClass(stuClass);
//				userinfo.setIdNumber(idNumber);
//				userinfo.setNation(nation);
//				userinfo.setHeight(height);
//				userinfo.setWeight(weight);
//				userinfo.setEducation(education);
//				userinfo.setCareer(career);
//				userinfo.setNickname(nickname);
//				userinfo.setBirthday(birthday);
//				userinfo.setPromocode(promocode);
//		
//				userinfoService.update(userinfo);
//				message="�����û��ɹ���";
//			}
//			else if(list.size()<1){
//				message="�û������ڣ�";
//			}
//			else{
//				message="�û��쳣��";
//			}
//		} catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			message="�����û��쳣��";
//		}finally{
//			try {
//				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("�������쳣��");
////				message="�������쳣��";
//			}
//		}
//	}
	
	
	
}
