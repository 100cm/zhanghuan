package zhanghuan.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import zhanghuan.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Path("dashboard")
public class ProductController {


    @GetRoute("products")
    public void products(Response response, Request request) {
        Product product = new Product();
        List<Product> productList = product.findAll();
        request.attribute("products", productList);
        request.attribute("page", "product/index.html");

    }

    @GetRoute("products/new")
    public void newProducts(Request request) {

        request.attribute("page", "product/new.html");
    }

    @PostRoute("products")
    public void createProducts(Product product, Request request, Response response) {
        product.save();
        response.redirect("/dashboard/products");
    }

}
