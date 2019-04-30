
package com.service;

import java.util.List;

 

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.QueryProducer;
import org.springframework.orm.hibernate5.HibernateTemplate;
 
import com.pojo.Cust;
import com.pojo.Cust2;
 
public class AuthService {
 
    private HibernateTemplate hibernateTemplate;
    private static Logger log = Logger.getLogger(AuthService.class);
 
    private AuthService() { }
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    public void setcustomer(String firstname,String lastname,int age,long contact, String movie,String username,String password)
    {
    	Session session = (Session) hibernateTemplate.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();
    	System.out.println(firstname);
    	 
		String sqlQuery = "insert into customer (firstname,lastname,age,contact,movie,username,password) values (" +
				"'" +firstname + "'"+ "," + "'" +lastname+ "'" +"," + age + "," + contact + "," + 
		"'" +movie + "'" + "," + "'" +username + "'" + "," + "'" +password + "'" +")";
		String status="Not Applied";
		String sqlQuery2= "insert into Stat (username,password,status) values (" + "'" + username +"'" +"," + "'" + password + "'" + ","+ "'"  +status + "'" +")";
    	System.out.println(sqlQuery);
    	System.out.println(sqlQuery2);
    	NativeQuery qry =  session.createNativeQuery(sqlQuery);
    	NativeQuery qry2 =  session.createNativeQuery(sqlQuery2);
        qry.executeUpdate();
        qry2.executeUpdate();
        tx.commit();       
    }
 
	@SuppressWarnings( { "unchecked", "deprecation" } )
    public boolean findUser(String username,String password) {
        log.info("Checking the user in the database");
        boolean isValidUser = false;    
      String sqlQuery = "from Cust u where u.username=? and u.password=?";   
        System.out.println("In the authentication service...user entered data " +username + "  "+ password);   
        try { 	
            List<Cust> userObj = (List) hibernateTemplate.find(sqlQuery, username, password);      
            if(userObj != null && userObj.size() > 0) {
                isValidUser = true;
            }
        } catch(Exception e) {
            isValidUser = false;
            log.error("An error occurred while fetching the user details from the database", e);    
        }
        return isValidUser;
    }
	
	@SuppressWarnings( { "unchecked", "deprecation" } )
    public boolean checkUser(String user,String firstname,String lastname,long contact,String movie) {
		boolean isValidUser = false;
		String sqlQuery = "from Cust u where u.firstname=? and u.lastname=? and  u.contact=? and u.movie=?";
try {
        	
            List<Cust> userObj = (List) hibernateTemplate.find(sqlQuery, firstname,lastname,contact,movie);
            
            
            if(userObj != null && userObj.size() > 0) {
                isValidUser = true;
                Session session = (Session) hibernateTemplate.getSessionFactory().openSession();
            	Transaction tx = session.beginTransaction();
            	String abc="Accepted";
            	String sql="Update stat set status= "+ "'" + abc + "'" + "where username= " + "'" + user + "'";
            	NativeQuery qry =  session.createNativeQuery(sql);
                qry.executeUpdate();
                tx.commit();
            }
            else
            {
            	 Session session = (Session) hibernateTemplate.getSessionFactory().openSession();
             	Transaction tx = session.beginTransaction();
             	String abc="Rejected";
             	String sql="Update stat set status= "+ "'" + abc + "'" + "where username= " + "'" + user + "'";
             	NativeQuery qry =  session.createNativeQuery(sql);
                 qry.executeUpdate();
                 tx.commit();
            }
        } catch(Exception e) {
            isValidUser = false;
           
            log.error("An error occurred while fetching the user details from the database", e);    
        }
	 
        
        return isValidUser;
}
	
	@SuppressWarnings( { "unchecked", "deprecation" } )
    public boolean checkregister(String firstname,String lastname,int age,long contact,String movie,String username,String password)
    {
		 
		String sqlQuery = "from Cust u where u.firstname=? and u.lastname=? and u.age=? and u.contact=? and u.movie=? and u.username=? and u.password=?";
		 List<Cust> userObj = (List) hibernateTemplate.find(sqlQuery, firstname,lastname,age,contact,movie,username,password);
         if(userObj != null && userObj.size() > 0) 
        	 return true;
         else 
        	 return false;
        	
		
    }
	@SuppressWarnings( { "unchecked", "deprecation" } )
	public String checkstatus(String user)
	{
		Session session = hibernateTemplate.getSessionFactory().openSession();
	  
		 String sqlQuery1="select status from stat where username=?";
	       session.beginTransaction();
	       SQLQuery q=session.createSQLQuery(sqlQuery1);
	  
	       q.setParameter(0, user);
	       List result=q.list();
	       String st="";
	       for(int i=0;i<result.size();i++)
	       {
	              st=(String)result.get(0);
	              
	       }
	   
	       return st;


	}
	@SuppressWarnings( { "unchecked", "deprecation" } )
	public boolean checkcustomer(String user)
	{
		boolean ch=false;
		String sd="from Cust2 u where u.username=?";
		List<Cust2> userObj = (List) hibernateTemplate.find(sd,user);
        
        
        if(userObj != null && userObj.size() > 0) 
        {
        	ch=true;
        }
        else
        {
        	ch=false;
        }
	return ch;
	}
	
	@SuppressWarnings( { "unchecked", "deprecation" } )
	public boolean checkal(String user)
	{
		 
		Session session = hibernateTemplate.getSessionFactory().openSession();
		  
		 String sql="select status from stat where username=?";
	       session.beginTransaction();
	       SQLQuery q=session.createSQLQuery(sql);
	 	  
	       q.setParameter(0, user);
	       List result=q.list();
	       String st= "";
	 //      System.out.println("Status "+st);
	       for(int i=0;i<result.size();i++)
	       {
	              st=(String)result.get(0);
	              
	       }
	       System.out.println("Status is "+st);
	       if(st.equals("Accepted") )
	       {
	       return true;
	       }
	       else
	       {
	    	  return false;
	       }
	      
	}
}
	
	
	 
