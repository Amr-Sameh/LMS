package General;

import java.io.Serializable;

/**
 * Created by PC - MeiR on 12/3/2016.
 */
public class General_Persone implements Serializable {

    private String name;
    private String id;
    private String e_mail = null;
    private String password;



    static final long serialVersionUID = 1007;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
