package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class EmployeeSaveApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction =null;
		boolean flag = false;
		
		try {
					session = HibernateUtil.getSession();
					if (session != null)
						transaction = session.beginTransaction();
			
						if (transaction != null) {
					Employee employee = new Employee();
				     employee.setEmpName("kiran");
				     employee.setEmpSal(5884.22);
				     session.save(employee);
				     flag = true;
								
						}
				} catch (HibernateException e) {
					// TODO: handle exception
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		 finally {
			// TODO: handle finally clause
			 
			 if(flag == true) {
				 transaction.commit();
				 System.out.println("Object saved successfully...");
			 }
			 
			else {
				transaction.rollback();
				System.out.println("Object not saved...");
			}
			
			 
			 HibernateUtil.closeSession(session);
		}
		

	}

}
