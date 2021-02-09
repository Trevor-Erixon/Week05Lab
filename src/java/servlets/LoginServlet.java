package servlets;

import java.io.IOException;
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
        
        User userCheck = (User) session.getAttribute("user");
        String logout = request.getParameter("logout");
        
        if (logout == null && userCheck == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
            return;
        }
        else if (logout != null)
        {
            session.invalidate();
            
            String logoutMessage = "You have successfully logged out.";
            request.setAttribute("logoutMessage", logoutMessage);
            logout = null;
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);            
            return;
        }
        
        if (userCheck != null)
        {
            response.sendRedirect("home");
            return;
        }
        else 
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }

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

        User user = new User(username, password);

        session.setAttribute("user", user);
        
        AccountService accServ = new AccountService();
        
        User userValidation = accServ.login(username, password);
        
        if (userValidation != null)
        {
            response.sendRedirect("home");
        }
        else
        {            
            request.setAttribute("logoutMessage", "");
            session.setAttribute("username", user.getUsername());
            
            String passwordMessage = "The password was incorrect. Please try again.";
            request.setAttribute("passwordMessage", passwordMessage);
            
            doGet(request, response);
        }
        
    }

}
