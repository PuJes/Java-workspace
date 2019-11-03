package hibernate.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class HibernateFilter implements Filter{
	private static Log log = LogFactory.getLog(HibernateFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//����request����
		request.setCharacterEncoding("GBK");
		
		//�õ�SessionFactory����
		SessionFactory sf = HibernateUtil.getSessionFactory();
		try {
			log.debug("����һ��������");
			sf.getCurrentSession().beginTransaction();
			log.debug("Request Path:\t"+((HttpServletRequest)request).getServletPath());
			chain.doFilter(request, response);
			
			log.debug("�ύ����");
			sf.getCurrentSession().getTransaction().commit();
		}catch (Throwable e) {
			e.printStackTrace();
			try {
				log.debug("�쳣�ع�����");
				sf.getCurrentSession().getTransaction().rollback();
			}catch (Throwable ex) {
				log.error("�ع��쳣");
			}
			throw new ServletException(e);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}