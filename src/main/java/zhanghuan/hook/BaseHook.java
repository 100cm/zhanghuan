package zhanghuan.hook;

import com.blade.ioc.annotation.Bean;
import com.blade.mvc.hook.Signature;
import com.blade.mvc.hook.WebHook;
import org.javalite.activejdbc.ConnectionsAccess;
import zhanghuan.Application;
import zhanghuan.bean.BaseConfig;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Bean
public class BaseHook implements WebHook{
    public boolean before(Signature signature) {
        return true;
    }
}
