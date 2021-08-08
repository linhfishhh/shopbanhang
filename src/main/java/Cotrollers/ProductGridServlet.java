package Cotrollers;

import Services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/product"})
public class ProductGridServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=null;
        String size=req.getParameter("size");
        if(size==null){
            try {
                req.setAttribute("List", ProductService.ShowAllProduct());
                requestDispatcher=req.getRequestDispatcher("/product-grid.jsp");
                requestDispatcher.forward(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            try {
                req.setAttribute("List",ProductService.FindSize(size));
                requestDispatcher=req.getRequestDispatcher("/product-grid.jsp");
                requestDispatcher.forward(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String input=req.getParameter("Filter").replaceAll("\\s","");
        String rp=input.replace("$","");
        String str=rp.replace("-","");
        String a="";
        String b="";
        for(int i=0;i<str.length();i++){
            if(i<3){
                a+=str.charAt(i);
        }else b+=str.charAt(i);
        }
        try {
            req.setAttribute("ListFind",ProductService.FindPrice(Integer.parseInt(a),Integer.parseInt(b)));
            requestDispatcher=req.getRequestDispatcher("/product-grid.jsp");
            requestDispatcher.forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
