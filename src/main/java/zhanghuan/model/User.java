package zhanghuan.model;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;

/**
 * Created by icepoint1999 on 09/03/2018.
 */
@Table("users")
public class User extends ActiveRecord {

    private Integer id;
    private String email;
    private String password;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
