package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author Trevor Erixon
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String logout = request.getParameter("logout");
        
        if (logout != null)
        {
            session.invalidate();
            String logoutMessage = "You have successfully logged out.";
            request.setAttribute("logoutMessage", logoutMessage);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username.equals("") || username == null || password.equals("") || password == null)
        {
            if (username.equals("") || username == null)
            {
                String usernameMessage = "Invalid username.";
                request.setAttribute("usernameMessage", usernameMessage);
            }
            
            if (password.equals("") || password == null)
            {
                String passwordMessage = "Please enter a password.";
                request.setAttribute("passwordMessage", passwordMessage);
            }
            
            doGet(request, response);
        }
        
        session.setAttribute("username", username);
        
        AccountService accServ = new AccountService();
        
        User user = accServ.login(username, password);      
        
        if (user != null)
        {
            
        }
        
        response.sendRedirect("home");
        
    }

}
