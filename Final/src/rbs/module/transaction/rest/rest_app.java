package rbs.module.transaction.rest;

import java.sql.Date;
import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import rbs.module.transaction.dao.DaoImplementation;

import rbs.module.transaction.model.Transaction;

@Path("/rest_app")
public class rest_app {
		
	DaoImplementation daoImplementation =new DaoImplementation();
	
	@GET
	@Path("/getbydate/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Transaction> getTransactions(@PathParam("date") Date date) {
		
		ArrayList<Transaction> t=daoImplementation.getTransactions(date);	
		return t;  			
	}
	
//	@GET
//	@Path("/getbyaccountnumber")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<Transaction> getTransactions(@QueryParam("accountnumber") double accountnumber) {
//		ArrayList<Transaction> t= daoImplementation.getTransactions(accountnumber); 	
//	        return t;
//	}
	
	@GET
	@Path("/getbyaccountnumber/{accountnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Transaction> getTransactions(@PathParam("accountnumber") int accountnumber) {
		ArrayList<Transaction> t= daoImplementation.getTransactions(accountnumber); 	
	        return t;
	}
	
	@GET
	@Path("/getbetweendates/{start}/{end}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Transaction> getTransactions(@PathParam("start")Date start,@PathParam("end") Date end) {
		ArrayList<Transaction> transactions = daoImplementation.getTransactions(start, end);	
		return transactions;
	}
	
	
	@GET
	@Path("/getbyaccounttype/{accounttype}")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Transaction> getTransactions(@PathParam("accounttype")String accountType) {
		ArrayList<Transaction> transactions = daoImplementation.getTransactions(accountType);
		return transactions;
	}
	
	

	
	
}
