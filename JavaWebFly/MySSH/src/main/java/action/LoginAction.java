package action;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.UserDAO;
import entity.User;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID =1L;
	public String username;
	public String password;
	private UserDAO userDAO;
	public String execute() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDAO =  (UserDAO) context.getBean("userDAO");
		((AbstractApplicationContext)context).close();
		List<User> users = userDAO.getUserByUserName(username);
		
		if(users.size()==0) {
			super.addFieldError("username", "用户名不存在");
			return ERROR;
		}
		if(!password.equals(users.get(0).getPassWord())) {
			super.addFieldError("password", "密码错误");
			return ERROR;
		}
		return SUCCESS;
	}
	@Override
	public void validate() {
		if(username==null||username.length()==0) {
			super.addActionError("yonghumingbunengweikong");
		}
		if(password==null||password.length()==0) {
			super.addActionError("passwordbunengweikong");
		}
	}

}
