package com.scp.nativeSQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeInterfaceImpl implements EmployeeInterface {

	public void insertEmployee(Employee e) throws MyException {
		Session session = Hibernateutil.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(e);
		trans.commit();
		// Hibernateutil.resourceCleanupActivities(session, trans);
	}

	public void getAllEmployeeWithHQL_Native() throws MyException {
		Session session = Hibernateutil.getSessionFactory().openSession();
		Query qry = session.getNamedQuery("HqlQuery");
		List list = qry.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Employee e = (Employee) itr.next();
			System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  " + e.getEmpSal() + "  " + e.getDeptId());
		}
	}

	public void allEmployeeWith_SQL_Native() throws MyException {
		Session session = Hibernateutil.getSessionFactory().openSession();
		Query query = session.getNamedQuery("SqlQuery");

		List list = query.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			for (int i = 1; i < obj.length; i++)
				System.out.println(obj[0] + "  " + obj[1]);
		}
	}
}