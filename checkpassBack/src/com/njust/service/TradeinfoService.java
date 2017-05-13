package com.njust.service;

import java.util.List;

import com.njust.dao.TradeinfoDao;
import com.njust.domain.Tradeinfo;
import com.njust.tag.PageBean;

public class TradeinfoService implements BaseService<Tradeinfo> {

	private TradeinfoDao tradeinfoDao;

	public void setTradeinfoDao(TradeinfoDao tradeinfoDao) {
		this.tradeinfoDao = tradeinfoDao;
	}

	public TradeinfoService() {

	}

	public void delete(Tradeinfo entity) {
		tradeinfoDao.delete(entity);
	}

	public void save(Tradeinfo entity) {
		tradeinfoDao.save(entity);
	}

	public void update(Tradeinfo entity) {
		tradeinfoDao.update(entity);

	}

	public List<Tradeinfo> findAll(String hql) {
		return tradeinfoDao.findAll(hql);
	}

	public List<Tradeinfo> findInfo(String hql, Object[] values) {
		return tradeinfoDao.findInfo(hql, values);
	}
	public PageBean querySearchForPage(int pageSize, int page,String hql) {
		return tradeinfoDao.querySearchForPage(pageSize, page, hql);
	
	}
	public PageBean querySearchForPage(int pageSize, int page,String hql,Object[] values){
		return tradeinfoDao.querySearchForPage(pageSize, page, hql, values);
	}
	public Tradeinfo getOneUser(String username) {
		String hql="from Tradeinfo u where u.username="+username;
		List<Tradeinfo> li=tradeinfoDao.findAll(hql);
		Tradeinfo temp=li.get(0);
		return temp;
		}


}
