import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class Register extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse resp)
throws ServletException,IOException{
	super.doPost(req, resp);
	
	String e=req.getParameter("email");
	String p=req.getParameter("password");
	
	
	//user and password set and get
	Users user=new Users();
	user.setEmail(e);
	user.setPassword(p);
	
	RegisterIMP rimp=new RegisterIMP();
	int i=rimp.registerUser(user);
	if(i>0) {
		System.out.println("Register Sucessful");
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("REGISTER","SUCCESS");
			PrintWriter pw=resp.getWriter();
			pw.write(jsonObject.toString());
			pw.print(jsonObject.toString());
			
			System.out.println("REGISTER sucessfully maded"+jsonObject.toString());
			
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

}
