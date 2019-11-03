package dao.imp;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import dao.IInfoDAO;
import domain.Information;

public class InfoDAO extends HibernateDaoSupport implements IInfoDAO{

	@Override
	public void addInformation(Information information) {
		this.getHibernateTemplate().save(information);
	}

	@Override
	public Information getInformationById(String id) {
		return (Information)this.getHibernateTemplate().get(Information.class, id);
	}

	@Override
	public void deleteInformation(Information information) {
		this.getHibernateTemplate().delete(information);
	}

	@Override
	public void updateInformation(Information information) {
		this.getHibernateTemplate().update(information);
	}

	@Override
	public List<Information> getInformationByTitle(String title) {
		String hsql = "from Information where title='"+title+"'";
		return (List<Information>)this.getHibernateTemplate().find(hsql);
	}

	@Override
	public List<Information> getAllInformation() {
		String hsql = "from Information";
		return (List<Information>)this.getHibernateTemplate().find(hsql);
	}

}
