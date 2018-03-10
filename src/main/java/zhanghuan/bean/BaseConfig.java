package zhanghuan.bean;

import com.blade.Blade;
import com.blade.event.BeanProcessor;
import com.blade.ioc.annotation.Bean;
import com.blade.jdbc.Base;
import com.blade.mvc.view.template.JetbrickTemplateEngine;


/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Bean
public class BaseConfig implements BeanProcessor {

    public void processor(Blade blade) {
        Base.open("jdbc:mysql://localhost:3306/zhanghuan", "root", "root");
        blade.templateEngine(new JetbrickTemplateEngine());
    }
}
