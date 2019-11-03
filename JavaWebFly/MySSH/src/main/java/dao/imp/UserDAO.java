package dao.imp;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import dao.IUserDAO;
import entity.User;
@SuppressWarnings({ "unchecked", "deprecation" })
public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	public UserDAO() {

	}

	@Override
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public User getUserById(String id) {

		return (User) this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public List<User> getUserByUserName(String userName) {
		String hsql = "from User where userName='" + userName + "'";
		return (List<User>) this.getHibernateTemplate().find(hsql);
	}

	@Override
	public List<User> getAllUser() {
		String hsql = "from User";
		return (List<User>) this.getHibernateTemplate().find(hsql);
	}

}