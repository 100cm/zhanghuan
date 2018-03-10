package zhanghuan;

import com.blade.Blade;
import com.blade.kit.BladeKit;
import org.javalite.activejdbc.Base;
import zhanghuan.bean.BaseConfig;
import zhanghuan.model.User;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
public class Application {

    public static void setDB() {


    }

    public static void main(String args[]) {
        Blade blade = Blade.me();
        blade.before("/dashboard/*", (request, response) -> {
            User user = request.session().attribute("current_user");
//            if (null == user) {
//                request.attribute("err", "请先登陆");
//                response.redirect("/login");
//            }
        }).after("/dashboard/*", (request, response) -> {
            response.render("index.html");
        }).start(Application.class, args);
    }
}
