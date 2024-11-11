package root;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			// Employee emp1 = new Employee("Rohit Singh", 90.000);
			// Employee emp2 = new Employee("Pankaj Mishra", 30.000);
			// Employee emp3 = new Employee("Roshan Thakur", 50.000);
			// Employee emp4 = new Employee("Manoj Saru", 70.000);
			// Employee emp5 = new Employee("Ajay Dalla", 10.000);

			// session.save(emp1);
			// session.save(emp2);
			// session.save(emp3);
			// session.save(emp4);
			// session.save(emp5);

			// transaction.commit();

			// Call NamedNativeQuery
			Query query = session.getNamedQuery("findEmployeeBySalaryAbove");
			query.setParameter("salary", 40.00);

			List list = query.list();

			for (Object object : list) {
				System.out.println(object);
			}

			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			sessionFactory.close();
		}
	}

}
