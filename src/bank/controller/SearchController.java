package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;

public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		String msg = null;
		boolean result = Service.getInstance().search(id);
		if(result == false)
			msg = "false";
		else
			msg = "true";
		request.setAttribute("msg", msg);
		request.setAttribute("rId", id);
		HttpUtil.forward(request, response, "/transfer.jsp");
	}

}
