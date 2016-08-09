package internetapp.web;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * Created by Sevumyan on 27.07.2016.
 */
@ManagedBean
@SessionScoped
public class MainBean {
    private String user;
    private String password;
    private String text;

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String checkUser(){
        if(this.user.equals("user") && this.password.equals("123")){
            return "success";
        }else{
            return "loginfailed";
        }
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }
}

