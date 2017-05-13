package com.njust.service;

import java.util.List;

import com.njust.dao.UserinfoDao;
import com.njust.domain.Userinfo;
import com.njust.tag.PageBean;

public class UserinfoService implements BaseService<Userinfo> {

	private UserinfoDao userinfoDao;

	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	public UserinfoService() {

	}

	public void delete(Userinfo entity) {
		userinfoDao.delete(entity);
	}

	public void save(Userinfo entity) {
		userinfoDao.save(entity);
	}

	public void update(Userinfo entity) {
		userinfoDao.update(entity);

	}

	public List<Userinfo> findAll(String hql) {
		return userinfoDao.findAll(hql);
	}

	public List<Userinfo> findInfo(String hql, Object[] values) {
		return userinfoDao.findInfo(hql, values);
	}
	public PageBean querySearchForPage(int pageSize, int page,String hql) {
		return userinfoDao.querySearchForPage(pageSize, page, hql);
	
	}
	public PageBean querySearchForPage(int pageSize, int page,String hql,Object[] values){
		return userinfoDao.querySearchForPage(pageSize, page, hql, values);
	}
	public Userinfo getOneUser(String username) {
		String hql="from Userinfo u where u.username="+username;
		List<Userinfo> li=userinfoDao.findAll(hql);
		Userinfo temp=li.get(0);
		return temp;
		} 

/*
	public PageBean queryForPage(int pageSize, int page,String hql) {
		// TODO Auto-generated method stub
		int allRow = userinfoDao.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<Userinfo> list = userinfoDao.queryForPage(hql, offset, length); // "һҳ"�ļ�¼

		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	*/


	
	
/*	
	public PageBean querySearchForPage(int pageSize, int page,String hql,Object[] values) {
		// TODO Auto-generated method stub
		int allRow = userinfoDao.getSearchRowCount(hql, values); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<Userinfo> list = userinfoDao.querySearchForPage(hql,values, offset, length); // "һҳ"�ļ�¼

		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
*/
}
