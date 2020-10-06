package emergon.servlet.product;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListProductServlet", urlPatterns = {"/ListProductServlet"})
public class ListProductServlet extends HttpServlet {

    private ProductService service = new ProductService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        Accept the Get Request from the browser
//        Get the list of products from the DB
          List<Product> listOfProducts = service.getProducts();
//        Store them into the request
          req.setAttribute("products", listOfProducts);
//        Pass the request to the JSP page to show the list of products. How? Use a RequestDispatcher object
          RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productList.jsp");
          dispatcher.forward(req, resp);
        
    }

    
}