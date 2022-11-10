package servletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Project3Servlet
 */
@WebServlet("/Project3Servlet")
public class Project3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Shows myShows;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Project3Servlet() {
        super();
        myShows = new Shows("./servletPackage/netflixAllWeeksGlobalProcessed.txt");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("userName");
		String pwd = request.getParameter("pwd"); 
		
		// if username = md and password = pw then let them go to the web app
		if((request.getParameter("submit") != null) && user.equals("md") && pwd.equals("pw"))
		{
			String valuedList = "<select name=\"showList\">";
			
			for (String showWeek : myShows.toArrayWeek()) {
				valuedList += "<option value=\"" +showWeek+ "\">"+showWeek+"</option>";
			}
			valuedList += "</select>"; 
			
			String value = request.getParameter("showList");
		
			// set attributes
			request.setAttribute("myOneSelection",value);
			request.setAttribute("aShowList",valuedList);
			request.setAttribute("showCt"," " + myShows.getCount());
			RequestDispatcher rd=request.getRequestDispatcher("/mainMenu.jsp");   
			rd.forward(request,response);
			
			
		}
		else if(request.getParameter("seeShows")!=null) // see all of the shows for that specific week
		{
			String value = request.getParameter("showList");
			
			ArrayList<ShowWeek> temp = myShows.getOneWeek(value);
			
			String valueSide = "<select name=\"oneWeek\">"; 
			for(ShowWeek showWeek : temp)
			{
				valueSide += "<option value=\"" +showWeek.getShowTitle() + "\">"+showWeek.getShowTitle()+"</option>";
			}
			valueSide += "</select>"; 
			
			request.setAttribute("myChosenWeek", value);
			request.setAttribute("oneWeek",valueSide); 	
			request.setAttribute("count"," " + temp.size());
			RequestDispatcher rd=request.getRequestDispatcher("/showThem.jsp");   
			rd.forward(request,response);
			
		}
		else if(request.getParameter("process")!=null)
		{
			String mySelected = (String) request.getParameter("oneWeek");
			request.setAttribute("showSelected",mySelected);
			RequestDispatcher rd=request.getRequestDispatcher("/process.jsp");   
			rd.forward(request,response);
		}
		else if(request.getParameter("purge")!=null)
		{
			//theOne = (String) request.getAttribute("mySelected");
			//String myPurged = myShows.purgeShow(theOne);
			
			//request.setAttribute("theOne", myPurged);
			RequestDispatcher rd=request.getRequestDispatcher("/purge.jsp");   
			rd.forward(request,response); 
		}
		else if(request.getParameter("suggest")!=null)
		{
			String myWeek = request.getParameter("oneWeek");
			String myString = request.getParameter("showSelected");
			//String myRandom = myShows.randomShow().getShowTitle();
			
			ShowWeek myReturn = myShows.suggestShow(myString, myWeek);
			String myReturnString = myReturn.getShowTitle();
			
			request.setAttribute("myRandom", myReturnString);
			RequestDispatcher rd=request.getRequestDispatcher("/suggest.jsp");   
			rd.forward(request,response); 
		}
		else if(request.getParameter("backToMain")!=null)
		{
			
			String valuedList = "<select name=\"showList\">";
			
			for (String showWeek : myShows.toArrayWeek()) {
				valuedList += "<option value=\"" +showWeek+ "\">"+showWeek+"</option>";
			}
			valuedList += "</select>"; 
			
			String value = request.getParameter("showList");
			
			request.setAttribute("myOneSelection",value);
			request.setAttribute("aShowList",valuedList);
			request.setAttribute("showCt"," " + myShows.getCount());
			RequestDispatcher rd=request.getRequestDispatcher("/mainMenu.jsp");   
			rd.forward(request,response);
			
		}
		else if(request.getParameter("logout")!=null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");   
			rd.forward(request,response); 
		}
		else
		{
			// Keep sending them back to the home page to try to login if they're not entering correct credentials
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");   
			rd.forward(request,response); 	
		}
		
		// Put all of your get methods here to get the values, and if no values are submitted for them then they're set to null
		// set up a bunch of if else if's based on which one is pressed and which one is not null
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
