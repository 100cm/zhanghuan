package zhanghuan.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.blade.mvc.http.Session;
import zhanghuan.model.User;

import java.util.List;


/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Path()
public class LoginController {

    @GetRoute("login")
    public String login() {
        return "login.html";
    }

    @PostRoute("signin")
    public void Signin(Response response, Request request, User user, Session session) {
        User model = new User();
        List<User> users = model.where("email", user.getEmail()).where("password", user.getPassword()).findAll();
        if (users.size() > 0) {
            User login = users.get(0);
            session.attribute("current_user", login);
            response.redirect("/dashboard/welcome");
        } else {
            response.redirect("/login");
        }

    }

    @PostRoute("register")
    public void register(Response response, Request request, User user, Session session) {
        Long id = user.save();
        user.setId(Integer.parseInt(id.toString()));
        session.attribute("current_user", user);
        response.redirect("/dashboard/welcome");
    }

    @GetRoute("logout")
    public void logout(Response response, Request request, User user, Session session) {
        session.remove("current_user");
        response.redirect("/login");
    }
}
