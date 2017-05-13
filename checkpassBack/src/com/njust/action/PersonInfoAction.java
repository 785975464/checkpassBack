package com.njust.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.njust.domain.Userinfo;
import com.njust.service.UserinfoService;
import com.njust.servlet.getMD5;
import com.njust.tag.JsonUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonInfoAction extends ActionSupport{
	private HttpServletRequest req;
	
	private List list;
	private UserinfoService userinfoService;
	
	private int id;
	private String username;
	private String password;
	private String level;
	private Boolean enabled;
	private Boolean accountNonExpired;
	private Boolean credentialsNonExpired;
	private Boolean accountNonLocked;
	private String realname;
	private String gender;
	private String age;
	private String address;
	private String phone;
	private String email;
	private String guardianName;
	private String school;
	private String grade;
	private String stuClass;
	private String idNumber;
	private String nation;
	private String height;
	private String weight;
	private String education;
	private String career;
	private String nickname;
	private String birthday;
	private String promocode;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	public void createUser(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is createUser() of PersonInfoAction!");
		String message=null;
		try {
			Userinfo userinfo = new Userinfo();
			userinfo.setUsername(username);
			userinfo.setPassword(password);
			userinfo.setLevel(level);
			userinfo.setEnabled(true);
			userinfo.setAccountNonExpired(true);
			userinfo.setCredentialsNonExpired(true);
			userinfo.setAccountNonLocked(true);
			userinfo.setRealname(realname);
			userinfo.setGender(gender);
			userinfo.setAge(age);
			userinfo.setAddress(address);
			userinfo.setPhone(phone);
			userinfo.setEmail(email);
			userinfo.setGuardianName(guardianName);
			userinfo.setSchool(school);
			userinfo.setGrade(grade);
			userinfo.setStuClass(stuClass);
			userinfo.setIdNumber(idNumber);
			userinfo.setNation(nation);
			userinfo.setHeight(height);
			userinfo.setWeight(weight);
			userinfo.setEducation(education);
			userinfo.setCareer(career);
			userinfo.setNickname(nickname);
			userinfo.setBirthday(birthday);
			userinfo.setPromocode(promocode);
	
			userinfoService.save(userinfo);
			message="添加用户成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="添加用户异常！";
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
	
	public void delUser() {
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is delUser() of PersonInfoAction!");
		System.out.println("要删除的是id为"+id);
		String message=null;
		try {
			req = ServletActionContext.getRequest();
			if(id==-1||req==null || req.getSession()==null){
				System.out.println("req为空，或req.getSession()为空！");
//				message="req为空，或req.getSession()为空！";
				message="请求异常，请重试！";
				return;
			}
			String queryhql = "from Userinfo u where u.id=?";
			Integer[] val = new Integer[] { id };
			try{
				list = userinfoService.findInfo(queryhql, val);
				if(list.size()!=1){							//找到要删除的用户
					message="被删除用户异常！";
					return;
				}
				System.out.println("找到该用户！");
				Userinfo temp = (Userinfo) list.get(0);
//				temp.setIsDeleted(1);						//标记删除
//				userinfoService.update(temp);
				userinfoService.delete(temp);
				System.out.println("已删除该用户！");
				message="已删除该用户！";
			}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("删除异常！");
				message="用户删除异常！";
				return;
			}
			System.out.println("用户删除成功！");
			message="用户删除成功！";
		}finally{
			try {
				id=-1;	//id置为空
				ServletActionContext.getResponse().getWriter().write(JsonUtil.msgToJson(message));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("输出结果异常！");
//				message="输出结果异常！";
			}
		}
//		return SUCCESS;
	}
	
	public void updateUserInfo() {
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is updateUserInfo() of PersonInfoAction! id is:"+id);
		String message=null;
		String hql = "from Userinfo u where u.id=?";
		Integer[] values = new Integer[] { id };
		try {
			list = userinfoService.findInfo(hql, values);
			if(list.size()==1){
				Userinfo userinfo = (Userinfo) list.get(0);
				userinfo.setUsername(username);
				userinfo.setPassword(password);
				userinfo.setLevel(level);
				userinfo.setRealname(realname);
				userinfo.setGender(gender);
				userinfo.setAge(age);
				userinfo.setAddress(address);
				userinfo.setPhone(phone);
				userinfo.setEmail(email);
				userinfo.setGuardianName(guardianName);
				userinfo.setSchool(school);
				userinfo.setGrade(grade);
				userinfo.setStuClass(stuClass);
				userinfo.setIdNumber(idNumber);
				userinfo.setNation(nation);
				userinfo.setHeight(height);
				userinfo.setWeight(weight);
				userinfo.setEducation(education);
				userinfo.setCareer(career);
				userinfo.setNickname(nickname);
				userinfo.setBirthday(birthday);
				userinfo.setPromocode(promocode);
		
				userinfoService.update(userinfo);
				message="更新用户成功！";
			}
			else if(list.size()<1){
				message="用户不存在！";
			}
			else{
				message="用户异常！";
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="更新用户异常！";
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
//		return "success";
	}
	
	public void getUserInfo(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is getUserInfo() of PersonInfoAction! id is:"+id);
		String hql="from Userinfo u where u.id=?";
		Integer[] values = new Integer[] { id };
		list = userinfoService.findInfo(hql,values);
		String listjson = JsonUtil.listToJson(list);
		try {
			ServletActionContext.getResponse().getWriter().write(listjson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getAllUsersInfo(){
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("This is getAllUsersInfo() of PersonInfoAction!");
//		String hql="from Userinfo u where u.id<20";
		String hql="from Userinfo u where u.id>0";
		list = userinfoService.findAll(hql);
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
	
	
	
//	public void downloadPersonInfo(){
//		System.out.println("This is downloadPersonInfo() in PersonInfoAction!");
//		req = ServletActionContext.getRequest();
//		String[] downloadbox = req.getParameterValues("downloadbox");
//		String hql = "from Userinfo u where u.username=?";
//		String[] values =null;
//		List<Userinfo> templist=null;
//		
//		for(int i=0;i<downloadbox.length;i++){
//			System.out.println(downloadbox[i]);
//			try {
//				values = new String[] { downloadbox[i]};
//				if(templist==null || templist.isEmpty()){
//					templist=userinfoService.findInfo(hql, values);
//				}
//				else{
//					templist.addAll( userinfoService.findInfo(hql, values) );
//				}
//				//makeDownList(templist);
//				//list.addAll( (Collection)templist );
//				//System.out.println("该社区有"+list.size()+"条数据！");
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//				//return null;
//			}
//		}
//		System.out.println("该社区有"+templist.size()+"条数据！"+templist);
//	}


	
	
	
}
