package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;

public class QueryController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = null;
		String job = (String)request.getParameter("job");
		if(job.equals("q"))
			path = "/result/queryResult.jsp";
		else if(job.equals("w"))
			path = "/withdrawl.jsp";
		String id = (String)request.getSession().getAttribute("id");
		int money = 0;
		if(id == null)
		{
			System.out.print("query: id does not exit");
		}
		else 
			money = Service.getInstance().query(id);
		
		request.setAttribute("money", money);
		HttpUtil.forward(request, response, path);
	}

}
