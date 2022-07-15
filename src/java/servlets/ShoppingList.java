package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");
        String operation = request.getParameter("action");

        if (operation != null && operation.equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        if (username != null && !username.equals("")) {
            //ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

       

      

        String operation = request.getParameter("action");
       

        if (operation != null && operation.equals("register")) {
             String username = request.getParameter("username");
            if (username != null && !username.equals("")) {
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");
                return;
            } else {
                String message = "username is empty";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }

        }
 ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (operation != null && operation.equals("add")) {
             String itemName = request.getParameter("itemName");
            //items = (ArrayList<String>) session.getAttribute("items");
            if (items == null) {
                items = new ArrayList();
            }
            items.add(itemName);
            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
            return;
        }

        if (operation != null && operation.equals("delete")) {
            
           // items = (ArrayList<String>) session.getAttribute("items");
            String delete = request.getParameter("itemDelete");
            items.remove(delete);
            session.setAttribute("items", items);
            response.sendRedirect("ShoppingList");
            return;
        }

        if (operation
                != null && operation.equals(
                        "logout")) {
            session.invalidate();
        }

    }

}
