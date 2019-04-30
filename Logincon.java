package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.control.Logincon;
import com.service.AuthService;

@Controller
public class Logincon {
	
	public String user;
	
	 @Autowired
	    private AuthService authenticateService;            // This will auto-inject the authentication service into the controller.
	 
	    private static Logger log = Logger.getLogger(Logincon.class);
	  
	    @RequestMapping(value="/")
	    public String log()
	    {
	    	return "login";
	    }
	@RequestMapping(value="/register")
	public String ind()
	{
		
		System.out.println("In the controller /");
		return "customer";
	}
	@RequestMapping(value="/sub")
	public ModelAndView reg(@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("age")int age,
			@RequestParam("contact")long contact,@RequestParam("movie")String movie,@RequestParam("username")String username,@RequestParam("password")String password)
	{
		boolean a=authenticateService.checkregister(firstname,lastname,age,contact, movie,username,password);
		if(a)
		{
				String s="User is already existing with same information";
				return new ModelAndView("already","output",s);
		}
		else
		{
		authenticateService.setcustomer(firstname,lastname,age,contact, movie,username,password);
		String msg="Registration Successfull!!!";
		 return new ModelAndView("verify", "output", msg);
		}
	}
	
	 
	    // Checks if the user credentials are valid or not.
	    @RequestMapping(value = "/validate")
	    public ModelAndView validateUsr(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("password")String password) {
	         String msg=" ";
	     //   System.out.println("In the third controller /");
	        
	        boolean isValid = authenticateService.findUser( username,password);
	        log.info("Is user valid?= " + isValid);
	        
	     //   System.out.println("In the controller..");
	     //   System.out.println(isValid);
	        if(isValid) {
	        	user=username;
	        	// System.out.println(user);
	             
	          
	             return new ModelAndView("apply");

	        } else {
	            msg = "Please!!! Enter the data correctly";
	            return new ModelAndView("verify", "output", msg);
	        }
	 
	       
	    }
	    
	    
	    
	    @RequestMapping(value = "/che")
	    public ModelAndView checkuser(@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,
	    		@RequestParam("contact")long contact,@RequestParam("movie")String movie) {
	         String msg=" ";
	         boolean isValid = authenticateService.checkUser(user,firstname,lastname,contact,movie);
	         if(isValid)
	         {
	        	 msg="Your request for credit card has been accepted";
	        	 return new ModelAndView("app","output",msg);
	         }
	         else
	         {
	        	 msg="You have entered wrong information !!! Request rejected";
	        	 return new ModelAndView("correct","output",msg);
	        	  
	         }
	          
	    }



	    
	   @RequestMapping(value= "/status")
	    public ModelAndView status(HttpServletRequest request)
	    {
		//   request.getSession().setAttribute("username ",user);  
		   System.out.println("user data "+user);
	            String s=authenticateService.checkstatus(user);
	            System.out.println("status "+s);
	       //    request.getSession().setAttribute("status",s);
	   	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("status");
	    mv.addObject("username", user);
	    mv.addObject("status", s);
	    	return mv;
	    //	return new ModelAndView("status","output",user);
	    }  
	   
	   @RequestMapping(value= "/back")
	   public String back()
	   {
		   return "login";
	   }
	   
	   @RequestMapping(value= "/apply")
	   public ModelAndView app()
	   {
		   boolean a=authenticateService.checkal(user);
		   if(a)
		   {
			   String st="You have already applied for the credit card";
			   System.out.println(st);
			return new ModelAndView("cross","output",st);   
		   }
		   else
		   {
		   return new ModelAndView("check");
		   }
	   }
	   
	   
	   @RequestMapping(value= "/bac")
	   public String bac()
	   {
		   return "login";
	   }
	   @RequestMapping(value= "/previous")
	   public String previous()
	   {
		   return "apply";
	   }
	   @RequestMapping(value= "/prev")
	   public String prev()
	   {
		   return "check";
	   }
	  

	    @RequestMapping(value="/logout",method = RequestMethod.GET)
	     public String logout(HttpServletRequest request){
	          HttpSession httpSession = request.getSession();
	            httpSession.invalidate();
	            return "login";
	        }

	    }
	    
