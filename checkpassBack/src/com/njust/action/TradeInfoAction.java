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
			message="添加交易记录成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="添加交易记录异常！";
		}finally{
			try {
				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("输出结果异常！");
//				message="输出结果异常！";
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
			
			ServletActionContext.getResponse().getWriter().write(jsonstring);  //以这种方式传值json
//			ServletActionContext.getResponse().getWriter().write(listjson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建自定义对象转json方法
	}
	
	//交易记录不可删除
//	public void delUser() {
//		System.out.println("This is delUser() of PersonInfoAction!");
//		System.out.println("要删除的是id为"+id);
//		String message=null;
//		try {
//			req = ServletActionContext.getRequest();
//			if(id==-1||req==null || req.getSession()==null){
//				System.out.println("req为空，或req.getSession()为空！");
////				message="req为空，或req.getSession()为空！";
//				message="请求异常，请重试！";
//				return;
//			}
//			String queryhql = "from Userinfo u where u.id=?";
//			Integer[] val = new Integer[] { id };
//			try{
//				list = userinfoService.findInfo(queryhql, val);
//				if(list.size()!=1){							//找到要删除的用户
//					message="被删除用户异常！";
//					return;
//				}
//				System.out.println("找到该用户！");
//				Userinfo temp = (Userinfo) list.get(0);
////				temp.setIsDeleted(1);						//标记删除
////				userinfoService.update(temp);
//				userinfoService.delete(temp);
//				System.out.println("已删除该用户！");
//				message="已删除该用户！";
//			}
//			catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("删除异常！");
//				message="用户删除异常！";
//				return;
//			}
//			System.out.println("用户删除成功！");
//			message="用户删除成功！";
//		}finally{
//			try {
//				id=-1;	//id置为空
//				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("输出结果异常！");
////				message="输出结果异常！";
//			}
//		}
////		return SUCCESS;
//	}
	
	//交易记录不可修改
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
//				message="更新用户成功！";
//			}
//			else if(list.size()<1){
//				message="用户不存在！";
//			}
//			else{
//				message="用户异常！";
//			}
//		} catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			message="更新用户异常！";
//		}finally{
//			try {
//				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("输出结果异常！");
////				message="输出结果异常！";
//			}
//		}
//	}
	
	
	
}
