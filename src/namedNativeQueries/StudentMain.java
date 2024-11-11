package namedNativeQueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {

			// Student s1 = new Student("Prateek", 77);
			// Student s2 = new Student("Rohit", 37);
			// Student s3 = new Student("Jay", 67);
			// Student s4 = new Student("Palak", 17);
			// Student s5 = new Student("matin", 67);

			// session.save(s1);
			// session.save(s2);
			// session.save(s3);
			// session.save(s4);
			// session.save(s5);

			// session.beginTransaction().commit();

			Query query = session.getNamedQuery("findByName");
			query.setParameter("char", "ro%");
			List list = query.list();
			for (Object object : list) {
				System.out.println(object);
			}

			Query query1 = session.getNamedQuery("getStudentMarksGreaterThan");
			query1.setParameter("marks", 69);
			List list1 = query1.list();
			for (Object object : list1) {
				System.out.println(object);
			}

			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			e.printStackTrace();
			session.close();
			sessionFactory.close();
		}
	}

}
