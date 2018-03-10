package zhanghuan.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import zhanghuan.model.User;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Path("dashboard")
public class IndexController {

    @GetRoute("welcome")
    public void welcome(Request request, Response response) {
        User user = new User();
        request.attribute("page", "user/index.html");
    }


}
