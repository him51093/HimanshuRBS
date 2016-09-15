package rbs.module.transaction.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.abc.cbs.vo.customer.CustomerRequestVO;
import com.abc.cbs.vo.customer.CustomerResponseVO;

import rbs.module.transaction.dao.DaoImplementation;
import rbs.module.transaction.model.Transaction;

@Path("/customer")
public class CustomerRest {

	@GET
	@Path("/getCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerResponseVO getCustomer() {

		// call service layer

		CustomerResponseVO cstomerResponseVO = new CustomerResponseVO();

		cstomerResponseVO.setFirstName("ravi");
		cstomerResponseVO.setLastName("kumar");
		cstomerResponseVO.setGender("Male");
		return cstomerResponseVO;

	}

	@POST
	@Path("/saveCustomer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveCustomer(CustomerRequestVO cstomerRequestVO) {

		String result = "cstomer : " + cstomerRequestVO;
		// call service layer
		return Response.status(201).entity(result).build();

	}
	
	@GET
	@Path("/getbyaccountnumber/{accountnumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Transaction> getTransactions(@PathParam("accountnumber") int accountnumber) {
		DaoImplementation daoImplementation =new DaoImplementation();
		ArrayList<Transaction> t= daoImplementation.getTransactions(accountnumber); 	
	        return t;
	}

}
